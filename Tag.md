MultiSelectManager|
AppsController|
AppsDragController|
AppsAdapter|AppsModel|
Launcher.AppsPagedView|
FolderController|
FolderIconDropController|
Launcher.Workspace|
Launcher.HomeController|
Launcher.Model|
FavoritesUpdater
StageManager
badge_app_icon_type
SYSTEM SETTINGS
AP RESET INFO EXTEND
AutoInstalls
AppIconSolution
LauncherActivityInfo
//Home
TouchInteractionService
SGestureDetector
SysUINavigation
UserEvent

InputDispatcher: Focus|InputDispatcher: Delivering touch to |InputReader: Btn_touch| statemanager:|onActivityInit, alreadyOnHome|RemoteCloseAnimation|onEnterAnimationComplete|Launcher: !@Boot_DEBUG: Launcher.onResume()|isInSwipeUpTouchRegion = true|OtherActivityInputConsumer:|TaskAnimationManager:|RecentsAnimationCallbacks|RemoteCloseAnimationListener|WindowManager: startRecentsActivity


PAI(Play auto install) OMC(Open Market Customization)

--- HomeSettings
false|true|false|false|true|CUSTOM_GRID|true
HomeOnly | Apps Button | Edit Lock | QuickPanel | PortOnly | AppsViewType | Search From Home | FolderSyncPreferenceSet

sehome_portrait_mode_only

DUMP OF SERVICE notification:
Current Notification Manager state:

AppSettings
BadgeCountReceiver|BADGE_COUNT_UPDATE
PopupDataProvider
onNotification
notification_enqueue|notification_canceled

notification_badging: 0 disable, 1 enable
badge_app_icon_type
AppSettings: com.samsung.android.app.simplesharing (10161) showBadge=true

StatusBarIconView
NotificationColorPicker

Live notification listeners (7):

Pid map: PID mappings:

navigation_mode
	THREE_BUTTONS(false, 0),
	TWO_BUTTONS(true, 1),
	NO_BUTTON(true, 2),
	S_GESTURE(true, 3);
	
Gesture vibration: navigation_gestures_vibrate, touch vibration: haptic_feedback_enabled


time="2/27/2019, 14:40" type=CONFIGURATION_CHANGE package=android config=en-rUS-v26 flags=0x0 
dumpsys activity intents
dumpsys activity broadcasts

set_zen_mode

Data Model:

system_app_anr

android.intent.action.DELETE
InstallShortcutReceiver/UninstallShortcutReceiver
  mIsGameServiceEnabled: true
  mIsGameHomeEnabled: true
  
Theme: current_sec_active_themepackage

All setting value: GLOBAL SETTINGS SYSTEM SETTINGS (user 0)
  
public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0;
public static final int COMPONENT_ENABLED_STATE_ENABLED = 1;
public static final int COMPONENT_ENABLED_STATE_DISABLED = 2;
public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3;
public static final int COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED = 4

SysUINavigationMode: initializeMode, mMode = NO_BUTTON
navigation_bar_gesture_hint = 0

        THREE_BUTTONS(false, 0),
        TWO_BUTTONS(true, 1),
        NO_BUTTON(true, 2),
        S_GESTURE(true, 3);

BUFFER NavBarLogger:

NavigationModeController:
      mode=3
      defaultOverlays=
      defaultLauncher=com.sec.android.app.launcher
      previouslySwitchedFromGestureNav=false
      previouslySwitchedOnRestoreLauncher=false
      restoreOverlay=com.android.internal.systemui.navbar.threebutton
      navbarCanMove=true
      mOverlayHistoryList.size=0
	  
Capture screen shot: ActivityManager: Start proc 31283:com.android.systemui:screenshot/u0a52 for service {com.android.systemui/com.android.systemui.screenshot.TakeScreenshotService}
	  
** MEMINFO in pid 10180 [com.sec.android.emergencymode.service] **

[DeviceConfig]

------ AP RESET INFO (/data/system/users/service/data/RR.p) ------

