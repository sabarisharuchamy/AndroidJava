package com.example.welcome.jsondataextract;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        getJSON("http://192.168.43.142/Android/getdata.php");
    }
    private void getJSON(final String urlWebService){
        class GetJSON extends AsyncTask<Void,Void,String>{
            protected void onPreExecute(){
                super.onPreExecute();
            }
            protected void onPostExecute(String s){
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                try {
                    loadIntoListView(s);
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(urlWebService);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                StringBuilder stringBuilder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String json;
                while ((json=reader.readLine())!=null){
                    stringBuilder.append(json+"\n");
                }
                return stringBuilder.toString().trim();
                }catch (Exception e) {
                e.printStackTrace();
                return e.toString();
                }
            }
        }    GetJSON getjson = new GetJSON();
             getjson.execute();
    }
    private void  loadIntoListView(String json) throws JSONException{
        JSONArray jsonArray = new JSONArray(json);

        String[] heroes = new String[jsonArray.length()];

        for (int i = 0;i < jsonArray.length();i++){
            JSONObject object = jsonArray.getJSONObject(i);
            heroes[i] = object.getString("name");
}
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,heroes);
listView.setAdapter(adapter);
    }
}
