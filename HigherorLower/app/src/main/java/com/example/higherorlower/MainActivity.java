package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int n;
    public void generaterandomnumber(){
        Random rand=new Random();
        n=rand.nextInt(20)+1;
    }
    public void guess(View view){
        EditText e1=(EditText)findViewById(R.id.editText);
        int guess=Integer.parseInt((e1.getText().toString()));
        String message;
        if(guess>n)
        {
            message="Try lower value";
        }
        else if(guess<n)
        {
            message="Try higher value";
        }
        else
        {
            message="You got it correct ! Play again";
            generaterandomnumber();
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generaterandomnumber();
//        Random rand=new Random();
//        n=rand.nextInt(20)+1;

    }
}
