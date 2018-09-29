package com.casuga.mcspenzer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    final String TAG = "4ITF-ACTIVITY-1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // Start the service after opening application
        Intent startSecretService = new Intent(this, SecretService.class);
        startService(startSecretService);

        ImageView first_imageView = findViewById(R.id.first_imageView);

        // Set title
        setTitle(getString(R.string.activity_1));

        // Set Image
        first_imageView.setImageResource(R.drawable.tubbataha);

        TextView first_locationChangeTextView = findViewById(R.id.first_locationChangeTextView);
        TextView first_distanceChangeTextView = findViewById(R.id.first_distanceChangeTextView);

        // Set location and distance
        first_locationChangeTextView.setText(R.string.location);
        first_distanceChangeTextView.setText(R.string.tubbataha_location);

        Button first_activityTwoButton = findViewById(R.id.first_activityTwoButton);
        Button first_mapButton = findViewById(R.id.first_mapButton);

        // Create an intent for going to second activity
        final Intent toActivityTwo = new Intent(this, SecondActivity.class);

        // Create an intent for opening geolocation on maps
        final Intent openMap = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("geo:9.7359339,118.74900750000006"));

        String chooserTitle = "Choose preferred application";

        final Intent chooser = Intent.createChooser(openMap, chooserTitle);

        first_activityTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toActivityTwo);
            }
        });

        first_mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (openMap.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart() method executed");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume() method executed");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause() method executed");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop() method executed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "onRestart() method executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy() method executed");
    }
}
