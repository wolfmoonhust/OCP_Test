ContextWrapper#sendBroadcast // all Activity and Service extends ContextWrapper so they can sendBroadcast
    ...
    ActivityManagerService#broadcastIntent // get Uid Pid
        verifyBroadcastLocked
        getRecordForAppLocked
        broadcastIntentLocked
        
        

    BroadcastQueue mFgBroadcastQueue;
    BroadcastQueue mBgBroadcastQueue;
    BroadcastQueue mOffloadBroadcastQueue; // Q OS

BroadcastQueue
    BroadcastHandler
    
BroadcastFilter extends IntentFilter
ReceiverList extends ArrayList<BroadcastFilter>
BroadcastRecord extends Binder

BroadcastReceiver
    PendingResult
    
    
ActivityManagerService#registerReceiver
