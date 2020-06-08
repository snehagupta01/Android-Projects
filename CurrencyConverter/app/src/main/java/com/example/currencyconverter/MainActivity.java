package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convert(View view){
        Log.i("info","button pressed");
        EditText e1=(EditText)findViewById(R.id.editText);
        String s1=e1.getText().toString();
        if(s1.isEmpty())
        {
            Toast.makeText(this, "Please enter the amount", Toast.LENGTH_LONG).show();
            return;
        }
        double amtindollars=Double.parseDouble(s1);
        double amtininr=amtindollars*76.33;
        String res=String.format("%.2f",amtininr);
        Toast.makeText(this, amtindollars +"$ = INR "+res, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
