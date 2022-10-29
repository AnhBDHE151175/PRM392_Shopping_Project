package com.example.prm392_shopping_project.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.prm392_shopping_project.model.Category;
import com.example.prm392_shopping_project.model.RecentlyViewed;

import java.util.List;

public class CategoryDB extends AppDatabaseContext implements IGenericDB<Category> {

    public CategoryDB(@Nullable Context context) {
        super(context);
    }

    @Override
    public long insert(Category category) {
        return 0;
    }

    @Override
    public long update(Category category) {
        return 0;
    }

    @Override
    public long delete(int id) {
        return 0;
    }

    @Override
    public Category getById(int id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }
}
