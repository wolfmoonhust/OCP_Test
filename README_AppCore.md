My PC:
SERIAL: 0G5E91EG500114
MODEL: 870Z5G


Currently we have two team CoreBasic(=AppCore basic), CoreAdvance(=AppCore MultiTask)
CoreBasic
TL : ksteel.kang
TPM : seonghoon77.choi

CoreAdvance
TL : sm74.you
TPM : espodel.kang

==========
KeyConsumed <- KeyHandle
KeyTriggered <- press Key

could not press hardkey -> need check stack when press key -> enough function (queueing, dispatch...)-> check logic else input framework need to check (Refer: P170601-05052 )

System key: power, recent, home -> handle by  SS, App does not do anything 


get log:
adb logcat -v threadtime | findstr -i inputdispatcher


Slog.d("Phong TX", "ahihi", new RuntimeException().fillInStackTrace())

=======AMS=========
Start Activity
    received request
    handle user id
    Query Activity Info
    Handle Intent/Class not found err
    Check Permission
    Check IntentFirewall
    Create ActivityRecord
    StartActivityUncheckedLocked
        handle launchmode FLG clear task, clear top
        handle onNewIntent case
    ActivityStack.startActivityLocked
        Insert Task At Top of Stack
        Starting window show for non-booting
        PrepareAppTransition
        setAppStartingWindow
    Set focus
    Resume - Top of focus Stack

============================

[김기호 / KiHo Kim] - 13:10                 
if interceptkeyTi about home key down displayed this means interactive is true when home key down

[김기호 / KiHo Kim]
if lcd off situation is..... interactive is false...

==============gumi biztrip=============
p4: 165.213.202.46:1716



layout issue P171018-01989
- check layer dump  (dumpsys)
- check mFrame, content frame is correct or not
- enbale DEBUG_LAYOUT and check "Compute frame" if pf is incorrect -> rootcause is in PWM
- check in PWM.layoutWindowLw()
- check in mSPWM.applyFrameInLayoutWindowLw(): need check pf of .... before and after child function

[Nguyễn Tiến Trung / Nguyen Tien Trung]
Tóm lại dump visible mà thấy frame sai thì enable debug layout check xem sai ở compute hay là sai ở layoutwindowlw

[Nguyễn Tiến Trung / Nguyen Tien Trung]
Sau thì check xem type nào để ktra logic tương ứng của nó


[Nguyễn Tiến Trung / Nguyen Tien Trung]
Debug đc là đẹp nhất :v



===============Schedule VSYNC==================
  Conclusion: Schedule VSYNC when -> schedule Frame   (postCallback -- most important)
        postCallback
            View - animation, drawable need to be scheduled     -> main reason 2
            schedule batch input
            ViewRootImpl scheduleTraversals                     -> main reason 1
                setLayoutParams
                setLayoutParams
                handleGetNewSurface
                handleGetNewSurface
                requestFitSystemWindows
                requestLayout
                invalidate                      -> main reason
                invalidateRectOnScreen
                setWindowStopped
                draw canceled but view still visible
                profileRendering ???
                drawing got some kind of err, draw & animating
                requestChildFocus
                clearChildFocus
                handleDispatchSystemUiVisibilityChanged
    unscheduleTraversals
        dispatchDetachedFromWindow
        set view got error (app will die)



===[Android] [View] draw process
basic flow
	- add window request (APP)
	- Calculate the desired size of the app by measuring based on resource config (View)
	- relayout window reuqest (ViewRootImpl)
	- compute window frame (WM)
	- Surface creation
	- Initialize ThreadedRenderer with surface obtained through relayout
	- measure again with mWinFrame obtained via relayout
	- based on the final measure performLayout → host.layout ()
	- If a layout request occurs again during host layout (add measure → host.layout ())
	- perform draw (View / ThreadedRenderer)
	- ThreadedRenderer.draw or ViewRootImpl.drawSoftware

	
===remove app======
adb remount
adb shell
cd system/priv-app
cd IssManager
ls -al
cd ..
rm -rf adb -> remove
adb reboot 


P171018-00359  log tool
P171013-04068  log tool dau nam
mCurrentCoverType = 10 enable mobile keyboard

WindowLayerController.java


