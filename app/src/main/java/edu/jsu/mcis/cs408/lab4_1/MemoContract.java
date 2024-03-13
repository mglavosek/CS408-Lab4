package edu.jsu.mcis.cs408.lab4_1;

import android.provider.BaseColumns;

public final class MemoContract {

    private MemoContract() {}

    public static class MemoEntry implements BaseColumns {
        public static final String TABLE_NAME = "memos";
        public static final String COLUMN_TEXT = "text";
    }
}

