package com.appin.javaexamples;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeScreenOrientationEx extends AppCompatActivity {

    @BindView(R.id.button10)
    Button button;
    @BindView(R.id.button11)
    Button button2;
    @BindView(R.id.button12)
    Button button3;
    @BindView(R.id.button13)
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_screen_orientation_ex);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button10)
    public void onButtonClicked() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @OnClick(R.id.button11)
    public void onButton2Clicked() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @OnClick(R.id.button12)
    public void onButton3Clicked() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE);
    }

    @OnClick(R.id.button13)
    public void onButton4Clicked() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT);
    }
}
