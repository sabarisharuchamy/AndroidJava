package com.androidopentutorials.sharedpreference;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.androidopentutorials.sharedpreference.utils.SharedPreference;

public class SecondActivity extends Activity {

	// UI References
	private TextView textTxt;
	
	private String text;
	
	private SharedPreference sharedPreference;

	Activity context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
				
		sharedPreference = new SharedPreference();

		findViewsById();
		
		//Retrieve a value from SharedPreference
		text = sharedPreference.getValue(context);
		textTxt.setText(text);
		
	}

	private void findViewsById() {
		textTxt = (TextView) findViewById(R.id.txt_text);
	}


}
