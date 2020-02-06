package com.appin.javaexamples;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToastAndCustomToastEx extends AppCompatActivity {

    @BindView(R.id.button14)
    Button button14;
    @BindView(R.id.button15)
    Button button15;
    @BindView(R.id.button16)
    Button button16;
    @BindView(R.id.button17)
    Button button17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_and_custom_toast_ex);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button14, R.id.button15, R.id.button16, R.id.button17})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button14:
                Toast.makeText(getApplicationContext(), "Hello Javatpoint", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button15:
                Toast.makeText(getApplicationContext(), "Hello Javatpoint", Toast.LENGTH_LONG).show();
                break;
            case R.id.button16:
                // Set the toast and duration
                int toastDurationInMilliSeconds = 10000;
                Toast mToastToShow = Toast.makeText(this, "Hello world, I am a toast.", Toast.LENGTH_LONG);
                mToastToShow.setMargin(50, 50);
                // Set the countdown to display the toast
                CountDownTimer toastCountDown;
                toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
                    public void onTick(long millisUntilFinished) {
                        mToastToShow.show();
                    }

                    public void onFinish() {
                        mToastToShow.cancel();
                    }
                };

                // Show the toast and starts the countdown
                mToastToShow.show();
                toastCountDown.start();
                break;
            case R.id.button17:
                //Creating the LayoutInflater instance
                LayoutInflater li = getLayoutInflater();
                //Getting the View object as defined in the customtoast.xml file
                View layout = li.inflate(R.layout.activity_custom_toast,(ViewGroup) findViewById(R.id.custom_toast_layout));

                //Creating the Toast object
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(layout);//setting the view of custom toast layout
                toast.show();
                break;
        }
    }
}
