package com.appin.javaexamples;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToggleButtonEx extends AppCompatActivity {

    @BindView(R.id.toggleButton)
    ToggleButton toggleButton;
    @BindView(R.id.toggleButton2)
    ToggleButton toggleButton2;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button_ex);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        StringBuilder result = new StringBuilder();
        result.append("ToggleButton1 : ").append(toggleButton.getText());
        result.append("\nToggleButton2 : ").append(toggleButton2.getText());
        //Displaying the message in toast
        Toast.makeText(getApplicationContext(), result.toString(),Toast.LENGTH_LONG).show();
    }
}
