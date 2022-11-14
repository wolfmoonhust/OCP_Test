911 11-03 15:31:52.416 16514 16514 I OverviewState: phongtx getTransitionDuration Normal
912 11-03 15:31:52.416 16514 16514 I OverviewState: java.lang.RuntimeException
913 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.launcher3.uioverrides.states.OverviewState.getTransitionDuration(OverviewState.java:77)
914 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.launcher3.statemanager.StateManager.goToStateAnimated(StateManager.java:331)
915 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.launcher3.statemanager.StateManager.goToState(StateManager.java:314)
916 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.launcher3.statemanager.StateManager.goToState(StateManager.java:194)
917 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.quickstep.LauncherActivityInterface.switchToRecentsIfVisible(LauncherActivityInterface.java:236)
918 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.quickstep.OverviewCommandHelper.executeCommand(OverviewCommandHelper.java:249)
919 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.quickstep.OverviewCommandHelper.executeNext(OverviewCommandHelper.java:113)
920 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.quickstep.OverviewCommandHelper.addCommand(OverviewCommandHelper.java:135)
921 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.quickstep.OverviewCommandHelper.lambda$addCommand$0$OverviewCommandHelper(OverviewCommandHelper.java:151)
922 11-03 15:31:52.416 16514 16514 I OverviewState: at com.android.quickstep.-$$Lambda$OverviewCommandHelper$FKwSAsC7nLNRAig2yTNg_i1l67A.run(Unknown Source:4)
923 11-03 15:31:52.416 16514 16514 I OverviewState: at android.os.Handler.handleCallback(Handler.java:938)


10195 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: phongtx setStateWithAnimationInternal isNoButtonQuickSwitch=false
10196 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: java.lang.RuntimeException
10197 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.launcher3.uioverrides.BaseRecentsViewStateController.setStateWithAnimationInternal(BaseRecentsViewStateController.java:96)
10198 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.launcher3.uioverrides.RecentsViewStateController.setStateWithAnimationInternal(RecentsViewStateController.java:118)
10199 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.launcher3.uioverrides.BaseRecentsViewStateController.setStateWithAnimation(BaseRecentsViewStateController.java:84)
10200 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.launcher3.uioverrides.BaseRecentsViewStateController.setStateWithAnimation(BaseRecentsViewStateController.java:55)
10201 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.launcher3.statemanager.StateManager.createAnimationToNewWorkspaceInternal(StateManager.java:408)
10202 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.launcher3.statemanager.StateManager.goToStateAnimated(StateManager.java:335)
10203 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.launcher3.statemanager.StateManager.goToState(StateManager.java:314)
10204 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.launcher3.statemanager.StateManager.goToState(StateManager.java:194)
10205 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.quickstep.LauncherActivityInterface.switchToRecentsIfVisible(LauncherActivityInterface.java:236)
10206 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.quickstep.OverviewCommandHelper.executeCommand(OverviewCommandHelper.java:249)
10207 11-04 16:13:22.838 18311 18311 I BaseRecentsViewState: at com.android.quickstep.OverviewCommandHelper.executeNext(OverviewCommandHelper.java:113)


878 11-04 17:30:29.586 28905 28905 I HomeStateTransition: phongtx setWorkspaceProperty
879 11-04 17:30:29.586 28905 28905 I HomeStateTransition: java.lang.RuntimeException
880 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.homescreen.home.HomeStateTransitionController.setWorkspaceProperty(HomeStateTransitionController.java:163)
881 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.homescreen.home.HomeStateTransitionController.setStateWithAnimation(HomeStateTransitionController.java:140)
882 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.launcher3.Workspace.setStateWithAnimation(Workspace.java:1849)
883 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.launcher3.Workspace.setStateWithAnimation(Workspace.java:208)
884 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.launcher3.statemanager.StateManager.createAnimationToNewWorkspaceInternal(StateManager.java:410)
885 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.launcher3.statemanager.StateManager.goToStateAnimated(StateManager.java:337)
886 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.launcher3.statemanager.StateManager.goToState(StateManager.java:314)
887 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.launcher3.statemanager.StateManager.goToState(StateManager.java:194)
888 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.quickstep.LauncherActivityInterface.switchToRecentsIfVisible(LauncherActivityInterface.java:236)
889 11-04 17:30:29.586 28905 28905 I HomeStateTransition: at com.android.quickstep.OverviewCommandHelper.executeCommand(OverviewCommandHelper.java:249)




