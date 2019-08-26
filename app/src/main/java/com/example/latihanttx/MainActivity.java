package com.example.latihanttx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button terjemah;
    EditText editText;
    TextToSpeech suara;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        terjemah = (Button) findViewById(R.id.btnTerjemah);

        suara = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR){
                    suara.setLanguage(Locale.JAPAN);
                }

            }
        });

        terjemah.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String text = editText.getText().toString();
        Toast.makeText(getApplicationContext(),text, Toast.LENGTH_SHORT).show();
        suara.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }
}
