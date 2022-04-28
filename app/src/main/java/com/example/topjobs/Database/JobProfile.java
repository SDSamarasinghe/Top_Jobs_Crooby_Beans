package com.example.topjobs.Database;

import android.provider.BaseColumns;

public final class JobProfile {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private JobProfile() {}

    /* Inner class that defines the table contents */
    public static class Job implements BaseColumns {
        public static final String TABLE_NAME = "JobInfo";
        public static final String COLUMN_1 = "com_name";
        public static final String COLUMN_2 = "com_title";
        public static final String COLUMN_3 = "com_salary";
        public static final String COLUMN_4 = "com_description";
        public static final String COLUMN_5 = "com_email";
        public static final String COLUMN_6 = "com_phone";
        public static final String COLUMN_7 = "com_district";
    }
}
