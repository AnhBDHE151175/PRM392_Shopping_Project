package com.example.prm392_shopping_project.database;

import static com.example.prm392_shopping_project.R.drawable.b1;
import static com.example.prm392_shopping_project.R.drawable.b2;
import static com.example.prm392_shopping_project.R.drawable.b3;
import static com.example.prm392_shopping_project.R.drawable.b4;
import static com.example.prm392_shopping_project.R.drawable.card1;
import static com.example.prm392_shopping_project.R.drawable.card2;
import static com.example.prm392_shopping_project.R.drawable.card3;
import static com.example.prm392_shopping_project.R.drawable.card4;
import static com.example.prm392_shopping_project.database.DatabaseConfig.PRODUCT_TABLE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prm392_shopping_project.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB extends AppDatabaseContext implements IGenericDB<Product>{

    @Override
    public void onCreate(SQLiteDatabase db) {
        super.onCreate(db);
    }

    public ProductDB(@Nullable Context context) {
        super(context);
    }

    @Override
    public long insert(Product product) {
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", product.getId());
        values.put("name", product.getName());
        values.put("description", product.getDescription());
        values.put("price", product.getPrice());
        values.put("quantity", product.getQuantity());
        values.put("category_id", product.getCategory().getId());
        values.put("discount", product.getDiscount());
        values.put("imageUrl", product.getImageUrl());
        values.put("bigImageUrl", product.getBigImageUrl());
        long count = db.insert(PRODUCT_TABLE, null, values);
        return count;
    }

    @Override
    public long update(Product product) {
        Product oldProduct = this.getById(product.getId());
        if (oldProduct == null) {
            return -1;
        }
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", product.getName());
        values.put("description", product.getDescription());
        values.put("price", product.getPrice());
        values.put("quantity", product.getQuantity());
        values.put("category_id", product.getCategory().getId());
        values.put("discount", product.getDiscount());
        values.put("imageUrl", product.getImageUrl());
        values.put("bigImageUrl", product.getBigImageUrl());
        long count = db.insert(PRODUCT_TABLE, null, values);
        db.close();
        return count;
    }

    @Override
    public long delete(int id) {
        SQLiteDatabase db = super.getWritableDatabase();
        long count = db.delete(PRODUCT_TABLE, "id =?", new String[]{String.valueOf(id)});

        return count;
    }

    @Override
    public Product getById(int id) {
        SQLiteDatabase db = super.getReadableDatabase();
        String query = "SELECT * FROM " + databaseConfig.PRODUCT_TABLE + " WHERE id = " + id;

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            try {
                Product product = new Product(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getString(7),
                        cursor.getString(8));
                return product;
            }
            catch (Exception ex){
                throw new RuntimeException();
            }
        }
        db.close();
        return null;
    }

    @Override
    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM Products";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            Product product = new Product(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getInt(6),
                    cursor.getString(7),
                    cursor.getString(8));
            list.add(product);
            cursor.moveToNext();
        }
        return list;
    }

    public long seedingData() {
        long count = 0;
        List<Product> list = new ArrayList<>();
        list.add(new Product("Dưa hấu", "Dưa hấu có hàm lượng nước cao và cũng cung cấp một số chất xơ.", 10, 100,1, 10, String.valueOf(card4), String.valueOf(b4)));
        list.add(new Product("Đu đủ", "Đu đủ là loại trái cây có hàm lượng dinh dưỡng cao và ít calo.", 100, 100,2, 30, String.valueOf(card3), String.valueOf(b3)));
        list.add(new Product("Dâu", "Dâu tây là một loại trái cây có giá trị dinh dưỡng cao, chứa nhiều vitamin C.", 100, 100,3, 20, String.valueOf(card2), String.valueOf(b2)));
        list.add(new Product("Kiwi", "Chứa đầy đủ các chất dinh dưỡng như vitamin C, vitamin K, vitamin E, folate và kali.", 100, 100,4, 10, String.valueOf(card1), String.valueOf(b1)));
        SQLiteDatabase db = super.getWritableDatabase();
        for (int i = 0; i < list.size(); i++) {
            Product product = list.get(i);
            ContentValues values = new ContentValues();
//            values.put("id", product.getId());
            values.put("name", product.getName());
            values.put("description", product.getDescription());
            values.put("price", product.getPrice());
            values.put("quantity", product.getQuantity());
            values.put("category_id", product.getCategoryId());
            values.put("discount", product.getDiscount());
            values.put("imageUrl", product.getImageUrl());
            values.put("bigImageUrl", product.getBigImageUrl());
            count = db.insert(PRODUCT_TABLE, null, values);
        }
        return count;
    }



}