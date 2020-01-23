package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class DisplayPatientDetails extends AppCompatActivity {
ListView listView;
String[] listItem;
String indItem;
public static int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patient_details);
        listView = findViewById(R.id.listView);
        List<Patient> challenge = this.getIntent().getExtras().getParcelableArrayList("Birds");
        listItem = new String[challenge.size()];
        for (Patient p:challenge){
            indItem = p.getRegisterId()+p.getPatientName()+p.getPatientDisease();
            listItem[count]=indItem;
            count++;
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);
    }
}
