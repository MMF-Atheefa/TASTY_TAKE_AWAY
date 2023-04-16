package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Dashboard extends AppCompatActivity implements SensorEventListener {

    private Button button;         //link
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button5;
    private Button button6;         // location
    private Button Map;

    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        button = findViewById(R.id.button8);                                    //link
        button.setOnClickListener(new View.OnClickListener() {                   //link
            @Override  public void onClick(View view) {openorder1(); }});        //link

        button = findViewById(R.id.button6);                                    //link
        button.setOnClickListener(new View.OnClickListener() {                   //link
            @Override  public void onClick(View view) {openorder2(); }});

        button = findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openorder3(); }});      //link

        button = findViewById(R.id.button14);
        button.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openorder4(); }});       //link

        button = findViewById(R.id.button15);
        button.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openorder5(); }});      //link

        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {opendone(); }});   // location


        Map=findViewById(R.id.newmap);
        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,Map.class);
                startActivity(intent);
            }
        });




        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }
    public void openorder1(){                                           //link
        Intent intent=new Intent(this, Burger.class);        //link
        startActivity(intent);}                                          //link

    public void openorder2(){                                           //link
        Intent intent=new Intent(this, Pizza.class);        //link
        startActivity(intent);}


    public void openorder3(){                                           //link
        Intent intent=new Intent(this, Noodles.class);        //link
        startActivity(intent);}

    public void openorder4(){                                           //link
        Intent intent=new Intent(this, Kottu.class);        //link
        startActivity(intent);}

    public void openorder5(){                                           //link
        Intent intent=new Intent(this, Rice.class);        //link
        startActivity(intent);}

    public void opendone(){
        Intent intent=new Intent(Dashboard.this,Location.class);    //location
        startActivity(intent);}



    MediaPlayer mp;
    boolean isRunning = false;
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.values[0] > 51 && isRunning == false) {
            isRunning = true;
            mp = new MediaPlayer();
            mp = MediaPlayer.create(this, R.raw.hotelaudios92077651);
            mp.start();
        }
    } @Override
    public void onAccuracyChanged (Sensor sensor,int accuracy){

    }

    @Override
    protected void onResume () {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause () {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
