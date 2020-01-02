package com.example.demo.sqlitecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {
    TextView tv1;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        db = MainActivity.db;
        tv1 = findViewById(R.id.tv1);
        String data = db.getStudent();
        if(data.length() == 0){
            tv1.setText("No Data");
        }
        else{
            tv1.setText(data);
        }
    }
}
