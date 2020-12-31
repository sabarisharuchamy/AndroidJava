package com.appin.javaexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AndroidThreadingEx extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_threading_ex);
        textView=findViewById(R.id.textView1);
        editText=findViewById(R.id.editText1);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsynchrTaskEx ex = new AsynchrTaskEx();
                String sleepTime = editText.getText().toString();
                ex.execute(sleepTime);
            }
        });

    }
    private class AsynchrTaskEx extends AsyncTask<String,String,String> {
        private String resp;
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(AndroidThreadingEx.this,
                    "ProgressDialog",
                    "Wait for "+editText.getText().toString()+ " seconds");
        }

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping...");
            try{
                int time=Integer.parseInt(params[0])*1000;
                Thread.sleep(time);
                resp="Slept for "+params[0]+" seconds";
            }catch (InterruptedException e){
                e.printStackTrace();
                resp=e.getMessage();
            }
            catch(Exception e){
                e.printStackTrace();
                resp=e.getMessage();
            }

            return resp;
        }

        @Override
        protected void onProgressUpdate(String... result) {
            super.onProgressUpdate(result);
            textView.setText(result[0]);
        }

        @Override
        protected void onPostExecute(String text) {
            super.onPostExecute(text);
            progressDialog.dismiss();
            textView.setText(text);
        }
    }

}