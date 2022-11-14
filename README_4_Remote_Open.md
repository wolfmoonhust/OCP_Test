>> click to workspace item
ItemClickHandler#onClick
    Log.w(TAG, "Icon Clicked");
    onClickAppShortcut
        startAppShortcutOrInfoActivity
            TestLogging.recordEvent(TestProtocol.SEQUENCE_MAIN, "start: startAppShortcutOrInfoActivity");
            Launcher#startActivitySafely
                BaseDraggingActivity#
                BaseDraggingActivity#startActivitySafely
                    QuickstepTransitionManager#getActivityLaunchOptions // create RemoteAnimationAdapterCompat with duration
                    Log.d(TAG," startActivitySafely isShortcut"+ isShortcut)
                    

73 08-18 09:01:41.130 3944 3944 I QuickstepTransition: phongtx getActivityLaunchOptions
74 08-18 09:01:41.130 3944 3944 I QuickstepTransition: java.lang.RuntimeException
75 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.QuickstepTransitionManager.getActivityLaunchOptions(QuickstepTransitionManager.java:299)
76 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.BaseQuickstepLauncher.getActivityLaunchOptions(BaseQuickstepLauncher.java:473)
77 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.BaseDraggingActivity.startActivitySafely(BaseDraggingActivity.java:227)
78 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.Launcher.startActivitySafely(Launcher.java:3339)
79 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.uioverrides.QuickstepLauncher.startActivitySafely(QuickstepLauncher.java:177)
80 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.touch.ItemClickHandler.startAppShortcutOrInfoActivity(ItemClickHandler.java:481)
81 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.touch.ItemClickHandler.onClickAppShortcut(ItemClickHandler.java:392)
82 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.touch.ItemClickHandler.onClick(ItemClickHandler.java:156)
83 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.touch.ItemClickHandler.lambda$getInstance$0(ItemClickHandler.java:107)
84 08-18 09:01:41.130 3944 3944 I QuickstepTransition: at com.android.launcher3.touch.-$$Lambda$ItemClickHandler$fH7QPPHeXou9_kNG2htSj_s2sMo.onClick(Unknown Source:2)

