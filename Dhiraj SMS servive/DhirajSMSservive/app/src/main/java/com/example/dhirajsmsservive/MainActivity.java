package com.example.dhirajsmsservive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView lblnumber,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblnumber=(TextView)findViewById(R.id.lbl_number);
        message=(TextView)findViewById(R.id.lbl_message);
        Bundle b= getIntent().getBundleExtra("data");
        if(b!=null)
        {
            String number=b.getString("number");
            String content=b.getString("content");
            lblnumber.setText(number);
            message.setText(content);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
   //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}