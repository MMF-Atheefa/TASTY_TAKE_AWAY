package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    private Button button;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override    public void onClick(View view) {
                opensignup();
            }});

        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override    public void onClick(View view) {
                openlogin();
            }});



    }
    public void opensignup(){
        Intent intent=new Intent(this, Registor.class);
        startActivity(intent);}

    public void openlogin(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);}
}