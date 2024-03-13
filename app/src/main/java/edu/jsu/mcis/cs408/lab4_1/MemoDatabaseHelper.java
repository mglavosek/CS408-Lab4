package edu.jsu.mcis.cs408.lab4_1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "memo.db";
    private static final int DATABASE_VERSION = 1;

    public MemoDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_MEMO_TABLE =
                "CREATE TABLE " + MemoContract.MemoEntry.TABLE_NAME + " (" +
                        MemoContract.MemoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        MemoContract.MemoEntry.COLUMN_TEXT + " TEXT NOT NULL" +
                        ");";
        db.execSQL(SQL_CREATE_MEMO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MemoContract.MemoEntry.TABLE_NAME);
        onCreate(db);
    }
}

