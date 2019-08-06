package com.example.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //创建SensorManager对象
    private SensorManager sensorManager;

    //加速度传感器
    TextView tvaccelerometer_x;
    TextView tvaccelerometer_y;
    TextView tvaccelerometer_z;

    //距离传感器
    TextView tvproximity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvaccelerometer_x = findViewById(R.id.accelerometer_x);
        tvaccelerometer_y = findViewById(R.id.accelerometer_y);
        tvaccelerometer_z = findViewById(R.id.accelerometer_z);

        tvproximity = findViewById(R.id.proximity);


        //获取系统服务
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //      注册事件
        //      * 参数1 ：SensorEventListener监听器
        //      * 参数2 ：Sensor 一个服务可能有多个Sensor实现，此处调用getDefaultSensor获取默认的Sensor
        //      * 参数3 ：模式 可选数据变化的刷新频率，多少微秒取一次。

        //      为加速度传感器监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

        //      为距离传感器监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //加速度传感器
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            tvaccelerometer_x.setText("X轴加速度：" + x);
            tvaccelerometer_y.setText("Y轴加速度：" + y);
            tvaccelerometer_z.setText("Z轴加速度：" + z);
        }

        //距离传感器
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            float X = event.values[0];
            tvproximity.setText("距离为:" + X);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