======================
starting window
- khong nam trong app process
- co the check status cua window trong thoi diem xay ra issue khi khong lay duoc log real time bang cach check dumpsys window
P180119-04449: check remove starting -> check status cua tat ca cac window cua app ->

=== lost focus ===
[김기호 / KiHo Kim] - 14:44                 
that kind of issue is app issue

[김기호 / KiHo Kim] - 14:44                 
inputwindowhandle is already set to launcher

[김기호 / KiHo Kim] - 14:45                 
but there is no focus window

[김기호 / KiHo Kim] - 14:46                 
Pwm is not control about it

[김기호 / KiHo Kim] - 14:47 
this could be mostly view and input or app issue, but it is impossible to analyze exactly in the log

[김기호 / KiHo Kim] - 15:10                 
input focusedapplication is set when focus application is changed, activity manager call to api on wms, so some app is resume or pause or create... this variable is update.

[김기호 / KiHo Kim] - 15:10                 
focusedWindow on input is set inputWindowHandle as you told me before

[김기호 / KiHo Kim] - 15:11                 
if there is no hasfocus window on inputWindowHandle, input cannot set about it

[김기호 / KiHo Kim] - 15:11                 
sometimes system doesn't have any focus window by app setting

[김기호 / KiHo Kim] - 15:12                 
focused application is changed but the app is not set focus window flag at that time

[김기호 / KiHo Kim] - 15:12                 
if so, the situation is occured

[김기호 / KiHo Kim] - 15:13                 
but it may once issue, so there is almos no any log about it.

[김기호 / KiHo Kim] - 15:13                 
it need to check wms log after set log status

[김기호 / KiHo Kim] - 15:14 
i know it is hard to check it...

[김기호 / KiHo Kim] - 15:17                 
i think there is log about window flag info like FLAG_NOT_FOCUSABLE....

[김기호 / KiHo Kim] - 15:17                 
you can check

[Trần Xuân Phong / Tran Xuan Phong] - 15:32 
you mean that we should check  values of flag whether it has FLAG_NOT_FOCUSABLE or not in fl value of window in this time, right?

[김기호 / KiHo Kim] - 15:32 
yes





===graphic docs===
\\107.113.53.70\Framework P\05.Users\nghi.nv\GraphicsFW\Documentation Guide\Cases Study
\\107.113.53.70\Framework P\05.Users\nghi.nv\GraphicsFW\Suwon-biz-trip\Documentation

0x00080000 show when lock
0x00400000 dismiss key guard


=== draw process===
basic flow
	- add window request (APP)
	- Calculate the desired size of the app by measuring based on resource config (View)
	- relayout window reuqest (ViewRootImpl)
	- compute window frame (WM)
	- Surface creation
	- Initialize ThreadedRenderer with surface obtained through relayout
	- measure again with mWinFrame obtained via relayout
	- based on the final measure performLayout → host.layout ()
	- If a layout request occurs again during host layout (add measure → host.layout ())
	- perform draw (View / ThreadedRenderer)
	- ThreadedRenderer.draw or ViewRootImpl.drawSoftware
	
                        (res & WindowManagerGlobal.ADD_FLAG_ALWAYS_CONSUME_NAV_BAR) != 0;

get setting value
adb shell settings get secure double_tab_launch_component


different val and var
different inner class vs nest class

====window cutout====
window cutout
14426409 Add Floating feature for DisplayCutout
14366488 Add Product feature for DisplayCutout
    //OHIO81/Cinnamon/frameworks/base/core/samsung/java/com/samsung/android/config/SamsungCoreConfig.java#9
    //OHIO81/Cinnamon/vendor/samsung/configs/feature/SecProductFeature/SecProductFeature.default#71
    //OHIO81/Combination/SDM710/model/a9sqlte/vendor/a9sqlte_common/SecProductFeature.common#8
14313089 DisplayCutout Backporting from AOSP 9.0



//OHIO81/Cinnamon/frameworks/base/core/res/res/values/config.xml
//OHIO81/Cinnamon/frameworks/base/core/res/res/values/symbols.xml#22
     <java-symbol type="string" name="config_mainBuiltInDisplayCutout" />
     <java-symbol type="bool" name="config_fillMainBuiltInDisplayCutout" />
     
     
