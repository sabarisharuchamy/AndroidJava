package com.appin.javaexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class AndroidOrientationLimitEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_orientation_limit_ex);
        if(this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(AndroidOrientationLimitEx.this,"This app is being restricted from changing orientation. Please check if any app is preventing this action.",Toast.LENGTH_LONG).show();
            finish();
        }
        //checkConfigChanges();
    }

    private void checkConfigChanges(){
        int orientation = this.getResources().getConfiguration().orientation;
        /*if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(MainActivity.this,"Portrait Orientation",Toast.LENGTH_LONG).show();
        } else if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(MainActivity.this,"Landscape Orientation",Toast.LENGTH_LONG).show();
        }*/
        if(orientation != Configuration.ORIENTATION_LANDSCAPE) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("This app works only in landscape mode. Do you want to switch to landscape and continue?");
            builder.setCancelable(false);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                }
            });
            builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.show();
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("This app works only in landscape mode. Do you want to switch to landscape and continue?");
            builder.setCancelable(false);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                    if(newConfig.orientation != Configuration.ORIENTATION_LANDSCAPE){
                        Toast.makeText(AndroidOrientationLimitEx.this,"This app is being restricted from changing orientation. Please check if any app is preventing this action.",Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            });
            builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.show();
        }
    }
}