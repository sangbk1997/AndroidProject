package com.example.sangbk.note;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sangbk on 10/11/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    // PHiên ban
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "SQLite";
    // ten co so du lieu
    private static final String DATABASE_NAME = "Note_Manager";
    // ten bang Note;
    private static final String TABLE_NOTE = "Note";
    private static final String COLUMN_NOTE_ID = "Note_Id";
    private static final String COLUMN_NOTE_TITLE = "Note_Title";
    private static final String COLUMN_NOTE_CONTENT = "Note_Content";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Tao cac bang
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Script bang
        String script = "CREATE TABLE" + TABLE_NOTE + "(" + COLUMN_NOTE_ID + "INTEGER PRIMARY KEY"
                + COLUMN_NOTE_TITLE + "TEXT" + COLUMN_NOTE_CONTENT + "TEXT" + ")";
        // CHAY lenh tao bang
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // huy bang cu neu no da ton tai
        db.execSQL("DROP TABLE IF EXIST" + TABLE_NOTE);
        // va tao lai
        onCreate(db);
        // Nếu trong bang Note chua có dữ liệu
        // Trèn vào mặc định 2 bản ghi
    }
    public void CreateDefaultNotesNeed() {
        int count = this.getNotesCount();
        if (count == 0) {
            note note1 = new note("First see Android ListView", "Sangbk");
            note note2 = new note("Learn Android ", "thứ 2,3");
            this.addNote(note1);
            this.addNote(note2);
        }
    }

    void addNote(note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
        values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());

        // chen một dòng dữ liệu vào mảng
        db.insert(TABLE_NOTE, null, values);
        // đóng kết nối database
        db.close();
    }

    public note getNote(int id) {
//        Log.i(TAG, "MyDatabaseHelper.getNote ... " + id);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NOTE, new String[]{COLUMN_NOTE_ID,
                        COLUMN_NOTE_TITLE, COLUMN_NOTE_CONTENT}, COLUMN_NOTE_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        note note = new note(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return note
        return note;
    }


    public List<note> getAllNotes() {
        List<note> noteList = new ArrayList<note>();
        // select All Query
        String selectQuery = "SELECT *FROM" + TABLE_NOTE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // duyet con tro và thêm vào danh sách
        if (cursor.moveToFirst()) {
            do {
                note note = new note();
                note.setNoteId(Integer.parseInt(cursor.getString(0)));
                note.setNoteTitle(cursor.getString(1));
                note.setNoteContent(cursor.getString(2));
                // them vao danh sach
                noteList.add(note);

            } while (cursor.moveToNext());

        }
        // return note list
        return noteList;

    }

    public int getNotesCount() {
        String countQuery = "SELECT *FROM" + TABLE_NOTE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }

    public int updateNote(note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOTE_TITLE, note.getNoteTitle());
        values.put(COLUMN_NOTE_CONTENT, note.getNoteContent());
        // updating now
        return db.update(TABLE_NOTE, values, COLUMN_NOTE_ID + "=?", new String[]{String.valueOf(note.getNoteId())});

    }

    public void deleteNote(note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTE, COLUMN_NOTE_ID + "=?", new String[]{String.valueOf(note.getNoteId())});
        db.close();
    }

}
