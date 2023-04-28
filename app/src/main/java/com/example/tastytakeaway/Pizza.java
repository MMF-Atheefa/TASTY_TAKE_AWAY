package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pizza extends AppCompatActivity implements View.OnClickListener {
    Button button,button1,button2,button3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);
        button = findViewById(R.id.button2);
        button1 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        button3 = findViewById(R.id.button22);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                button.setText("BUY");
                Intent intent=new Intent(this, Payment.class);
                startActivity(intent);
                break;
            case R.id.button3:
                button.setText ("Buy");
                Intent intent1=new Intent(this, Payment.class);
                startActivity(intent1);
                break;
            case R.id.button4:
                button.setText("Buy.");
                Intent intent2=new Intent(this, Payment.class);
                startActivity(intent2);
                break;

            case R.id.button22:
                button.setText("Buy");
                Intent intent22=new Intent(this, Sensor.class);
                startActivity(intent22);
                break;

        }

    }
}