14597301 Apply conventional & display cutout policy


“Choreographer(abc): Skipped xx frames! The application may be doing too much work on its main thread.” 
These logs generally will appear when the MAIN thread is not able to complete or remain busy due to heavy task.


[정병석 / ByungSeok Jung] - 16:58                 
adb reboot recovery

[정병석 / ByungSeok Jung] - 16:58                 
and

[정병석 / ByungSeok Jung] - 16:59 
push it while recovery mode

==============
Dismiss Dialog
dismissDialog()
    mWindowManager.removeViewImmediate(mDecor) ==> WindowManagerImpl : removeViewImmediate() ==> WindowManagerGlobal : removeViewLocked()==> ViewRootImpl : die

mHandler.sendEmptyMessage(MSG_DIE); ==>doDie(); ==>             if (mAdded) {
                dispatchDetachedFromWindow();
            }
======
state LCD: 
    LightsHAL: lcd

====== Splash screen====
O OS:
app side: need to define
    <meta-data
                    android:name="com.samsung.android.startingwindow.LAYOUT_RESID_FOR_MASS"
                     />
framework: default support
P OS:
app side: need to define
    <meta-data
                    android:name="com.samsung.android.startingwindow.LAYOUT_RESID_FOR_MASS"
                    />
framework: default not support

additionally, need to check:
    if (pm.hasSystemFeature(PackageManager.SEM_FEATURE_DEVICE_CATEGORY_PHONE_LOW_END)
                || (pm.hasSystemFeature(PackageManager.SEM_FEATURE_DEVICE_CATEGORY_TABLET)
                        && !pm.hasSystemFeature(PackageManager.SEM_FEATURE_DEVICE_CATEGORY_TABLET_HIGH_END)))
Ex:
    //PROD_PEACE/WINNER/SM-F900_EUR_NA/model/winnerlte/build_conf/common_build_conf.winnerlte
        device-category = phone_high_end // this value define
https://code.sec.samsung.net/ogre/server/1716/preview/PROD_PEACE/WINNER/SM-F900_EUR_NA/model/winnerlte/build_conf/common_build_conf.winnerlte%231?included_paths=&keyword=%22device-category%22&limit=50&workspace=w-TEMPLATE_D4_WINNERLTE-EUR-OPEN_PPREL

===check keyguard type:
KeyguardSecurityView: showSecurityScreen

====== to check SEP version======
SEC_PRODUCT_FEATURE_FRAMEWORK_SUPPORT_MIRROR_LINK
    change to false if device run SEPLite???
    
SEC_PRODUCT_FEATURE_COMMON_CONFIG_SEP_CATEGORY ->
//PEACE/Strawberry/EXYNOS5/model/m20lte/build_conf/common_build_conf.m20lte
    	se-platform-category = sep_lite
[Akash Goel] - 13:37                 
To check any model is SEP Lite or not

[Akash Goel] - 13:37                 
you can refer build_conf file of that model

[Akash Goel] - 13:38                 
Example

[Akash Goel] - 13:38                 
//PEACE/Strawberry/EXYNOS5/model/m20lte/build_conf/common_build_conf.m20lte#3

[Akash Goel] - 13:38                 
se-platform-category = sep_lite

[Akash Goel] - 13:38                 
if any model is sep_lite then category is sep_lite

[Trần Xuân Phong / Tran Xuan Phong] - 13:41 
I see

[Trần Xuân Phong / Tran Xuan Phong] - 13:41 
but i have a bit confusion

[Trần Xuân Phong / Tran Xuan Phong] - 13:41 
because SEC_PRODUCT_FEATURE_COMMON_CONFIG_SEP_CATEGORY was not set

[Trần Xuân Phong / Tran Xuan Phong] - 13:42 
Could you please explain for me?

[Akash Goel] - 13:50                 
I am not pretty sure about it

[Akash Goel] - 13:50                 
but this look up is done

[Akash Goel] - 13:51                 
//PEACE/Cinnamon/buildscript/build_common/core/config.py#12

