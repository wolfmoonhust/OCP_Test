horizontalSizeConfiguration, verticalSizeConfigurations, smallestSizeConfigurations
ActiviityRecord.getConfigurationChanges //check whether onfiguration change

LaunchingTaskPositioner.configure


ACtivitySTtack.postAddToDisplay

ActivityThread.handleBindApplication
	mBoundApplication = data;
    mConfiguration = new Configuration(data.config);
    mCompatConfiguration = new Configuration(data.config);
	
ActivityThread.handleConfigurationChanged
	config = applyCompatConfiguration
	
	
	
ActivityRecord.ensureActivityConfigurationLocked(int, boolean, boolean) line: 3143	
ActivityStack.ensureActivitiesVisibleLocked(ActivityRecord, int, boolean) line: 2367	
ActivityStackSupervisor.ensureActivitiesVisibleLocked(ActivityRecord, int, boolean) line: 4618	
ActivityStackSupervisor.attachApplicationLocked(ProcessRecord) line: 1280	
ActivityManagerService.attachApplicationLocked(IApplicationThread, int) line: 9491	
ActivityManagerService.attachApplication(IApplicationThread) line: 9558	



ActivityThread.handleConfigurationChanged was called from
	CONFIGURATION_CHANGED
		scheduleConfigurationChanged(ActivityTheard)
			scheduleDisplayConfigurationLocked(MultiDisplayManagerService)
				performDisplayOverrideConfigUpdate(ActivityManagerService)
					updateGlobalConfiguration(ActivityManagerService)
					updateDisplayOverrideConfigurationLocked(ActivityManagerService)
			updateGlobalConfiguration(ActivityManagerService) ->>>>>>>>>>>>>>>>>>>SEND GLOBAL CONFIGURATION
	handleLaunchActivity
	handleUpdatePackageCompatibilityInfo
	handleRelaunchActivity
	handleApplicationInfoChanged
	updateConfigurationForDexCompatIfNeeded
		handleActivityConfigurationChanged
			ACTIVITY_MOVED_TO_DISPLAY
			ActivityClientRecord register activity.mMainThread.handleActivityConfigurationChanged
			ACTIVITY_CONFIGURATION_CHANGED
				scheduleActivityConfigurationChanged(ActivityThread)
					scheduleConfigurationChanged(ActivityRecord)
						ensureActivityConfigurationLocked(ActivityRecord)
		performLaunchActivity


			
handleActivityConfigurationChanged
	mActivityConfigCallback.onConfigurationChanged(ViewRootImpl)
		performConfigurationChange(ViewRootImpl)
			MSG_UPDATE_CONFIGURATION
				requestUpdateConfiguration(ViewRootImpl)
					reportNewConfiguration(WindowManagerGlobal)
						handleUpdatePackageCompatibilityInfo(ActivityTheard)
			MSG_RESIZED_REPORT
		
		
		
		
		
		
ActivityManagerService.updateDisplayOverrideConfigurationLocked(Configuration, ActivityRecord, boolean, int, ActivityManagerService$UpdateConfigurationResult) line: 25645	
ActivityManagerService.updateDisplayOverrideConfiguration(Configuration, int) line: 25623	
WindowManagerService.sendNewConfiguration(int) line: 5389	
InputMonitor.notifyConfigurationChanged() line: 477	
InputManagerService.notifyConfigurationChanged(long) line: 2881	



ActivityManagerService.updateDisplayOverrideConfigurationLocked(Configuration, ActivityRecord, boolean, int, ActivityManagerService$UpdateConfigurationResult) line: 25645	
ActivityManagerService.updateDisplayOverrideConfigurationLocked(Configuration, ActivityRecord, boolean, int) line: 25634	
ActivityStack.resumeTopActivityInnerLocked(ActivityRecord, ActivityOptions, ActivityRecord, boolean) line: 3380	
ActivityStack.resumeTopActivityUncheckedLocked(ActivityRecord, ActivityOptions, ActivityRecord, boolean) line: 2866	
ActivityStack.resumeTopActivityUncheckedLocked(ActivityRecord, ActivityOptions) line: 2846	
ActivityStackSupervisor.resumeFocusedStackTopActivityLocked(ActivityStack, ActivityRecord, ActivityOptions) line: 2635	
ActivityStackSupervisor.resumeFocusedStackTopActivityLocked() line: 2588	
ActivityStackSupervisor.applySleepTokensLocked(boolean) line: 4459	
ActivityManagerService.updateSleepIfNeededLocked() line: 16311	
ActivityStackSupervisor.removeSleepTokenLocked(ActivityStackSupervisor$SleepTokenImpl) line: 5427	
ActivityStackSupervisor.-wrap6(ActivityStackSupervisor, ActivityStackSupervisor$SleepTokenImpl) line: not available	
ActivityStackSupervisor$SleepTokenImpl.release() line: 6613	
PhoneWindowManager.updateScreenOffSleepToken(boolean, boolean) line: 9803	
PhoneWindowManager.screenTurningOn(WindowManagerPolicy$ScreenOnListener) line: 8817	
DisplayPowerController.setScreenState(int, int) line: 2232	
DisplayPowerController.animateScreenStateChange(int, int, boolean) line: 2506	


