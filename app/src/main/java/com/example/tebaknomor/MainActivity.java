package com.example.tebaknomor;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void randomNumberGenerator() //for repeating the game
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;
    }
    public void onGuess(View view) throws IOException
    {
        try {
            String message;
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());
            if(guessedNumber < randomNumber)
                message="Lebih Tinggi !!";
            else if(guessedNumber > randomNumber)
                message="Lebih Rendah !!";
            else
            {
                message="Nah Betul !!";
                randomNumberGenerator();    //kinda recurtion !
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        catch (Exception e){
            System.out.println("Only numbers!!!");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;    //limit upto 20 from 1
    }

}