package com.example.memorableplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    static ArrayList<String> places=new ArrayList<String>();;
    static ArrayList<LatLng> locations=new ArrayList<LatLng>();

    static ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView=findViewById(R.id.listview);




        locations.add(new LatLng(0,0));

        places.add("Add a new place ...");

        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this,Integer.toString(position), LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("placeno",position);
                startActivity(intent);
            }
        });
    }
}