>>>>>>>>>>>>>.When start an activity in DeX
ActivityManagerService.updateDisplayOverrideConfigurationLocked(Configuration, ActivityRecord, boolean, int, ActivityManagerService$UpdateConfigurationResult) line: 25645	
ActivityManagerService.updateDisplayOverrideConfigurationLocked(Configuration, ActivityRecord, boolean, int) line: 25634	
ActivityStack.resumeTopActivityInnerLocked(ActivityRecord, ActivityOptions, ActivityRecord, boolean) line: 3380	
ActivityStack.resumeTopActivityUncheckedLocked(ActivityRecord, ActivityOptions, ActivityRecord, boolean) line: 2866	
ActivityStack.resumeTopActivityUncheckedLocked(ActivityRecord, ActivityOptions) line: 2846	
ActivityStackSupervisor.resumeFocusedStackTopActivityLocked(ActivityStack, ActivityRecord, ActivityOptions) line: 2635	
ActivityStackSupervisor.resumeFocusedStackTopActivityLocked() line: 2588	


>>>>>>> check device is tablet or phone
FreeformStackController.loadResource
	MultiWindowManager.Utils.sIsTablet
FreeformStackWindowController
	isTablet = MultiWindowManager.Utils.sIsTablet
LaunchingTaskPositioner.configure


================10262219===================
//NILE/Cinnamon/frameworks/base/core/java/android/app/Activity.java#154
//NILE/Cinnamon/frameworks/base/services/core/java/com/android/server/am/ActivityManagerService.java#1101
attachApplicationLocked
	 if (DesktopModeFeature.ENABLED && SAMSUNG_MULTIWINDOW_SUPPORT && mMultiWindowManager != null) {
		if (mMultiWindowManager.isDexCompatPackageLocked(app.info.packageName)) {
			appConfiguration = new Configuration(configCopy);
			mMultiWindowManager.applyDexCompatConfigurationLocked(appConfiguration, app.info.packageName, "updateConfiguraton");
		}
	}
	

//NILE/Cinnamon/frameworks/base/services/core/java/com/android/server/am/ActivityStack.java#586 -> refactor change to ActiviityRecord.ensureActivityConfigurationLocked
ensureActivityConfigurationLocked
	if (DesktopModeFeature.ENABLED && SAMSUNG_MULTIWINDOW_SUPPORT) {
		if (mService.mMultiWindowManager.isDexCompatPackageLocked(r.packageName)) {
			newConfig = new Configuration(mService.mConfiguration);
			mService.mMultiWindowManager.applyDexCompatConfigurationLocked(newConfig, r.packageName, "ensureActivityConfig[" + r + "]");
		}
	}
relaunchActivityLocked
	if (DesktopModeFeature.ENABLED && SAMSUNG_MULTIWINDOW_SUPPORT) {
				if (mService.mMultiWindowManager.isDexCompatPackageLocked(r.packageName)) {
					mService.mMultiWindowManager.applyDexCompatConfigurationLocked(config, r.packageName, "relaunchActivity[" + r + "]");
				}
			}
			
//NILE/Cinnamon/frameworks/base/services/core/java/com/android/server/am/ActivityStackSupervisor.java#750
realStartActivityLocked
	if (DesktopModeFeature.ENABLED && SAMSUNG_MULTIWINDOW_SUPPORT) {
					if (mService.mMultiWindowManager.isDexCompatPackageLocked(app.info.packageName)) {
						mService.mMultiWindowManager.applyDexCompatConfigurationLocked(config, app.info.packageName, "realStartActivity[" + r + "]");
					}
				}

