package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cooltechworks.views.ScratchImageView;

public class AndroidScratchCardEx1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_scratch_card_ex1);

        // initializing our scratchcardimageview.
        ScratchImageView scratchImageView = findViewById(R.id.idScratchCardIv);
        scratchImageView.setRevealListener(new ScratchImageView.IRevealListener() {
            @Override
            public void onRevealed(ScratchImageView iv) {
                // this method is called after revealing the image.
                Toast.makeText(AndroidScratchCardEx1.this, "image is revealed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchImageView siv, float percent) {
                // we can check how much percentage of
                // image is revealed using percent variable
                //Toast.makeText(MainActivity4.this,String.valueOf(percent),Toast.LENGTH_SHORT).show();
                if(percent>0.40){
                    siv.reveal();
                }
            }
        });
    }
}