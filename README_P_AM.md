Activity Manager

- Architecture
	- ActivityStack
- event logs
	I am_create_activity
	I na_new_intent

- dumpsys activity activities
	Task Record
		task id
		calling package
		intent -> flag activity
		mTaskToReturnTo (1 return to home or 0 return to app)
		mResuzeMode -> support multi window or not 
	Activity Record
		launchedFromPackage
		forntOfTask -> root activity?
		newVisible = true -> nếu window bị đen -> need check from WM

- Flag
	TaskAffinity
	Flag New Task: start từ launcher/ A->B có taskAffinity khác
	Flag Clear Task: thuong su dung cung voi co new task de activity moi luon la root activity (activity dau tien cua task) -> activity bi destroy, tao task moi
	Flag Clear Top: 
	Flag multiple task duoc su dung cung voi flag new document hoac flag new task de tao activity voi new task
	Flag new document
	Flag no history
	Flag reorder to front: bưng 1 activity đã có sẵn trong task đó lên trên cùng
	Flag single top: neu activ dang o top task
	Flag Task on home: duoc su dung cung voi Flag new task để activity thành root activity -> back to HOME
	
- Launch mode
	standard
	single top: giong flag single top
	single task: giong ket hop flag new task vs clear top
	single instance: trong 1 task chi co duy nhat 1 instance
	
Add and Remove Activity
- add: start activity/move activity ở các stack khác nhau
- remove: destroy/finish activity or move activity ở các stack khác nhau

Resizeable mode
- android version >= N
- default: resizableActivity = true in AndroidManifest.xml

Visible Activity
- Check stack activity visible
- Check activity visible
- check 

[Đặng Thị Trang / Dang Thi Trang] - 16:20 
trước tiên em nghĩ anh nên đọc event log để biết một cách tổng quá đã

[Đặng Thị Trang / Dang Thi Trang] - 16:22                 
tiếp là đảm bảo anh hiểu được chức năng của cờ mà launcher mode

[Đặng Thị Trang / Dang Thi Trang] - 16:22                 
xong học start activity vô cùng nhanh

[Đặng Thị Trang / Dang Thi Trang] - 16:23                 
cờ với launch mode

[Đặng Thị Trang / Dang Thi Trang] - 16:24 
logic của ams thực ra dễ lắm, nó chỉ dài nên mình hơi khó hình dung rôi, khi anh nhớ hết các bước rồi thì thấy nó dễ lắm

[Đặng Thị Trang / Dang Thi Trang] - 16:27 
cách học cờ với launch mode hiệu quả nhất là viết app test rồi check event log


====Day 1:
---EventLogTags.log
# An activity is being finished:
30001 am_finish_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(EventLogTags.AM_FINISH_ACTIVITY, r.userId, System.identityHashCode(r), task.taskId, r.shortComponentName, reason) //r ActivityRecord
am_finish_activity:	 [0,227001158,86,com.example.appcorelogtool/.MainActivity,app-request]

# A task is being brought to the front of the screen:
30002 am_task_to_front (User|1|5),(Task|1|5)
# An existing activity is being given a new intent:
30003 am_new_intent (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Action|3),(MIME Type|3),(URI|3),(Flags|1|5)

# A new task is being created:
30004 am_create_task (User|1|5),(Task ID|1|5)
EventLog.writeEvent(EventLogTags.AM_CREATE_TASK, mStartActivity.userId, mStartActivity.getTask().taskId);
am_create_task:	 [0,86]

# A new activity is being created in an existing task:
# { AppCore:FW_AMS_DEBUG_LOG - Add launchedFromPackage
# 30005 am_create_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Action|3),(MIME Type|3),(URI|3),(Flags|1|5)
# 30005 am_create_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Action|3),(MIME Type|3),(URI|3),(Flags|1|5),(launchedFromPackage|3)
EventLog.writeEvent(EventLogTags.AM_CREATE_ACTIVITY, r.userId, System.identityHashCode(r), task.taskId, r.shortComponentName, r.intent.getAction(),r.intent.getType(), strSecuredData, r.intent.getFlags(), r.launchedFromPackage); // task: task record of r
am_create_activity:	 [0,227001158,86,com.example.appcorelogtool/.MainActivity,android.intent.action.MAIN,NULL,NULL,270532608,com.sec.android.app.launcher]	
# AppCore:FW_AMS_DEBUG_LOG }

# An activity has been resumed into the foreground but was not already running:
30006 am_restart_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3)
EventLog.writeEvent(EventLogTags.AM_RESTART_ACTIVITY, r.userId, System.identityHashCode(r), task.taskId, r.shortComponentName);
am_restart_activity:	 [0,227001158,86,com.example.appcorelogtool/.MainActivity]

# An activity has been resumed and is now in the foreground:
30007 am_resume_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3)
EventLog.writeEvent(EventLogTags.AM_RESUME_ACTIVITY, next.userId, System.identityHashCode(next), next.getTask().taskId, next.shortComponentName);
am_resume_activity:	 [0,247072485,77,com.sec.android.app.launcher/.activities.LauncherActivity]

