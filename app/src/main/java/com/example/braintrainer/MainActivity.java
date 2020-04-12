package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button goButton;
ArrayList<Integer> answers=new ArrayList<Integer>();
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playagain;
    TextView sumTextView;
    TextView timertext;
    int locationOfCorrectAnswer;
    TextView result;
    TextView scoreView;
    int score=0;
    int numberOfQuestions=0;
    ConstraintLayout gamelayout;
    public void start(View view)
{

    goButton.setVisibility(View.INVISIBLE);
    gamelayout.setVisibility(View.VISIBLE);
    playAgain(findViewById(R.id.timertextView));


}
public void newQuestion(){
    Random rand=new Random();
    int a=rand.nextInt(21);
    int b=rand.nextInt(21);
    sumTextView=findViewById(R.id.sumtextView);
    sumTextView.setText(Integer.toString(a)+ "+" + Integer.toString(b));
    locationOfCorrectAnswer =rand.nextInt(4);
    answers.clear();
    for(int i=0;i<4;i++)
    {
        if(i==locationOfCorrectAnswer)
            answers.add(a+b);
        else{
            int wrongAnswer=rand.nextInt(41);
            while(wrongAnswer==a+b){
                wrongAnswer=(rand.nextInt(41));
            }
            answers.add(wrongAnswer);
        }
    }
    button0.setText(Integer.toString(answers.get(0)));
    button1.setText(Integer.toString(answers.get(1)));
    button2.setText(Integer.toString(answers.get(2)));
    button3.setText(Integer.toString(answers.get(3)));

}
public void chooseAnswer(View view)
{
    if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString()))
    {
        Log.i("Correct!","You Got It!");
        result.setText("Correct!");
        result.setVisibility(View.VISIBLE);
        score++;
    }
    else {
        Log.i("Wrong","Aww, Sad");
        result.setText("Wrong!");
        result.setVisibility(View.VISIBLE);
    }
    numberOfQuestions++;
    scoreView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
    newQuestion();
}
public void playAgain(View view){
    playagain.setVisibility(View.INVISIBLE);
    result.setVisibility(View.INVISIBLE);
    score=0;
numberOfQuestions=0;
timertext.setText("30s");
scoreView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));

    newQuestion();

    new CountDownTimer(30100,1000){

        @Override
        public void onTick(long millisUntilFinished) {
            timertext.setText(String.valueOf(millisUntilFinished/1000 + "s"));
        }

        @Override
        public void onFinish() {
            result.setVisibility(View.VISIBLE);
            result.setText("Done");
            playagain.setVisibility(View.VISIBLE);
        }
    }.start();


}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button0=findViewById(R.id.button1);
         button1=findViewById(R.id.button2);
         button2=findViewById(R.id.button3);
         button3=findViewById(R.id.button4);
        goButton=findViewById(R.id.button);
        timertext=findViewById(R.id.timertextView);
        result=findViewById(R.id.resulttextView);
        scoreView=findViewById(R.id.scoretextView);
        playagain=findViewById(R.id.playAgain);
        gamelayout=findViewById(R.id.gamelayout);
        goButton.setVisibility(View.VISIBLE);
        gamelayout.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
          }
}
