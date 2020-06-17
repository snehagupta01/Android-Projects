package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.service.voice.VoiceInteractionService;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    TextView t1;
    public class DownloadTask extends AsyncTask<String, Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;
            try{
                url=new URL(urls[0]);
                urlConnection=(HttpURLConnection)url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);
                 int data=reader.read();
                 while(data!=-1){
                     char current=(char)data;
                     result+=current;
                     data=reader.read();
                 }
                 return result;
            }catch (Exception e) {
                e.printStackTrace();

                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "could not load :(", Toast.LENGTH_LONG).show();
                    }
                });

                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Log.i("JSON",s);
            try {
                JSONObject jsonObject=new JSONObject(s);
                String weatherinfo=jsonObject.getString("weather");
                //Log.i("weatgerinfo",weatherinfo);
                String message="";
                JSONArray arr=new JSONArray(weatherinfo);
                for(int i=0;i<arr.length();i++){
                    JSONObject jsonpart=arr.getJSONObject(i);
//                    Log.i("main",jsonpart.getString("main"));
//                    Log.i("main",jsonpart.getString("description"));
                    String main=jsonpart.getString("main");
                    String description=jsonpart.getString("description");

                    if(!main.equals("")&&!description.equals("")){
                        message+=main+": "+description+"\r\n";
                    }
                }
                if(!message.equals("")){
                    t1.setText(message);
                }else {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(getApplicationContext(), "could not load :(", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            } catch (Exception e) {

                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(getApplicationContext(), "could not load :(", Toast.LENGTH_LONG).show();
                    }
                });

                e.printStackTrace();
            }

        }
    }
    public void getweather(View view){

        DownloadTask task=new DownloadTask();
        try {
            String encodedCityName = URLEncoder.encode(e1.getText().toString(), "UTF-8");
            task.execute("https://openweathermap.org/data/2.5/weather?q=" + encodedCityName + "&appid=439d4b804bc8187953eb36d2a8c26a02");
            InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(e1.getWindowToken(), 0);
        }catch (Exception e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(getApplicationContext(), "could not load :(", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        t1=(TextView)findViewById(R.id.textView3);
    }
}
