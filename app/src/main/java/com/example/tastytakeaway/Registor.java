package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Registor extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registor);

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName()
                + "/" + R.raw.video);
        videoView.start();


        button = findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {
            @Override    public void onClick(View view) {
                opengo();
            }});


    }
    public void opengo(){
        Intent intent=new Intent(this, Dashboard.class);
        startActivity(intent);



    }
}