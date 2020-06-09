package com.example.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean img1isshowing=true;
    public void fade(View view){
        ImageView img1=(ImageView)findViewById(R.id.imageView);

        ImageView img2=(ImageView)findViewById(R.id.imageView2);

        if(img1isshowing) {
            img1isshowing=false;
            img1.animate().alpha(0).setDuration(2000);
            img2.animate().alpha(1).setDuration(2000);
        }
        else{
            img1.animate().alpha(1).setDuration(2000);
            img2.animate().alpha(0).setDuration(2000);
            img1isshowing=true;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img1=(ImageView)findViewById(R.id.imageView);
        img1.setX(-1000);
        img1.animate().translationXBy(1000).rotation(3600).setDuration(2000);
    }
}
