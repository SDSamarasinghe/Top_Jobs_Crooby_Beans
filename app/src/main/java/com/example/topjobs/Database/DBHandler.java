package com.example.topjobs.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TopJobs.db";
    public static final String TABLE1 = "UserInfo";
    public static final String TABLE2 = "JobInfo";
    //public static final String TABLE3 = "";
   // public static final String TABLE4 = "";

    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase db) {


        String table1 = "CREATE TABLE "+TABLE1+"(id INTEGER PRIMARY KEY, product TEXT)";
        String table2 = "CREATE TABLE "+TABLE2+"(id INTEGER PRIMARY KEY, product TEXT)";

        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);

        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + UserProfile.Users.TABLE_NAME + " (" +
                    UserProfile.Users._ID + " INTEGER PRIMARY KEY," +
                    UserProfile.Users.COLUMN_1 + " TEXT," +
                    UserProfile.Users.COLUMN_2 + " TEXT," +
                    UserProfile.Users.COLUMN_3 + " TEXT," +
                    UserProfile.Users.COLUMN_4 + " TEXT," +
                    UserProfile.Users.COLUMN_5 + " TEXT," +
                    UserProfile.Users.COLUMN_6 + " TEXT," +
                    UserProfile.Users.COLUMN_7 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + UserProfile.Users.TABLE_NAME;


    public boolean insert (String com_name, String com_title, String com_Salary, String com_description, String com_email, String com_phone, String com_district, String user_name, String user_contact, String user_gender, String user_district, String user_email, String user_password, String user_dob){
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values1 = new ContentValues();
        values1.put("com_name", com_name);
        values1.put("com_title", com_title);
        values1.put("com_Salary", com_Salary);
        values1.put("com_description", com_description);
        values1.put("com_email", com_email);
        values1.put("com_phone", com_phone);
        values1.put("com_district", com_district);
        SQLiteDatabase.insert(TABLE1, null,values1);

        ContentValues values2 = new ContentValues();
        values2.put("user_name", user_name);
        values2.put("user_name", user_contact);
        values2.put("user_name", user_gender);
        values2.put("user_name", user_district);
        values2.put("user_name", user_email);
        values2.put("user_name", user_password);
        values2.put("user_name", user_dob);
        SQLiteDatabase.insert(TABLE1, null,values2);



        return true;

    }

    public ArrayList getUsers(){
        //GET Readable database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        //Perform raw query
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE1
        , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndexOrThrow("user_name")));
            cursor.moveToNext();
        }
        return arrayList;

    }
    public ArrayList getJobs(){
        //GET Readable database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<String> arrayList = new ArrayList<>();
        //Perform raw query
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE2
                , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            arrayList.add(cursor.getString(cursor.getColumnIndexOrThrow("com_name")));
            cursor.moveToNext();
        }
        return arrayList;

    }

    public void deleteInfo (String user_name){

        SQLiteDatabase db = getWritableDatabase();
        // Define 'where' part of query.
        String selection = UserProfile.Users.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { "MyTitle" };
        // Issue SQL statement.
        int deletedRows = db.delete(UserProfile.Users.TABLE_NAME, selection, selectionArgs);
    }



    public List readAllInfo (){
        SQLiteDatabase db = getReadableDatabase();

        String user_name ="Sadish";

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                UserProfile.Users.COLUMN_1,
                UserProfile.Users.COLUMN_2,
                UserProfile.Users.COLUMN_3,
                UserProfile.Users.COLUMN_4,
                UserProfile.Users.COLUMN_5,
                UserProfile.Users.COLUMN_6,
                UserProfile.Users.COLUMN_7
        };

// Filter results WHERE "title" = 'My Title'
        String selection = UserProfile.Users.COLUMN_1 + " = ?";
        String[] selectionArgs = { user_name };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                UserProfile.Users.COLUMN_1 + " DESC";

        Cursor cursor = db.query(
                UserProfile.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List usernames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_1));
            usernames.add(user);
        }
        cursor.close();
        return usernames;
    }


    public List readAllInfo (String username){
        SQLiteDatabase db = getReadableDatabase();

        String user_name ="Sadish";

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                UserProfile.Users.COLUMN_1,
                UserProfile.Users.COLUMN_2,
                UserProfile.Users.COLUMN_3,
                UserProfile.Users.COLUMN_4,
                UserProfile.Users.COLUMN_5,
                UserProfile.Users.COLUMN_6,
                UserProfile.Users.COLUMN_7
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = UserProfile.Users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { username };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                UserProfile.Users.COLUMN_1 + " DESC";

        Cursor cursor = db.query(
                UserProfile.Users.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List userInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_1));
            String user_contact = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_2));
            String user_gender = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_3));
            String user_district = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_4));
            String user_email = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_5));
            String user_dob = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_6));
            String user_password = cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_7));
            userInfo.add(user);//0
            userInfo.add(user_contact);//1
            userInfo.add(user_gender);//2
            userInfo.add(user_district);//3
            userInfo.add(user_email);//4
            userInfo.add(user_dob);//5
            userInfo.add(user_password);//6
        }
        cursor.close();
        return userInfo;
    }


}
