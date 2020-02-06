package com.appin.javaexamples;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;
    @BindView(R.id.button9)
    Button button9;
    @BindView(R.id.button10)
    Button button10;
    @BindView(R.id.button11)
    Button button11;
    @BindView(R.id.button12)
    Button button12;
    @BindView(R.id.button13)
    Button button13;
    @BindView(R.id.button14)
    Button button14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button:
                intent = new Intent(getApplicationContext(), JsonArrayEx.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(getApplicationContext(), HorizontalCalendarEx.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(getApplicationContext(), RecyclerViewEx.class);
                startActivity(intent);
                break;
            case R.id.button4:
                intent = new Intent(getApplicationContext(), JsonArrayFromAdapter.class);
                startActivity(intent);
                break;
            case R.id.button5:
                intent = new Intent(getApplicationContext(), JsonVolleyRecyclerEx.class);
                startActivity(intent);
                break;
            case R.id.button6:
                intent = new Intent(getApplicationContext(), JsonRecyclerWithImageAndText.class);
                startActivity(intent);
                break;
            case R.id.button7:
                intent = new Intent(getApplicationContext(), ShowAndHideTitleEx.class);
                startActivity(intent);
                break;
            case R.id.button8:
                intent = new Intent(getApplicationContext(), ChangeScreenOrientationEx.class);
                startActivity(intent);
                break;
            case R.id.button9:
                intent = new Intent(getApplicationContext(), WorkingWithButton.class);
                startActivity(intent);
                break;
            case R.id.button10:
                intent = new Intent(getApplicationContext(), ToastAndCustomToastEx.class);
                startActivity(intent);
                break;
            case R.id.button11:
                intent = new Intent(getApplicationContext(), AndroidSnackBarEx.class);
                startActivity(intent);
                break;
            case R.id.button12:
                intent = new Intent(getApplicationContext(), AndroidChocoBarEx.class);
                startActivity(intent);
                break;
            case R.id.button13:
                intent = new Intent(getApplicationContext(), ToggleButtonEx.class);
                startActivity(intent);
                break;
            case R.id.button14:
                intent = new Intent(getApplicationContext(), CheckboxAndCustomCheckboxEx.class);
                startActivity(intent);
                break;
        }
    }


}
