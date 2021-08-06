package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class AndroidVibrationEx2 extends AppCompatActivity {

    Button bComposeVibration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_vibration_ex2);

        // register the button with the appropriate ID
        bComposeVibration = findViewById(R.id.makeVibrationCompositionButton);

        // create instance of the vibrator and initialise it with Vibrator system service
        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // handle compose vibration button
        bComposeVibration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Note: The first element needs to be 0
                long[] vibrationWaveFormDurationPattern = {0, 10, 200, 500, 700, 1000, 300, 200, 50, 10};

                // the vibration of the type custom waveforms needs the API version 26
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

                    // create VibrationEffect instance and createWaveform of vibrationWaveFormDurationPattern
                    // -1 here is the parameter which indicates that the vibration shouldn't be repeated.
                    VibrationEffect vibrationEffect = VibrationEffect.createWaveform(vibrationWaveFormDurationPattern, -1);

                    // it is safe to cancel all the vibration taking place currently
                    vibrator.cancel();

                    // now initiate the vibration of the device
                    vibrator.vibrate(vibrationEffect);
                }
            }
        });
    }
}