# Application Not Responding
30008 am_anr (User|1|5),(pid|1|5),(Package Name|3),(Flags|1|5),(reason|3)

# Activity launch time
30009 am_activity_launch_time (User|1|5),(Token|1|5),(Component Name|3),(time|2|3)
EventLog.writeEvent(AM_ACTIVITY_LAUNCH_TIME, userId, System.identityHashCode(this), shortComponentName, thisTime, totalTime);
am_activity_launch_time:	 [0,227001158,com.example.appcorelogtool/.MainActivity,1653,1653]

# Application process bound to work
30010 am_proc_bound (User|1|5),(PID|1|5),(Process Name|3)
EventLog.writeEvent(EventLogTags.AM_PROC_BOUND, app.userId, app.pid, app.processName);
am_proc_bound:	 [0,25638,com.example.appcorelogtool]

# Application process died
30011 am_proc_died (User|1|5),(PID|1|5),(Process Name|3),(OomAdj|1|5),(ProcState|1|5)

# The Activity Manager failed to pause the given activity.
30012 am_failed_to_pause (User|1|5),(Token|1|5),(Wanting to pause|3),(Currently pausing|3)

# Attempting to pause the current activity
30013 am_pause_activity (User|1|5),(Token|1|5),(Component Name|3),(User Leaving|3)
EventLogTags.writeAmPauseActivity(prev.userId, System.identityHashCode(prev), prev.shortComponentName, "userLeaving=" + userLeaving);
am_pause_activity:	 [0,227001158,com.example.appcorelogtool/.MainActivity,userLeaving=false]

# Application process has been started
30014 am_proc_start (User|1|5),(PID|1|5),(UID|1|5),(Process Name|3),(Type|3),(Component|3)
EventLog.writeEvent(EventLogTags.AM_PROC_START, UserHandle.getUserId(app.startUid), pid, app.startUid, app.processName, app.hostingType, app.hostingNameStr != null ? app.hostingNameStr : "");
am_proc_start:	 [0,25638,10196,com.example.appcorelogtool,activelaunch,com.example.appcorelogtool/.MainActivity]

# An activity is being destroyed:
30018 am_destroy_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(EventLogTags.AM_DESTROY_ACTIVITY, r.userId, System.identityHashCode(r), r.getTask().taskId, r.shortComponentName, reason);
am_destroy_activity:	 [0,227001158,86,com.example.appcorelogtool/.MainActivity,finish-imm:activityIdleInternalLocked]

# An activity has been relaunched, resumed, and is now in the foreground:
30019 am_relaunch_resume_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3)
# An activity has been relaunched:
30020 am_relaunch_activity (User|1|5),(Token|1|5),(Task ID|1|5),(Component Name|3)
EventLog.writeEvent(andResume ? AM_RELAUNCH_RESUME_ACTIVITY : AM_RELAUNCH_ACTIVITY, userId, System.identityHashCode(this), task.taskId, shortComponentName, Integer.toHexString(configChangeFlags));

