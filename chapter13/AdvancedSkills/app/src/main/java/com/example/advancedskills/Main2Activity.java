package com.example.advancedskills;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Person person = (Person) getIntent().getSerializableExtra("p_data");
        Toast.makeText(Main2Activity.this, person.getName(), Toast.LENGTH_SHORT).show();


    }
}
