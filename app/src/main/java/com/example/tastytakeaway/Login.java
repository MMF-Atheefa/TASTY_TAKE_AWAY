package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button signupButton, loginButton;
    EditText username, password;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signupButton = findViewById(R.id.signup_button);
        loginButton = findViewById(R.id.login_button);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        DB = new DBHelper(this);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensignup();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });
    }

    public void opensignup() {
        Intent intent = new Intent(this, Registor.class);
        startActivity(intent);
    }

    public void openlogin() {
        String usernames = username.getText().toString();
        String passwords = password.getText().toString();

        if (usernames.equals("") || passwords.equals(""))
            Toast.makeText(Login.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
        else {
            Boolean checkuserpasswords = DB.checkusernamepassword(usernames, passwords);
            if (checkuserpasswords == true) {
                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, Dashboard.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }
}