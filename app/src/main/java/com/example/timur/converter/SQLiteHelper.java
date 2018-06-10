package com.example.timur.converter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Timur on 11.03.2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "CONVERTER";
    private final static int DB_VERSION = 2;
    private final static String TABLE_NAME = "LENGTH_TABLE";
    private final static String ID = "_id";
    private final static String LENGTH_FIRST = "FIRST_LENGTH";
    private final static String SPINNER_FIRST = "FIRST_SPINNER";
    private final static String LENGTH_SECOND = "SECOND_LENGTH";
    private final static String SPINNER_SECOND = "SECOND_SPINNER";
    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" +
            ID + " INTEGER_PRIMARY_KEY, " +
            LENGTH_FIRST + " INTEGER, " +
            SPINNER_FIRST + " INTEGER, " +
            LENGTH_SECOND + " INTEGER, " +
            SPINNER_SECOND + " INTEGER" +
            ");";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void saveLength(LengthModel model) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(LENGTH_FIRST, model.getFirstLength());
        cv.put(SPINNER_FIRST, model.getFirstSpinner());
        cv.put(LENGTH_SECOND, model.getSecondLength());
        cv.put(SPINNER_SECOND, model.getSecondSpinner());

        long rowId = db.insert(TABLE_NAME, null, cv);
        Log.d("Row inserted: ", "ID = " + rowId);
        db.close();
    }

    public LengthModel getData( LengthModel model) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            int firstLengthIndex = cursor.getColumnIndex(LENGTH_FIRST);
            int firstSpinnerIndex = cursor.getColumnIndex(SPINNER_FIRST);
            int secondLengthIndex = cursor.getColumnIndex(LENGTH_SECOND);
            int secondSpinnerIndex = cursor.getColumnIndex(SPINNER_SECOND);
            do {
                model.setFirstLength(cursor.getDouble(firstLengthIndex));
                model.setFirstSpinner(cursor.getInt(firstSpinnerIndex));
                model.setSecondLength(cursor.getDouble(secondLengthIndex));
                model.setSecondSpinner(cursor.getInt(secondSpinnerIndex));
            } while (cursor.moveToNext());
            Log.d("Date received", "amount: " + cursor.getCount());
        } else {
            Log.d("Data is empty", "amount: " + cursor.getCount());

        }
        cursor.close();
        db.close();
        return model;
    }

    public void clearData () {
        SQLiteDatabase db = getWritableDatabase();
        long clearCount = db.delete(TABLE_NAME, null, null);
        Log.d("DATA DELETED ", "amount: " + clearCount);
        db.close();
    }
}
