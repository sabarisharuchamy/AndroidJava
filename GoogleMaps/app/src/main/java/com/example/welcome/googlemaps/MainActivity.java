package com.example.welcome.googlemaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;

public class MainActivity extends AppCompatActivity {
    EditText donorName,donorMobile,donorLocation;
    Spinner donorBloodGroup;
    Button button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_form);
        donorName = findViewById(R.id.donorName);
        donorMobile = findViewById(R.id.donorMobile);
        donorBloodGroup = findViewById(R.id.donorBloodGroup);
        donorLocation = findViewById(R.id.donorLocation);

        button = findViewById(R.id.donorSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("location",donorLocation.getText().toString());
                startActivity(i);
            }
        });
    }
}
