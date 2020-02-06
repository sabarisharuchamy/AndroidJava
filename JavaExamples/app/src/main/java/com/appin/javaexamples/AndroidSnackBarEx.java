package com.appin.javaexamples;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AndroidSnackBarEx extends AppCompatActivity {

    @BindView(R.id.button18)
    Button button;
    @BindView(R.id.button19)
    Button button2;
    @BindView(R.id.button20)
    Button button3;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.button21)
    Button button21;
    @BindView(R.id.button22)
    Button button22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_snack_bar_ex);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button18, R.id.button19, R.id.button20, R.id.button21, R.id.button22})
    public void onViewClicked(View view) {
        Snackbar snackbar;
        TextView textView;
        View sbView;
        switch (view.getId()) {
            case R.id.button18:
                snackbar = Snackbar.make(linearLayout, "Button is clicked", Snackbar.LENGTH_LONG);
                snackbar.show();
                break;
            case R.id.button19:
                snackbar = Snackbar
                        .make(linearLayout, "Message is deleted", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1 = Snackbar.make(linearLayout, "Message is restored!", Snackbar.LENGTH_SHORT);
                                snackbar1.show();
                            }
                        });

                snackbar.show();
                break;
            case R.id.button20:
                snackbar = Snackbar
                        .make(linearLayout, "Try again!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });
                snackbar.setActionTextColor(Color.RED);
                sbView = snackbar.getView();
                textView = (TextView) sbView.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
                break;
            case R.id.button21:
                snackbar = Snackbar
                        .make(linearLayout, "Try again!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });
                // styling for action text
                snackbar.setActionTextColor(Color.WHITE);

// styling for rest of text
                View snackbarView = snackbar.getView();
                textView = (TextView) snackbarView.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                textView.setAllCaps(true);
                textView.setTextSize(20);

// styling for background of snackbar
                sbView = snackbarView;
                sbView.setBackgroundColor(Color.BLUE);
                snackbar.show();
                break;
            case R.id.button22:
                snackbar = Snackbar.make(linearLayout, "Style Text, Font and Action Color",
                        Snackbar.LENGTH_SHORT);
                // Set action text color
                snackbar.setActionTextColor(
                        ContextCompat.getColor(getBaseContext(), R.color.actionTextColor)
                );
                snackbar.setAction("Undo", new UndoListener());
                sbView = snackbar.getView();
                textView = sbView.findViewById(R.id.snackbar_text);
                // set no of text line
                textView.setMaxLines(2);
                //set text color
                textView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.actionTextColor));
                //set text size
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                //Set Snackbar background color
                sbView.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.colorBg));
                snackbar.show();

                break;
        }
    }

    // Define the click listener
    private class UndoListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // Code to undo the user's last action
            View contextView = findViewById(android.R.id.content);
            // Make and display Snackbar
            Snackbar.make(contextView, "Message restore", Snackbar.LENGTH_SHORT)
                    .show();

        }
    }
}