[Akash Goel]
168    def get_spf_overlay(self, cfg):
169        """
170        :return: (dict)
171        """
172        # make spf name for build module - prefix is added
173        spfname = lambda x: 'SEC_PRODUCT_FEATURE_' + x
174        spf2opt = {
175            spfname('BUILD_PRODUCT_SHIP'): 'sec-product-ship',
176            spfname('BUILD_FACTORY_BUILD'): 'factory-build',
177            spfname('BUILD_INCLUDE_CONFIRMED_APKS'): 'include-confirmed-apks',
178            spfname('FACTORY_SUPPORT_INTERPOSER'): 'interposer-binary',
179            spfname('COMMON_CONFIG_SEP_VERSION'): 'se-platform-version',
180            spfname('COMMON_CONFIG_DEVICE_CATEGORY'): 'device-category',
181            spfname('COMMON_CONFIG_SEP_CATEGORY'): 'se-platform-category'
182        }
14864404 in 8.1
====
10359667  add power key double concept to quick launch camera

===P190212-06582
     [T725/SEA/VN][Keyboard] Keyboard blinking when Search in email
     -> disable animation in power saving mode
     
===CTS checking===
Test case: 
    port 1740
    path: for 9.0 //TEAM/GOOGLE_APPROVAL/CTS/CTS_9.0_Rev1/cts/tests/framework/base/activitymanager/
log:
    FAIL LOG -> Device logcat
===P190614-02052 surface remain
    same root cause with P180321-06441 P180227-02978 P190227-04930 P180720-04358 P180321-06441



https://developer.android.com/studio/intro/keyboard-shortcuts

Reformat Code (CTRL+ALT+L / Command+Option+L):
Basic Code Completion (CTRL+Space/Command+Space):
Override Methods(CTRL+O/Command+O) :
Generate Code (ALT+INS/Command+N) :
Search By Symbol Name (CTRL+Alt+Shift+N/Command+Option+O) :
ind Action (CTRL+Shift+A/Command+Shift+A) :
Find Action (CTRL+Shift+A/Command+Shift+A) :
Recently Opened Files (CTRL+E/Command+E):
Search Everywhere (Press Shift Twice / Press Shift Twice):

==== check package of pop up
adb exec-out uiautomator dump /dev/tty > log.log

===P190618-03592 check screen timeout
DEBUG_KEEP_SCREEN_ON SCREEN_ON
tips: normally, screen userActivityTimeout was set only w.mAttrs.userActivityTimeout >= 0
we can see this value when search "userActivityTimeout" in log

===write log to file 
15256814

===
[Lưu Quốc Tín / Luu Quoc Tin] - 09:10                 
[Phạm Quang Vinh / Pham Quang Vinh] - 08:56                 
bên SysUI, Setting đợt này cũng nhiều issues nhưng báo cáo khiêm tốn quá

[Phạm Quang Vinh / Pham Quang Vinh]
SETTINGS & SYSTEM U
P190620-01598: Apply 6 preloaded video wallpapers for A805_BlackPink (LDT salescode)
Currently, Wallpaper can setup only one OMC video wallpaper
Need to change concept and logic to set up several OMC video wallpapers
Done by CL 16389627

===Systrace when booting
[Lê Phương Tú / Le Phuong Tu] - 10:47                 
16476442 P

[Lê Phương Tú / Le Phuong Tu]
16477802 Q
==== build fail due to RP 
add to end of command build: --skip-rpcheck

E.g: 	./build -oa -tuser -r14377560 -ma -d mid -i A750FNXXU1ASB1 -j 1ASB1 -S -T -C 3.0 -Wf -G -l A750FNXXU1ASA4 --skip-rpcheck a7y18lte_eur_open OXM OXM_SUP

====Source Insight Liscense
App.Date
 2016-11-03  
Use Exp.Date
 2017-11-01  

PC ID
 626775 
PC S/N
 0G5E91EG500114 

License S/N
 SI3US-500712-28127 
CIS CODE
 Q430-026611 

====kill process===
a51:/ #  ps -A | grep systemui
u0_a54       23675  4517 8231380 255048 ep_poll             0 S com.android.systemui
a51:/ # kill 23675

====insert SIM
[Phan Anh Dũng / Phan Anh Dung]
ICC_CARD_STATE

====
add to style:
    <item name="android:windowDisablePreview">true</item>

