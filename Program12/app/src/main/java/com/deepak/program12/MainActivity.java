package com.deepak.program12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sendBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBroadcast = findViewById(R.id.sendBroadcast);

        IntentFilter intentFilter = new IntentFilter("com.deepak.program12.SendBroadcast");
        MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(myBroadcastReceiver,intentFilter);


        sendBroadcast.setOnClickListener(view -> {
            Intent intent = new Intent("com.deepak.program12.SendBroadcast");
            intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            sendBroadcast(intent);
        });
    }
}