package com.example.expensemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDatabase";
    private static final int DATABASE_VERSION = 1;

    public AppDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables
        db.execSQL(DBContract.UserEntry.CREATE_TABLE);
        db.execSQL(DBContract.UserDetailsEntry.CREATE_TABLE);
        // Add more tables if needed
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.UserEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + DBContract.UserDetailsEntry.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }
}
