package com.example.sangbk.ikariam_part1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sangbk on 10/18/2017.
 */

public class MySQLHelper extends SQLiteOpenHelper {
    public MySQLHelper(Context context) {
        super(context,"ManageInformation",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE configureInformationNV(_id INTEGER PRIMARY KEY AUTOINCREMENT, ten TEXT, mau TEXT , satthuong TEXT, giap TEXT, sodan TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert(String ten,String mau, String satthuong,String giap, String sodan){
        ContentValues cv=new ContentValues();
        cv.put("ten",ten);
        cv.put("mau",mau);
        cv.put("satthuong",satthuong);
        cv.put("giap",giap);
        cv.put("sodan",sodan);
        getReadableDatabase().insert("configureInformationNV","ten",cv);
    }
    public void delete(String name){
        String []args={name};
        getWritableDatabase().delete("configureInformationNV","ten=?",args);
    }
    public Cursor getAll(){
        return getReadableDatabase().rawQuery("SELECT * FROM configureInformationNV ORDER BY ten",null);
    }
    public String getTen(Cursor c){
        return c.getString(1);
    }
    public String getMau(Cursor c){
        return c.getString(2);
    }
    public String getSatThuong(Cursor c){
        return c.getString(3);
    }
    public String getGiap(Cursor c){
        return c.getString(4);
    }
    public String getSoDan(Cursor c){
        return c.getString(5);
    }

}
