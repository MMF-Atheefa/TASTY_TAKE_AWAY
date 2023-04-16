package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Registor extends AppCompatActivity {
    Button registerButton;
    EditText username, password , repassword , phoneNumber, email;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registor);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.confirm_password);
        phoneNumber = (EditText) findViewById(R.id.phonenumber);
        email = (EditText) findViewById(R.id.email);
        registerButton = findViewById(R.id.register_button);
        DB = new DBHelper(this);

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName()
                + "/" + R.raw.video);
        videoView.start();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernames = username.getText().toString();
                String passwords = password.getText().toString();
                String repasswords = repassword.getText().toString();
                String phoneNumbers = phoneNumber.getText().toString();
                String emails = email.getText().toString();

                if (usernames.equals("") || passwords.equals("") || repasswords.equals("") || phoneNumbers.equals("") || emails.equals(""))
                    Toast.makeText(Registor.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
                else {
                    if (passwords.equals(repasswords)) {
                        Boolean checkuser = DB.checkusername(usernames);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(usernames, passwords, repasswords, phoneNumbers, emails);
                            if (insert == true) {
                                Toast.makeText(Registor.this, "Registation Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Registor.this, Login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Registor.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(Registor.this, "User Already Exist", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Registor.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}