package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {
    private Button button;


    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        button = findViewById(R.id.started_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openorder(); }});

    }

    public void openorder(){
        Intent intent=new Intent(this, Login.class);
        startActivity(intent);}

}