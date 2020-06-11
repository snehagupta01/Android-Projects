package com.example.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer media;
    AudioManager audioManager;


    public void play(View view){
         media.start();
    }
    public void pause(View view){
        media.pause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media=MediaPlayer.create(this,R.raw.s1);

        audioManager=(AudioManager) getSystemService(AUDIO_SERVICE);

        int maxvolume= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        int currvolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar vol=(SeekBar)findViewById(R.id.volumeseekBar);

        vol.setMax(maxvolume);
        vol.setProgress(currvolume);
        vol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
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
