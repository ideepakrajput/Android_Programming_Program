package com.deepak.program11;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Second_Activity extends AppCompatActivity {
    TextView welcome;
    Button logout;
    String user;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcome = findViewById(R.id.welcome);
        logout = findViewById(R.id.logout);

        Intent intent = getIntent();
        user = intent.getStringExtra("data");

        welcome.setText("Welcome "+ user);

        logout.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(Second_Activity.this);
            builder.setTitle("Log Out");
            builder.setMessage("Are you sure you want to exit?");
            Toast.makeText(Second_Activity.this, "Clicked", Toast.LENGTH_SHORT).show();
            builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                Intent intent1 = new Intent(Second_Activity.this, MainActivity.class);
                startActivity(intent1);
            });
            builder.setNegativeButton("No", (dialogInterface, i) -> {
                Intent intent12 = new Intent(Second_Activity.this, Second_Activity.class);
                startActivity(intent12);
            });
            AlertDialog alert = builder.create();
            alert.show();
        });
    }
}