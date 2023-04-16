package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Noodles extends AppCompatActivity {

    private Button button;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noodles);
        button = findViewById(R.id.button24);
        button.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openorder(); }});


    }public void openorder(){
        Intent intent=new Intent(this,Map.class);
        startActivity(intent);}

}