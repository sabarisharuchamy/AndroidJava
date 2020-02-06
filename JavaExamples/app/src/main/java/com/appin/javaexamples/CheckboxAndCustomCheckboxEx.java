package com.appin.javaexamples;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckboxAndCustomCheckboxEx extends AppCompatActivity {

    @BindView(R.id.checkBox)
    CheckBox pizza;
    @BindView(R.id.checkBox2)
    CheckBox coffee;
    @BindView(R.id.checkBox3)
    CheckBox burger;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.checkBox4)
    CheckBox icecream;
    @BindView(R.id.checkBox5)
    CheckBox chocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox_and_custom_checkbox_ex);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        int totalamount=0;
        StringBuilder result=new StringBuilder();
        result.append("Selected Items:");
        if(pizza.isChecked()){
            result.append("\nPizza 100Rs");
            totalamount+=100;
        }
        if(coffee.isChecked()){
            result.append("\nCoffe 50Rs");
            totalamount+=50;
        }
        if(burger.isChecked()){
            result.append("\nBurger 120Rs");
            totalamount+=120;
        }
        if(icecream.isChecked()){
            result.append("\nIceCream 50Rs");
            totalamount+=50;
        }
        if(chocolate.isChecked()){
            result.append("\nChocolate 70Rs");
            totalamount+=70;
        }
        if(result!=null && !result.toString().equals("")) {
            result.append("\nTotal: " + totalamount + "Rs");
            //Displaying the message on the toast
            Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Nothing Selected", Toast.LENGTH_LONG).show();
        }
}
}
