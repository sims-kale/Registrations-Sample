package com.example.registrationassignment1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DB = "Register.db";

    public DBHandler(Context context) {
        super(context, "Register.db",null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table users(Name TEXT primary key, Birth_Date TEXT , Email TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists users");

    }
    public Boolean insertData(String name, String birthdate, String email){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Birth_Date", String.valueOf(birthdate));
        contentValues.put("Email", email);
        long result= sqLiteDatabase.insert("users", null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public Boolean checkName (String name ){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from users where name = ?", new String[]{name});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkBirthDate( String birth_date){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from users where name = ? and birth_date= ?", new String[]{birth_date});
        if(cursor.getCount()>0)
            return  true;
        else
            return false;
    }
    public Boolean checkEmail(String email, String name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select * from users where name =? and email= ? ", new String[]{email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
