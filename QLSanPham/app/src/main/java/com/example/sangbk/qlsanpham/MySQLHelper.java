package com.example.sangbk.qlsanpham;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLHelper extends SQLiteOpenHelper {
    public MySQLHelper(Context context) {
        super(context,"ManageRestaurant",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE listRestaurant(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, count TEXT , cost TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String name,String count, String cost){
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("count",count);
        cv.put("cost",cost);
        getReadableDatabase().insert("listRestaurant","name",cv);
    }
    public void update(String id, String name, String count,String cost) {
        ContentValues cv=new ContentValues();
        String[] args={id};
        cv.put("name", name);
        cv.put("count",count);
        cv.put("cost",cost);
        getWritableDatabase().update("listRestaurant", cv, "_id=?",
                args);
    }
    public void delete(String id){
        String []args={id};
        getWritableDatabase().delete("listRestaurant","_id=?",args);
    }
    public Cursor getById(String id) {
        String[] args={id};
        return(getReadableDatabase()
                .rawQuery("SELECT _id, name, count, cost FROM listRestaurant where _id=?",args));
    }
    public Cursor getAll(){
        return getReadableDatabase().rawQuery("SELECT * FROM listRestaurant ORDER BY name",null);
    }
    public String getName(Cursor c){
        return  c.getString(1);
    }
    public String getCount(Cursor c){
        return  c.getString(2);
    }
    public String getCost(Cursor c){
        return  c.getString(3);
    }

}