//NILE/Cinnamon/frameworks/base/core/java/android/app/ActivityThread.java#212
performLaunchActivity
	if (SAMSUNG_MULTIWINDOW_SUPPORT && DesktopModeFeature.ENABLED && r.overrideConfig != null) {
						updateConfigurationForDexCompatIfNeeded(r.overrideConfig);
					}
handleActivityConfigurationChanged
	 if (SAMSUNG_MULTIWINDOW_SUPPORT && DesktopModeFeature.ENABLED && data.overrideConfig != null) {
				updateConfigurationForDexCompatIfNeeded(data.overrideConfig);
			}
updateConfigurationForDexCompatIfNeeded// check condition,
	Configuration threadConfig = getConfiguration();
	if (threadConfig.orientation != activityOverrideConfig.orientation) {
		threadConfig.updateFrom(activityOverrideConfig);
		threadConfig.seq = 0; // force update
		if (DEBUG_CONFIGURATION) {
			Slog.i(TAG, "updateConfigurationForDexCompatIfNeeded: threadConfig=" + threadConfig + ", this=" + this);
		}
		handleConfigurationChanged(threadConfig, null);
	}
isDexCompatMode // return true if DeX compat mode is enabled
getConfiguration
	return new Configuration(mConfiguration);
//NILE/Cinnamon/frameworks/base/core/java/com/android/internal/policy/DecorView.java#63

//NILE/Cinnamon/frameworks/base/core/java/android/hardware/display/DisplayManager.java#83
getOrCreateDisplayLocked

//NILE/Cinnamon/frameworks/base/core/java/android/hardware/display/DisplayManagerGlobal.java#61
getDisplayInfo // add condition for dex case, update base on thread.getConfiguration()
	if (SAMSUNG_MULTIWINDOW_SUPPORT && DesktopModeFeature.ENABLED) {
		final ActivityThread thread = ActivityThread.currentActivityThread();
		if (thread != null && thread.isDexCompatMode()) {
			Configuration threadConfig = thread.getConfiguration();
			if (threadConfig.densityDpi != Configuration.DENSITY_DPI_UNDEFINED
			&& threadConfig.screenWidthDp != Configuration.SCREEN_WIDTH_DP_UNDEFINED
			&& threadConfig.screenHeightDp != Configuration.SCREEN_HEIGHT_DP_UNDEFINED) {
				final int width = (int) (threadConfig.screenWidthDp * threadConfig.densityDpi * DisplayMetrics.DENSITY_DEFAULT_SCALE);
				final int height = (int) (threadConfig.screenHeightDp * threadConfig.densityDpi * DisplayMetrics.DENSITY_DEFAULT_SCALE);
				info.appWidth = info.logicalWidth = width;
				info.appHeight = info.logicalHeight = height;
				if (DEBUG) {
					Log.i(TAG, "getDisplayInfo: displayId=" + displayId + ", info=" + info + ", threadConfig=" + threadConfig);
				}
			}
		}
	}
//NILE/Cinnamon/vendor/samsung/frameworks/base/services/core/java/com/android/server/am/MultiWindowManagerService.java#169 -> refactor in FreeformStackController
isDexCompatPackageLocked
applyDexCompatConfigurationLocked
getTopActivityByPackageLocked





sumarize:
updateGlobalConfiguration
    mFreeformController.applyDexCompatConfigurationLocked(null, appConfig, app.info, "updateConfiguraton");  // calculate and set config for app runs Compatibility mode


app.thread.scheduleConfigurationChanged(appConfig); // transfer config to app side
    handleConfigurationChanged(config, compat)
        mResourcesManager.applyConfigurationToResourcesLocked(config, compat) // apply new config to Resource manager




vậy mình có thể hiểu là đoạn kia chỉ làm mục đích là tạo 1 cái configuration cho app để nó nghĩ là mình đang chạy ở 411x731

ResourceManager.getOrCreateResources

ResourcesKey has displayId field

ResourceManager.getResources



