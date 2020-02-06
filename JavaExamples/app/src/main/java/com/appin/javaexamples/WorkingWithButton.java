package com.appin.javaexamples;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WorkingWithButton extends AppCompatActivity {

    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_with_button);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        String value1=editText1.getText().toString();
        String value2=editText2.getText().toString();
        int a=Integer.parseInt(value1);
        int b=Integer.parseInt(value2);
        int sum=a+b;
        Toast.makeText(getApplicationContext(),String.valueOf(sum), Toast.LENGTH_LONG).show();
    }
}
