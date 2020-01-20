package com.example.welcome.googlemaps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "donorManager";
    private static final String TABLE_CONTACTS = "donors";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "contuctNumber";
    private static final String KEY_CITY= "city";
    private static final String KEY_BL_GRP = "bloodGroup";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LAN= "lan";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_NAME + " TEXT," + KEY_PH_NO + " TEXT,"
                + KEY_CITY + " TEXT," + KEY_BL_GRP + " TEXT," + KEY_LAT + " TEXT,"+ KEY_LAN + " TEXT"+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new contact
    void addContact(Donor donor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, donor.getName());
        values.put(KEY_PH_NO, donor.getContuctNumber());
        values.put(KEY_CITY, donor.getCity());
        values.put(KEY_BL_GRP, donor.getBloodGroup());
        values.put(KEY_LAT, donor.getLat());
        values.put(KEY_LAN, donor.getLan());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single contact
    Donor getContact(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_NAME,
                        KEY_PH_NO , KEY_CITY ,KEY_BL_GRP ,KEY_LAT ,KEY_LAN }, KEY_NAME + "=?",
                new String[] { name }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Donor donor = new Donor(cursor.getString(0),cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
        // return contact
        return donor;
    }

    // code to get all contacts in a list view
    public List<Donor> getAllDonors() {
        List<Donor> donorList = new ArrayList<Donor>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Donor donor = new Donor();
                donor.setName(cursor.getString(0));
                donor.setContuctNumber(cursor.getString(1));
                donor.setCity(cursor.getString(2));
                donor.setBloodGroup(cursor.getString(3));
                donor.setLat(cursor.getString(4));
                donor.setLan(cursor.getString(5));
                // Adding contact to list
                donorList.add(donor);
            } while (cursor.moveToNext());
        }

        // return contact list
        return donorList;
    }


    // Getting contacts Count
    public int getDonorCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