phone
07-31 17:48:20.038 E 25064             phongtx                                                                              application resource android.content.res.Resources@5021243 
07-31 17:48:20.039 E 25064             phongtx                                                                              application configuration {0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h773dp 420dpi nrml long hdr port finger -keyb/v/h -nav/h appBounds=Rect(0, 0 - 1080, 2094) s.17 mkbd/h desktop/d ?dc} 
07-31 17:48:20.039 E 25064             phongtx                                                                              activity resource android.content.res.Resources@64460c0 
07-31 17:48:20.039 E 25064             phongtx                                                                              activity configuration {0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h773dp 420dpi nrml long hdr port finger -keyb/v/h -nav/h appBounds=Rect(0, 0 - 1080, 2094) s.17 mkbd/h desktop/d ?dc} 

dex
07-31 17:50:26.410 E 28121             phongtx                                                                              Application Context textSize 15.0 
07-31 17:50:26.414 E 28121             phongtx                                                                              Activity Context textSize 15.0 
07-31 17:50:26.414 E 28121             phongtx                                                                              application resource android.content.res.Resources@64460c0 
07-31 17:50:26.415 E 28121             phongtx                                                                              application configuration {0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.18 mkbd/h desktop/e dc/e} 
07-31 17:50:26.415 E 28121             phongtx                                                                              activity resource android.content.res.Resources@517e1f9 
07-31 17:50:26.415 E 28121             phongtx                                                                              activity configuration {0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.18 mkbd/h desktop/e dc/e} 




dex include keepAlive
07-31 17:52:05.619 E 28930             phongtx                                                                              Application Context textSize 40.0 
07-31 17:52:05.631 E 28930             phongtx                                                                              Activity Context textSize 15.0 
07-31 17:52:05.631 E 28930             phongtx                                                                              application resource android.content.res.Resources@5021243 
07-31 17:52:05.632 E 28930             phongtx                                                                              application configuration {0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h773dp 420dpi nrml long hdr port finger qwerty/v/v -nav/h appBounds=Rect(0, 0 - 1080, 2094) s.18 mkbd/h desktop/d ?dc} 
07-31 17:52:05.632 E 28930             phongtx                                                                              activity resource android.content.res.Resources@64460c0 
07-31 17:52:05.632 E 28930             phongtx                                                                              activity configuration {0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.18 mkbd/h desktop/e dc/e} 


mOverrideConfiguration


07-31 19:43:29.337 I 4653              FreeformStackController                                                              [DexCompat] applyDexCompatConfigurationLocked: outConfig={0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/e dc/e}, packageName=appcore.svmc.multidisplayapp, reason=ensureActivityConfig[ActivityRecord{7f660c2 u0 appcore.svmc.multidisplayapp/.MainActivity t45}], candidate=ActivityRecord{7f660c2 u0 appcore.svmc.multidisplayapp/.MainActivity t45} 


07-31 19:44:38.880 I 4653              FreeformStackController                                                              [DexCompat] applyDexCompatConfigurationLocked: outConfig={0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 420dpi nrml long hdr port finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/d dc/e}, packageName=appcore.svmc.multidisplayapp, reason=realStartActivity[ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46}], candidate=ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46} 
07-31 19:44:38.887 I 4653              FreeformStackController                                                              [DexCompat] applyDexCompatConfigurationLocked: outConfig={0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/e dc/e}, packageName=appcore.svmc.multidisplayapp, reason=ensureActivityConfig[ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46}], candidate=ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46} 
07-31 19:44:38.921 I 4653              FreeformStackController                                                              [DexCompat] applyDexCompatConfigurationLocked: outConfig={0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 420dpi nrml long hdr port finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/d dc/e}, packageName=appcore.svmc.multidisplayapp, reason=realStartActivity[ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46}], candidate=ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46} 
07-31 19:44:38.944 I 4653              FreeformStackController                                                              [DexCompat] applyDexCompatConfigurationLocked: outConfig={0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/e dc/e}, packageName=appcore.svmc.multidisplayapp, reason=ensureActivityConfig[ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46}], candidate=ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46} 
07-31 19:44:39.939 I 4653              FreeformStackController                                                              [DexCompat] applyDexCompatConfigurationLocked: outConfig={0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/e dc/e}, packageName=appcore.svmc.multidisplayapp, reason=ensureActivityConfig[ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46}], candidate=ActivityRecord{2cb3518 u0 appcore.svmc.multidisplayapp/.MainActivity t46} 



{0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 420dpi nrml long hdr port finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/d dc/e}
realStartActivity[ActivityRecord{5e8a907 u0 appcore.svmc.multidisplayapp/.MainActivity t50}]

