package com.example.appeggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView timerTextView;
    SeekBar timerSeekBar;
    boolean counterisactive=false;
    Button gobutton;
    CountDownTimer countDownTimer;

    public void buttonclicked(View view){
    //Log.i("b","b");


        if(counterisactive){
            timerTextView.setText("00:30");
            timerSeekBar.setProgress(30);
            timerSeekBar.setEnabled(true);
            countDownTimer.cancel();
            gobutton.setText("GO");
            counterisactive=false;
        }
        else{
            counterisactive=true;
            timerSeekBar.setEnabled(false);
            gobutton.setText("STOP");
        countDownTimer=new CountDownTimer(timerSeekBar.getProgress()*1000+100,100){

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
            //Log.i("finsihed","finished");
                MediaPlayer mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                mediaPlayer.start();
                timerTextView.setText("00:30");
                timerSeekBar.setProgress(30);
                timerSeekBar.setEnabled(true);
                countDownTimer.cancel();
                gobutton.setText("GO");
                counterisactive=false;
            }
        }.start();
        }
    }
    public void updateTimer(int secondsleft){
        int minutes=secondsleft/60;
        int seconds=secondsleft-(minutes*60);

        String secondString=Integer.toString(seconds);
        if(seconds<=9){
            secondString="0"+secondString;
        }
        timerTextView.setText(Integer.toString(minutes)+":"+secondString);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar=(SeekBar)findViewById(R.id.timerSeekBar);
        timerTextView=(TextView)findViewById(R.id.countdownTextView);
        gobutton=(Button)findViewById(R.id.goButton);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                updateTimer(i);

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
