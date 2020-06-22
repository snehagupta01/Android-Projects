package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    TextView sumTextView,timerTextView;
    TextView resultView,scoreView;
    ConstraintLayout gamelayout;
    Button b0,b1,b2,b3,playagain;
    androidx.gridlayout.widget.GridLayout gridLayout;

    ArrayList<Integer> answers=new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score=0;
    int noofquestion=0;
    public void playAgain(View view){
        score=0;
        noofquestion=0;
        timerTextView.setText("30s");
        scoreView.setText(Integer.toString(score)+"/"+Integer.toString(noofquestion));
        playagain.setVisibility(View.INVISIBLE);
        gridLayout.setVisibility(View.VISIBLE);
        resultView.setText("");
        newquestion();
        new CountDownTimer(30100,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }
            @Override
            public void onFinish() {
                resultView.setText("Done");
                playagain.setVisibility(View.VISIBLE);
               gridLayout.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
    public void chooseAnswer(View view){
        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
            //Log.i("nn","correct");
            resultView.setText("Correct");
            score++;
        }
        else{
           // Log.i("nn","wrong");
            resultView.setText("Inorrect");
        }
        noofquestion++;
        //Log.i("nn",view.getTag().toString());
        scoreView.setText(Integer.toString(score)+"/"+Integer.toString(noofquestion));
        newquestion();
    }
    public void newquestion(){
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);
        answers.clear();
        for(int i=0;i<4;i++){
            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            }
            else
            {
                int wronganswer=rand.nextInt(41);
                while(wronganswer == (a+b)){
                    wronganswer=rand.nextInt(41);
                }
                answers.add(wronganswer);
            }
        }
        b0.setText(Integer.toString(answers.get(0)));
        b1.setText(Integer.toString(answers.get(1)));
        b2.setText(Integer.toString(answers.get(2)));
        b3.setText(Integer.toString(answers.get(3)));
    }
    public void begin(View view){
        goButton.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(View.VISIBLE);
        playAgain(timerTextView);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=(Button)findViewById(R.id.button);
        sumTextView=(TextView)findViewById(R.id.sumTextView);
        resultView=(TextView)findViewById(R.id.resultTextView);
        scoreView=(TextView)findViewById(R.id.scoreTextView);
        timerTextView=(TextView)findViewById(R.id.timerTextView);
        playagain=(Button)findViewById(R.id.button5);

        gridLayout = findViewById(R.id.gridLayout);

        gamelayout=findViewById(R.id.gamelayout);

        gamelayout.setVisibility(View.INVISIBLE);

        b0=(Button)findViewById(R.id.button1);
        b1=(Button)findViewById(R.id.button2);
        b2=(Button)findViewById(R.id.button3);
        b3=(Button)findViewById(R.id.button4);

        goButton.setVisibility(View.VISIBLE);


    }
}
