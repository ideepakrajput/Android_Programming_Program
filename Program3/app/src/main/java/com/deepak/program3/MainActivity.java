package com.deepak.program3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.login);
        EditText enterUsername = findViewById(R.id.enterUsername);
        EditText enterPassword = findViewById(R.id.enterPassword);
        TextView message = findViewById(R.id.message);


        
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = "deepakrajput";
                String username2 = "deepak@123";
                String password1 = "Deepak@9560";
                String password2 = "Deepak@123";
                CharSequence usernameGet= enterUsername.getText();
                CharSequence passwordGet = enterPassword.getText();

                if (username1.contentEquals(usernameGet) && password1.contentEquals(passwordGet) || username2.contentEquals(usernameGet) && password2.contentEquals(passwordGet) ){
                    message.setText("!!! Congratulations, Login Successful !!!");
                    message.setTextColor(Color.GREEN);
                    message.setTextSize(20);

                }
                else{
                    message.setText("!!! Sorry, Credentials doesn't match !!!");
                    message.setTextColor(Color.RED);
                    message.setTextSize(20);
                }


            }
        });
    }
}