package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
        ArrayList<String> friends=new ArrayList<String>();
        friends.add("s!");
        friends.add("s2");
        friends.add("s3");
        friends.add("s4");

        try {

            sharedPreferences.edit().putString("frds",ObjectSerializer.serialize(friends)).apply();
            Log.i("frds",ObjectSerializer.serialize(friends));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> newfrds=new ArrayList<>();
        try {
            newfrds=(ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("frds",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("newfrds",newfrds.toString());

//        sharedPreferences.edit().putString("username","sneha").apply();//save
//        String usern=sharedPreferences.getString("username","sg");
//        Log.i("usernameee",usern);
    }
}
