package com.deepak.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myList = findViewById(R.id.myList);
        TextView ticText = findViewById(R.id.ticText);
        TextView courses = findViewById(R.id.courses);
        courses.setText(R.string.courses);
        String[] MyList = {
                "Biomedical Science",
                "Chemistry",
                "Computer Science",
                "Food Technology",
                "Geography",
                "Hindi",
                "Mathematics",
                "Physics"
        };
        ArrayAdapter<String> Lists;
        Lists = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, MyList);
        myList.setAdapter(Lists);

        myList.setOnItemClickListener((adapterView, view, position, l) -> {
            switch (position){
                case 0:
                    ticText.setText(R.string.biomedical);
                    return;
                case 1:
                    ticText.setText(R.string.chemistry);
                    return;
                case 2:
                    ticText.setText(R.string.computer);
                    return;
                case 3:
                    ticText.setText(R.string.food);
                    return;
                case 4:
                    ticText.setText(R.string.geography);
                    return;
                case 5:
                    ticText.setText(R.string.hindi);
                    return;
                case 6:
                    ticText.setText(R.string.maths);
                    return;
                case 7:
                    ticText.setText(R.string.physics);
                    return;
                default:
                    ticText.setText("Error Occured");
            }
        });

    }
}