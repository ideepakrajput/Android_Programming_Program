package com.deepak.program4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner = findViewById(R.id.spinner);
        ImageView images = findViewById(R.id.images);

        String[] items = getResources().getStringArray(R.array.items);

        if(spinner != null) {
            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(items[i].equals("Book")){
                        images.setImageResource(R.drawable.book);
                        Toast.makeText(MainActivity.this, "Selected Book", Toast.LENGTH_SHORT).show();
                    }if(items[i].equals("Animal")){
                        images.setImageResource(R.drawable.animal);
                        Toast.makeText(MainActivity.this, "Selected Animal", Toast.LENGTH_SHORT).show();
                    }if(items[i].equals("Car")){
                        images.setImageResource(R.drawable.car);
                        Toast.makeText(MainActivity.this, "Selected Car", Toast.LENGTH_SHORT).show();
                    }if(items[i].equals("Lab")){
                        images.setImageResource(R.drawable.lab);
                        Toast.makeText(MainActivity.this, "Selected Lab", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }
    }
}