FreeformStackController.applyDexCompatConfigurationLocked(ActivityRecord, Configuration, ApplicationInfo, String) line: 1000	
ActivityStackSupervisor.realStartActivityLocked(ActivityRecord, ProcessRecord, boolean, boolean) line: 1709	
ActivityStackSupervisor.startSpecificActivityLocked(ActivityRecord, boolean, boolean) line: 2018	
ActivityStack.resumeTopActivityInnerLocked(ActivityRecord, ActivityOptions, ActivityRecord, boolean) line: 3499	
ActivityStack.resumeTopActivityUncheckedLocked(ActivityRecord, ActivityOptions, ActivityRecord, boolean) line: 2866	
ActivityStack.resumeTopActivityUncheckedLocked(ActivityRecord, ActivityOptions) line: 2846	
ActivityStackSupervisor.resumeFocusedStackTopActivityLocked(ActivityStack, ActivityRecord, ActivityOptions) line: 2615	
ActivityStack.completePauseLocked(boolean, ActivityRecord) line: 1930	


{0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/e dc/e}
ensureActivityConfig[ActivityRecord{5e8a907 u0 appcore.svmc.multidisplayapp/.MainActivity t50}]

FreeformStackController.applyDexCompatConfigurationLocked(ActivityRecord, Configuration, ApplicationInfo, String) line: 1000	
ActivityRecord.ensureActivityConfigurationLocked(int, boolean, boolean) line: 3225	
ActivityRecord.ensureActivityConfigurationLocked(int, boolean) line: 3137	
ActivityManagerService.ensureConfigAndVisibilityAfterUpdate(ActivityRecord, int) line: 25828	
ActivityManagerService.updateDisplayOverrideConfigurationLocked(Configuration, ActivityRecord, boolean, int, ActivityManagerService$UpdateConfigurationResult) line: 25664	
ActivityManagerService.updateDisplayOverrideConfigurationLocked(Configuration, ActivityRecord, boolean, int) line: 25634	
ActivityStackSupervisor.realStartActivityLocked(ActivityRecord, ProcessRecord, boolean, boolean) line: 1732	

{0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 420dpi nrml long hdr port finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/d dc/e}
realStartActivity[ActivityRecord{5e8a907 u0 appcore.svmc.multidisplayapp/.MainActivity t50}]

ActivityStackSupervisor.realStartActivityLocked(ActivityRecord, ProcessRecord, boolean, boolean) line: 1849	
ActivityStackSupervisor.startSpecificActivityLocked(ActivityRecord, boolean, boolean) line: 2018	
ActivityStack.resumeTopActivityInnerLocked(ActivityRecord, ActivityOptions, ActivityRecord, boolean) line: 3499	
ActivityStack.resumeTopActivityUncheckedLocked(ActivityRecord, ActivityOptions, ActivityRecord, boolean) line: 2866	
ActivityStack.resumeTopActivityUncheckedLocked(ActivityRecord, ActivityOptions) line: 2846	
ActivityStackSupervisor.resumeFocusedStackTopActivityLocked(ActivityStack, ActivityRecord, ActivityOptions) line: 2615	
ActivityStack.completePauseLocked(boolean, ActivityRecord) line: 1930	
ActivityStack.activityPausedLocked(IBinder, boolean) line: 1840	


{0 1.1 themeSeq = 0 showBtnBg = 0 ?mcc?mnc [en_US,de_DE] ldltr sw411dp w411dp h731dp 160dpi nrml long hdr port desk finger qwerty/v/v -nav/h appBounds=Rect(754, 161 - 1165, 892) s.8 mkbd/h desktop/e dc/e}
ensureActivityConfig[ActivityRecord{5e8a907 u0 appcore.svmc.multidisplayapp/.MainActivity t50}]
ActivityRecord.ensureActivityConfigurationLocked(int, boolean, boolean) line: 3225	
ActivityStack.ensureActivitiesVisibleLocked(ActivityRecord, int, boolean) line: 2367	
ActivityStackSupervisor.ensureActivitiesVisibleLocked(ActivityRecord, int, boolean) line: 4618	
ActivityStackSupervisor.reportResumedActivityLocked(ActivityRecord) line: 4567	
ActivityRecord.completeResumeLocked() line: 2253	
ActivityStack.minimalResumeActivityLocked(ActivityRecord) line: 1411	



































































	