3437 10-14 14:27:25.335 3312 3312 I RecentsView: phongtx reloadIfNeed
3438 10-14 14:27:25.335 3312 3312 I RecentsView: java.lang.RuntimeException
3439 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.quickstep.views.RecentsView.reloadIfNeeded(RecentsView.java:2004)
3440 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.quickstep.views.RecentsView.updateTaskStackListenerState(RecentsView.java:1516)
3441 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.quickstep.views.RecentsView.setOverviewStateEnabled(RecentsView.java:1157)
3442 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.quickstep.views.LauncherRecentsView.setOverviewStateEnabled(LauncherRecentsView.java:161)
3443 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.quickstep.views.LauncherRecentsView.onStateTransitionStart(LauncherRecentsView.java:135)
3444 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.quickstep.views.LauncherRecentsView.onStateTransitionStart(LauncherRecentsView.java:57)
3445 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.launcher3.statemanager.StateManager.onStateTransitionStart(StateManager.java:472)
3446 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.launcher3.statemanager.StateManager.access$200(StateManager.java:74)
3447 10-14 14:27:25.335 3312 3312 I RecentsView: at com.android.launcher3.statemanager.StateManager$1.onAnimationStart(StateManager.java:428)
3448 10-14 14:27:25.335 3312 3312 I RecentsView: at android.animation.Animator$AnimatorListener.onAnimationStart(Animator.java:539)
3449 10-14 14:27:25.335 3312 3312 I RecentsView: at android.animation.AnimatorSet.start(AnimatorSet.java:737)
3450 10-14 14:27:25.335 3312 3312 I RecentsView: at android.animation.AnimatorSet.start(AnimatorSet.java:684)



1326 10-14 01:50:04.061 31329 31329 I SuggestedAppsViewImpl: phongtx updateItemsInternal
1327 10-14 01:50:04.061 31329 31329 I SuggestedAppsViewImpl: java.lang.RuntimeException
1328 10-14 01:50:04.061 31329 31329 I SuggestedAppsViewImpl: at com.android.quickstep.suggestedapps.SuggestedAppsViewImpl.updateItemsInternal(SuggestedAppsViewImpl.java:374)
1329 10-14 01:50:04.061 31329 31329 I SuggestedAppsViewImpl: at com.android.quickstep.suggestedapps.SuggestedAppsViewImpl.lambda$setPredictedApps$4$SuggestedAppsViewImpl(SuggestedAppsViewImpl.java:309)
1330 10-14 01:50:04.061 31329 31329 I SuggestedAppsViewImpl: at com.android.quickstep.suggestedapps.-$$Lambda$SuggestedAppsViewImpl$C-bYKtGC54oTY5LXseQHGF_u8Is.run(Unknown Source:4)
1331 10-14 01:50:04.061 31329 31329 I SuggestedAppsViewImpl: at android.os.Handler.handleCallback(Handler.java:938)


