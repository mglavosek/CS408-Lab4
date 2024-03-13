package edu.jsu.mcis.cs408.lab4_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MemoModel {

    private MemoDatabaseHelper dbHelper;

    public MemoModel(Context context) {
        dbHelper = new MemoDatabaseHelper(context);
    }

    public void addNewMemo(String memoText) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MemoContract.MemoEntry.COLUMN_TEXT, memoText);
        db.insert(MemoContract.MemoEntry.TABLE_NAME, null, values);
        db.close();
    }

    public void deleteMemo(long memoId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = MemoContract.MemoEntry._ID + "=?";
        String[] selectionArgs = { String.valueOf(memoId) };
        db.delete(MemoContract.MemoEntry.TABLE_NAME, selection, selectionArgs);
        db.close();
    }

    public Cursor getAllMemos() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                MemoContract.MemoEntry._ID,
                MemoContract.MemoEntry.COLUMN_TEXT
        };
        return db.query(
                MemoContract.MemoEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }
}


