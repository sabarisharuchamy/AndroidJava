package com.appin.javaexamples;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;

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
    @BindView(R.id.button15)
    Button button15;
    @BindView(R.id.button16)
    Button button16;
    @BindView(R.id.button17)
    Button button17;
    @BindView(R.id.button18)
    Button button18;
    @BindView(R.id.button19)
    Button button19;
    @BindView(R.id.button20)
    Button button20;
    @BindView(R.id.button21)
    Button button21;
    @BindView(R.id.button22)
    Button button22;
    @BindView(R.id.button23)
    Button button23;
    @BindView(R.id.button24)
    Button button24;
    @BindView(R.id.button25)
    Button button25;
    @BindView(R.id.button26)
    Button button26;
    @BindView(R.id.button27)
    Button button27;
    @BindView(R.id.button28)
    Button button28;
    @BindView(R.id.button29)
    Button button29;
    @BindView(R.id.button30)
    Button button30;
    @BindView(R.id.button31)
    Button button31;
    @BindView(R.id.button32)
    Button button32;
    @BindView(R.id.button33)
    Button button33;
    @BindView(R.id.button34)
    Button button34;
    @BindView(R.id.button35)
    Button button35;
    @BindView(R.id.button36)
    Button button36;
    @BindView(R.id.button37)
    Button button37;
    @BindView(R.id.button38)
    Button button38;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15, R.id.button16,R.id.button17,R.id.button18,R.id.button19,R.id.button20,R.id.button21,R.id.button22,R.id.button23,R.id.button24,R.id.button25,R.id.button26,R.id.button27,R.id.button28,R.id.button29,R.id.button30,R.id.button31,R.id.button32, R.id.button33, R.id.button34, R.id.button35, R.id.button36, R.id.button37, R.id.button38})
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
            case R.id.button15:
                intent = new Intent(getApplicationContext(), RadioButtonAndCustomRadioButtonEx.class);
                startActivity(intent);
                break;
            case R.id.button16:
                intent = new Intent(getApplicationContext(), DynamicRadioButtonEx.class);
                startActivity(intent);
                break;
            case R.id.button17:
                intent = new Intent(getApplicationContext(), AndroidSqliteEx.class);
                startActivity(intent);
                break;
            case R.id.button18:
                intent = new Intent(getApplicationContext(), AndroidSqliteSpinnerEx.class);
                startActivity(intent);
                break;
            case R.id.button19:
                intent = new Intent(getApplicationContext(), AndroidRetrofitEx.class);
                startActivity(intent);
                break;
            case R.id.button20:
                intent = new Intent(getApplicationContext(), AndroidThreadingEx.class);
                startActivity(intent);
                break;
            case R.id.button21:
                intent = new Intent(getApplicationContext(), ShareDataBetweenFragments.class);
                startActivity(intent);
                break;
            case R.id.button22:
                intent = new Intent(getApplicationContext(), ShareDataBetweenFragmentsViewModel.class);
                startActivity(intent);
                break;
            case R.id.button23:
                intent = new Intent(getApplicationContext(), AndroidWebViewEx.class);
                startActivity(intent);
                break;
            case R.id.button24:
                intent = new Intent(getApplicationContext(), AndroidSplashScreenEx.class);
                startActivity(intent);
                break;
            case R.id.button25:
                intent = new Intent(getApplicationContext(), AndroidDataBindingEx.class);
                startActivity(intent);
                break;
            case R.id.button26:
                intent = new Intent(getApplicationContext(), AndroidOptionsMenuEx.class);
                startActivity(intent);
                break;
            case R.id.button27:
                intent = new Intent(getApplicationContext(), AndroidSlidingDrawerEx.class);
                startActivity(intent);
                break;
            case R.id.button28:
                pref = getSharedPreferences("user_details",MODE_PRIVATE);
                if(pref.contains("username") && pref.contains("password")){
                    intent = new Intent(getApplicationContext(),DetailsActivity.class);
                    startActivity(intent);
                }else {
                    intent = new Intent(getApplicationContext(), AndroidSessionSharedPreferencesEx.class);
                    startActivity(intent);
                }
                break;
            case R.id.button29:
                intent = new Intent(getApplicationContext(),AndroidExpandableFloatingButtonEx.class);
                startActivity(intent);
                break;
            case R.id.button30:
                intent = new Intent(getApplicationContext(),AndroidWebServiceEx.class);
                startActivity(intent);
                break;
            case R.id.button31:
                intent = new Intent(getApplicationContext(),AndroidScratchCardEx1.class);
                startActivity(intent);
                break;
            case R.id.button32:
                intent = new Intent(getApplicationContext(),AndroidScratchCardEx2.class);
                startActivity(intent);
                break;
            case R.id.button33:
                intent = new Intent(getApplicationContext(),AndroidOrientationLimitEx.class);
                startActivity(intent);
                break;
            case R.id.button34:
                intent = new Intent(getApplicationContext(),AndroidVibrationEx1.class);
                startActivity(intent);
                break;
            case R.id.button35:
                intent = new Intent(getApplicationContext(),AndroidVibrationEx2.class);
                startActivity(intent);
                break;
            case R.id.button36:
                intent = new Intent(getApplicationContext(),AndroidMediaStoreEx.class);
                startActivity(intent);
                break;
            case R.id.button37:
                intent = new Intent(getApplicationContext(),AndroidReadExcelEx.class);
                startActivity(intent);
                break;
            case R.id.button38:
                intent = new Intent(getApplicationContext(),AndroidHorizontalRecyclerViewEx.class);
                startActivity(intent);
                break;
        }
    }


}
