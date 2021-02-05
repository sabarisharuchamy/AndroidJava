package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AndroidSplashScreenEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_splash_screen_ex);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(AndroidSplashScreenEx.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}