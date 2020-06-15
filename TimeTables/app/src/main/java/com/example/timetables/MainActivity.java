package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimeTable(int timestablenumber){
        ArrayList<String> timeTableContent=new ArrayList<String>();
        for(int j=1;j<=10;j++){
            timeTableContent.add(Integer.toString(j*timestablenumber));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,timeTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timesTablesSeekBar=(SeekBar)findViewById(R.id.timesTablesSeekBar);
        timesTablesListView =(ListView)findViewById(R.id.myListView);

        timesTablesSeekBar.setMax(20);
        timesTablesSeekBar.setProgress(10);

        generateTimeTable(10);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                int min=1;
                int timestablenumber;
                if(i<min)
                {
                    timestablenumber=min;
                }
                else
                {
                    timestablenumber=i;
                }
                generateTimeTable(timestablenumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
