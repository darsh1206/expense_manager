package com.example.expensemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
            return database.insert(DBContract.UserEntry.TABLE_NAME, null, values);
        }

        // Add more methods for CRUD operations as needed
}
