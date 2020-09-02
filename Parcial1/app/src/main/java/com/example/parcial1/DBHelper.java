package com.example.parcial1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.Map;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_FILE = "MyDatabase.db";
    private static final String TABLE = "Gatitos";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_AGE = "edad";

    public DBHelper(Context context) {
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_AGE + " INTEGER)";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        sqLiteDatabase.execSQL(query, params);
        onCreate(sqLiteDatabase);
    }

    public void save(String name, int age) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIELD_NAME, name);
        values.put(FIELD_AGE, age);

        db.insert(TABLE, null, values);
    }

    public Map<String, Object> find(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_ID + "= ?";
        String[] args = {id};

        Cursor c = db.query(TABLE, null, clause, args, null, null, null);
        Map<String, Object> res = new HashMap<String, Object>();
        if (c.moveToFirst()) {
            res.put(FIELD_NAME, c.getString(1));
            res.put(FIELD_AGE, (int) c.getInt(2));
        } else {
            res.put(FIELD_ID, "");
            res.put(FIELD_NAME, "");
            res.put(FIELD_AGE, "");
        }

        return res;
    }

    public Map<String, Object> findByPos(int pos) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE;

        Cursor c = db.rawQuery(query, null);
        Map<String, Object> res = new HashMap<String, Object>();

        if (c.move(pos)){
            res.put(FIELD_ID, c.getInt(0));
            res.put(FIELD_NAME, c.getString(1));
            res.put(FIELD_AGE, c.getInt(2));
        } else {
            res.put(FIELD_ID, "");
            res.put(FIELD_NAME, "");
            res.put(FIELD_AGE, "");
        }

        return res;
    }

    public Map<String, Object> findFirstAlphabetical() {
        SQLiteDatabase db = getReadableDatabase();


        Cursor c = db.query(TABLE, null, null, null, null, null, FIELD_NAME + " ASC");
        Map<String, Object> res = new HashMap<String, Object>();

        if (c.moveToFirst()){
            res.put(FIELD_ID, c.getInt(0));
            res.put(FIELD_NAME, c.getString(1));
            res.put(FIELD_AGE, c.getInt(2));
        } else {
            res.put(FIELD_NAME, "db vacia");
        }

        return res;
    }

    public Map<String, Object> findOldestCat() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(TABLE, null, null, null,null,null, FIELD_AGE + " DESC");

        Map<String, Object> res = new HashMap<String, Object>();

        if (c.moveToFirst()){
            res.put(FIELD_ID, c.getInt(0));
            res.put(FIELD_NAME, c.getString(1));
            res.put(FIELD_AGE, c.getInt(2));
        } else {
            res.put(FIELD_AGE, "db vacia");
        }

        return res;
    }
}
