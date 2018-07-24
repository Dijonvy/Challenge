package com.questions.sixth.Services;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.questions.datastructures.Node;
import com.questions.datastructures.SinglyLinkedList;
import com.questions.sixth.RemoveEmailThreadDuplicates;

public class EmailProcessorService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * Used to name the worker thread, important only for debugging.
     */

    public static final String BROADCAST_ACTION =
            "com.questions.services.emailProcessor.BROADCAST";

    public EmailProcessorService() {
        super("EmailProcessorService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("SERVICE","Email thread request received! Starting cleaner...");
        SinglyLinkedList emailThread = null;
        Bundle extras = intent.getExtras();
        if(extras != null) {
            emailThread = extras.getParcelable("emailThread");

            RemoveEmailThreadDuplicates remover = new RemoveEmailThreadDuplicates();
            remover.removeDuplicateMessages(emailThread);

            for(Node node = emailThread.head; node != null; node = node.next) {
                Log.d("SERVICE CLEANER - Node ",node.data);
            }

            Intent localIntent = new Intent(BROADCAST_ACTION);
            localIntent.putExtra("emailThreadResult",emailThread);
            this.sendBroadcast(localIntent);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent,flags,startId);
        return START_REDELIVER_INTENT;
    }
}