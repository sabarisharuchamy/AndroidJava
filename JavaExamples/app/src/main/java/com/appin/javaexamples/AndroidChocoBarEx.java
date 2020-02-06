package com.appin.javaexamples;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pd.chocobar.ChocoBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AndroidChocoBarEx extends AppCompatActivity {

    @BindView(R.id.button23)
    Button button;
    @BindView(R.id.button24)
    Button button2;
    @BindView(R.id.button25)
    Button button3;
    @BindView(R.id.button26)
    Button button4;
    @BindView(R.id.button27)
    Button button5;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_choco_bar_ex);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button23, R.id.button24, R.id.button25, R.id.button26, R.id.button27})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button23:
                ChocoBar.builder().setActivity(AndroidChocoBarEx.this)
                        .setText("GREEN")
                        .setDuration(ChocoBar.LENGTH_SHORT)
                        .green()  // in built green ChocoBar
                        .show();
                break;
            case R.id.button24:
                ChocoBar.builder().setView(linearLayout)
                        .setText("RED")
                        .setDuration(ChocoBar.LENGTH_INDEFINITE)
                        .setActionText(android.R.string.ok)
                        .red()   // in built red ChocoBar
                        .show();
                break;
            case R.id.button25:
                ChocoBar.builder().setView(linearLayout)
                        .setText("GRAY_GOOD")
                        .centerText()
                        .setDuration(ChocoBar.LENGTH_LONG)
                        .good()
                        .show();

                ChocoBar.builder().setView(linearLayout)
                        .setText("GRAY_BAD")
                        .centerText()
                        .setDuration(ChocoBar.LENGTH_LONG)
                        .bad()
                        .show();
                break;
            case R.id.button26:
                ChocoBar.builder().setActivity(AndroidChocoBarEx.this).setActionText("ACTION")
                        .setActionClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(AndroidChocoBarEx.this, "You clicked",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setText("This is a normal ChocoBar")
                        .setDuration(ChocoBar.LENGTH_INDEFINITE)
                        .build()
                        .show();
                break;
            case R.id.button27:
                ChocoBar.builder().setBackgroundColor(Color.parseColor("#00bfff"))
                        .setTextSize(18)
                        .setTextColor(Color.parseColor("#FFFFFF"))
                        .setTextTypefaceStyle(Typeface.ITALIC)
                        .setText("This is a custom Chocobar")
                        .setMaxLines(4)
                        .centerText()
                        .setActionText("ChocoBar")
                        .setActionTextColor(Color.parseColor("#66FFFFFF"))
                        .setActionTextSize(20)
                        .setActionTextTypefaceStyle(Typeface.BOLD)
                        .setIcon(R.mipmap.ic_launcher)
                        .setActivity(AndroidChocoBarEx.this)
                        .setDuration(ChocoBar.LENGTH_INDEFINITE)
                        .build()
                        .show();
                break;
        }
    }
}
