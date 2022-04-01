package com.deepak.program5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    TextView item_text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item_text = findViewById(R.id.item_text);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.home:
                item_text.setText("Home Selected");
                return true;
            case R.id.about:
                item_text.setText("About Selected");
                return true;
            case R.id.contact:
                item_text.setText("Contact Selected");
                return true;
            case R.id.help:
                item_text.setText("Help Selected");
                return true;
            case R.id.suggest:
                item_text.setText("Suggest Selected");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}