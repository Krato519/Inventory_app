package com.example.inventory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "myDatabase001.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DataBaseSchema.TABLE_NAME + " (" +
            DataBaseSchema._ID + "INTEGER PRIMARY KEY," +
            DataBaseSchema.NAME + " TEXT," +
            DataBaseSchema.TYPE + " TEXT," +
            DataBaseSchema.BRAND + " TEXT," +
            DataBaseSchema.MODEL + " TEXT," +
            DataBaseSchema.STATUS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " +   DataBaseSchema.TABLE_NAME;

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
        System.out.println("Creating Database...");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
        System.out.println("Upgrading Database...");
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
        System.out.println("Downgrading database...");
    }
}
