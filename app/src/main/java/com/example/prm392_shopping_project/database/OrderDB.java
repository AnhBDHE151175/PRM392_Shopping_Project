package com.example.prm392_shopping_project.database;

import static com.example.prm392_shopping_project.database.DatabaseConfig.CUSTOMER_TABLE;
import static com.example.prm392_shopping_project.database.DatabaseConfig.ORDER_TABLE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prm392_shopping_project.model.Order;

import java.util.List;

public class OrderDB extends AppDatabaseContext implements IGenericDB<Order>{
    public OrderDB(@Nullable Context context) {
        super(context);
    }

    @Override
    public long insert(Order order) {
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("order_date", order.getOrderDate().toString());
        values.put("total_bill", order.getTotalBill());
        values.put("customer_id", order.getCustomerId());
        long count = db.insert(ORDER_TABLE, null, values);
        return count;
    }
    public int getMaxId(){
        SQLiteDatabase db = super.getReadableDatabase();
        String sql = "SELECT * FROM "+ORDER_TABLE+" ORDER BY id DESC LIMIT 1";
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToFirst()) {
            try {
                int a = cursor.getInt(0);
                return a;
            }
            catch (Exception ex){
                throw new RuntimeException();
            }
        }
        db.close();
        return 0;

    }

    @Override
    public long update(Order order) {
        return 0;
    }

    @Override
    public long delete(int id) {
        return 0;
    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public long seedingData() {
        return 0;
    }
}