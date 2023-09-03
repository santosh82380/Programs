package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start,stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button) findViewById(R.id.btn_start);
        stop=(Button) findViewById(R.id.btn_stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        if (v.equals(start)) {
            Intent it = new Intent(this, ServiceClass.class);
            startService(it);
        } else {
            Intent it = new Intent(this, ServiceClass.class);
            stopService(it);
        }
    }


}