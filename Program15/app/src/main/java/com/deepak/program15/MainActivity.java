package com.deepak.program15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {
        EditText rollnoedit,nameedit;
        Button add,update,delete,viewbtn;
        DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rollnoedit = findViewById(R.id.rollnoedit);
        nameedit = findViewById(R.id.nameedit);

        add = findViewById(R.id.add);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        viewbtn = findViewById(R.id.viewbtn);
        
        DB = new DBHelper(this);
        
        add.setOnClickListener(view -> {
            String rollnoG = rollnoedit.getText().toString();
            String nameG = nameedit.getText().toString();
            
            Boolean checkinsertdata = DB.insertuserdata(rollnoG,nameG);
            
            if (checkinsertdata == true){
                Toast.makeText(this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Not Inserted : Roll No Exists", Toast.LENGTH_SHORT).show();
            }
        });
        update.setOnClickListener(view -> {
                    String rollnoG = rollnoedit.getText().toString();
                    String nameG = nameedit.getText().toString();

                    Boolean checkupdatedata = DB.updateuserdata(rollnoG,nameG);

                    if (checkupdatedata == true){
                        Toast.makeText(this, "Entry Updated", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Entry Not Exists", Toast.LENGTH_SHORT).show();
                    }
                });
        delete.setOnClickListener(view -> {
                    String rollnoG = rollnoedit.getText().toString();
                    String nameG = nameedit.getText().toString();

                    Boolean checkdeletedata = DB.deleteuserdata(rollnoG,nameG);

                    if (checkdeletedata == true){
                        Toast.makeText(this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Entry Not Exists", Toast.LENGTH_SHORT).show();
                    }
                });
        viewbtn.setOnClickListener(view -> {
            Cursor res = DB.getdata();
            if(res.getCount()==0){
                Toast.makeText(this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                return;
            }

            StringBuffer buffer = new StringBuffer();
            while(res.moveToNext()){
                buffer.append("Roll No. : " + res.getString(0)+"\n");
                buffer.append("Name : "+ res.getString(1)+"\n\n");
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setCancelable(true);
            builder.setTitle("User Entries");
            builder.setMessage(buffer.toString());
            builder.show();
        });
    }


}