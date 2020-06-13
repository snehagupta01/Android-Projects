package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mylistview=findViewById(R.id.myListView);

        final ArrayList<String> familymem=new ArrayList<String>();

        familymem.add("s1");
        familymem.add("s2");
        familymem.add("s3");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,familymem);

        mylistview.setAdapter(arrayAdapter);
    /*
    *   ListView mylistview=findViewById(R.id.myListView);
        final ArrayList<String> familymem=new ArrayList<String>(asList("s1","s2"));
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,familymem);
        mylistview.setAdapter(arrayadapter);
    * */
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("pesron selected",familymem.get(position));
                Toast.makeText(getApplicationContext(),"Hello " + familymem.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }
}
