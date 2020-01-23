package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class JsonArrayFromAdapter extends AppCompatActivity implements JsonExtractAdapter{
TextView textView;
public static String test="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array_from_adapter);
        textView = findViewById(R.id.textView4);
        textView.setText(test);
    }

    @Override
    public void dispJson(String value) {
test = value;
    }
}