Booting issue tag:
!@Boot: bootcomplete 
cpuinfo:
P210109-00352, P200618-07913, 

When we checked the A series booting issue in PLM, then arranged the launcher booting time during !@Boot_DEBUG: Launcher.onCreate() ~ !@Boot_DEBUG: Launcher - FinishFirstBind.

P201221-05660
DUT :A715FXXU3BTL3 : 7 s
REF :A715FXXU3ATK1 : 5.8 s

P201211-03781
DUT :A525FXXU0ATL3 : 6.7 s
REF :A705GMDDU5BTJ3 : 4.3 s

P201221-06260
DUT :A715FXXU3BTL3 : 6.6 s
REF :A715FXXU3ATK1 : 5.1 s

P201220-00392
DUT :A515FXXU4DTL4 : 4.3 s
REF :A515FXXU4CTJ1 : 5.7 s

So, the average launcher booting time maybe 4~5 sec in a kind of this A series model.

And the launcher booting time of A725F in this issue is 4.6 sec, so it's not lower than other model.

Memory leak
** MEMINFO in pid 2660 [com.sec.android.app.launcher] **

Square icon due to develop option
com.android.theme.icon.square:0 {
  mPackageName...........: com.android.theme.icon.square
  mUserId................: 0
  mTargetPackageName.....: android
  mTargetOverlayableName.: null
  mBaseCodePath..........: /product/overlay/IconShapeSquare/IconShapeSquareOverlay.apk
  mState.................: STATE_ENABLED
  mIsEnabled.............: true
  mIsStatic..............: false
  mPriority..............: 1
  mCategory..............: android.theme.customization.adaptive_icon_shape
} 

Issue Segmentation fault P181224-03599
Issue duplicate icons P181226-03640, P181224-03609
Issue NoClassDefFoundError P181220-09372

