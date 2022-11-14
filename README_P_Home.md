
----
UX Recent: //ANDROID/Applications/Task_Manager/
//RIO/Cinnamon/applications/par/idp/Homescreen/TouchWizHome_2017/MAIN/Android.mk

ONE UI HOME ACTIVITY DUMP

PROVIDER ContentProviderRecord{e67df79 u0 com.sec.android.app.launcher/com.android.launcher3.LauncherProvider

WorkspaceItemInfo
LoaderCursor: Error loading

DBTable: favorites
DBTable: appsTray

Data Model:

com.android.quickstep.TouchInteractionService
SysUINavigationMode:
      mode=NO_BUTTON
navigation_bar_gesture_hint

onNavigationModeChanged

Rotate to landscape mode
sehome_portrait_mode_only

HsOrientationListener: onSensorChanged, newRotation

===check userID
07-04 19:17:46.441  1000  1009  1645 D WindowManager: isScreenshotDisabledLocked: userId = 150, disabled =false
07-04 19:17:39.553  1000  1009  1072 I SemPersonaManager: SecureFolder personaId = 150


===search recent task visible
ACTIVITY MANAGER RECENT TASKS (dumpsys activity recents)

Visible recent tasks (most recent first):
realActivity=

===zero page confirmed
InBum Chang/Service R&D Group

===
[Nguyễn Trung Sơn / Nguyen Trung Son]
adb pull /data/data/com.sec.android.app.launcher D:\Data\
sau do sua data bang sqlite browser, sua launcher.db table favourite



d:\OneUI Home\Perforce\RIO_CSC\Combination\SM7325\a52sxq\OMC\OKR\KTC\etc\default_application_order.xml

  
07-14 09:11:37.448 10058  4599  4599 I wm_on_resume_called: [160883584,com.android.quickstep.RecentsActivity,RESUME_ACTIVITY]

07-14 09:11:43.051 10058  4599  4599 I wm_on_resume_called: [160883584,com.android.quickstep.RecentsActivity,RESUME_ACTIVITY]


07-14 09:12:03.491 10253 26909 26909 I wm_on_resume_called: [11137012,com.teslacoilsw.launcher.NovaLauncher,RESUME_ACTIVITY]

07-14 09:12:56.578 10058  4599  4599 I TouchInteractionService: onSystemUiFlagsChanged, userUnlocked

07-14 09:14:02.978 10058  4599  4599 I ViewRootImpl@a9121e5[RecentsActivity]: MSG_WINDOW_FOCUS_CHANGED 1 1
07-14 09:14:04.408 10058  4599  4599 W PagedView: Touch Pos : D-(1524, 42643348)-M-(1520, 42643397)-SS-M-(1505, 42643414)-M-(1469, 42643431)-M-(1406, 42643447)-M-(1326, 42643464)-M-(1241, 42643481)-M-(1164, 42643497)-M-(1097, 42643514)-M-(1063, 42643528)-U-(1063, 42643528)-End

07-14 09:14:05.522 10058  4599  4599 W PagedView: Scroll Pos : End
07-14 09:14:08.048 10058  4599  4599 E PagedView: validateNewPage: failed to find a page > mMinScrollX


global shortcuts : 1, shortcutCount : 0, Notifications :



Package [com.sec.android.app.launcher] (b0f5804):
    userId=10154
    pkg=Package{971e1ed com.sec.android.app.launcher}
    codePath=/system/priv-app/TouchWizHome_2017
    resourcePath=/system/priv-app/TouchWizHome_2017
    legacyNativeLibraryDir=/system/priv-app/TouchWizHome_2017/lib
    primaryCpuAbi=arm64-v8a
    secondaryCpuAbi=null
    versionCode=1210705033 minSdk=28 targetSdk=30
    versionName=12.1.07.33 //production/sep12.1_oneui3.1
    
07-21 14:54:53.970 10154  1925  1925 I Launcher: !@Boot_DEBUG: Launcher.onCreate()

07-21 14:54:42.922  1000  1112  1112 W PackageManager: Failed to scan /system/app/PlayAutoInstallConfig: Package android.autoinstalls.config.samsung at /system/app/PlayAutoInstallConfig ignored: updated version 1000 better than this 1

07-21 14:54:55.931 10154  1925  1975 I AppIconSolution: getThemeIconWithBG called with public API, pkg = com.samsung.android.messaging
07-21 14:54:55.931 10154  1925  1975 I AppIconSolution: return adaptive icon for com.samsung.android.messaging
07-21 14:54:55.931 10154  1925  1975 I LauncherActivityInfo: packageName: com.samsung.android.messaging, useThemeIcon: false, height: 288, width: 288, density: 640
    
07-21 14:54:55.980 10154  1925  1975 I AppIconSolution: getThemeIconWithBG called with public API, pkg = com.sec.android.app.sbrowser
07-21 14:54:55.980 10154  1925  1975 I AppIconSolution: return adaptive icon for com.sec.android.app.sbrowser

WorkspaceItemInfo(id=29 type=APP container=hotseat targetComponent=ComponentInfo{com.samsung.android.messaging/com.android.mms.ui.ConversationComposer} screen=-1010 cell(1,0) span(1,1) minSpan(1,1) rank=1 user=UserHandle{0} title=Повідомлення hidden=0 screenType=0 lowResIcon=false runtimeStatusFlags=320)

WorkspaceItemInfo(id=30 type=APP container=hotseat targetComponent=ComponentInfo{com.sec.android.app.sbrowser/com.sec.android.app.sbrowser.SBrowserMainActivity} screen=-1010 cell(2,0) span(1,1) minSpan(1,1) rank=2 user=UserHandle{0} title=Інтернет hidden=0 screenType=0 lowResIcon=false runtimeStatusFlags=384)


RecentsView#onConfigurationChanged
    getAdjustedRotation
        Log.i(TAG, "orientation " + orientation + " rotation " + rotation // return Rotation value
    RecentsOrientedState#setRecentsRotation
        Log.i(TAG, "setRecentsRotation "
    updateOrientationHandler // if need
        Log.i(TAG, "updateOrientationHandler rotation
    Log.i(TAG, "onConfigurationChanged "
    
===Update SEC_FLOATING_FEATURE_LAUNCHER
22329688 

=== animation type
AppTransitionParams

SEC_FLOATING_FEATURE_LAUNCHER_CONFIG_ANIMATION_TYPE

18637408 config animation type
22331901 S OS

===Log.w(TAG, "BasicAnimationType=" check Animation type and duration

=== push commit
https://mobilerndhub.sec.samsung.net/its/login.jsp

git push origin HEAD:refs/for/develop/oneui4

path set để chery pick giữ lại parent vs change Id

1. checkout 3.1 branch
2. cherry-pick dev commit => conflict
3. resolve it by merge tool in studio
4. git add .
5. git cherry-pick --continue
6. save
7. push

===  menu tree request
[Lê Viết Thăng / Le Viet Thang]
[이동준/Dongjun Lee/Principal Engineer/Framework R&D Group/Samsung Electronics] 6/8/2021 14:39
Basically I know role is SWPL, but they request us



==== monochrome

Framework has been changed to provide Color palette icon using Google monochrome API from T OS
This is not in case of problem with FW logic,
to support this function, each apps need to set the monochrome icon

We are currently collecting update results for each app through the notice below.
http://mobilerndhub.sec.samsung.net/hub/site/rainbow/board/Notice_TOS_USA/view/31630246
This is being requested.
In the end, there is no problem with code and this issue is solved through App update



NP870Z5G/0G5E91EG500114T
A528B/357456420078100
G996N/353561330169818
T875/356167110073720

https://gerrit.sw.sec.samsung.net/package/#/c/1163998/1
https://gerrit.sw.sec.samsung.net/package/#/c/1163998/1
https://gerrit.sw.sec.samsung.net/package/#/c/1310592/3

Naming of  the Unit Tests
<unitOfWork>_<stateUnderTest>_<expectedBehavior>
https://mobilerndhub.sec.samsung.net/wiki/display/DEVOPS3/How+to+get+permission+to+write+on+M-Wiki
search: TG_SE Home

===Failure [INSTALL_FAILED_VERIFICATION_FAILURE: Package Verification Result]
https://stackoverflow.com/questions/15014519/apk-installation-failed-install-failed-verification-failure


===systrace by ADB
python systrace.py -t 4 -a com.sec.android.app.launcher


=== add apk to build PBS in case test app entry
24475030

//PROD_SOLO/ONEUI_4_1/SM-A037X_T225_GLOBAL_ALL/Common/applications/par/idp/Homescreen/TouchWizHome_2017/MAIN/Android.mk#1 (shelved in 24475030)
LOCAL_OVERRIDES_PACKAGES := Launcher2 SecLauncher3 Launcher3 Launcher3QuickStep
LOCAL_SRC_FILES := OneUiHome-debug.apk
LOCAL_REQUIRED_MODULES := privapp-permissions-com.sec.android.app.launcher.xml

add to OneUiHome-debug.apk
//PROD_SOLO/ONEUI_4_1/SM-A037X_T225_GLOBAL_ALL/Common/applications/par/idp/Homescreen/TouchWizHome_2017/MAIN/

=== Click to Task on RecentsView
63 10-28 11:41:38.407 2512 2512 I TaskView: Click task : com.android.chrome

=== check SEP version
T975
[ro.build.version.sep]: [130000]  => ăn vào #sep13.0-oneui4.0 ((13.0))

X205
[ro.build.version.sep]: [120500]  => ăn vào #sep13.0-oneui4.0 ((13.0))

X906B
[ro.build.version.sep]: [130100]  => #sep13.1-oneui4.1 (13.1)

===S OS recent performance
P211020-00397 - SM-A526B_EUR_12_XX
- 13.0.00.97: 0.57  

P211013-04554 -  SM-A826S_KOR_12_SKC
- 13.0.00.95: 0.57

P211013-05234 - SM-A426B_EUR_12_XX
- 13.0.00.107: 0.58
P211014-04367 

>>>TODO check first page and second page animation
P211013-05271[APP성능][APP실행속도][A426N][UJ9][반응속도] A426N SOS App실행속도 시험 A426N ROS 대비 열세 件 

>>> analysis about delay from touch down -> remote animation start
P211007-04559(Reject)   [APP성능][APP실행속도][A426B][UK4][반응속도] A426B SOS App실행속도 시험 A426BF ROS 대비 열세 件

78e224c6a88ebdfb65bf014df3a10dc78576079d

=== handOff 
setting 0: turn off 1: turn on
_id:189 name:mcf_continuity pkg:android value:0 default:0 defaultSystemSet:true
P221019-03538
	suhyun_.kim
===memory leak
P211025-02248

===Keep open concept
P211022-05145

===check game launcher dumpstate
Package Data
GOS GOS DUMP
===
P211012-06546 UX

P210924-06884 [Conv/Vietnam][SM-G781B/EUR] Screen blink when use hot key Alt + Tab 
P211007-05821 Icon is not appearing in recent apps for privacy
P211007-04501 
P211014-04367 (Register)    [APP성능][APP실행속도][N975F][UJ2][실행속도] N975F SOS App실행속도 시험 N975F ROS 대비 열세 件 
\\107.113.53.221\Public\son.nt1\trace

P211023-02203 (Register)   [EV1][G975FC/MEA/VN] window handler icon still show in recent key app 
Ib91b4218043cb7802cd8a7cf08e9b8ffb923af55

=== AM & SM
P211216-02452

=== you can find the qb info in the log
[김유나 / YOONA KIM]
look up qb link by "QuickBuild ID" in the dumpstate  log
[김유나 / YOONA KIM]
 { 3932761 }[ ABL ] QuickBuild ID [58431676R]




=== print icon 
BaseIconCache#newContentValues
    
pull data: adb pull /data/user/0/com.sec.android.app.launcher/


public void saveBitmapToStorage(Context context, Bitmap bitmap, String name) {
        String path = getDirPath(context);
        String fileName = "phongtx" + name +".png";
        Log.i(TAG, "phongtx newContentValues path " + path  + " filename: " + fileName, new RuntimeException().fillInStackTrace());
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        File fileCacheItem = new File(path + "/"+fileName);
        try (OutputStream out = new FileOutputStream(fileCacheItem)) {
            fileCacheItem.createNewFile();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (Exception e) {
            Log.w(TAG, "saveBitmapToFileCache, Exception" + e);
        }
    }

    private static String getDirPath(@NonNull Context context) {
        File dir = context.getCacheDir();
        if (dir != null && dir.exists()) {
            return dir.getAbsolutePath();
        }
        return null;
    }

=== app transition issue location wrong
	getIconBoundsForHorizontalIcon
	
	
	
=== menu entry
P211118-00447

 (Reject)   [App성능파트][APP실행속도][A336B][VAK][반응속도] A336B SOS App실행속도 시험 A526B ROS 대비 열세 件
===

[Phạm Mạnh Toàn / Pham Manh Toan] 1/14/2022 11:00

[Lê Viết Thăng / Le Viet Thang] 1/14/2022 13:43
type=APP hidden=4

[Lê Viết Thăng / Le Viet Thang] 1/14/2022 13:43
giá trị 4 là sao nhỉ ae ?

[Phạm Mạnh Toàn / Pham Manh Toan] 1/14/2022 13:45
cái này là a Hidden app theo cách nào

[Phạm Mạnh Toàn / Pham Manh Toan] 1/14/2022 13:45
= 0 thì là ko hidden

[Phạm Mạnh Toàn / Pham Manh Toan] 1/14/2022 13:45
1 là hidden trong xml file

[Phạm Mạnh Toàn / Pham Manh Toan] 1/14/2022 13:46
2 là option hidden trong quick option bởi người dùng

[Phạm Mạnh Toàn / Pham Manh Toan] 1/14/2022 13:46
3 hidden by game

[Phạm Mạnh Toàn / Pham Manh Toan] 1/14/2022 13:46
4 là by TSS



== issue margin layout
find id -> find view bound -> check margin -> apply follow UI 
af011449e4732c07423cc3298c86da4eef0ddacd

=== move to app folder
P211108-05035
Please move this issue to app's defect project app folder 
(01)Home Screen V8.0)

=== blank screen happens when finish set up wizard
P220114-00440.

=== reaction time 
P211126-05198

===
P220218-04009


===Grip command feature not applied(Grip/Reject zone not applied)
Reject zone 

WINDOW MANAGER EXTENSION (dumpsys window extension)

deadzone enabled=true deadzone_v3 enabled=false


===
[Nguyễn Viết Đàn / Nguyen Viet Dan]
ae còn lưu các bước lấy data của thằng user k nhỉ


Data
1. Open Settings -> Apps -> More Button -:> Show System App. 
2. Open Samsung Experiecn Home -> Permission -> Enable Storage 
3. Open My file app -> Internal Storage -> More Button -> Settings -> Show hidden File 
4. In Myfile -> More Button -> Create Folder with name ".homedata" -> OK
5. In Home Screen Long Press on Home Sreen (or pinch zoom in) -> Long Press Widget -> pop up coppy complete .
6. Give us all folder ".homedata" in Myfile app


=== request release new apk
- check about commit alreay cherry pick to production branch
- check with SWPL about release plan of this model
- request TPM

===Toast
ToastLog: [android.os.BinderProxy@99fa4bd] Show toast for (com.sec.android.app.launcher, 10099). msg='App isn't available'




===
[Trần Xuân Phong / Tran Xuan Phong] 4/26/2022 09:53
mấy file layout mình xem trên device file explore thì nó ở path nào vậy Sơn

[Nguyễn Trung Sơn / Nguyen Trung Son]
n thường ở prism/etc/carriers/xxx


===taskview
[니라즈 / Niraj Kumar]
We have a PLM issue in SRI Noida
P220813-02121 [Conv/SM_A516B/PHE/Vietnam/SecureFolder]Secure Folder apps are displayed in recent list after select {Off} Secure Folder button from Quick panel
[니라즈 / Niraj Kumar] 9/22/2022 20:10
In my opinion, concept is : Open any app in Secure folder, in recent it shows preview if quick panel Secure folder is ON 
if Quick Panel turn Off - then recent will not show Opened app

[니라즈 / Niraj Kumar]
It is S22/S23 common issue. Do we have a history of similar issue in T OS


==show/hide statusbar/navigationbar
StateManager#onStateTransitionStart
...... if (mState.supportStatusBar(mActivity)) {
                systemUiController.showStatusBar();
            } else {
                systemUiController.hideStatusBar();
            }



[김동욱 / Dong-Wook Kim]
Hi, The task list is always retrieved through the activity manager. 
Therefore, this issue needs to be confirmed by the core team.




I will follow up the issue on the project
here with how to find the app folder
=============================
select All Model/Project
- Dev. Type: SW DEV
- Range: Pjt. Name
 Home Screen V8.X
- seach 'Private' on search area.  

Kindly let me know if you have any questions.
Thank you! 


-P220713-05224 
    request update daily -> hard issue, offline to update status, discuss solution
    involve HQ earlier in case could not handle
    share list issue focus + request update status on every morning
    

