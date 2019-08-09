package com.example.advancedskills;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//                long triggerAtTime = SystemClock.elapsedRealtime()+10*1000;
//                manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,);



                Person person = new Person("小邋遢", false);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("p_data", person);
                startActivity(intent);

            }
        });


    }
}