OverviewCommandHelper#goToStateAnimated
mConfig.duration  // config duration OverviewState#getTransitionDuration RECENTS_ANIM_FROM_HOME_DURATION_MS 230L
createAnimationToNewWorkspaceInternal  // create animation and add to mConfig
	Log.i(TAG, "createAnimationToNewWorkspaceInternal 
	super.setStateWithAnimationInternal
		hsSetStateWithAnimationInternal
			
	RecentsViewStateController#setStateWithAnimationInternal
		hsSetStateWithAnimationInternal
			addStateChangeAnimator
				addEnterElementsAnimator
					getElementsAnimator(RecentsUIAnimationType.ENTER_FROM_HOME)
						play(getHsClearAllAnimator(true));
						play(getSearchBarAnimator(true));
mUiHandler.post(new StartAnimRunnable(animation)); // start animation need to check why duration is ~330 (230L + 100??)



StateManager#onStateTransitionStart
	Log.i(TAG, "onStateTransitionStart mState = " + state);
	LauncherRecentsView#onStateTransitionStart
		Log.i(TAG, "onStateTransitionStart " + toState)
		setOverviewStateEnabled
		RecentsView#setOverviewStateEnabled
			Log.i(TAG, "setOverviewStateEnabled " + enabled);
			taskViewAnimation
			updateTaskStackListenerState
				reloadIfNeeded
					RecentsModel#getTasks
						Log.i(TAG, "getTasks, callback : "
						
	
xxx





RecentsView#applyLoadPlan
	Log.i(TAG, "applyLoadPlan, tasks : " + tasks)
	taskView.bind // bind data
	startEnteringTaskViewAnimation
		getElementsAnimator(RecentsUIAnimationType.ENTER_FROM_HOME_TASK_VIEW) // set animation for firstPage and second page
		
	Log.i(TAG, "applyLoadPlan requiredTask "
	
XXX
LauncherRecentsView#onStateTransitionStart
	SuggestedAppsViewImpl#update
		SuggestedAppsViewImpl#setPredictedApps
		
SuggestedAppsViewImpl#setPredictedApps
	Log.w(TAG, "predictedSize : "
	updateItemsInternal
		Log.i(TAG, "updateItemsInternal animate
			createEnterAnimation
				initEnterAnimator
phongtx reloadIfNeed|showCurrentTask|updateRecentsRotation|onStateTransitionStart mState|update fromHome|setOverviewStateEnabled|getTasks, callback



EnterFromHomeTaskViewAnimator
	start animation: get().start(); 
	duration thoi gian dai nhat trong tat cac cac child animation
	
	
====================TABLET: T270

EnterFromHomeTaskViewAnimator#init
	 if (mRecentsInfo.isVerticalListType() || mRecentsInfo.isGridType()) {
            play(getRecentsViewAnimator());
				 recentsViewAnimator.setDuration(FIRST_PAGE_DURATION_MS); //320
				 
				 
R OS
EnterByButtonAnimator#init
	setDuration(getDuration(fromHome, isMultiWindowMode, isTablet)); //340
	if (fromHome) {
            setStartDelay(ENTER_ANIM_DELAY_MS); //100  bat dau start animation thi moi co log trong onAmationStart(sau thoi gian delay)
        }
	play(getRecentsViewAnimator(rv, true, fromHome));
		recentsViewAnimator.setDuration(RECENTS_VIEW_EXIT_ANIM_DRUATION_MS); //400
		
		
Duration time of getSearchBarAnimator always is 200ms event though we set duration time 

Explain: 

[이희정 / Huijeong Lee] 11/30/2021 16:03
hsClearAllAnimator (ObjectAnimator) is included in the EnterFromHomeAnimator (AnimatorSet), and the EnterFromHomeAnimator is included in the builderAnimatorSet. 
The duration of all animators included in the animatorSet follows the duration defined in the animatorSet, not each duration. 
As you found, the duration of the builder animator set uses mConfig.duration, so mConfig.duration is also applied to the duration of the hsCleanAllAnimator.

https://developer.android.com/reference/android/animation/AnimatorSet
AnimatorSet    setDuration(long duration)
Sets the length of each of the current child animations of this AnimatorSet.

https://mobilerndhub.sec.samsung.net/wiki/display/~hj0128.lee/Animator
If you need an example, you can refer "animateByAnimatorSet" method.

[Trần Xuân Phong / Tran Xuan Phong] 11/30/2021 16:06
I see

[Trần Xuân Phong / Tran Xuan Phong] 11/30/2021 16:09
Do you know why we set duration for earch child ObjectAnimator (clearAllAnimator, searchBarAnimator...)?
because as you said, when we set  by setDuration API, it will effect to all childs. seem it is redundant?

[이희정 / Huijeong Lee] 11/30/2021 16:15
Yes.. It is redundant when animator is used in animatorset. But, it was defined for the case it is used alone not in animatorset.

[이희정 / Huijeong Lee] 11/30/2021 16:16
Of course, it is not currently used alone.



[ro.boot.debug_level]: [0x494d] -> debug level -  mid
[ro.boot.debug_level]: [0x4f4c] -> low

==execution
P211102-07749 [APP성능][APP실행속도][X808U][반응속도][UL1] X808U App실행속도 시험 T978U R OS 대비 열세 件 


RecentsView|StateManager|RecentsAnimatorHelper|SuggestedApps|InputReader|QuickStepAtomic|RecentsAnimatorSet|Suggester



[임지용 / Jiyong Lim] 12/16/2021 08:50
You can measure the time from overviewToggle to the moment the animation is changed through systrace log analysis.

[임지용 / Jiyong Lim] 12/16/2021 08:51
If it is similar to the previous problem, you can transfer to the system team.

[Trần Xuân Phong / Tran Xuan Phong] 12/16/2021 08:54
moment the animation is changed -> you mean changing state animation is started in systrace?

[임지용 / Jiyong Lim] 12/16/2021 08:58
in real view.. like at the start of the hotseat scale changed by adding trace log

[Trần Xuân Phong / Tran Xuan Phong] 12/16/2021 09:04
Could you please share me commit about adding trace log to check this point?
It is helpul for me to make clear some point to check reaction type issue :)

[임지용 / Jiyong Lim] 12/16/2021 09:12
public void onStateTransitionComplete(LauncherState finalState) {
    try (TraceHelper.TraceTag tag =
                 TraceHelper.TraceTag.getInstance("onStateTransitionComplete:" + finalState)) {
        Log.i(TAG, "onStateTransitionComplete " + finalState); /* Rune.RECENTS_SUPPORT_ONEUI */
        if (finalState == NORMAL || finalState == SPRING_LOADED) {
            // Clean-up logic that occurs when recents is no longer in use/visible.
            reset();
        }
        setOverlayEnabled(finalState == OVERVIEW || finalState == OVERVIEW_MODAL_TASK);
        setFreezeViewVisibility(false);
        if (Rune.RECENTS_SUPPORT_ONEUI_VI) {
            stateTransitionComplete(finalState == OVERVIEW || finalState == OVERVIEW_MODAL_TASK);
        }
    }
}

[임지용 / Jiyong Lim] 12/16/2021 09:13
just wrap the method

try (TraceHelper.TraceTag tag =
                 TraceHelper.TraceTag.getInstance("onStateTransitionComplete:" + finalState)) {
}

[임지용 / Jiyong Lim] 12/16/2021 09:14
you can search 'section string' in trace

[Trần Xuân Phong / Tran Xuan Phong] 12/16/2021 09:19
I got it. but this method is complete of StateTranstion. Does it conflict with test requirement of reaction test (touch down -> first frame change refer: https://mobilerndhub.sec.samsung.net/wiki/pages/viewpage.action?pageId=563087667)?

[임지용 / Jiyong Lim]
this is example... you should insert in correct place..


