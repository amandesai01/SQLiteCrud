package com.example.demo.sqlitecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHandler extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase db;

    DBHandler(Context context){
        super(context, "student_db", null, 1);
        this.context = context;
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table student(rno int primary key, name varchar(30))";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public void addStudent(int rno, String name){
        ContentValues cv = new ContentValues();
        cv.put("rno", rno);
        cv.put("name", name);
        long id = db.insert("student", null, cv);
        if(id > 0){
            Toast.makeText(context, "Query Successful", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Issue", Toast.LENGTH_SHORT).show();
        }
    }

    public String getStudent(){
        StringBuffer sb = new StringBuffer();
        Cursor c = db.query("student", null, null, null, null, null, null, null);
        c.moveToFirst();
        sb.append("Roll No" + "\t" + "Name" + "\n");
        if(c.getCount()>0){
            do {
                sb.append(c.getString(0) + "\t" + c.getString(1) + "\n");
            }while (c.moveToNext());
        }
        return sb.toString();
    }

    public void deleteStudent(int rno){
        long id = db.delete("student", "rno=" + rno, null);
        if(id > 0){
            Toast.makeText(context, "Query Successful", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Issue", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateStudent(int rno, String name){
        ContentValues cv = new ContentValues();
        cv.put("rno", rno);
        cv.put("name", name);
        long id = db.update("student",  cv, "rno="+rno, null);
        if(id > 0){
            Toast.makeText(context, "Query Successful", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Issue", Toast.LENGTH_SHORT).show();
        }
    }



}
