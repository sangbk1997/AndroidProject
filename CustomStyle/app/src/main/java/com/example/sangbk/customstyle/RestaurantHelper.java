package com.example.sangbk.customstyle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sangbk on 10/17/2017.
 */

public class RestaurantHelper  extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="Lunchlist.db";
    private  static final int SCHEMA_VERSION=1;

    public RestaurantHelper(Context context) {
        super(context,DATABASE_NAME,null,SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
             db.execSQL("CREATE TABLE restaurant (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, type TEXT, discount TEXT,notes TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert(String name, String address,String type, String discount,String notes){
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("address",address);
        values.put("type",type);
        values.put("discount",discount);
        values.put("notes",notes);
        getWritableDatabase().insert("restaurants","name",values);

    }
    public Cursor getAll(){
        return (getReadableDatabase().rawQuery("SELECT _id,name,address,type,discount,notes FROM restaurants ORDER BY name",null));
    }
    public String getName(Cursor c){
        return c.getString(1);
    }
    public String getAddress(Cursor c){
        return c.getString(2);
    }
    public String getType(Cursor c){
        return c.getString(3);
    }
    public String getDiscount(Cursor c){
        return c.getString(4);
    }
    public String getNotes(Cursor c){
        return c.getString(5);
    }
}