Issue game icon disappears P181217-05855 b56ee86169e5f1ffb4774b01f00a0b5654ca9409 
Skia JNI between the GC process (# 01) and libskia function P181231-03952
Issue easy mode FOTA P181024-04338
Issue Resource$NotFoundException P181227-07896
    5-01624
Issue app disappears after change power mode P190121-03704
    7-01599
Issue delete app slowly P190128-03102
Issue crashed after add language P190128-05594
Issue crashed ViewContext.isVisible P190222-06441
Issue crashed remove samsung acc P190222-06441
Issue crashed change guest mode P190313-07288
Issue badge count call app P190306-03592, P190225-06764, P190219-03490
Issue app blank name in MPSM P190402-05632
Issue NPE LauncherModel$Callbacks.isHomeNormal P190403-01039
Issue IllegalArgumentException SQLite P190618-02302
Issue SQLiteFullException P190613-02710
Issue IllegalArgumentException: width and height must be > 0 P190419-02283
Issue back up and restore folder color P190823-07033
Issue Chrome disable P190905-03825

Issue KnoxConfigure P190603-00077

Issue T230NZ: 
    19-07455, P190213-03966 maitance
Add app to home: P190429-05344 
Issue message not update after quick reply P190517-05452
Issue Folder change color P190321-04624 P190322-04137
Issue OMC app change location after download: change package name
Issue OMC app square grey icon P190522-06277, P190607-00471

Issue Notification help tip in easy mode P190509-03208
Issue App change location after max power saving mode on/off P190516-02555 P190516-02290 P181204-07143
App remove after change MPSM P190327-04616
Run launcher in MPSM P190402-0563
Wrong size after on/off MPSM P190424-08007

Issue missing grey icon OMC app P190529-02671

Issue app hidden TTS P190626-00432 P190627-04501
Issue wallpaper color change bright when change rotation P191030-02187
    07-08767 Ic7bb0208e525070c195224bb2f47976689d07c53
Issue can not drop app to folder I8acda042a1db55ab87d401703dbb401c86a016ea
Issue Apps icon get disappear after drag from app tray folder to home P190904-04539
        13-02159 I7dbbc755becfea0259d6a30efe1332597d12aacf
    29-00606 P191204-10051
Issue Close ColorPalette/Color Preview when on/off dark mode P191202-04366
Issue non-samsung app icon is smaller than samsung app icon P191203-00743
Issue RTL language cannot move widget P191218-07752
Issue force close f/c launcher3.Alarm.setAlarm(long) P191217-07923
Issue cannot swipe in widget cbfcf8b2a9caa9dafb7ddbf7949260fe7dafb9ef

Issue T865 white app name P200103-03491

Issue unlock user P200108-03263
Issue load PAI icon square star war edition P200203-04130
Issue DeadSystemException Activity slept P200124-03356 P200104-00814
Issue force close Permission Denial: starting Intent P200204-06590
        0-00958 Huynwook Nam
updatePointerIcon called with position out of bounds

Good Lock app task changer swipe for quick panel resolved issue P200205-04557 I79a184f5b7beda34befad5e5fdcbb90f62c6164c 90.07
Good lock conflict gesture sy0422.lee
Issue restore touch event dex mode P200205-00641 P200212-05400
Issue f/c Cannot set 'scaleX' to Float.NaN P200219-05550 P191205-09838
    22-07101
 Modified to hide DefaultPageIcon when configuratiON-CHANGEd in plusPage of PageEditMode
Accessibility not work in gesture mode P200221-03289 P200219-07492 P200219-07376 93dcccdee48e4d73859ab8c2a64d36d699ebc656
Not avaiable app shortcut after restart P200229-02473
    8-02641 P200302-05900
Animation reduce flick recent app P200218-03560
NPE MotionEvent.getPointerCount P200304-03901
Apps tray disappear due to twice animation when swipe up P200303-02083 P200304-00861
(P200305-06650) fc in locateApp [FRAMEWORKG-32524]
Gesture in other user profile not work P191217-01722
SFinder not support multiwindow P200318-02009
Good lock vibration not work P190812-03499
Issue Has not finished the item rebinding logic for remained pages P200309-00135

Blink due to RELAYOUT_RES_KEEP_ALIVE_SURFACE P200504-00450
Blink/black screen due to note app memo P200509-02059
Issue cannot add message contact widget P200506-07440
F/c com.android.homescreen.widgetlist.WidgetPageItemAdapter.getItemViewResourceId P200522-00090
sluggish netflix return home due, surface create lately P200526-04330

Notification connect faile P200602-00736
Issue navigation bar change color delete clipboard P190706-01969
Issue press back skip resume launcher => black screen. Due to ZLA P200630-05441
Issue 	
Smart Switch application was embedded in the end of app tray after PAI process P200701-00605
Issue fatal PackageUpdatedTask.printLog P200706-05699
PAI app issue Finsky  : [2] jdy.b(14): android.autoinstalls.config.samsung: onError 403 
T505 P200715-06691, A21s P200715-06858, A40 P200716-00318
Issue icon Squircle square apply theme P200703-02519
Manifier shortcut remove after FOTA P200630-03367
ItemInfo not match P200617-01239
Game icon remained on homescreen P200831-01939
Google documents disappear after reboot P191219-05267
Contact my profile deep shortcut unavailable after FOTA P200709-04948
Hidden app not hidden in easy mode P200921-06224
Shortcut KNOX locked user unavailable after reboot P200923-03299
Half screen abnormal divider/dim layer color/Secondary Divider Dim P200930-01982


// R OS
//RIO/Cinnamon/applications/par/idp/Homescreen/TouchWizHome_2017/MAIN/Android.mk
//PROD_RIO/ONEUI_3_0/FLUMEN/Cinnamon/applications/par/idp/Homescreen/TouchWizHome_2017/MAIN/
//RIO/Cinnamon/applications/sources/apps/SecSettings/src/com/android/settings/dashboard/

Issue SuggestionApp not show in recent: I3c9cf84b6eff7f60baf0efc820f2137eac2d869e version 12.0.0.75 19800294
Issue launcher screen reduce half size P201001-03160
Recent task view disappear when rotate device P201007-03370
Gesture not work after turn on/off block gesture with spen P201009-04152 P200922-04694
Issue abnormal recent task snapshot P200930-03032
Issue recent rotate as last activity orientation P200923-02540
Issue T mobile FOTA lost app disappear P201027-00817
Issue null locked pair app task view P201029-04236
Issue gesture sluggish P201110-06006 P201110-06402 P201110-01842 P201110-01940
Requested permissions not granted: {com.sec.android.app.launcher=[android.permission.STATUS_BAR] P200528-01640

Issue add feature P201130-04850
Issue resume time first reboot P201211-03781
Issue fatal DecorView#onMeasure() P201216-00336
Enter recent sluggish P201214-01138
Issue cannot touch recent view after rotate  P201223-05463
Issue recent entry time P201008-00945, P201102-07990, P201207-04790
White app icon is showing in recent app P210430-04604
(P201109-04312) change text color of  widget name in Add Item Activity
screen blink open with secure finger P210510-04923

//OHIO_CSC/Strawberry/EXYNOS5/degasy18wifi/OMC/BNZ/BNZ/default_workspace.xml
//OHIO_CSC/Strawberry/EXYNOS5/degasy18wifi_chn/OMC/BNZ/BNZ/default_workspace.xml
//OHIO_CSC/Strawberry/EXYNOS5/degasy18wifi/OMC/SER/SER/default_workspace.xml


Issue not show finger unlock P201028-02638, P201105-03278, P200427-05741, P201028-02638
Issue post position P200805-00529
Issue default message app P210212-00257
Issue locked profile user icon on home screen disappear after reboot P210118-04261, P210301-02991
Issue launcher apk increased size P201104-06213, P210301-02201
Issue red line in edge of ENG binary P201207-06629
Issue launcher flash when update P210223-00644
Clock live icon updater null P210629-04511
change class name Google TV issue P220709-01556

Color palette icon lighter/darker than other P211027-01733
Work profile icon not apply P211102-04047
Apply google apps icon P211123-04638
Apply deep shortcut P220107-04421
Update launch class name Gallery P220708-06639
Black screen when return from dex mode P220808-00251 reason empty home stack activity
Black screen when unlock P220225-00665 acidencial touch protection

A53x sluggish quick step launcher P211125-02488
Change AM class name for X200 refer issue P211216-02452. some CL: CHN XAR no AM, KOO correct, CL OWO 23421362, OXM 23310577, ODM OJM 23311145, OLE OLM OZS XAC 23446855
Issue app on sd card out of folder P210426-04697 P220128-04638
A53 booting time issue P220114-00440
Kakao talk badge not show due to shortcut type P210430-03415
Blink open memo P211125-04911
Multi task of an app  P220217-05006
Shortcut disappear P220629-05163


T OS color palette Same issue with
P220912-01552
P220823-05701
P220825-05448
P220822-03669
P220824-05193
P220830-03135
P220823-06115

T OS pair app triple orientation P220826-01416 yong94.kim

b/239908518 [PlayStore] PAI screen isn't displayed in T OS 	anuj.agrawal
P220623-02598 jjkk.lee OutOfMemoryError: Failed to allocate a 48 byte allocation with 192936 free bytes and 188KB until OOM ShortcutInfo$1.createFromParce

Nav bar Gesture hint wrong resource P220914-04477

IllegalStateException: User 10 must be unlocked for widgets to be available P220917-02755

P181119-00287 
[Lê Viết Thăng/Le Viet Thang/Staff Engineer/Framework P /SVMC/Samsung&nbsp;Electronics] 9/27/2021 10:09
@Nguyễn Trung Sơn , có cái feature:

https://mobilerndhub.sec.samsung.net/hub/site/n10chnsos/board/notice/view/30080305/?page=1

[Lê Viết Thăng/Le Viet Thang/Staff Engineer/Framework P /SVMC/Samsung&nbsp;Electronics]
CscFeature_Launcher_SupportBadgeClearGesture



