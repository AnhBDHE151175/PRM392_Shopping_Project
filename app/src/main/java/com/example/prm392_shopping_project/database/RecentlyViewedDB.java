package com.example.prm392_shopping_project.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.prm392_shopping_project.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class RecentlyViewedDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PRM392_Project";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "RecentlyView";

    private static final String KEY_ID = "Id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_DESCRIPTION = "Description";
    private static final String KEY_PRICE = "Price";
    private static final String KEY_QUANTITY = "Quantity";
    private static final String KEY_UNIT = "Unit";
    private static final String KEY_IMAGE_URL = "ImageUrl";
    private static final String KEY_BIG_IMAGE_URL = "BigImageUrl";


    public RecentlyViewedDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s INTEGER)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_DESCRIPTION, KEY_PRICE, KEY_QUANTITY, KEY_UNIT, KEY_IMAGE_URL, KEY_BIG_IMAGE_URL);
        db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTable = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(dropTable);
        onCreate(db);
    }

    public void add(RecentlyViewed recentlyViewedProduct) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, recentlyViewedProduct.getId());
        values.put(KEY_NAME, recentlyViewedProduct.getName());
        values.put(KEY_DESCRIPTION, recentlyViewedProduct.getDescription());
        values.put(KEY_PRICE, recentlyViewedProduct.getPrice());
        values.put(KEY_QUANTITY, recentlyViewedProduct.getQuantity());
        values.put(KEY_UNIT, recentlyViewedProduct.getUnit());
        values.put(KEY_IMAGE_URL, recentlyViewedProduct.getImageUrl());
        values.put(KEY_BIG_IMAGE_URL, recentlyViewedProduct.getBigimageurl());

        long save = db.insert(TABLE_NAME, null, values);
        int a = 1;
        db.close();
    }

    public List<RecentlyViewed> getAll() {
        List<RecentlyViewed> list = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            RecentlyViewed recentlyViewed = new RecentlyViewed(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getInt(6), cursor.getInt(7));
            list.add(recentlyViewed);
            cursor.moveToNext();
        }
        return list;
    }

}
