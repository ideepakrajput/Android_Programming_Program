package com.deepak.program14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button startS,stopS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startS = findViewById(R.id.startS);
        stopS = findViewById(R.id.stopS);

        startS.setOnClickListener(view -> {
            Intent intent = new Intent(this,MyService.class);
            startService(intent);
        });

        stopS.setOnClickListener(view -> {
            Intent intent = new Intent(this,MyService.class);
            stopService(intent);
        });
    }
}