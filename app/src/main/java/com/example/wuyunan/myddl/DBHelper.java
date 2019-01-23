package com.example.wuyunan.myddl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wuyunan on 18/7/22.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {super(context, "myDDL.db", null, 1);}
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table users(username text primary key,password text,grade text,createtime text)");
        db.execSQL("create table myddl(lid INTEGER PRIMARY KEY AUTOINCREMENT,username text,grade text,ddlremark text,ddl date,sts text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop if table exists users");
        db.execSQL("drop if table exists  myddl");
        onCreate(db);
    }
}
