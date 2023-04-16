package com.example.tastytakeaway;

import static com.example.tastytakeaway.R.id.button22;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pizza extends AppCompatActivity {

    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza);
        button = findViewById(button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openorder(); }});


    }public void openorder(){
        Intent intent=new Intent(this, Sensor.class);
        startActivity(intent);}
}
