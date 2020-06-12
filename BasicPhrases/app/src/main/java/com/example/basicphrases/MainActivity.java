package com.example.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void playphrase(View view){
        Button buttonpressed=(Button)view;
        MediaPlayer mp=MediaPlayer.create(this,getResources().getIdentifier(buttonpressed.getTag().toString(),"raw",getPackageName()));
        mp.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
