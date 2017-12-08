package com.example.sangbk.sqlitewithlistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sangbk on 10/17/2017.
 */

public class MySQLHelper extends SQLiteOpenHelper {
    private static  final String DATABASE_NAME="QLBanHang";
    private static final int VERSION=1;
    public MySQLHelper(Context context) {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          db.execSQL("CREATE TABLE items (_idItem INTEGER PRIMARY KEY AUTOINCREMENT, tensanpham TEXT, soluong INTEGER, sotien INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertItem(String name,int soluong, int gia){
        ContentValues cv=new ContentValues();
        cv.put("tensanpham",name);
        cv.put("soluong",soluong);
        cv.put("sotien",gia);
        getWritableDatabase().insert("items","tensanpham",cv);

    }
    public Cursor getAll(){
        return (getReadableDatabase().rawQuery("SELECT _idItem, tensanpham,soluong,sotien",null));
    }
    public String getName(Cursor c){
        return c.getString(1);
    }
    public String getCount(Cursor c){
        return c.getString(2);
    }
    public String getCost(Cursor c){
        return c.getString(3);
    }
}
