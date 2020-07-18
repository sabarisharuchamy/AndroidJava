package com.appin.javaexamples;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RadioButtonAndCustomRadioButtonEx extends AppCompatActivity {

    @BindView(R.id.radioButton1)
    RadioButton radioButton1;
    @BindView(R.id.radioButton2)
    RadioButton radioButton2;
    RadioButton genderradioButton;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_and_custom_radio_button_ex);
        ButterKnife.bind(this);
    }

    public void onclickbuttonMethod(View v){
        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        if(radioButton1.isChecked()==false||radioButton2.isChecked()==false||genderradioButton==null){
            Toast.makeText(RadioButtonAndCustomRadioButtonEx.this, "Please ensure that age and weight are above the required and also select your gender", Toast.LENGTH_LONG).show();
        }else {
            if (selectedId == -1) {
                Toast.makeText(RadioButtonAndCustomRadioButtonEx.this, "Please select a gender", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(RadioButtonAndCustomRadioButtonEx.this, "You are eligible!\n"+radioButton1.getText()+"\n"+radioButton2.getText()+"\n"+genderradioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        }


    }
}
