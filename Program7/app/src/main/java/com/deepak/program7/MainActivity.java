package com.deepak.program7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout constraint =findViewById(R.id.constraint);

        Button redButton = findViewById(R.id.redButton);
        Button grayButton = findViewById(R.id.grayButton);
        Button greenButton = findViewById(R.id.greenButton);

        redButton.setOnClickListener(view -> constraint.setBackgroundResource(R.color.red));

        grayButton.setOnClickListener(view -> constraint.setBackgroundResource(R.color.gray));

        greenButton.setOnClickListener(view -> constraint.setBackgroundResource(R.color.green));
    }
}