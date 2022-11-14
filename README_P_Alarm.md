AlarmManagerService

SamsungAlarmManagerService

AlarmManagerServiceExt

TAG = "AlarmManager"

RTC = 1
ELAPSED_REALTIME_WAKEUP = 2
ELAPSED_REALTIME = 3

===start AlarmManager
SystemServer#startOtherServices
    mSystemServiceManager.startService(AlarmManagerService.class);
        new AlarmManagerService
            new SamsungAlarmManagerService
            AlarmManagerServiceExt#createAppSync
        onStart
            mHandler = new AlarmHandler
            setTimeZoneImpl
            
            
===recevie request===
AlarmManager#setImpl
    AlarmManagerService#mService#set // remove and add flags if need
        setImpl // calculate maxElapsed
            setImplLocked
                a = new Alarm(
                setImplLocked(Alarm a, boolean rebatching, boolean doValidate)
                
AlarmManagerService#setImplLocked(Alarm a, boolean rebatching, boolean doValidate)
    adjustDeliveryTimeBasedOnStandbyBucketLocked
    insertAndBatchAlarmLocked
        addBatchLocked
    SamsungAlarmManagerService#notifySetAlarm
        Slog.d(TAG, callStr + " (T:"
    if (needRebatch) {
        rebatchAllAlarmsLocked
        rescheduleKernelAlarmsLocked
        updateNextAlarmClockLocked

        
===trigger Alarm===
AlarmThread#run // receive Expired from native
    SamsungAlarmManagerService#notifyWaitForAlarm
        Slog.d(TAG, "Expired : "
    triggerList.clear()
    if ((result & TIME_CHANGED_MASK) != 0) { // time change
        removeImpl(mTimeTickSender);
        removeImpl(mDateChangeSender);
        rebatchAllAlarms();
        update mNumTimeChanged mLastTimeChangeClockTime mLastTimeChangeRealtime
        send broadcast ACTION_TIME_CHANGED
        rescheduleKernelAlarmsLocked
    }
    if (result != TIME_CHANGED_MASK) { // co the vua la TIME_CHANGED_MASK vua la sign to trigger alarm
        hasWakeup = triggerAlarmsLocked(triggerList
        if (!hasWakeup && checkAllowNonWakeupDelayLocked(nowELAPSED)) {
            mPendingNonWakeupAlarms.addAll(triggerList);
            rescheduleKernelAlarmsLocked
            updateNextAlarmClockLocked
        } else {
            if (mPendingNonWakeupAlarms.size() > 0) {
            }
            deliverAlarmsLocked(triggerList, nowELAPSED);
            reorderAlarmsBasedOnStandbyBuckets(triggerPackages);
            rescheduleKernelAlarmsLocked();
            updateNextAlarmClockLocked();
        }
    }
    
    
    
    
    
    AlarmManagerService#deliverAlarmsLocked // duyet tung Alarm trong triggerList
        AlarmManagerService#DeliverTracker#deliverLocked 
            if (alarm.operation != null)
                SamsungAlarmManagerService#notifyDeliverListenerLocked
                    Slog.v(TAG, "Sending to uid : " + alarm.uid +
                alarm.operation.send
            else 
                alarm.listener.doAlarm
                SamsungAlarmManagerService#notifyDeliverListenerLocked


                
AlarmManagerService#triggerAlarmsLocked
    while (mAlarmBatches.size() > 0) {
        batch = mAlarmBatches.get(0);
        mAlarmBatches.remove(0);
        for (int i = 0; i < N; i++) { //duyet tung alarm trong batch
            if ((alarm.flags&AlarmManager.FLAG_ALLOW_WHILE_IDLE) != 0) {
            }
                getWhileIdleMinIntervalLocked
                setImplLocked
                if (isBackgroundRestricted(alarm)) {
                    mPendingBackgroundAlarms.put
                }
                alarm.count = 1;
                triggerList.add(alarm);
                if (mPendingIdleUntil == alarm) { 
                    mPendingIdleUntil = null;
                    rebatchAllAlarmsLocked
                    restorePendingWhileIdleAlarmsLocked
                }
                if (mNextWakeFromIdle == alarm) {
                    mNextWakeFromIdle = null
                    rebatchAllAlarmsLocked(false);
                }
                if (alarm.repeatInterval > 0) {
                    setImplLocked
                }
                
        }
    }
    calculateDeliveryPriorities

    if (localLOGV
        Slog.v(TAG, "Triggering alarm # // print all alarm in triggerList
        
AlarmManagerService#triggerAlarmsLocked
    duyet tung batch trong list mAlarmBatches
    duyet tung alarm trong batch vua lay ra
        if ((alarm.flags&AlarmManager.FLAG_ALLOW_WHILE_IDLE) != 0) {
            getWhileIdleMinIntervalLocked
            setImplLocked
        if (isBackgroundRestricted(alarm)) {
        alarm.count = 1;
        triggerList.add(alarm);
    calculateDeliveryPriorities
    


AlarmManagerService#rebatchAllAlarmsLocked
    clear mAlarmBatches
    duyet tung batch trong list clone
        duyet tung alarm trong batch do
            reAddAlarmLocked // calculate whenElapsed maxWhenElapsed expectedWhenElapsed expectedMaxWhenElapsed
                setImplLocked

AlarmManagerService#rescheduleKernelAlarmsLocked //reschedule in case need to update fistWakeup and nextNonWakeup, update mNextWakeup and mNextNonWakeup also
    setLocked
        if (NativeData != 0) {
            SamsungAlarmManagerService#notifySetLocked
                Slog.i(TAG, "setLocked to kernel
            set(mNativeData, type, alarmSeconds, alarmNanoseconds);
                Slog.wtf(TAG, "Unable to set kernel alarm, //in case has failure when set to native
        else {
            SamsungAlarmManagerService#notifySendAlarmEvent
                Slog.w(TAG, "send alarm event

AlarmManagerService#updateNextAlarmClockLocked
    
mAlarmBatches
addPendingAlarmList
mNextAlarmClockForUser
mPendingSendNextAlarmClockChangedForUser

mPendingNonWakeupAlarms duoc add khi 
    (!hasWakeup && checkAllowNonWakeupDelayLocked(nowELAPSED)) // khong co wake up va cho phep delay

triggerList duoc add khi
    - trigger 1 Alarm ma no ko co flag FLAG_ALLOW_WHILE_IDLE
    - triggerList.addAll(mPendingNonWakeupAlarms); // add all tu mPendingNonWakeupAlarms

mPriorities


Question:
    when start?
    type
    when AlarmManager trigger
    add to batchs?



canHold()

Schedule an Alarm
Alarm clock


mNextWakeup
mNextNonWakeup
CU = CallingUid = id của app
CU = Calling Pid = id của process



system current time: dong bo khi co mang
    RCT_WAKEUP/RTC
elapse realtime: thoi gian tinh tu luc boot device
    REALTIME_WAKEUP/REALTIME
Alarm Flag:
    STANDALONE
    WAKE_FROM_IDLE: wake up device from idle state, app use once time
    ALLOW_WHILE_IDLE
    ALLOW_WHILE_IDLE_UNRESTRICTED:
    IDLE_UNTIL: tat ca alarm set sau do se duoc add vao 1 list, sau khi alarm set IDLE_UNTIL duoc trigger thi cac alarm do moi dc schedule

===dump
DUMP OF SERVICE alarm:
Current Alarm Manager state:

Pending alarm batches

P200107-08343

//DOTO 
make up test alarm, get dumpstate and compare alarm dump with system log

01-14	13:16:36.834	D	1560	1896	SamsungAlarmManager:	 setExact Intent (T:0/F:3/AC:true) 20190114T131700 (O:1547446620000/E:442718500/ME:442718500/RI:0) nowELAPSED=442695333 - CU:10109/CP:27310/op:PendingIntent{2e81943: PendingIntentRecord{5e701fd com.sec.android.app.clockpackage broadcastIntent}}	



===P191123-01491 DUT failed to set up automatic date and time

Below is latest time set log before reboot.
11-28 11:00:34.150  1243  4541 W SamsungAlarmManager: setTime : 1575003600000 CU:1000/CP:9329
11-28 11:00:34.150  1243  4541 D AlarmManagerService: Setting time of day to sec=1575003600

and Below is the set time log when the device reboots.
11-28 23:01:04.557  1283  1283 D AlarmManagerService: Kernel timezone updated to 360 minutes west of GMT
11-28 23:01:04.557  1283  1283 D AlarmManagerService: Setting time of day to sec=1575294698

And below is the build time.
[ro.build.date.utc]: [1575294698]

As i told you, when the device reboot, AlarmManagerService sets time to build time.
That's concept of Google for file security. 	


P210123-02195[EV1][P615/EUR][Settings] Date and time not mantain after resart device

P210412-05442
As log, last time changing was 2021-03-27 13:38:49.572
  mLastTimeChangeClockTime=1616852329572=2021-03-27 13:38:49.572
  mLastTimeChangeRealtime=788702

And there is no request to change time in remain log.
