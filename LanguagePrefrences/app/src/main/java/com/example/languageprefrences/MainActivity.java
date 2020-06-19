package com.example.languageprefrences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView t1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.english:
                setLanguage("English");
                return true;
            case R.id.spanish:
                setLanguage("Spanish");
                return true;
            default:
                return false;
        }

    }

    public void setLanguage(String language){

        sharedPreferences.edit().putString("lang",language).apply();

        t1.setText(language);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=this.getSharedPreferences("com.example.languageprefrences", Context.MODE_PRIVATE);

        String language;

        language=sharedPreferences.getString("lang","Error");

        t1=(TextView)findViewById(R.id.textview);
         if(language.equals("Error")){
             new AlertDialog.Builder(this)
                     .setIcon(android.R.drawable.ic_btn_speak_now)
                     .setTitle("Choose a Language")
                     .setMessage("Which language would you like to use ?")
                     .setPositiveButton("English", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             //set English
                             setLanguage("English");
                         }
                     })
                     .setNegativeButton("Spanish", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             //setSpanish
                             setLanguage("Spanish");
                         }
                     })
                     .show();
         }
        else{
            t1.setText(language);
         }

    }
}
