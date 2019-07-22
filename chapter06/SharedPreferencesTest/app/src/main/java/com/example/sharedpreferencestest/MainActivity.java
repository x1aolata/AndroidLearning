package com.example.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","x1aolata");
                editor.putBoolean("married",false);
                editor.putInt("age",28);
                editor.apply();
            }
        });

        Button get= findViewById(R.id.get);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","");
                int age=pref.getInt("age",0);
                boolean married= pref.getBoolean("married",true);
                TextView textView =findViewById(R.id.textView);
                textView.setText("name:  "+name+"\nage:  "+String.valueOf(age)+"\nmarried:  "+String.valueOf(married));

            }
        });
    }
}
