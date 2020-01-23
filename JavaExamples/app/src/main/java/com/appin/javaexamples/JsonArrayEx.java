package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class JsonArrayEx extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array_ex);

        Patient patient1 = new Patient(1, "Ram Murthy","Cancer");
        Patient patient2 = new Patient(2, "Ganesh Murthy","Fever");
        Patient patient3 = new Patient(3, "Jai Murthy","Diabetes");
        Patient patient4 = new Patient(4, "Krishna Murthy","Appendix");
        Patient patient5 = new Patient(5, "Tamil Murthy","Fracture");
        final ArrayList<Patient> arrayList = new ArrayList<Patient>();
        arrayList.add(patient1);
        arrayList.add(patient2);
        arrayList.add(patient3);
        arrayList.add(patient4);
        arrayList.add(patient5);

        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DisplayPatientDetails.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("Birds", arrayList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
