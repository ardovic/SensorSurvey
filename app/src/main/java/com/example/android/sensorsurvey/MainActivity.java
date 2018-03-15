package com.example.android.sensorsurvey;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * SensorSurvey queries the sensor manager for a list of available
 * sensors, and displays the list in a TextView.
 */
public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;

    private Sensor mSensorProximity;
    private Sensor mSensorLight;

    //@BindView(R.id.sensor_list) TextView list;
    //@BindView(R.id.sensor_proximity) TextView proximity;
    //@BindView(R.id.sensor_light) TextView light;


    @Override
    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mSensorProximity != null) {
            mSensorManager.registerListener(this, mSensorLight, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if(mSensorLight != null) {
            mSensorManager.registerListener(this, mSensorProximity, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife.bind(this);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);



        mSensorProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensorText = new StringBuilder();

        for (Sensor sensor : sensorList) {
            sensorText.append(sensor.getName());
            sensorText.append(System.getProperty("line.separator"));
        }

        ((TextView)findViewById(R.id.sensor_list)).setText(sensorText.toString());

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();

        switch (sensorType) {
            case Sensor.TYPE_PROXIMITY:
                float currentProximityValue = event.values[0];
                String textProximity = String.format(getString(R.string.value_format), currentProximityValue);
                ((TextView)findViewById(R.id.sensor_proximity)).setText(textProximity);
                break;
            case Sensor.TYPE_LIGHT:
                float currentLightValue = event.values[0];
                String textLight = String.format(getString(R.string.value_format), currentLightValue);
                ((TextView)findViewById(R.id.sensor_light)).setText(textLight);
                break;
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
