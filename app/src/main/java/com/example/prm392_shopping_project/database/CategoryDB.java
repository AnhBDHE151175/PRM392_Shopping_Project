package com.example.prm392_shopping_project.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.prm392_shopping_project.model.RecentlyViewed;

public class CategoryDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PRM392_Project";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Category";

    private static final String KEY_ID = "Id";
    private static final String KEY_NAME = "Name";
    private static final String KEY_DESCRIPTION = "Description";
    private static final String KEY_PRICE = "Price";
    private static final String KEY_QUANTITY = "Quantity";


    public CategoryDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s INTEGER, %s INTEGER)", TABLE_NAME, KEY_ID, KEY_NAME, KEY_DESCRIPTION, KEY_PRICE,KEY_QUANTITY);
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTable = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(dropTable);
        onCreate(db);
    }
    //CRUD

}
