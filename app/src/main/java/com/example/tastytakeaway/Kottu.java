package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Kottu extends AppCompatActivity implements View.OnClickListener {
    Button button,button1,button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kottu);
        button = findViewById(R.id.button3);
        button1 = findViewById(R.id.button17);
        button2 = findViewById(R.id.button19);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button3:
                button.setText("BUY");
                Intent intent=new Intent(this, Payment.class);
                startActivity(intent);
                break;
            case R.id.button17:
                button.setText ("Buy");
                Intent intent1=new Intent(this, Payment.class);
                startActivity(intent1);
                break;
            case R.id.button19:
                button.setText("Buy.");
                Intent intent2=new Intent(this, Payment.class);
                startActivity(intent2);
                break;

        }

    }
}