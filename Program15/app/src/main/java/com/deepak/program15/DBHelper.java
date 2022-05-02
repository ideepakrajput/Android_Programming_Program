package com.deepak.program15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(rollno INT primary Key,name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public boolean insertuserdata(String rollno,String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rollno", rollno);
        contentValues.put("name", name);
        long result = DB.insert("Userdetails",null,contentValues);
        if (result == -1){
            return false;
        }else {
            return  true;
        }
    }

    public boolean updateuserdata(String rollno,String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        Cursor cursor = DB.rawQuery("select * from Userdetails where rollno = ?", new String[] {rollno});

        if (cursor.getCount()>0){
            long result = DB.update("Userdetails",contentValues,"rollno = ?",new String[] {rollno});
            if (result == -1){
                return false;
            }else {
                return  true;
            }
        }
        else {
            return false;
        }
    }
    public boolean deleteuserdata(String rollno,String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails where rollno = ?", new String[] {rollno});

        if (cursor.getCount()>0){
            long result = DB.delete("Userdetails","rollno = ?",new String[] {rollno});
            if (result == -1){
                return false;
            }else {
                return  true;
            }
        }
        else {
            return false;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails",null);
        return cursor;
    }
}
