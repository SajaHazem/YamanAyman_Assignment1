package com.example.kudos.yamanayman_assignment1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText EnterNumber;
    TextView approximation;
    Random random = new Random();
    int randomNumber = random.nextInt(1000-0);//generate a random number which the user will guess through the game
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button comparebutton = (Button)findViewById(R.id.comapre);
        Button RestartButton = (Button) findViewById(R.id.Restart);
        comparebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//as action listner in java that when this button pressed it will do the following:
                EnterNumber =(EditText) findViewById(R.id.EnterNumber);
                int guessedone = Integer.parseInt(EnterNumber.getText().toString());//get the number user enter to check if it is true or not
                approximation = (TextView)findViewById(R.id.approximation);
                if(randomNumber > guessedone){//compare guessed number with random number program take
                    approximation.setText("Smaller");
                    if(randomNumber - 5 < guessedone  && guessedone < randomNumber + 5){

                        Context c = getApplicationContext();
                        String veryclose = "very close!!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast tost = Toast.makeText(c, veryclose, duration);
                        tost.show();

                    }
                }
                else if(randomNumber < guessedone){
                    approximation.setText("Greater");
                    if(randomNumber- 5 < guessedone  && guessedone < randomNumber + 5){//this is to print toast message that if the input from user was very close it will notify

                        Context c = getApplicationContext();
                        String veryclose = "very close!!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast tost = Toast.makeText(c, veryclose, duration);
                        tost.show();

                    }

                }
                if(randomNumber == guessedone){
                    approximation.setText("right!!");
                }

            }
        });
//this will operate when Restart button pressed so the game will start again to play new one
        RestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = random.nextInt(1000-0);
                approximation.setText("");
                approximation.setText("");
            }
        });

    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
