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

    public static class UserDetailsEntry {
        public static final String TABLE_NAME = "user_details";
        public static final String COLUMN_USER_ID = "user_id";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_BIRTHDATE = "birthdate";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_COUNTRY = "country";

        // Modified CREATE_TABLE string to include foreign key constraint and primary key
        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," + // Primary key for user_details table
                        COLUMN_USER_ID + " INTEGER," + // Foreign key referencing users table
                        COLUMN_DESCRIPTION + " TEXT," +
                        COLUMN_BIRTHDATE + " TEXT," +
                        COLUMN_ADDRESS + " TEXT," +
                        COLUMN_CITY + " TEXT," +
                        COLUMN_COUNTRY + " TEXT," +
                        "FOREIGN KEY(" + COLUMN_USER_ID + ") REFERENCES " +
                        UserEntry.TABLE_NAME + "(" + UserEntry.COLUMN_USERNAME + "))";
    }

}
