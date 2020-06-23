package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            SQLiteDatabase myDatabase=this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,age INT(3))");

            myDatabase.execSQL("INSERT INTO users VALUES('SNEHA',30)");
            myDatabase.execSQL("INSERT INTO users VALUES('SNEHA1',40)");
            myDatabase.execSQL("INSERT INTO users VALUES('SNEHA2',40)");

            Cursor c=myDatabase.rawQuery("SELECT * FROM users WHERE age > 35 AND name='SNEHA1'",null);

            int nameIndex=c.getColumnIndex("name");
            int ageIndex=c.getColumnIndex("age");

            c.moveToFirst();

            while(c!=null){
                Log.i("name",c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
