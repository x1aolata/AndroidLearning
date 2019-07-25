package com.example.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String id = "channel_1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:

                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);



                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this, id)
                        // 必要的
                        .setContentTitle("我想要")
                        .setContentText("力量的代价")
                        // 小图标
                        .setSmallIcon(R.mipmap.ic_launcher)
                        // 大图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_horn))
                        // 时间
                        .setWhen(System.currentTimeMillis())

                        // 跳转的活动或其他
                        .setContentIntent(pi)

                        .setAutoCancel(true)

                        // 声音、震动、LED灯
                        //        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                        //        .setVibrate(new long[]{0, 1000, 1000, 1000})
                        //        .setLights(Color.GREEN, 1000, 1000)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)



                        // 长文字
                        //.setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))


                        // 大图
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.bing)))


                        // 优先级
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}
