package com.deepak.program10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button send = findViewById(R.id.send);
        EditText inputText = findViewById(R.id.inputText);

        send.setOnClickListener(view -> {
            String msg = inputText.getText().toString();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,msg);
            intent.setType("text/plain");
            startActivity(intent);
        });

    }
}