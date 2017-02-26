package com.savitarmotors.savitar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="savitar.db";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE1_NAME="customers";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="ADDRESS";
    public static final String COL_4="EMAIL";
    public static final String COL_5="MOBILE";
    public static final String COL_6="PASSWORD";



    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query="CREATE TABLE customers(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,ADDRESS TEXT,EMAIL TEXT,MOBILE TEXT,PASSWORD TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS customers");
    }
    public boolean insertData(String name, String address,
                              String email,String mobile,
                              String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,address);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,mobile);
        contentValues.put(COL_6,password);
        long result = db.insert("customers", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getEmail(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("customers", null, "EMAIL=?", new String[]{name}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        }
        return name;
    }

    public String getPass(String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("customers", null, "PASSWORD=?", new String[]{password}, null, null, null);
        if (cursor.getCount()<1){
            cursor.close();
            return "NOT EXIST";
        }
        return password;
    }

}
