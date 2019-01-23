package com.example.wuyunan.myddl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wuyunan on 18/7/22.
 */

public class DBManager {
    DBHelper dbhelper;
    Context context;

    public DBManager(Context conetxt) {
        this.context = context;
        dbhelper = new DBHelper(conetxt);
    }

    public void adduser(Users users) {
        SQLiteDatabase db = null;
        try {
            db = dbhelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("username", users.getUsername());
            values.put("password", users.getPassword());
            values.put("grade", users.getGrade());
            values.put("createtime", users.getCreatetime());

            db.insert("users", null, values);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            db.close();
        }
    }

    public String getUsers(String uname)
    {
        String result = "";
        SQLiteDatabase db = null;
        try {
            db = dbhelper.getWritableDatabase();
            Cursor c = db.rawQuery("select username,password,grade,createtime from Users where username='"+uname+"'", null);
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                if (c.getString(0) != "")
                    result += c.getString(0) + "/" + c.getString(1) + "//";
                }
            } catch(Exception e) {
                // TODO
            } finally {
               // c.close();
                db.close();
            }




        return result;
    }
}
