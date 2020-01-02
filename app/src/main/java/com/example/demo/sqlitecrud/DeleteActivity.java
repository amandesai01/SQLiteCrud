package com.example.demo.sqlitecrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteActivity extends AppCompatActivity {

    EditText etRno;
    Button btnSave;
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        etRno = findViewById(R.id.etRno);
        btnSave = findViewById(R.id.btnSave);
        db = MainActivity.db;
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rno = Integer.parseInt(etRno.getText().toString());
                if(rno <= 0){
                    etRno.setError("Error");
                    return;
                }
                db.deleteStudent(rno);
                etRno.setText("");
                etRno.requestFocus();
            }
        });
    }
}
