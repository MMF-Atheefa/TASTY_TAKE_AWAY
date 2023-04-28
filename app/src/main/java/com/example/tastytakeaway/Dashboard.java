package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Dashboard extends AppCompatActivity implements SensorEventListener  {

    private Button Map;         //link
     Button orderburger,orderpizza,ordernoodles,orderkottu,orderrice;

    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        orderburger = findViewById(R.id.orderburger);                                    //link
        orderburger.setOnClickListener(new View.OnClickListener() {                   //link
            @Override  public void onClick(View view) {openorderburger(); }});        //link

        orderpizza = findViewById(R.id.orderpizza);                                    //link
        orderpizza.setOnClickListener(new View.OnClickListener() {                   //link
            @Override  public void onClick(View view) {openorderpizza(); }});

        ordernoodles = findViewById(R.id.ordernoodles);
        ordernoodles.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openordernoodles(); }});      //link

        orderkottu = findViewById(R.id.orderkottu);
        orderkottu.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openorderkottu(); }});       //link

        orderrice = findViewById(R.id.orderrice);
        orderrice.setOnClickListener(new View.OnClickListener() {
            @Override  public void onClick(View view) {openorderrice(); }});      //link


        Map=findViewById(R.id.donebutton);
        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Dashboard.this,Location.class);    //location
                startActivity(intent);}
        });


        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }
    public void openorderburger(){                                           //link
        Intent intent=new Intent(this, Burger.class);        //link
        startActivity(intent);}                                          //link

    public void openorderpizza(){                                           //link
        Intent intent=new Intent(this, Pizza.class);        //link
        startActivity(intent);}

    public void openordernoodles(){                                           //link
        Intent intent=new Intent(this, Noodles.class);        //link
        startActivity(intent);}

    public void openorderkottu(){                                           //link
        Intent intent=new Intent(this, Kottu.class);        //link
        startActivity(intent);}

    public void openorderrice(){                                           //link
        Intent intent=new Intent(this, Rice.class);        //link
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

    //Back Press Exit
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Dashboard.this);
        alertDialog.setTitle("Confirm Exit");
        alertDialog.setMessage(" \"Are you sure you want to exit?\"");
        alertDialog.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }

}
