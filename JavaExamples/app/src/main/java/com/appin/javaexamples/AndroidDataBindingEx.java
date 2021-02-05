package com.appin.javaexamples;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.appin.javaexamples.databinding.ActivityAndroidDataBindingExBinding;

public class AndroidDataBindingEx extends AppCompatActivity {
    ActivityAndroidDataBindingExBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_data_binding_ex);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_android_data_binding_ex);
        binding.tvHeading.setText("Welcome to Android TV");
        binding.tvSubHeading.setText("Please enjoy all the features available here");
    }
}