package com.example.textcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int first = 0;
    public int second = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstSlogInput = (EditText) findViewById(R.id.firstSlogInput);
        EditText secondSlogInput = (EditText) findViewById(R.id.secondSlogInput);
        firstSlogInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    firstSlogInput.setText("");
                }
            }
        });
        secondSlogInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    secondSlogInput.setText("");
                }
            }
        });
    }

    public void add(View view){
        TextView firstSlog = findViewById(R.id.firstSlogInput);
        TextView secondSlog = findViewById(R.id.secondSlogInput);
        try {
            first = Integer.parseInt(String.valueOf(firstSlog.getText()));
            second = Integer.parseInt(String.valueOf(secondSlog.getText()));
            Intent intent = new Intent(this, Output.class);
            intent.putExtra("first", first);
            intent.putExtra("second",second);
            startActivity(intent);
        }
        catch (Exception ex){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Ошибка");
            builder.setMessage("Неверные входные данные, введите еще раз");
            builder.setPositiveButton("Ок", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }


    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putIntArray("numbers", new int[] {first, second});
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("numbers")) {
            int[] numbers = savedInstanceState.getIntArray("numbers");
            first = numbers[0];
            second = numbers[1];
            if (!(first == 0 && second == 0)){
                resetUI();
            }

        }
    }
    protected void resetUI(){
        TextView leftScore = findViewById(R.id.firstSlogInput);
        leftScore.setText(String.valueOf(first));
        TextView rightScore = findViewById(R.id.secondSlogInput);
        rightScore.setText(String.valueOf(second));
    }
}