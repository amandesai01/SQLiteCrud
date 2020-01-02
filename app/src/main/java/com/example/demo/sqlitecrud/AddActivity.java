package com.example.demo.sqlitecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText etName, etRno;
    Button btnSave;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        etName = findViewById(R.id.etName);
        etRno = findViewById(R.id.etRno);
        btnSave = findViewById(R.id.btnSave);
        db = MainActivity.db;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name  = etName.getText().toString();
                int rno = Integer.parseInt(etRno.getText().toString());
                if(name.length() < 2){
                    etName.setError("Error");
                    return;
                }
                if(rno <= 0){
                    etRno.setError("Error");
                    return;
                }
                db.addStudent(rno, name);

                etName.setText("");
                etRno.setText("");
                etName.requestFocus();
            }
        });
    }
}
