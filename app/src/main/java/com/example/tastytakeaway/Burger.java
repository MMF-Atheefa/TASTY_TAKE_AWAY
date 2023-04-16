package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Burger extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.burger);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

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


