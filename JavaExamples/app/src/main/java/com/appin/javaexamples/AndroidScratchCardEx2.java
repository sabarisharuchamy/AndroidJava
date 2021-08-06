package com.appin.javaexamples;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AndroidScratchCardEx2 extends AppCompatActivity {

    private ScratchCard mScratchCard;
    TextView codeTxt;
    String number;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_scratch_card_ex2);

        mScratchCard = findViewById(R.id.scratchCard);
        codeTxt = findViewById(R.id.codeTxt);
        number = codeTxt.getText().toString();
        codeTxt.setText(number);
        codeTxt.setText(Utils.generateNewCode());

        findViewById(R.id.btnScratchAgain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= 11) {
                    //Code for recreate
                    recreate();
                } else {
                    finish();
                    startActivity(getIntent());
                }
            }
        });
    }

    private void scratch(boolean isScratched) {
        if (isScratched) {
            mScratchCard.setVisibility(View.INVISIBLE);
        } else {
            mScratchCard.setVisibility(View.VISIBLE);
        }
    }

    private void handleListeners() {
        mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                if (visiblePercent > 0.8) {
                    scratch(true);
                }
            }
        });
    }
}