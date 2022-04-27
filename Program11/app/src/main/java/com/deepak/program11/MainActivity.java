package com.deepak.program11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userEdit;
    EditText passEdit;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEdit = findViewById(R.id.userEdit);
        passEdit = findViewById(R.id.passEdit);
        login = findViewById(R.id.login);

        String username = "deepakrajput";
        String password = "Deepak@9560";

        login.setOnClickListener(view -> {
            String getuser = userEdit.getText().toString();
            String getpass = passEdit.getText().toString();
            if (username.contentEquals(getuser) && password.contentEquals(getpass)) {
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                intent.putExtra("data", getuser);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "!!! Sorry, Login Unsuccessful!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}