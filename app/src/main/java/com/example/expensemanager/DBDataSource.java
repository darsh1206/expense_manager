package com.example.expensemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

public class DBDataSource {
    private SQLiteDatabase database;
    private AppDB dbHelper;

    public DBDataSource(Context context) {
            dbHelper = new AppDB(context);
        }
    public void open() {
        database = dbHelper.getWritableDatabase();
    }
    public void close() {
        dbHelper.close();
    }
    public long insertUser(String username, String password, String email) {
        ContentValues values = new ContentValues();
        values.put(DBContract.UserEntry.COLUMN_USERNAME, username);
        values.put(DBContract.UserEntry.COLUMN_PASSWORD, password);
        values.put(DBContract.UserEntry.COLUMN_EMAIL, email);

        long insertedRowId = database.insert(DBContract.UserEntry.TABLE_NAME, null, values);

        // Retrieve the primary key value for the newly inserted user
        Cursor cursor = database.rawQuery("SELECT last_insert_rowid()", null);
        long userId = -1;
        if (cursor != null && cursor.moveToFirst()) {
            userId = cursor.getLong(0);
            cursor.close();
        }

        return userId;
    }

    public void insertUserDetails(int userId, String description, String birthdate, String address, String city, String country) {
        ContentValues values = new ContentValues();
        values.put(DBContract.UserDetailsEntry.COLUMN_USER_ID, userId);
        values.put(DBContract.UserDetailsEntry.COLUMN_DESCRIPTION, description);
        values.put(DBContract.UserDetailsEntry.COLUMN_BIRTHDATE, birthdate);
        values.put(DBContract.UserDetailsEntry.COLUMN_ADDRESS, address);
        values.put(DBContract.UserDetailsEntry.COLUMN_CITY, city);
        values.put(DBContract.UserDetailsEntry.COLUMN_COUNTRY, country);
        database.insert(DBContract.UserDetailsEntry.TABLE_NAME, null, values);
    }

    public int updateUserDetails(long userId, String description, String birthdate, String address, String city, String country) {
        ContentValues values = new ContentValues();
        values.put(DBContract.UserDetailsEntry.COLUMN_DESCRIPTION, description);
        values.put(DBContract.UserDetailsEntry.COLUMN_BIRTHDATE, birthdate);
        values.put(DBContract.UserDetailsEntry.COLUMN_ADDRESS, address);
        values.put(DBContract.UserDetailsEntry.COLUMN_CITY, city);
        values.put(DBContract.UserDetailsEntry.COLUMN_COUNTRY, country);

        // Define the WHERE clause to update the row for the given user ID
        String whereClause = DBContract.UserDetailsEntry.COLUMN_USER_ID + " = ?";
        String[] whereArgs = {String.valueOf(userId)};

        // Perform the update
        return database.update(DBContract.UserDetailsEntry.TABLE_NAME, values, whereClause, whereArgs);
    }



    // Add more methods for CRUD operations as needed
}
