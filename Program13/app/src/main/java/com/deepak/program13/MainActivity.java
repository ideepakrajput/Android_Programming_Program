package com.deepak.program13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText titleN,textN;
    Button createN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleN = findViewById(R.id.titleN);
        textN = findViewById(R.id.textN);
        createN = findViewById(R.id.createN);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        createN.setOnClickListener(view -> {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
            String titleGet = titleN.getText().toString();
            String textGet = textN.getText().toString();
            builder.setContentTitle(titleGet);
            builder.setContentText(textGet);
            builder.setSmallIcon(R.drawable.ic_launcher_background);
            builder.setAutoCancel(true);

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
            managerCompat.notify(1,builder.build());

        });
    }
}
