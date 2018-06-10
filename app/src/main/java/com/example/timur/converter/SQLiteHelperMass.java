package com.example.timur.converter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Timur on 11.03.2018.
 */

public class SQLiteHelperMass extends SQLiteOpenHelper {
    private final static String DB_NAME = "CONVERTER_MASS";
    private final static int DB_VERSION = 2;
    private final static String TABLE_NAME = "MASS_TABLE";
    private final static String ID = "_id";
    private final static String MASS_FIRST = "FIRST_MASS";
    private final static String SPINNER_FIRST = "FIRST_SPINNER";
    private final static String MASS_SECOND = "SECOND_MASS";
    private final static String SPINNER_SECOND = "SECOND_SPINNER";
    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" +
            ID + " INTEGER_PRIMARY_KEY, " +
            MASS_FIRST + " INTEGER, " +
            SPINNER_FIRST + " INTEGER, " +
            MASS_SECOND + " INTEGER, " +
            SPINNER_SECOND + " INTEGER" +
            ");";

    public SQLiteHelperMass(Context context) {
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

    public void saveLength(MassModel model) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(MASS_FIRST, model.getFirstMass());
        cv.put(SPINNER_FIRST, model.getFirstMassSpinner());
        cv.put(MASS_SECOND, model.getSecondMass());
        cv.put(SPINNER_SECOND, model.getSecondMassSpinner());

        long rowId = db.insert(TABLE_NAME, null, cv);
        Log.d("Row inserted: ", "ID = " + rowId);
        db.close();
    }

    public MassModel getData( MassModel model) {
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
            int firstMassIndex = cursor.getColumnIndex(MASS_FIRST);
            int firstSpinnerIndex = cursor.getColumnIndex(SPINNER_FIRST);
            int secondMassIndex = cursor.getColumnIndex(MASS_SECOND);
            int secondSpinnerIndex = cursor.getColumnIndex(SPINNER_SECOND);
            do {
                model.setFirstMass(cursor.getDouble(firstMassIndex));
                model.setFirstMassSpinner(cursor.getInt(firstSpinnerIndex));
                model.setSecondMass(cursor.getDouble(secondMassIndex));
                model.setSecondMassSpinner(cursor.getInt(secondSpinnerIndex));
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
