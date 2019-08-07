package com.example.sensor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //创建SensorManager对象
    private SensorManager sensorManager;

    //加速度传感器
    TextView tvaccelerometer_x;
    TextView tvaccelerometer_y;
    TextView tvaccelerometer_z;

    //距离传感器
    TextView tvproximity;

    //方向传感器
    TextView orientation_x;
    TextView orientation_y;
    TextView orientation_z;

    //陀螺仪传感器
    TextView gyroscope_x;
    TextView gyroscope_y;
    TextView gyroscope_z;

    //线性加速度传感器
    TextView linearacceleration_x;
    TextView linearacceleration_y;
    TextView linearacceleration_z;

    //光传感器
    TextView light;

    //压强传感器
    TextView pressure;

    //计步传感器
    TextView step_counter;
    TextView step_detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvaccelerometer_x = findViewById(R.id.accelerometer_x);
        tvaccelerometer_y = findViewById(R.id.accelerometer_y);
        tvaccelerometer_z = findViewById(R.id.accelerometer_z);

        tvproximity = findViewById(R.id.proximity);

        orientation_x = findViewById(R.id.orientation_x);
        orientation_y = findViewById(R.id.orientation_y);
        orientation_z = findViewById(R.id.orientation_z);

        gyroscope_x = findViewById(R.id.gyroscope_x);
        gyroscope_y = findViewById(R.id.gyroscope_y);
        gyroscope_z = findViewById(R.id.gyroscope_z);

        linearacceleration_x = findViewById(R.id.linearacceleration_x);
        linearacceleration_y = findViewById(R.id.linearacceleration_y);
        linearacceleration_z = findViewById(R.id.linearacceleration_z);

        light = findViewById(R.id.light);

        pressure = findViewById(R.id.pressure);

        step_counter = findViewById(R.id.step_counter);
        step_detector = findViewById(R.id.step_detector);


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

        //      为方向传感器监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_NORMAL);

        //      为陀螺仪传感器监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
                SensorManager.SENSOR_DELAY_NORMAL);

        //      为线性加速度传感器监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
                SensorManager.SENSOR_DELAY_NORMAL);

        //      为光传感器监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_NORMAL);

        //      为压强传感器监听器
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE),
                SensorManager.SENSOR_DELAY_NORMAL);

        //      为计步传感器监听器
        //      计步器（记录历史步数累加值）
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER),
                SensorManager.SENSOR_DELAY_NORMAL);
        //      检测器（检测每次步伐数据）
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR),
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
            float x = event.values[0];
            tvproximity.setText("距离为:" + x);
        }

        //方向传感器
        if (event.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            orientation_x.setText("X轴转过的角度：" + x);
            orientation_y.setText("Y轴转过的角度：" + y);
            orientation_z.setText("Z轴转过的角度：" + z);
        }

        //陀螺仪传感器
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            //将弧度传化成角度
            x = (float) Math.toDegrees(x);
            y = (float) Math.toDegrees(y);
            z = (float) Math.toDegrees(z);
            gyroscope_x.setText("X轴角速度：" + x);
            gyroscope_y.setText("Y轴角速度：" + y);
            gyroscope_z.setText("Z轴角速度：" + z);
        }

        //线性加速度传感器
        if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            linearacceleration_x.setText("X轴加速度：" + x);
            linearacceleration_y.setText("Y轴加速度：" + y);
            linearacceleration_z.setText("Z轴加速度：" + z);
        }

        //光传感器
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float x = event.values[0];
            light.setText("光强为:" + x);
        }

        //压强传感器
        if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {
            float x = event.values[0];
            pressure.setText("压强为:" + x + "hPa");
        }

        //计步传感器
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            float x = event.values[0];
            step_counter.setText("总步数为:" + x);
        }
        if (event.sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            float x = event.values[0];
            step_detector.setText("步数是否有效:" + x);
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
