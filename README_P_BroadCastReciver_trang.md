  static class Alarm {
        public final int type;  // type of alarm: RTC_WAKEUP = 0 or RTC = 1 or ELAPSED_REALTIME_WAKEUP = 2 or ELAPSED_REALTIME = 3
        public long origWhen;    // origWhen = triggerAtTime
        public final boolean wakeup; // wakeup = true if type = ELAPSED_REALTIME_WAKEUP/RTC_WAKEUP
        public final PendingIntent operation;
        public final IAlarmListener listener;
        public final String listenerTag;
        public final String statsTag;
        public final WorkSource workSource;
        public final int flags;
        public final AlarmManager.AlarmClockInfo alarmClock;
        public int uid;             // [AppSync] Used in SyncScheduler
        public final int creatorUid;
        public final String packageName;
        public final String sourcePackage;
        public int count;
        public long when; // when = triggerAtTime at initial time  
        public long windowLength;
        public long whenElapsed;    // 'when' in the elapsed time base. whenElapsed = triggerElapsed
        public long maxWhenElapsed; // also in the elapsed time base
        // Expected alarm expiry time before app standby deferring is applied.
        public long expectedWhenElapsed;  // expectedWhenElapsed = triggerElapsed
        public long expectedMaxWhenElapsed;
        //++ AppSync
        public int pid;             // [AppSync] Added by and Used in SyncScheduler
        public long whenOriginal;   // [AppSync] Added by and Used in SyncScheduler; whenOriginal = triggerAtTime
        public char passport;       // [AppSync] Added by and Used in SyncScheduler
        //-- AppSync
        public long repeatInterval;
        public PriorityClass priorityClass;
        // <-- AE Improve remove alarm process
        public Batch batch; 
        // AE Improve remove alarm process -->




1. Set an alarm {
	Callstack
	02-15 09:58:56.175 D 4358     5952     ActivityManager:    at com.android.server.AlarmManagerService.setLocked(AlarmManagerService.java:3473) 
	02-15 09:58:56.175 D 4358     5952     ActivityManager:    at com.android.server.AlarmManagerService.rescheduleKernelAlarmsLocked(AlarmManagerService.java:3066) 
	02-15 09:58:56.175 D 4358     5952     ActivityManager:    at com.android.server.AlarmManagerService.setImplLocked(AlarmManagerService.java:1988) 
	02-15 09:58:56.175 D 4358     5952     ActivityManager:    at com.android.server.AlarmManagerService.setImplLocked(AlarmManagerService.java:1800) 
	02-15 09:58:56.175 D 4358     5952     ActivityManager:    at com.android.server.AlarmManagerService.setImpl(AlarmManagerService.java:1751) 
	02-15 09:58:56.175 D 4358     5952     ActivityManager:    at com.android.server.AlarmManagerService$2.set(AlarmManagerService.java:2090) 
	02-15 09:58:56.175 D 4358     5952     ActivityManager:    at android.app.IAlarmManager$Stub.onTransact(IAlarmManager.java:92) 

	Một số tham số cần chú ý: 
		- triggerAtTime: thời điểm để kích hoạt alarm(send alarm to app). triggerAtTime là một timestamp
		- windowLength: một số alarm có thể không cần được kích hoạt ngay tại thời điểm triggerAtTime,
		                nó có thể được kích hoạt trong khoảng thời gian (triggerAtTime + windowLength)
						windowLength là một duration 
		- interval: dành cho các repeat alarm, sau mỗi khoảng thời gian là interval thì alarm sẽ được gửi lại một lần
						interval là một duration 
		- 
		
		
		
	khi AlarmManagerService nhận được request xét một alarm thì AlarmManagerService sẽ thực hiện lần lượt các bước sau
	private final IBinder mService = new IAlarmManager.Stub() {
		public void set(){
		
			======= phần này điều chỉnh một số flag =================
			- đối với các repeat alarm thì max interval là 5 năm
			- App không được quyền xét các cờ FLAG_WAKE_FROM_IDLE/ FLAG_ALLOW_WHILE_IDLE_UNRESTRICTED cho alarm nên cần phải check để remove nó đi
			  Chỉ có các alarm đặc biệt mới được xét các cờ này. Việc xét cờ được quyết định bởi AlarmManagerService
			- Only the system can use FLAG_IDLE_UNTIL -- this is used to tell the alarm manager when to come out of idle mode, which is only for DeviceIdleController.
			- Check xem alarm đang xét có cần phải add thêm FLAG_STANDALONE hay không? nếu có thì add thêm vào
			  Ví dụ về một số alarm được add thêm FLAG_STANDALONE: 
			         + những alarm được xét bằng hàm setExact(), setIdleUntil(), setAlarmClock(), setExactAndAllowWhileIdle()
			- Nếu alarm đang xét là một  alarm clock thì add cờ FLAG_WAKE_FROM_IDLE và FLAG_STANDALONE
			=========================================================
			
			====== bắt đầu thực hiện xét alarm ====================
			// sẽ có 4 trường hợp gọi đến setImpl() method:
				+ xét một alarm khi nhận được request
				+ schedule time tick
				+ schedule date changed event 
				+ restore disallowed alarm list
			- setImpl(type, triggerAtTime, windowLength, interval, operation, directReceiver,
                    listenerTag, flags, workSource, alarmClock, callingUid, callingPackage){
					- Chỉnh sửa một số thông số về: 
						+ windowLength(là một duration): nếu windowLength lớn hơn 12 tiếng thì xét lại windowLength là 1 tiếng. 
						+ interval (là một duration):  đối với các repeat alarm, khoảng thời gian giữa hai lần trigger luôn phải lớn hơn 1s
						+ triggerAtTime(là một timestamp): nếu triggerAtTime < 0 thì xét triggerAtTime = 0 -> alarm sẽ được trigger ngay lập tức
						+ nominalTrigger: nếu alarm được xét có type là RTC_WAKEUP hoặc RTC thì triggerAtTime sẽ được convert to elapsed time, time đã được convert đó chính là nominalTrigger
						                  còn nếu alarm được xét có type là ELAPSED_REALTIME_WAKEUP hoặc ELAPSED_REALTIME thì nominalTrigger chính là triggerAtTime
										  nominalTrigger là một timestamp
						+ triggerElapsed: là thời gian trigger alarm chuẩn, được tính toán dựa trên nominalTrigger và minTrigger
						                   triggerElapsed là một timestamp
						+ maxElapsed: giá trị này được tính toán dựa trên windowLength của alarm. maxElapsed là một duration
					- check restrict 500 alarms for each App
					- setImplLocked(type, triggerAtTime, triggerElapsed, windowLength, maxElapsed,
								interval, operation, directReceiver, listenerTag, flags, true, workSource,
								alarmClock, callingUid, callingPackage){
						- thông tin thêm về một số tham số: 
							+ when: có thể là RTC hoặc ELAPSED_REALTIME
							+ whenElapsed: luôn luôn là ELAPSED_REALTIME
								Vậy sự khác nhau giữa when và whenElapsed là gì:  
									"when" thời gian user xét để trigger alarm, nó có thể là RTC hoặc ELAPSED_REALTIME
								    "whenElapsed" nó luôn luôn là ELAPSED_REALTIME, nếu "when" là RTC thì "whenElapsed" chính là biến đổi của "when" ở dạng ELAPSED_REALTIME  
																					nếu "when" là ELAPSED_REALTIME thì "whenElapsed" chính là "when"
							+ maxWhen: chính là maxElapsed
						- Alarm a = new Alarm();
						- tìm trong hệ thống, nếu tồn tại một alarm như thế này rồi thì remove nó đi {
							- removeLocked(operation, directReceiver);
						}
						- setImplLocked(a, false, doValidate);{
							- xét trường hợp alarm đang xét có cờ  FLAG_IDLE_UNTIL {
								xét lại when, whenElapsed, maxWhenElapsed cho alarm dựa vào một số điều kiện khác 
							} 
							- xét trường hợp trong hệ thống đang tồi tại một alarm mPendingIdleUntil {
								- Điều này có nghĩa là tất cả các alarm không có cờ FLAG_ALLOW_WHILE_IDLE/FLAG_ALLOW_WHILE_IDLE_UNRESTRICTED/FLAG_WAKE_FROM_IDLE mà được request to schedule trước khi mPendingIdleUntil được kích hoạt
								  đều bị xếp vào mPendingWhileIdleAlarms và dừng quá trình xét alarm cho đến khi mPendingIdleUntil được kích hoạt
								  RETURN.
							}
							- điều chỉnh delivery time{
								adjustDeliveryTimeBasedOnStandbyBucketLocked{
									- isExemptFromAppStandby(alarm) = true nghĩa là alarm đang xét có thể là alarmClock, hoặc được xét bởi system, hoặc có cờ FLAG_ALLOW_WHILE_IDLE_UNRESTRICTED thì ta sẽ không điều chỉnh delivery time của các alarm thuộc loại này
									- check lại thêm vì đếch hiểu chi cả ^^
								}
							}
							- Tiếp theo thực hiện insertAndBatchAlarmLocked(a); {
								- cố gắng tìm một cái batch đã đang tồn tại phù hợp cho alarm, nếu không có cái nào phù hợp thì tạo mới một cái 
								- xác định vị trí của batch đó trong mAlarmBatches list
								- add alarm vào batch 
								- vì start time của cái batch này đã có thể bị thay đổi do vừa add thêm alarm vào batch nên thứ tự của nó trong mAlarmBatches cũng có thể đã bị thay đổi vì thế cần phải thực hiện move nó về đúng vị trí của nó trong mAlarmBatches
							}
							
							boolean needRebatch = false;
							- xét trường hợp alarm đang xét có cờ  FLAG_IDLE_UNTIL {
								- xét mPendingIdleUntil = a
								- needRebatch = true
							} 
							- xét trường hợp alarm đang xét có cờ  FLAG_WAKE_FROM_IDLE {
								- xét lại mNextWakeFromIdle = a nếu cần thiết 
								- trong trường hợp mNextWakeFromIdle được update lại là a, có nghĩa rằng thời gian wake up from idle đã bị thay đổi(xảy ra sớm hơn), thì sẽ cần phải rebatch lại các alarm trong trường hợp whenElapsed của mPendingIdleUntil bị thay đổi(do mNextWakeFromIdle thay đổi)
								- needRebatch = true
							}
							
							- xét trường hợp rebatching = false {
								- mSamsungAlarmManagerService.notifySetAlarm(a, mNextAlarmClockMayChange); // SamsungAlarmManager:	 setExact Intent (T:2/F:1/AC:false) 20191128T092009 - CU:10195/CP:25296	
								- Nếu needRebatch = true {
									- rebatchAllAlarmsLocked(false); {
										// tạm thời bỏ qua
									}
								}
							}
							
							- rescheduleKernelAlarmsLocked(); {
								- tìm trong mAlarmBatches list hai batch: 
									+ firstWakeup
									+ nextNonWakeup
								- Ta luôn luôn xét xuống kernel hai loại alarm:
									1. wake up alarm: setLocked(ELAPSED_REALTIME_WAKEUP, firstWakeup.start);
									2. non wake up alarm: setLocked(ELAPSED_REALTIME, nextNonWakeup);
									- mSamsungAlarmManagerService.notifySetLocked(type, when);  // SamsungAlarmManager:	 setLocked to kernel ...
							}
							
							- updateNextAlarmClockLocked tương ứng với userId
						}
					}
			}
		}
	}
}


2. xử lý khi nhận được Expired
AlarmThread.run() {
	- ArrayList<Alarm> triggerList = new ArrayList<Alarm>();
	- int result = waitForAlarm(mNativeData);
	- mSamsungAlarmManagerService.notifyWaitForAlarm(result) // Slog.d(TAG, "Expired : " + result);
	- Xét trường hợp time change {
		(result & TIME_CHANGED_MASK) != 0 {
			- vì là change time nên cần phải schedule lại time tick, date, send broadcast ACTION_TIME_CHANGED
			CHÚ Ý: chỉ thực hiện schedule lại time tick, date, send broadcast ACTION_TIME_CHANGED khi mà khoảng thời gian giữa lần thay đổi trước và lần thay đổi này
			       ít nhất là 1s(tăng/giảm ít nhất là 1s). Nếu nhỏ hơn 1s thì sẽ không làm gì cả vì có thể
				   đó là tín hiện giả từ kernel do có sự điều chỉnh gì đó
			- thực hiện rescheduleKernelAlarmsLocked
		}
	}
	- xét trường hợp không phải là time change hoặc vừa là time change vừa là sign to trigger alarm {
		// trigger alarm 
		- mLastTrigger = nowELAPSED;
		- boolean hasWakeup = triggerAlarmsLocked(triggerList, nowELAPSED, nowRTC){
			- Duyệt lần lượt từng batch một trong  mAlarmBatches {
				- Batch batch = mAlarmBatches.get(0);
				- tại thời điểm này, chỉ xét những batch nào có start time nhỏ hơn nowELAPSED, 
				  những batch có start time lớn hơn nowELAPSED sẽ được xét sau {
					- mAlarmBatches.remove(0);
					- duyệt lần lượt từng alarm trong batch {
						- nếu alarm có chứa cờ FLAG_ALLOW_WHILE_IDLE {
							alarm manager sẽ hạn chế sự thường xuyên mà một app có thể schedule
							- nếu device ở trạng thái bình thường, khoảng thời gian giữa hai lần dispatching alarm là 1 giây
							- nếu device đang ở trang thái dozing mode, khoảng thời gian giữa hai lần dispatching alarm sẽ 9 phút
							Nếu vi phạm khoảng thời gian tiêu chuẩn trên thì thay vì deliver alarm tới app, activity manager sẽ thực hiện reschedule lại
							và duyệt alarm tiếp theo
						}
						- triggerList.add(alarm);
						- nếu alarm đang xét là mPendingIdleUntil {
							- bây giờ sẽ trigger alarm này nên xét lại mPendingIdleUntil = null
							- rebatch lại tất cả các alarm để đảm bảo thứ tự các alarm trong các batch đã đúng rồi 
							- sau đó thực hiện add các alarm(cái đã bị add vào mPendingWhileIdleAlarms trước khi trigger mPendingIdleUntil) vào một batch nào đó mà nó nên thuộc về
						}
						- nếu alarm đang xét là mNextWakeFromIdle {
							- bây giờ sẽ trigger alarm này nên xét lại mNextWakeFromIdle = null
							- rebatch lại tất cả các alarm để đảm bảo thứ tự các alarm trong các batch đã đúng rồi 
						}
						
						- nếu alarm đang xét là repeat alarm thì ta sẽ thực hiện xét alarm cho lần tiếp theo
						
						- nếu alarm đang xét là clock alarm thì sẽ thực hiện sends message SEND_ALRM_CLOCK_CHANGED
					}
				  }
			}
			- calculateDeliveryPriorities: TICK < WAKEUP < NORMAL
			- sắp xếp lại thứ tự các alarm trong triggerList dựa theo priority vừa tính toán
		}
		// Nếu không có wakeup alarm trong triggerList và non wakeup alarm có thể delay được thì sẽ không trigger alarm tại thời điểm này 
		// mà add alarm vào list mPendingNonWakeupAlarms
			Một non wakeup alarm có thể delay được khi screen off, tuy nhiên thời gian delay là khác nhau tương ứng với thời gian bao lâu screen đã off
				- nếu screen đã off là 5 phút thì có thể delay 2 phút 
				- nếu screen đã off là 30 phút thì có thể delay 15 phút 
				- nếu screen đã off là nhiều hơn 30 phút thì có thể delay 60 phút 
		// ngược lại, sẽ thực hiện trigger alarm 
		- đầu tiên sẽ merge mPendingNonWakeupAlarms vào triggerList. Tuy nhiên vẫn phải theo thứ tự TICK < WAKEUP < NORMAL
		- deliverAlarmsLocked(triggerList, nowELAPSED); {
			- Duyệt lần lượt từng alarm trong triggerList {
				- mDeliveryTracker.deliverLocked(alarm, nowELAPSED, allowWhileIdle){
					- mSamsungAlarmManagerService.notifyDeliverLocked   // Slog.v(TAG, "Sending to uid : " 
					alarm.operation.send(getContext(), 0,...
				}
			}
		}
		- rescheduleKernelAlarmsLocked();
		- updateNextAlarmClockLocked();
	}
}



mNonInteractiveStartTime: là thời điểm cuối cùng screen on cho đến nowELAPSED. trong khoảng thời gian từ mNonInteractiveStartTime đến nowELAPSED là screen đang off