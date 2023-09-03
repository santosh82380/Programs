package com.example.dhirajspeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextToSpeech t1;
    EditText input;
    Button speech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.txt_input);
        speech = findViewById(R.id.btn_txt2spch);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
        speech.setOnClickListener(this);}
            @Override
            public void onClick(View view) {
                String tospeak = input.getText().toString();
                Toast.makeText(getBaseContext(),tospeak,Toast.LENGTH_SHORT).show();
                t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH, null);
            }


}