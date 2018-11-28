package vn.edu.poly.projectone.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


import vn.edu.poly.projectone.Constant;
import vn.edu.poly.projectone.database.DatabaseHelper;
import vn.edu.poly.projectone.model.Diary;

public class DiaryDAO implements Constant {
    private DatabaseHelper databaseHelper;

    public DiaryDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public long insertDiary(Diary diary) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, diary.title);
        contentValues.put(COLUMN_DATE, diary.date);
        contentValues.put(COLUMN_DESCRIBE, diary.describe);

        long result = sqLiteDatabase.insert(TABLE_DIARY, null, contentValues);

        sqLiteDatabase.close();
        return result;
    }

    public long updateDiary(Diary diary) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, diary.title);
        contentValues.put(COLUMN_DATE, diary.date);
        contentValues.put(COLUMN_DESCRIBE, diary.describe);

        long result = sqLiteDatabase.update(TABLE_DIARY, contentValues,
                COLUMN_TITLE + "=?",
                new String[]{diary.title});

        sqLiteDatabase.close();

        return result;

    }

    public long deleteDiary(String diaryTitle) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(TABLE_DIARY, COLUMN_TITLE + "=?",
                new String[]{diaryTitle});

        sqLiteDatabase.close();

        return result;
    }

    public List<Diary> getAllDiarys() {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        List<Diary> diaries = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_DIARY,
                null);

        // kiem tra cursor co du lieu hay ko
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                // thiet lap con tro ve vi tri dau tien
                cursor.moveToFirst();
                do {
                    String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
                    long date = cursor.getLong(cursor.getColumnIndex(COLUMN_DATE));
                    String describe = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIBE));

                    Diary diary = new Diary(title, date, describe);


                    diaries.add(diary);

                } while (cursor.moveToNext());
            }

        }

        return diaries;
    }

    public Diary getDiaryByTitle(String diaryTitle) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Diary diary = null;

        Cursor cursor = sqLiteDatabase.query(TABLE_DIARY,
                new String[]{COLUMN_TITLE, COLUMN_DATE, COLUMN_DESCRIBE}, COLUMN_TITLE + "=?",
                new String[]{diaryTitle}, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
            long date = cursor.getLong(cursor.getColumnIndex(COLUMN_DATE));
            String describe = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIBE));
            diary = new Diary(title, date, describe);

        }

        sqLiteDatabase.close();

        return diary;
    }
}
