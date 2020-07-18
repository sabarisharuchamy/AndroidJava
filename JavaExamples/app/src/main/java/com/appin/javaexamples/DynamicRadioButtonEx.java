package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class DynamicRadioButtonEx extends AppCompatActivity {
    RadioGroup rg;
    RelativeLayout rl;
    RadioButton rb1,rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_radio_button_ex);
        rg = new RadioGroup(this);
        rl = (RelativeLayout) findViewById(R.id.relativeLayout);
        rb1 = new RadioButton(this);
        rb2 = new RadioButton(this);

        rb1.setText("Male");
        rb2.setText("Female");
        rg.addView(rb1);
        rg.addView(rb2);
        rg.setOrientation(RadioGroup.HORIZONTAL);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) LayoutParams.WRAP_CONTENT,(int)LayoutParams.WRAP_CONTENT);
        params.leftMargin =150;
        params.topMargin = 100;

        rg.setLayoutParams(params);
        rl.addView(rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
