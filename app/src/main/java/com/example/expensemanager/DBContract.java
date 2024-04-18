package com.example.expensemanager;

public final class DBContract {
    private DBContract() {}
    public static class UserEntry {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_EMAIL = "email";

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                        COLUMN_PASSWORD + " TEXT," +
                        COLUMN_EMAIL + " TEXT)";
    }
}
