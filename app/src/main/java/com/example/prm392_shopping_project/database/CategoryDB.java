package com.example.prm392_shopping_project.database;

import static com.example.prm392_shopping_project.R.drawable.b1;
import static com.example.prm392_shopping_project.R.drawable.b2;
import static com.example.prm392_shopping_project.R.drawable.b3;
import static com.example.prm392_shopping_project.R.drawable.b4;
import static com.example.prm392_shopping_project.R.drawable.card1;
import static com.example.prm392_shopping_project.R.drawable.card2;
import static com.example.prm392_shopping_project.R.drawable.card3;
import static com.example.prm392_shopping_project.R.drawable.card4;
import static com.example.prm392_shopping_project.R.drawable.ic_home_fish;
import static com.example.prm392_shopping_project.R.drawable.ic_home_fruits;
import static com.example.prm392_shopping_project.R.drawable.ic_home_meats;
import static com.example.prm392_shopping_project.R.drawable.ic_home_veggies;
import static com.example.prm392_shopping_project.database.DatabaseConfig.CATEGORY_TABLE;
import static com.example.prm392_shopping_project.database.DatabaseConfig.PRODUCT_TABLE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.prm392_shopping_project.model.Category;
import com.example.prm392_shopping_project.model.Product;
import com.example.prm392_shopping_project.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class CategoryDB extends AppDatabaseContext implements IGenericDB<Category> {

    public CategoryDB(@Nullable Context context) {
        super(context);
    }

    @Override
    public long insert(Category category) {
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", category.getName());
        values.put("imageUrl", category.getImageUrl());
        long count = db.insert(CATEGORY_TABLE, null, values);
        return count;
    }

    @Override
    public long update(Category category) {
        Category oldCategory = this.getById(category.getId());
        if (oldCategory == null) {
            return -1;
        }
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", category.getName());
        values.put("imageUrl", category.getImageUrl());
        long count = db.update(CATEGORY_TABLE, values, "id=?", new String[]{String.valueOf(oldCategory.getId())});
        return count;
    }

    @Override
    public long delete(int id) {
        SQLiteDatabase db = super.getWritableDatabase();
        long count = db.delete(CATEGORY_TABLE, "id =?", new String[]{String.valueOf(id)});
        return count;
    }

    @Override
    public Category getById(int id) {
        String query = "SELECT * FROM " + CATEGORY_TABLE + " WHERE id = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        if (cursor.moveToNext()) {
            Category category = new Category(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            return category;
        }
        return null;
    }

    @Override
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM " + CATEGORY_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Category category = new Category(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2)
            );
            list.add(category);
        }
        return list;
    }

    @Override
    public long seedingData() {
        long count = 0;
        List<Category> list = new ArrayList<>();
        list.add(new Category("Fruits", String.valueOf(ic_home_fruits)));
        list.add(new Category("Fish", String.valueOf(ic_home_fish)));
        list.add(new Category( "Meats", String.valueOf(ic_home_meats)));
        list.add(new Category( "Veggies", String.valueOf(ic_home_veggies)));
        SQLiteDatabase db = super.getWritableDatabase();
        for (int i = 0; i < list.size(); i++) {
            Category category = list.get(i);
            ContentValues values = new ContentValues();
            values.put("name", category.getName());
            values.put("imageUrl", category.getImageUrl());
            count = db.insert(CATEGORY_TABLE, null, values);
        }
        return count;
    }
}
