package edu.jsu.mcis.cs408.lab4_1;

import android.database.Cursor;

public class MemoController {

    private final MemoModel model;

    public MemoController(MemoModel model) {
        this.model = model;
    }

    public void addNewMemo(String memoText) {
        model.addNewMemo(memoText);
    }

    public void deleteMemo(long memoId) {
        model.deleteMemo(memoId);
    }

    public Cursor getAllMemos() {
        return model.getAllMemos();
    }
}


