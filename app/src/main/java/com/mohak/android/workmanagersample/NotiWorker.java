package com.mohak.android.workmanagersample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class NotiWorker extends Worker {

    public NotiWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    private static final String TAG = NotiWorker.class.getName();

    /**
     * Override this method to do your actual background processing.  This method is called on a
     * background thread - you are required to <b>synchronously</b> do your work and return the
     * {@link Result} from this method.  Once you return from this
     * method, the Worker is considered to have finished what its doing and will be destroyed.
     * <p>
     * A Worker is given a maximum of ten minutes to finish its execution and return a
     * {@link Result}.  After this time has expired, the Worker will
     * be signalled to stop.
     *
     * @return The {@link Result} of the computation; note that
     * dependent work will not execute if you use
     * {@link Result#failure()} or
     */
    @NonNull
    @Override
    public Result doWork() {

        Context context = getApplicationContext();
        try {
            Log.d(TAG, "doWork Called");
            Utils.sendNotification(context);
            return Result.success();
        } catch (Throwable throwable) {
            Log.d(TAG, "Error Sending Notification" + throwable.getMessage());
            return Result.failure();
        }

    }
}