===App Entry===
[APP진입성능][APP실행속도]
APP실행속도
===layer dump in case does not get by surface dump===
adb shell dumpsys SurfaceFlinger --file --no-limit // this will start collect adb shell dumpsys surfaceflinge to file : /data/vendor/display/dumpsys.txt 
Perform the test,when finish 
adb shell dumpsys SurfaceFlinger --file --no-limit // same command to stop the collection 
adb pull /data/vendor/display/dumpsys.txt ./

==== check change list build to compare version===
flash : ro.build.changelist=18069879
fota : ro.build.changelist=16947210 	

===P200303-07282 Issue: The ratio of override density to physical density is small then 0.85
18170189 

===
[Lưu Quốc Tín / Luu Quoc Tin]
Debugging Tips:
You can debug/dump all Messages dispatched by a Looper by attaching a LogPrinter:
final Looper looper = getMainLooper();
looper.setMessageLogging(new LogPrinter(Log.DEBUG, "Looper"));

===app transition===
The left / right move VI is a VI that occurs when moving between tasks.
Up / down movement VI is a VI that occurs when moving between activities.

It seems that the setting team needs to check.

===UX for appcore===
//ANDROID/Applications/Basic_Interaction_(Android)/UI/[OneUI2.X]/[OneUI2.X]Basic_Interaction_UI.pptx
//ANDROID/Applications/Multi_Window/UI/[OneUI2.X]/[OneUI2.X]Multi_Window_UI.pdf
//ANDROID/Applications/Multi_Window/UI/[OneUI2.X]/[OneUI2.X]Multi_Window_UI_[Winner].pdf

//ANDROID/Applications/Basic_Interaction_(Android)/GUI/[OneUI2.X]/Phone/Global/[OneUI2.X]Basic_interaction_GUI.pptx 834930  Added one UI 2.5 (p.3)
//DESIGN/Standard/UX/Common/

//ANDROID/Applications/Edge/UI/[OneUI2.X]/[OneUI2.X]Edge_Basic_UI.pdf

===OneUI version===
follow SEP version release
    http://mosaic.sec.samsung.net/kms/comty.do?comtyId=2492752&menuId=2492770&page=list&type=LIST

===check JDM project
//QUEEN/Waffle/SM6115/model/gta4l/vendor/gta4l_common/SecProductFeature.common
SEC_PRODUCT_FEATURE_COMMON_CONFIG_DEVICE_MANUFACTURING_TYPE=jdm

===Dismis Dismiss Keyboard shortcut dialog
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 dispatchDetachedFromWindow 	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 java.lang.RuntimeException	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at android.view.ViewRootImpl.dispatchDetachedFromWindow(ViewRootImpl.java:4626)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at android.view.ViewRootImpl.doDie(ViewRootImpl.java:8122)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at android.view.ViewRootImpl.die(ViewRootImpl.java:8083)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at android.view.WindowManagerGlobal.removeViewLocked(WindowManagerGlobal.java:498)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at android.view.WindowManagerGlobal.removeView(WindowManagerGlobal.java:436)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at android.view.WindowManagerImpl.removeViewImmediate(WindowManagerImpl.java:124)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at android.app.Dialog.dismissDialog(Dialog.java:518)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at android.app.Dialog.dismiss(Dialog.java:501)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at com.android.systemui.statusbar.KeyboardShortcuts.dismissKeyboardShortcuts(KeyboardShortcuts.java:436)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at com.android.systemui.statusbar.KeyboardShortcuts.dismiss(KeyboardShortcuts.java:201)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at com.android.systemui.statusbar.phone.StatusBar.dismissKeyboardShortcuts(StatusBar.java:7854)	
03-08	14:08:06.042	D	12916	12916	phongtxViewRootImpl:	 	at com.android.systemui.statusbar.phone.StatusBar$H.handleMessage(StatusBar.java:3201)	

===get setting config
https://mobilerndhub.sec.samsung.net/wiki/display/SVMC/Some+useful+adb+commands
 
_id:233 name:auto_time_zone pkg:com.android.providers.settings value:0 default:0 defaultSystemSet:true
_id:232 name:auto_time pkg:com.android.providers.settings value:0 default:0 defaultSystemSet:true

