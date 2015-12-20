package com.rifaz.simak;


import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter extends SQLiteOpenHelper{
    public static String DATABASE_NAME = "MHS.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_MHS = "Mahasiswa";
    private static final String TABLE_REM = "Remember";
    private static final String KEY_ID = "_ID";
    private static final String KEY_NAMA = "Nama";
    private static final String KEY_NIM = "NIM";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_USERNAME = "Username";
    private static final String KEY_PASSWORD = "Password";
    public static String TAG = "tag";
    
    private static final String CREATE_TABLE_MHS = "CREATE TABLE "
            + TABLE_MHS + "(" 
    		+ KEY_NAMA + " TEXT,"
            + KEY_NIM + " INTEGER,"
            + KEY_EMAIL + " TEXT,"
            + KEY_USERNAME + " TEXT,"
            + KEY_PASSWORD + " TEXT );";
    
    private static final String CREATE_TABLE_REMEMBER = "CREATE TABLE "
            + TABLE_REM + "(" 
    		+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_USERNAME + " TEXT,"
            + KEY_PASSWORD + " TEXT );";

    public DBAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MHS);
        db.execSQL(CREATE_TABLE_REMEMBER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_MHS);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_REMEMBER);
        onCreate(db);
    }

    public long MHSdaftar(Model MHS) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, MHS.nama);
        values.put(KEY_NIM, MHS.nim);
        values.put(KEY_EMAIL, MHS.email);
        values.put(KEY_USERNAME, MHS.username);
        values.put(KEY_PASSWORD, MHS.password);
        
        long insert = db.insert(TABLE_MHS, null, values);
        return insert;
    }

    public int updateEntry(Model MHS) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAMA, MHS.nama);
        values.put(KEY_NIM, MHS.nim);
        values.put(KEY_EMAIL, MHS.email);
        values.put(KEY_USERNAME, MHS.username);
        values.put(KEY_PASSWORD, MHS.password);

        return db.update(TABLE_MHS, values, KEY_NIM + " = ?",
                new String[] { String.valueOf(MHS.nim) });
    }

    public void deleteEntry(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MHS, KEY_NIM + " = ?",
                new String[] { String.valueOf(id) });
    }
    
    public Model getMHS(String username , String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        
        String us = "'" + username + "'"; 
        String ps = "'" + password + "'";

        String selectQuery = "SELECT  * FROM " + TABLE_MHS+ " WHERE "
                + KEY_USERNAME + " = " + us + " AND "  + KEY_PASSWORD + " = " + ps;
        Log.d(TAG, selectQuery);
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null)
            c.moveToFirst();
      
        	Model getMHS = new Model();
        
        	getMHS.nama = c.getString(c.getColumnIndex(KEY_NAMA));
        	getMHS.nim = c.getInt(c.getColumnIndex(KEY_NIM));
        	getMHS.email = c.getString(c.getColumnIndex(KEY_EMAIL));
        	getMHS.username = c.getString(c.getColumnIndex(KEY_USERNAME));
        	getMHS.password = c.getString(c.getColumnIndex(KEY_PASSWORD));
        
        return getMHS;
    }
    
    public List<Model> getAllMenuList(String userN) {
        List<Model> MHSArrayList = new ArrayList<Model>();
    	Model MHS = new Model();
        String selectQuery = "SELECT  * FROM " + TABLE_MHS + " WHERE " + KEY_USERNAME
        		+ " = '" + userN +"'";
        Log.d(TAG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {

            	MHS.nama = c.getString(c.getColumnIndex(KEY_NAMA));
            	MHS.email = c.getString(c.getColumnIndex(KEY_EMAIL));
            	//MHS.email = c.getString(c.getColumnIndex(KEY_EMAIL));
            	//MHS.username = c.getString(c.getColumnIndex(KEY_USERNAME));
            	//MHS.password = c.getString(c.getColumnIndex(KEY_PASSWORD));

            	
                MHSArrayList.add(MHS);
            } while (c.moveToNext());
        }
        return MHSArrayList;
    }
    
    
    
    //MODUL
    //INGAT 
    //PASSWORD
    //DAN
    //USERNAME
    
    
    public long MHSingat(Model MHS) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, MHS.username);
        values.put(KEY_PASSWORD, MHS.password);
        
        long insert = db.insert(TABLE_REM, null, values);
        return insert;
    }


    public void logOut(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REM, KEY_USERNAME + " = ?",
                new String[] { String.valueOf(id) });
    }
    
    
    public List<Model> autoGet(int get) {
        List<Model> passArrayList = new ArrayList<Model>();
        Model mod = new Model();
        
        String selectQuery = "SELECT * FROM " + TABLE_REM + " WHERE " + KEY_ID
        						+ " = " +get;
        Log.d(TAG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
            	mod.username = c.getString(c.getColumnIndex(KEY_USERNAME));
                mod.password = c.getString(c.getColumnIndex(KEY_PASSWORD));
                
                passArrayList.add(mod);
            } while (c.moveToNext());
        }
        return passArrayList;
    }
}
