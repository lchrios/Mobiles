package com.example.clase2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// sqlite - LIKE MariaDB, MySQL, Oracle, Postgre
// dbms - database management system
// - relational database
// stored locally in files

// the lenguage you use is SQL - same old queries

public class DBHelper extends SQLiteOpenHelper {

    // constants we will use
    private static final String DB_FILE = "MyDatabase.db";
    private static final String TABLE = "Students";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_GRADE =  "grade";


    // context is a class that is able to request functionality from OS
    public DBHelper(Context context) {
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_GRADE + " INTEGER)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // version changed!
        // prepared statements
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        sqLiteDatabase.execSQL(query, params);
        onCreate(sqLiteDatabase);

    }

    public void save(String name, int grade) {

        SQLiteDatabase db = getWritableDatabase();
        String clause = f



        db.insert(TABLE, null, )

    }

    public int delete(String name) { return 0; }

    public int find(String name) { return 0; }

}