adb shell settings get global auto_time

===R OS
19691028 reset ANR timeout when focused window is set


show memo in lockscreen
- sticky note: user needs to unlock devices
- write on lockscreen: only for note device, if user unlock device many times, meno will be saved and memo will not be shown in lockscreen when user unlock device

===
split
picture in picture
free form
ghost mode
immersive navigationbar
conventinal mode
smart popup view
power key

=== enable proto log
You can use the command : adb shell wm logging enable-text WM_DEBUG_FOCUS WM_DEBUG_FOCUS_LIGHT
adb shell wm logging enable-text WM_DEBUG_ORIENTATION 


===dumps 
DUMP OF SERVICE settings: -> adb shell dumpsys settings
===
P201228-02131(Not Released)   [A715F/EUR/EV1] [Setting] Phone show black screen when run one hand mode

P201204-04668   [AES][APP실행속도][G715FN][TL2][반응속도] G715FN ROS App실행속도 시험 G715FN QOS 대비 열세 件 

===under checking
TODO: 

 
 P210215-01251
 G887N SN 354453100001513
 
 P210215-01251
  P210210-03633 T865 - CAMERA_CRASH_com.sec.android.app.camera

  
- P210219-04999 cowork with launcher team to check "Recent task screen has a black strip when rotate device" on tab A7 (T505).


 C:\SCS\CS_LogFilter_ver_2_1\log\LogFilter_20210116_181042.txt
 
 
===App entry R OS===
P201204-04668 G715FN animation for starting Gallery
P210309-03107 A015F Gallery
P210308-03663 A217F Contact

==sys trace
systrace.py -t 10 gfx input view wm am res dalvik bionic sched freq idle power binder_lock binder_driver -a com.android.systemui -o 1.html

===monitoring===
P210402-01439 ĐEICATED MEMORY



W12

 



C:\Users\phong.tx\AppData\Local\Temp\Temp1_dumpstate_app_anr-2021-04-01-16-15-51.zip\dumpstate_app_anr-2021-04-01-16-15-51.txt
===patent===

[Lưu Quốc Tín / Luu Quoc Tin]
https://mobilerndhub.sec.samsung.net/wiki/display/SVMC/Framework+P+-+Patent+Activity+Progress

ActivityRecord#showStartingWindow
    mCustomStartingWindowController.addData
    
    
getCustomStartingWindowMap
    mCustomStartingWindowMapsForUsers.get(userId)

    
    
    
====

- Có 6 năm kinh nghiệm phát triển phần mềm, maintain AOSP source code.
- Tự tin với ngôn ngữ lập trình Java/Kotlin
- Có khả năng học hỏi, tìm hiểu công nghệ mới
- Có khả năng làm việc nhóm, độc lập, làm việc dưới áp lực cao.
- có kiến thức  với phương pháp quản lý dự án: Scrum,Agile, waterfall.



- Project: Application Core framework
- Ngôn ngữ: Java.
- Vai trò: Technical leader for 4 years.
    + maintain google open source code, đảm bảo sự tương thích các feature của samsung với 3rd party app.
    + develop idea, feature nhận được từ các team khác.
    + porting các feature samsung lên các OS.

- Project: media core framework
- Ngôn ngữ: C++
- Vai trò: member for 1,5 years
    + maintain google open source code
    + co-work với vendor (Qualcomn, mediatek, SLSI), apply firmware,
    + porting các feature samsung lên các OS.



=== surface dump
adb shell se property debug.sf.layerdump N(1~4)
 1 : add log of Hwcomposer::dump() every frame commit
 2 : save dumpsys SF as text file in /data/log/
 3 : dump layer’s buffer raw in /data/log/
 4 : dump layer’s buffer raw as 1/4scale down in/data/log/
 
=== animation duration
1393 01-17 20:22:41.773 1176 1365 D SettingsProvider: isChangeAllowed() : name = window_animation_scale
1396 01-17 20:22:41.773 1176 1365 D SettingsProvider: isChangeAllowed() : name = transition_animation_scale
1398 01-17 20:22:41.773 1176 1365 D SettingsProvider: isChangeAllowed() : name = animator_duration_scale
