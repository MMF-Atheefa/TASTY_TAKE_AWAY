package com.example.tastytakeaway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.widget.TextView;

public class Sensor extends AppCompatActivity implements SensorEventListener {


    private TextView textView;
    private SensorManager sensorManager;

    private android.hardware.Sensor tempSensor;

    private Boolean isTemperatureSensorAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        textView = findViewById(R.id.textView9);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            tempSensor = sensorManager.getDefaultSensor(android.hardware.Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTemperatureSensorAvailable = true;
        }
        else

        {
            textView.setText("Temperature is Available");
            isTemperatureSensorAvailable = false;

        }}



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText(sensorEvent.values [0]+"°C");
    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        if(isTemperatureSensorAvailable){
            sensorManager.registerListener(this,tempSensor,SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isTemperatureSensorAvailable){
            sensorManager.unregisterListener(this );
        }
    }



}