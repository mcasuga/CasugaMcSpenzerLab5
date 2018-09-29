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

public class SecondActivity extends AppCompatActivity {

    final String TAG = "4ITF-ACTIVITY-2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Start the service after opening application
        Intent startSecretService = new Intent(this, SecretService.class);
        startService(startSecretService);

        ImageView second_imageView = findViewById(R.id.second_imageView);

        // Set title
        setTitle(getString(R.string.activity_2));

        second_imageView.setImageResource(R.drawable.puerto_princesa);

        TextView second_locationChangeTextView = findViewById(R.id.second_locationChangeTextView);
        TextView second_distanceChangeTextView = findViewById(R.id.second_distanceChangeTextView);

        // Set location and distance
        second_locationChangeTextView.setText(R.string.location);
        second_distanceChangeTextView.setText(R.string.puerto_princesa_location);

        Button second_activityOneButton = findViewById(R.id.second_activityOneButton);
        Button second_mapButton = findViewById(R.id.second_mapButton);

        // Create an intent for going to first activity
        final Intent toActivityOne = new Intent(this, FirstActivity.class);

        // Create an intent for opening geolocation on maps
        final Intent openMap = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("geo:9.967216299999999,118.78550999999993"));

        String chooserTitle = "Choose preferred application";

        final Intent chooser = Intent.createChooser(openMap, chooserTitle);

        second_activityOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(toActivityOne);
            }
        });

        second_mapButton.setOnClickListener(new View.OnClickListener() {
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
