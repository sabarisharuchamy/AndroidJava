package com.appin.javaexamples;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowAndHideTitleEx extends AppCompatActivity {

    @BindView(R.id.button8)
    Button hideButton;
    @BindView(R.id.button9)
    Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        setContentView(R.layout.activity_show_and_hide_title_ex);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button8)
    public void onHideButtonClicked() {
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
    }

    @OnClick(R.id.button9)
    public void onShowButtonClicked() {
        getSupportActionBar().show(); // show the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN); //enable full screen
    }
}
