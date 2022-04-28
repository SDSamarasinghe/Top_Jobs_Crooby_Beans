package com.example.topjobs.Database;


import android.provider.BaseColumns;

public final class UserProfile {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private UserProfile() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_1 = "user_name";
        public static final String COLUMN_2 = "user_contact";
        public static final String COLUMN_3 = "user_gender";
        public static final String COLUMN_4 = "user_district";
        public static final String COLUMN_5 = "user_email";
        public static final String COLUMN_6 = "user_password";
        public static final String COLUMN_7 = "user_dob";
    }
}