# The activity's onPause has been called.
30021 am_on_paused_called (User|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(LOG_AM_ON_PAUSE_CALLED, UserHandle.myUserId(), getComponentName().getClassName(), reason);
am_on_paused_called:	 [0,com.example.appcorelogtool.MainActivity,performPause]

# The activity's onResume has been called.
30022 am_on_resume_called (User|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(LOG_AM_ON_RESUME_CALLED, UserHandle.myUserId(), getComponentName().getClassName(), reason);
am_on_resume_called:	 [0,com.example.appcorelogtool.MainActivity,RESUME_ACTIVITY]

# Kill a process to reclaim memory.
30023 am_kill (User|1|5),(PID|1|5),(Process Name|3),(OomAdj|1|5),(Reason|3)

# Activity set to resumed
30043 am_set_resumed_activity (User|1|5),(Component Name|3),(Reason|3)
EventLogTags.writeAmSetResumedActivity( r == null ? -1 : r.userId, r == null ? "NULL" : r.shortComponentName, reason);
am_set_resumed_activity:	 [0,com.example.appcorelogtool/.MainActivity,minimalResumeActivityLocked]

# Stack focus
30044 am_focused_stack (User|1|5),(Focused Stack Id|1|5),(Last Focused Stack Id|1|5),(Reason|3)
EventLogTags.writeAmFocusedStack(mCurrentUser, mFocusedStack == null ? -1 : mFocusedStack.getStackId(), mLastFocusedStack == null ? -1 : mLastFocusedStack.getStackId(), reason);
am_focused_stack:	 [0,9,0,reuseOrNewTask]	

# Attempting to stop an activity
30048 am_stop_activity (User|1|5),(Token|1|5),(Component Name|3)
EventLogTags.writeAmStopActivity(r.userId, System.identityHashCode(r), r.shortComponentName);
am_stop_activity:	 [0,247072485,com.sec.android.app.launcher/.activities.LauncherActivity]

# The activity's onStop has been called.
30049 am_on_stop_called (User|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(LOG_AM_ON_STOP_CALLED, UserHandle.myUserId(), getComponentName().getClassName(), reason);
am_on_stop_called:	 [0,com.example.appcorelogtool.MainActivity,LIFECYCLER_STOP_ACTIVITY]

# The activity's onCreate has been called.
30057 am_on_create_called (User|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(LOG_AM_ON_CREATE_CALLED, UserHandle.myUserId(), getComponentName().getClassName(), reason);
am_on_create_called:	 [0,com.example.appcorelogtool.MainActivity,performCreate]

# The activity's onRestart has been called.
30058 am_on_restart_called (User|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(LOG_AM_ON_RESTART_CALLED, UserHandle.myUserId(), getComponentName().getClassName(), reason);
am_on_restart_called:	 [0,com.sec.android.app.launcher.activities.LauncherActivity,performRestartActivity]

# The activity's onStart has been called.
30059 am_on_start_called (User|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(LOG_AM_ON_START_CALLED, UserHandle.myUserId(), getComponentName().getClassName(), reason);
am_on_start_called:	 [0,com.example.appcorelogtool.MainActivity,handleStartActivity]

# The activity's onDestroy has been called.
30060 am_on_destroy_called (User|1|5),(Component Name|3),(Reason|3)
EventLog.writeEvent(LOG_AM_ON_DESTROY_CALLED, UserHandle.myUserId(), getComponentName().getClassName(), reason);
am_on_destroy_called:	 [0,com.example.appcorelogtool.MainActivity,performDestroy]

# The activity's onActivityResult has been called.
30062 am_on_activity_result_called (User|1|5),(Component Name|3),(Reason|3)

# The task is being removed from its parent stack
30061 am_remove_task (Task ID|1|5), (Stack ID|1|5)
EventLog.writeEvent(EventLogTags.AM_REMOVE_TASK, task.taskId, getStackId());
am_remove_task:	 [125,15]	

# Out of memory for surfaces.
31000 wm_no_surface_memory (Window|3),(PID|1|5),(Operation|3)

# Task created.
#/* { AppCore */
#31001 wm_task_created (TaskId|1|5),(StackId|1|5)
31001 wm_task_created (TaskId|1|5),(StackId|1|5),(WindowingMode|1|5)
EventLog.writeEvent(WM_TASK_CREATED, taskId, stack.mStackId, /* { AppCore */stack.getWindowingMode()/* AppCore } */);
#/* AppCore } */

# Task moved to top (1) or bottom (0).
31002 wm_task_moved (TaskId|1|5),(ToTop|1),(Index|1)
EventLog.writeEvent(EventLogTags.WM_TASK_MOVED, child.mTaskId, toTop, targetPosition);
wm_task_moved:	 [103,1,0]	

# Task removed with source explanation.
#31003 wm_task_removed (TaskId|1|5),(Reason|3)
31003 wm_task_removed (TaskId|1|5),(Reason|3),(WindowingMode|1|5)
EventLog.writeEvent(WM_TASK_REMOVED, mTaskId, "reParentTask",/* { AppCore */getWindowingMode()/* AppCore } */);
wm_task_removed:	 [91,reParentTask,5]	


# Stack created.
#31004 wm_stack_created (StackId|1|5)
31004 wm_stack_created (StackId|1|5),(WindowingMode|1|5)
EventLog.writeEvent(EventLogTags.WM_STACK_CREATED, stackId,/* { AppCore */getWindowingMode()/* AppCore } */);
wm_stack_created:	 [11,0]	



# Home stack moved to top (1) or bottom (0).
31005 wm_home_stack_moved (ToTop|1)

# Stack removed.
#31006 wm_stack_removed (StackId|1|5)
31006 wm_stack_removed (StackId|1|5),(WindowingMode|1|5)
EventLog.writeEvent(EventLogTags.WM_STACK_REMOVED, mStackId,/* { AppCore */getWindowingMode()/* AppCore } */);
wm_stack_removed:	 [14,5]	

# bootanim finished:
31007 wm_boot_animation_done (time|2|3)


31900 wm_task_windowing_mode_changed (TaskId|1|5),(PrevWindowingMode|1|5),(WindowingMode|1|5)
EventLog.writeEvent(WM_TASK_WINDOWING_MODE_CHANGED, mTaskId, prevWindowingMode, getWindowingMode());
wm_task_windowing_mode_changed:	 [91,5,1]	

31901 wm_user_rotation_changed (Rotation|1|5),(callingPid|1|5)









===day 2
---launch mode
ref: https://medium.com/@iammert/android-launchmode-visualized-8843fc833dbe
    Single Task
    Case 1:
        Condition:
            SingleTaskActivity //affitiny=SingleTaskActivity
            other //default affinity
        Step:
            #StandardActivity->SingleTopActivity->SingleTaskActivity->StandardActivity->SingleTaskActivity
        Result:
            #SingleTaskActivity
            #SingleTopActivity<-StandardActivity
    Case 2:
        Condition: default affinity
        Step:
            #StandardActivity->SingleTopActivity->SingleTaskActivity->StandardActivity->SingleTaskActivity
        Result:
            #SingleTaskActivity<-SingleTopActivity<-StandardActivity
            -> some activity above SingleTaskActivity will be finished by clear-task-stack
    Question: use Single Task with out define Affinity?
    Case 3:
        A Single Task, B : Affinity default
        C D : something
        Step: A->B->C(NEW_TASK)->D->A(NEW_TASK)
        Result:
            #A
            #D<-C
            ->B finish "clear-task-stack" A DOES NOT FINISH
    Single Instance:
    Case 1:
        Condition:
            default affinity
        Step:
            StandardActivity->SingleInstanceActivity
        Result:
            #SingleInstanceActivity
            #StandardActivity
            -> create new stack and new task
    Case 2:
        Condition:
            default affinity
        Step:
            StandardActivity->SingleInstanceActivity->SingleTopActivity->StandardActivity->SingleInstanceActivity
        Result:
            #SingleInstanceActivity
            #StandardActivity<-SingleTopActivity<-StandardActivity
            -> when user single instance, this activity only in separate stack
            -> when start singleTopActivity from SingleInstanceActivity, it will be added to previous task of StandardActivity (because default affinity)
    Single top:
        Condition:
            default affinity
        Step:
            StandardActivity->SingleTopActivity->StandardActivity->SingleTopActivity
        Result:
            #SingleTopActivity<-StandardActivity<-SingleTopActivity<-StandardActivity
        ->create a activity in top of task, if activity already in top, no need to create it (user am_new_intent)
    Standard:
    

---Intent Flag
https://www.slideshare.net/RanNachmany/manipulating-android-tasks-and-back-stack
Intent.java

FLAG_ACTIVITY_NEW_TASK
    Case 1: A->B->C(NEW_TASK)->D->A(NEW_TASK)
    Result:
        #A<-B<-A
        #D<-C
FLAG_ACTIVITY_NO_HISTORY
A->B->C(NEW_TASK,NO_HISTORY)->D
A->B->C(NEW_TASK)-> D and finish C ???

FLAG_ACTIVITY_SINGLE_TOP
    same behavior like singletop launch mode

FLAG_ACTIVITY_MULTIPLE_TASK //TODO

FLAG_ACTIVITY_SINGLE_TOP
    Step: A->B->D->B (include SINGLE_TOP)
    Result: A->B (D finish: clear-task-stack, B finish: clear-task-top and create)
FLAG_ACTIVITY_CLEAR_TOP
    Case 1:
    Step: A->B->D(NEW_TASK)->B(CLEAR_TOP|NEW_TASK) //A B: affinity =  default, D: affinity = something
    Result:
        #A
        #D
        -> A B will be finished, after that A will be created
    Case 2:
    Step: A->B->D->B(CLEAR_TOP)
    Result:
        #A->B
        ->B D will be finished, after that B will be created
    Case 3:
    Step: A->B->C->A->B->D->A(CLEAR_TOP)
    Result:A<-C<-B<-A
FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
    -> if current activity is running, it will be saw in recents
FLAG_ACTIVITY_RESET_TASK_IF_NEEDED //TODO
FLAG_ACTIVITY_CLEAR_TASK 0X00008000
    Case 1:
        Step: B->C (CLEAR_TASK) //
        Result C<-B<-A
        -> CLEAR_TASK did not effect because NEW_TASK was not used
    Case 2:
        Step: B->C (NEW_TASK|CLEAR_TASK C has not existed yet)
        Result:
            #C
            #B<-A
    Case 3:
        Step: B->C (NEW_TASK|CLEAR_TASK)->D->A(NEW_TASK|CLEAR_TASK)
        Result:
            #A
            #D<-C
            ->A B: finish: "clear-task-all" and A re-create
    Case 4:
        A->B->C(NEW_TASK|CLEAR_TASK)->D, back to B by recent->C(NEW_TASK|CLEAR_TASK)
        Result:
        #C
        #B<-A
        ->C D: finish: "clear-task-all" and C re-create
    Case 5:
        A->B->C(NEW_TASK|CLEAR_TASK)->D->B(NEW_TASK|CLEAR_TASK)
        Result:
        #B
        #D<-C
        ->A B: finish: "clear-task-all" and A re-create
FLAG_ACTIVITY_NEW_DOCUMENT
    Step: A->B(NEW_DOCUMENT)->A
    Result:
        #A<-B
        #A
FLAG_ACTIVITY_MULTIPLE_TASK
    always user with either FLAG_ACTIVITY_NEW_DOCUMENT or FLAG_ACTIVITY_NEW_TASK
    Step: A->C(MULTIPLE_TASK|NEW_TASK)->back to A by recent->C(MULTIPLE_TASK|NEW_TASK)
    Result:
        #C
        #A
        #C
FLAG_ACTIVITY_NO_HISTORY
    Step: A->B(NO_HISTORY)->A
    Result:
        #A<-B<-A
        -> B finish "stop-no-history"
FLAG_ACTIVITY_REORDER_TO_FRONT
    will be ignored if FLAG_ACTIVITY_CLEAR_TOP is also specified
    Case 1:
        Step: A->C->D(REORDER_TO_FRONT)->C->D
        Result:
            D<-C<-C<-A
    Case 2:
        Step: A->B->C->D->A(NEW_TASK|REORDER_TO_FRONT)
        Result:A<-D<-C<-B<-A //TODO
        ->need check reuseActivity
FLAG_ACTIVITY_TASK_ON_HOME
    Step: A->B->C(NEW_TASK|TASK_ON_HOME)
    Result:
    #C
    #LauncherActivity
    #B<-A
    -> back press in C activity -> go to Home
FLAG_ACTIVITY_BROUGHT_TO_FRONT
    not normally set by application, was set for you by launchMode as SingleTask

Thu tu de xem xet mot activity co duoc start trong mot existing Task hay khong:
    - task.intent.component =  mStartActivity.component
    - task.affinityIntent.component = mStartActivity.component
    - task.rootAffinity = mStartActivity.taskAffinity

=== day 3===
http://mobilerndhub.sec.samsung.net/wiki/display/SVMC/Start+new+process



Step to start Activity
ActivityStarter#startActivity
    Slog.i(TAG, "START u"
    r = new ActivityRecord
    ActivityStarter#startActivity
        ActivityStarter#startActivityUnchecked
            ActivityStarter#setInitialState
            ActivityStarter#computeLaunchingTaskFlags
            reusedActivity = getReusableIntentActivity();
            if (newTask) EventLog.writeEvent(EventLogTags.AM_CREATE_TASK,
            ActivityStack.logStartActivity(EventLogTags.AM_CREATE_ACTIVITY
            ActivityStack#startActivityLocked
                ActivityStack#insertTaskAtTop
                ActivityStack#createWindowContainer
                ActivityRecord#showStartingWindow
            ActivityStackSupervisor#resumeFocusedStackTopActivityLocked
                ActivityStack#topRunningActivityLocked
                ActivityStack#resumeTopActivityUncheckedLocked
                    ActivityStack#resumeTopActivityUncheckedLocked
                        ActivityStack#resumeTopActivityInnerLocked
                            ActivityStack#resumeTopActivityInnerLocked
                                //remove next Activity Record from some lists
                                mStackSupervisor.mStoppingActivities.remove(next);
                                mStackSupervisor.mGoingToSleepActivities.remove(next);
                                next.sleeping = false;
                                mStackSupervisor.mActivitiesWaitingForVisibleActivity.remove(next);
                                DEBUG_SWITCH) Slog.v(TAG_SWITCH, "Resuming " + next);
                                ActivityStackSupervisor#pauseBackStacks // writeAmPauseActivity in here
                                    ActivityStack#startPausingLocked
                                        mPausingActivity = prev
                                        prev.setState(PAUSING, "startPausingLocked");
                                        next = mStackSupervisor.topRunningActivityLocked();
                                        DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Enqueueing pending pause: " + prev)
                                        EventLogTags.writeAmPauseActivity(prev.userId, System.identityHashCode(prev)
                                        scheduleTransaction(prev.app.thread, prev.appToken,PauseActivityItem.obtain(prev.finishing, userLeaving, prev.configChangeFlags, pauseImmediately));
                                        if (pauseImmediately)
                                             completePauseLocked
                                        else
                                             schedulePauseTimeout
                                                    sendMessageDelayed(msg, PAUSE_TIMEOUT)
                                                    DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Waiting for pause to complete...")
                        ActivityStack#topRunningActivityLocked
            ActivityStackSupervisor#updateUserStackLocked
            ActivityStackSupervisor#handleNonResizableTaskIfNeeded
            
            
            

                        
====START===

ActivityThread#handleStartActivity
    config = new Configuration(mCompatConfiguration) //create and update config
    Activity#performStart
        Instrumentation#callActivityOnStart
        writeEventLog(LOG_AM_ON_START_CALLED, reason) //am_on_start_called
        ActivityClientRecord#setState(ON_START)
        

                        
ActivityStackSupervisor#ensureActivitiesVisibleLocked
    ActivityStack#ensureActivitiesVisibleLocked
        checkKeyguardVisibility
        makeVisibleAndRestartIfNeeded
        ActivityRecord#startFreezingScreenLocked ???
        DEBUG_VISIBILITY) Slog.v(TAG_VISIBILITY, "Starting and making visible
        ActivityRecord#setVisible(true)
        ActivityStackSupervisor#startSpecificActivityLocked
            ActivityStackSupervisor#realStartActivityLocked // TODO
                DEBUG_STATES) Slog.v(TAG_PAUSE,"realStartActivityLocked: Skipping start of r= // return here

        AMS#activityPaused
            ActivityStack#activityPausedLocked
            (DEBUG_PAUSE) Slog.v(TAG_PAUSE,"Activity paused: token="
                ActivityStack#completePauseLocked
                    DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Complete pause: "
                    prev.setState(PAUSED, "completePausedLocked");
                    ActivityStackSupervisor#resumeFocusedStackTopActivityLocked
                    


ActivityStarter#startActivityUnchecked
    ActivityStarter#setTaskFromReuseOrCreateNewTask
        ActivityStac#moveToFront
        ActivityStackSupervisor#setFocusStackUnchecked
            mFocusedStack = focusCandidate
            EventLogTags.writeAmFocusedStack(mCurrentUser, mFocusedStack
            
            

===RESUME phase===
ActivityManagerService#activityPaused
    ActivityStack#activityPausedLocked
        ActivityStackSupervisor#resumeFocusedStackTopActivityLocked
            ActivityStack#resumeTopActivityUncheckedLocked
                ActivityStack#resumeTopActivityUncheckedLocked
                    ActivityStack#resumeTopActivityInnerLocked
                        ActivityStack#resumeTopActivityInnerLocked
                            mStackSupervisor.mStoppingActivities.remove(next);
                            mStackSupervisor.mGoingToSleepActivities.remove(next);
                            next.sleeping = false;
                            mStackSupervisor.mActivitiesWaitingForVisibleActivity.remove(next);
                            DEBUG_SWITCH) Slog.v(TAG_SWITCH, "Resuming "
                            ActivityStackSupervisor#pauseBackStacks // writeAmPauseActivity in here
                                    ActivityStack#startPausingLocked
                                        mPausingActivity = prev
                                                prev.setState(PAUSING, "startPausingLocked");
                                                next = mStackSupervisor.topRunningActivityLocked();
                                                DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Enqueueing pending pause: " + prev)
                                                EventLogTags.writeAmPauseActivity(prev.userId, System.identityHashCode(prev)
                                                scheduleTransaction(prev.app.thread, prev.appToken,PauseActivityItem.obtain(prev.finishing, userLeaving, prev.configChangeFlags, pauseImmediately));
                                                if (pauseImmediately)
                                                    completePauseLocked
                                                else
                                                    schedulePauseTimeout
                                                        sendMessageDelayed(msg, PAUSE_TIMEOUT)
                                                        DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Waiting f
                            ActivityStackSupervisor#startSpecificActivityLocked
                                ActivityStackSupervisor#realStartActivityLocked
                                    DEBUG_ALL) Slog.v(TAG, "Launching: " + r);
                                    EventLog.writeEvent(EventLogTags.AM_RESTART_ACTIVITY
                                    ClientTransaction#addCallback(LaunchActivityItem)
                                    ClientLifecycleManager#scheduleTransaction(clientTransaction) // with lifecycleItem is ResumeActivityItem
                                        ClientTransaction#schedule
                                            ActivityThread#ApplicationThread#scheduleTransaction
                                                ClientTransactionHandler#scheduleTransaction
                                                    ClientTransaction#preExecute
                                                    EXECUTE_TRANSACTION
                                    ActivityStack#minimalResumeActivityLocked

===RESUME phase===
EXECUTE_TRANSACTION
    TransactionExecutor#execute
        TransactionExecutor#executeCallbacks
            LaunchActivityItem#execute
                ActivityThread#handleLaunchActivity
                    handleConfigurationChanged
                    WindowManagerGlobal#initialize
                    performLaunchActivity
                        Instrumentation#callActivityOnCreate
                            Activity#performCreate
                                Activity#onCreate
                                writeEventLog(LOG_AM_ON_CREATE_CALLED, "performCreate")
                        ActivityClientRecord#setState(ON_CREATE)
        TransactionExecutor#executeLifecycleState
            TransactionExecutor#cycleToPath
                TransactionExecutor#performLifecycleSequence
            ResumeActivityItem#execute
                ActivityThread#handleResumeActivity
                    ActivityThread#performResumeActivity
                        Activity#performResume
                            Instrumentation#callActivityOnResume
                            writeEventLog(LOG_AM_ON_RESUME_CALLED //am_on_resume_called
                    ActivityClientRecord#setState(ON_RESUME)
                    mNewActivities = r
                    addIdleHandler(new Idler())
                ResumeActivityItem#postExecute
                    AMS#activityResumed
                    

===STOP phase===

ActivityStack#ensureActivitiesVisibleLocked
    ActivityStack#makeInvisible
        ActivityRecord#setVisible(false)
        ActivityStack#addToStopping
            ActivityStackSupervisor#scheduleIdleLocked
                IDLE_NOW_MSG
                    ActivityStackSupervisor#activityIdleInternal
                        ActivityStackSupervisor#activityIdleInternalLocked
                            ActivityStack#finishCurrentActivityLocked
                            ActivityStack#stopActivityLocked
                                DEBUG_SWITCH) Slog.d(TAG_SWITCH, "Stopping: "
                                adjustFocusedActivityStack(r, "stopActivity")
                                ActivityRecord#setState(STOPPING, "stopActivityLocked")
                                EventLogTags.writeAmStopActivity
                                scheduleTransaction //with StopActivityItem
                                STOP_TIMEOUT_MSG
                    

===FINISH phase===

ActivityStack<T>.finishCurrentActivityLocked(ActivityRecord, int, boolean, String) line: 4489	
ActivityStack<T>.completePauseLocked(boolean, ActivityRecord) line: 1876	
ActivityStack<T>.activityPausedLocked(IBinder, boolean) line: 1842	
ActivityManagerService.activityPaused(IBinder) line: 10515	


ActivityStack<T>.finishCurrentActivityLocked(ActivityRecord, int, boolean, String) line: 4532	
ActivityStackSupervisor.activityIdleInternalLocked(IBinder, boolean, boolean, Configuration) line: 2485	
ActivityStackSupervisor$ActivityStackSupervisorHandler.activityIdleInternal(ActivityRecord, boolean) line: 5673	
ActivityStackSupervisor$ActivityStackSupervisorHandler.handleMessage(Message) line: 5708	


ActivityStack#destroyActivityLocked
    EventLog.writeEvent(EventLogTags.AM_DESTROY_ACTIVITY
    
    
        


Activity#finish
        AMS#finishActivity // TODO recheck???
            ActivityStack#requestFinishActivityLocked
                ActivityStack#finishActivityLocked
                    ActivityRecord#makeFinishingLocked
                        finishing = true
                    EventLog.writeEvent(EventLogTags.AM_FINISH_ACTIVITY

ActivityStack#finishCurrentActivityLocked
    ActivityRecord#setState(FINISHING, "finishCurrentActivityLocked")
    mFinishingActivities.add(r)


Enable log:
ActivityManagerDebugConfig
DEBUG_PAUSE DEBUG_STACK DEBUG_SWITCH DEBUG_TRANSITION DEBUG_VISIBILITY DEBUG_STATES

Next action:
study deeply about main function like below:
    computeLaunchingTaskFlags
    computeSourceStack
    ...
    
    mLifecycleStateRequest

    
Activity#performPause
    onPause()
    LOG_AM_ON_PAUSE_CALLED, "performPause");
    performPause
    
    
    
startProcessLocked

handleProcessStartedLocked




    
ActivityStackSupervisor#realStartActivityLocked
    addCallback(LaunchActivityItem
    


===start process===
AMS#ActiveLaunchReceiver#onReceive
    com.samsung.DO_ACTIVE_LAUNCH
        Slog.d(TAG, "Checking for the Active launch isPkgEverLaunched :"
        context#startActivity(launchIntent, activeOpt.toBundle())
            ContextImpl#startActivity
                Instrumentation#execStartActivity
                    ActivityManagerService#startActivity
                        ActivityManagerService#startActivityAsUser
                            ActivityStarter#execute
                                ActivityStarter#startActivityMayWait
                                    TAG, "TouchDown intent received, starting ActiveLaunch"
                                    ActivityManagerService#startProcessLocked
                                        ....
                                            startProcess
                                            mProcStartHandler.post(() ->
                                                handleProcessStartedLocked
                                                    EventLog.writeEvent(EventLogTags.AM_PROC_START //am_proc_start
        Slog.d(TAG, "starting Active launch")

===attachApplication==
ActivityThread#main
    ActivityThread#attach
        AMS#attachApplication
            AMS#attachApplicationLocked
                EventLog.writeEvent(EventLogTags.AM_PROC_BOUND
                ActivityThread#bindApplication
                    BIND_APPLICATION//Trace.TRACE_TAG_ACTIVITY_MANAGER, "bindApplication")
                        handleBindApplication
                ActivityStackSupervisor#attachApplicationLocked
                    ActivityStackSupervisor#realStartActivityLocked // return by allPausedActivitiesComplete() condition
===

            ActivityStackSupervisor#realStartActivityLocked // return by allPausedActivitiesComplete() condition
                "realStartActivityLocked: Skipping start of r"
                    ActivityRecord#startFreezingScreenLocked // prev activity???
                    ActivityRecord#setVisibility
                    EventLog.writeEvent(EventLogTags.AM_RESTART_ACTIVITY
                    ActivityStack#minimalResumeActivityLocked
                        ActivityRecord#setState(RESUMED, "minimalResumeActivityLocked")
                            TaskRecord#onActivityStateChanged
                                ActivityStack#onActivityStateChanged
                                    ActivityStack#setResumedActivity
                                        DEBUG_STACK) Slog.d(TAG_STACK, "setResumedActivity stack:
                                        mResumedActivity = r
                                    AMS#setResumedActivityUncheckLocked
                                        mLastResumedActivity = r
                                        WMS#setFocusedApp
                                        EventLogTags.writeAmSetResumedActivity( //am_set_resumed_activity

                                        
                        ActivityRecord#completeResumeLocked


===

    PauseActivityItem#postExecute
        AMS#activityPaused
            ActivityStack#activityPausedLocked
            (DEBUG_PAUSE) Slog.v(TAG_PAUSE,"Activity paused: token="
                ActivityStack#completePauseLocked
                    DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Complete pause: "
                    prev.setState(PAUSED, "completePausedLocked");
                    ActivityStackSupervisor#resumeFocusedStackTopActivityLocked
                        ActivityStack#resumeTopActivityUncheckedLocked
                            ActivityStack#resumeTopActivityInnerLocked
                                //remove next Activity Record from some lists
                                mStackSupervisor.mStoppingActivities.remove(next);
                                mStackSupervisor.mGoingToSleepActivities.remove(next);
                                next.sleeping = false;
                                mStackSupervisor.mActivitiesWaitingForVisibleActivity.remove(next);
                                DEBUG_SWITCH) Slog.v(TAG_SWITCH, "Resuming " + next);
                                ActivityStackSupervisor#pauseBackStacks // writeAmPauseActivity in here
                                    ActivityStack#startPausingLocked
                                        mPausingActivity = prev
                                                prev.setState(PAUSING, "startPausingLocked");
                                                next = mStackSupervisor.topRunningActivityLocked();
                                                DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Enqueueing pending pause: " + prev)
                                                EventLogTags.writeAmPauseActivity(prev.userId, System.identityHashCode(prev)
                                                scheduleTransaction(prev.app.thread, prev.appToken,PauseActivityItem.obtain(prev.finishing, userLeaving, prev.configChangeFlags, pauseImmediately));
                                                if (pauseImmediately)
                                                    completePauseLocked
                                                else
                                                    schedulePauseTimeout
                                                        sendMessageDelayed(msg, PAUSE_TIMEOUT)
                                                        DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Waiting for pause to complete...")
                                ActivityStackSupervisor#startSpecificActivityLocked
                                    ActivityStackSupervisor#realStartActivityLocked
                                        ActivityRecord#startFreezingScreenLocked // prev activity???
                                        ActivityRecord#setVisibility
                                        DEBUG_ALL) Slog.v(TAG, "Launching: " + r);
                                        EventLog.writeEvent(EventLogTags.AM_RESTART_ACTIVITY
                                        ClientLifecycleManager#scheduleTransaction(clientTransaction) // with lifecycleItem is ResumeActivityItem
                                        ActivityStack#minimalResumeActivityLocked
                                            ActivityRecord#setState(RESUMED, "minimalResumeActivityLocked")
                                                TaskRecord#onActivityStateChanged
                                                    ActivityStack#onActivityStateChanged
                                                        ActivityStack#setResumedActivity
                                                            DEBUG_STACK) Slog.d(TAG_STACK, "setResumedActivity stack:
                                                            mResumedActivity = r
                                                        AMS#setResumedActivityUncheckLocked
                                                            mLastResumedActivity = r
                                                            WMS#setFocusedApp
                                                            EventLogTags.writeAmSetResumedActivity( //am_set_resumed_activity
                                            ActivityRecord#completeResumeLocked


                                            
                                            
====PAUSE detail===
ActivityStackSupervisor#pauseBackStacks
    ActivityStack#startPausingLocked
        prev.setState(PAUSING, "startPausingLocked");
        next = mStackSupervisor.topRunningActivityLocked();
        DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Enqueueing pending pause: " + prev)
        EventLogTags.writeAmPauseActivity(prev.userId, System.identityHashCode(prev)
        scheduleTransaction(prev.app.thread, prev.appToken,PauseActivityItem.obtain(prev.finishing, userLeaving, prev.configChangeFlags, pauseImmediately));
        if (pauseImmediately)
            completePauseLocked
        else
            schedulePauseTimeout
                sendMessageDelayed(msg, PAUSE_TIMEOUT)
                DEBUG_PAUSE) Slog.v(TAG_PAUSE, "Waiting for pause to complete...")
                

TransactionExecutor#executeLifecycleState
    PauseActivityItem#execute
        ActivityThread#handlePauseActivity
            ActivityThread#performPauseActivity
                ActivityThread#performPauseActivityIfNeeded
                    Instrumentation#callActivityOnPause
                        Activity#performPause
                            performPause() // call to override
                            writeEventLog(LOG_AM_ON_PAUSE_CALLED, "performPause");
                    ActivityClientRecord#setState(ON_PAUSE);
                    
                    
LaunchActivityItem#execute //TRACE_TAG_ACTIVITY_MANAGER, "activityStart"
    r = new ActivityClientRecord
    ActivityThread#handleLaunchActivity

ResumeAtivityItem#execute //TRACE_TAG_ACTIVITY_MANAGER, "activityResume"
    ActivityThread#handleResumeActivity

    ActivityThread#main //TRACE_TAG_ACTIVITY_MANAGER, "ActivityThreadMain");
BIND_APPLICATION // TRACE_TAG_ACTIVITY_MANAGER, "bindApplication"
ZygoteInit ???? 

    
    
realStartActivityLocked|START u|pointer|startActivity|atta|performCreate|add ResumeAc|minimalResumeActivityLocked|startPausingLocked

com.samsung.android|add ResumeAc
phongtx|am_|ActivityManager|TransactionExecutor