package com.example.bit.passman;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bit on 22.11.17.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "baseDB";
    public static final String TABLE_BASE = "base";
    public static final String KEY_ID = "_id";
    public static final String KEY_RESOURCE = "resource";
    public static final String KEY_LOGIN = "login";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_COMMENT = "comment";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "
        + TABLE_BASE + " ("
        + KEY_ID + " integer primary key, "
        + KEY_RESOURCE + " text, "
        + KEY_LOGIN + " text, "
        + KEY_PASSWORD + " text, "
        + KEY_COMMENT + " text" +
        ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_BASE);
        onCreate(sqLiteDatabase);

    }
}


