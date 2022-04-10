package com.example.textcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Output extends AppCompatActivity {
    int firstSlog;
    int secondSlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        Intent intent = getIntent();
        firstSlog = intent.getIntExtra("first", firstSlog);
        secondSlog = intent.getIntExtra("second", secondSlog);
        TextView mainView = findViewById(R.id.answer);
        if (secondSlog<0){
            mainView.setText(firstSlog + " + " +"("+ secondSlog + ")" + " = " + (firstSlog+secondSlog));
        }
        else{
            mainView.setText(firstSlog + " + " + secondSlog + " = " + (firstSlog+secondSlog));
        }
    }
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        TextView mainView = findViewById(R.id.answer);
        outState.putString("mainText", String.valueOf(mainView.getText()));
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("mainText")) {
            int[] numbers = savedInstanceState.getIntArray("numbers");

        }
    }
}