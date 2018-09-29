package com.casuga.mcspenzer;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class SecretService extends IntentService {

    final String TAG = "4ITF-SECRET-SERVICE";

    public SecretService() {
        super("SecretService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "Secret service is running");
    }
}