>>> override remote animation in Systemserver
LauncherApps#startMainActivity
    ActivityTaskManagerService#startActivityAsUser
        Slog.d(TAG,"startActivityAsUser: callingPid="
        //setActivityOptions(checkedOptions) and overridePendingAppTransitionRemote  
        ActivityStarter#execute

QuickstepTransitionManager#getActivityLaunchOptions // create RemoteAnimationAdapterCompat with duration  mTransitionParams.APP_OPEN_HOME_EXIT_SCALE_DURATION_MS
    new AppLaunchAnimationRunner
    runner = new LauncherAnimationRunner
    adapterCompat = new RemoteAnimationAdapterCompat
    new ActivityOptionsWrapper( ActivityOptionsCompat.makeRemoteAnimation
    
    



LauncherAnimationRunner#onAnimationStart
    Log.i(TAG, "onAnimationStart, appTargets : "
    new AnimationResult
    QuickStepTransitionManager#AppLaunchAnimationRunner#onCreateAnimation
        Log.i(TAG, "AppLaunchAnimationRunner, onCreateAnimation")
        
        
        
        

            
>> receive event from SystemServer
AppTransition#goodToGo
    RemoteAnimationController#goodToGo
        ProtoLog.d(WM_DEBUG_REMOTE_ANIMATIONS, "goodToGo()")
        Log.d(TAG,"RemoteAnimationController::onAnimationStart, animations="
        ProtoLog.d(WM_DEBUG_REMOTE_ANIMATIONS, "goodToGo(): onAnimationStart,"
        RemoteAnimationAdapterCompat#onAnimationStart//mRemoteAnimationAdapter.getRunner().onAnimationStart
            RemoteAnimationRunnerCompat#onAnimationStart


RemoteAnimationAdapterCompat#onAnimationStart
    LauncherAnimationRunner#onAnimationStart
        Log.i(TAG, "onAnimationStart, appTargets : "
        new AnimationResult
        QuickStepTransitionManager#AppLaunchAnimationRunner#onCreateAnimation


AppLaunchAnimationRunner#onCreateAnimation
Log.i(TAG, "AppLaunchAnimationRunner, onCreateAnimation")
QuickstepTransitionManager#composeIconLaunchAnimator
    QuickstepTransitionManager#getOpeningWindowAnimators
        AppTransitionAnimatorImpl#getOpeningWindowAnimator
            Log.w(TAG, "animation with
            openingTargets = new RemoteAnimationTargets
                Log.i("RemoteAnimationTargets", /* Rune.RECENTS_AOSP_BUGFIX */ "unfilteredApps :
            valueAnimator = getValueAnimatorByStatus // consider about duration isOpening ? mTransitionParams.APP_OPEN_APP_ENTER_SCALE_DURATION_MS
            valueAnimator#addUpdateListener //TODO
            valueAnimator#addListener
                onAnimationStart
                    Log.w(TAG, "onAnimationStart - APP IN"
                onAnimationEnd
                    Log.w(TAG, "onAnimationEnd - APP IN, Execution time for each frame

144 08-13 14:56:18.228 17884 17884 W AppStartUtils: sendActiveLaunchBroadcast() v.hasOnClickListeners() : true, iconInfo : WorkspaceItemInfo(id=6 type=APP container=desktop targetComponent=ComponentInfo{com.sec.android.gallery3d/com.samsung.android.gallery.app.activity.GalleryActivity} screen=0 cell(1,4) span(1,1) minSpan(1,1) rank=0 rankOfList=-1 user=UserHandle{0} title=Gallery hidden=0 screenType=0 lowResIcon=false runtimeStatusFlags=320)

996 08-13 14:56:18.485 17884 17884 I WrappedLauncherAnimationRunner: onCreateAnimation, animationRunnerImpl : com.android.launcher3.QuickstepAppTransitionManagerImpl$AppLaunchAnimationRunner@1bd0140


406 08-13 14:56:18.323 17884 17884 D ActivityOptions: makeRemoteAnimation, adapter=android.view.RemoteAnimationAdapter@9b273e6, caller=com.android.systemui.shared.system.ActivityOptionsCompat.makeRemoteAnimation:69 com.android.launcher3.QuickstepAppTransitionManagerImpl.getActivityLaunchOptions:249 com.android.launcher3.Launcher.getActivityLaunchOptions:3091 

systemuiShare#RemoteAnimationAdapterCompat
    mWrapped = new RemoteAnimationAdapter(wrapRemoteAnimationRunner(runner)
    mRemoteTransition = buildRemoteTransition(runner)
    
    
    
515 08-18 09:59:06.188 1198 1283 I WindowManager: Starting remote animation

796 08-18 10:29:57.933 14644 14863 I LauncherAnimationRunner: phongtx onAnimationStart appTargets : [Lcom.android.systemui.shared.system.RemoteAnimationTargetCompat;@129fa59
797 08-18 10:29:57.933 14644 14863 I LauncherAnimationRunner: java.lang.RuntimeException
798 08-18 10:29:57.933 14644 14863 I LauncherAnimationRunner: at com.android.launcher3.LauncherAnimationRunner.onAnimationStart(LauncherAnimationRunner.java:93)
799 08-18 10:29:57.933 14644 14863 I LauncherAnimationRunner: at com.android.systemui.shared.system.RemoteAnimationAdapterCompat$1.onAnimationStart(RemoteAnimationAdapterCompat.java:98)
800 08-18 10:29:57.933 14644 14863 I LauncherAnimationRunner: at android.view.IRemoteAnimationRunner$Stub.onTransact(IRemoteAnimationRunner.java:117)
801 08-18 10:29:57.933 14644 14863 I LauncherAnimationRunner: at android.os.Binder.execTransactInternal(Binder.java:1220)

===Log.w(TAG, "BasicAnimationType=" check Animation type and duration

WM_DEBUG_APP_TRANSITIONS


adb shell wm logging enable-text WM_DEBUG_APP_TRANSITIONS 

AppTransition#overridePendingAppTransitionRemote
    ProtoLog.i(WM_DEBUG_APP_TRANSITIONS, "Override pending remote transitionSet=%b adapter=%s"
    mRemoteAnimationController = new RemoteAnimationController
    
onAnimationStart|onRecentsAnimationStart|onGestureEnded|onGestureStarted|getElementsAnimator|onCreateAnimation|createWindowAnimation

P220106-05182