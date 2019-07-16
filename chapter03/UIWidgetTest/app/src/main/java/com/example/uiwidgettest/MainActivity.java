package com.example.uiwidgettest;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.edit_view);
        final ImageView imageView = findViewById(R.id.image_view);
        final ProgressBar progressBar = findViewById(R.id.progressbar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Hello");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();

//                progressDialog.dismiss();


//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("Warning");
//                dialog.setMessage("nihao");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                });
//                dialog.show();


//                if (progressBar.getVisibility() == View.VISIBLE) {
//                    progressBar.setVisibility(View.INVISIBLE);
//                } else {
//                    progressBar.setVisibility(View.VISIBLE);
//                }


//                if(progressBar.getProgress()==100)
//                {
//                    progressBar.setProgress(0);
//                }
//                progressBar.setProgress(progressBar.getProgress() + 10);


//                imageView.setImageResource(R.drawable.pic_2);


//                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
