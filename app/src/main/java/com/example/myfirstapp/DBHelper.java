package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {///alt enter2x
    private static int version = 1;
    private static String DB_NAME = "contacts";
    String tableName = "contact";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+tableName+"(id INTEGER PRIMARY KEY AUTOINCREMENT, name  Text, phone_number Text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public boolean saveContact(String name, String phone_number){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone_number", phone_number);

        double result = db.insert(tableName, null, contentValues);
        if(result > 0){
            return true;
        }
        return false;
    }

    public boolean upDate(String name, String phone_number, String id){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone_number", phone_number);

        double result = db.update(tableName,  contentValues, "id=?", new String[]{id});
        if(result > 0){
            return true;
        }
        return false;
    }

    public boolean deleteContact(String id){
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete(tableName, "id = ?", new String[]{id});
        if(result > 0){
            return true;
        }
        return false;
    }

    public Cursor fetchData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName, null);
        return cursor;
    }

}
