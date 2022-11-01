package com.example.prm392_shopping_project.database;

import static com.example.prm392_shopping_project.database.DatabaseConfig.CUSTOMER_TABLE;
import static com.example.prm392_shopping_project.database.DatabaseConfig.PRODUCT_TABLE;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prm392_shopping_project.model.Customer;

import java.util.List;

public class CustomerDB extends AppDatabaseContext implements IGenericDB<Customer>{
    public CustomerDB(@Nullable Context context) {
        super(context);
    }

    @Override
    public long insert(Customer customer) {
        SQLiteDatabase db = super.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", customer.getCustomerId());
        values.put("email", customer.getCustomerName());
        values.put("address", customer.getAddress());
        values.put("phone", customer.getPhone());
        long count = db.insert(CUSTOMER_TABLE, null, values);
        return count;
    }

    @Override
    public long update(Customer customer) {
        return 0;
    }

    @Override
    public long delete(int id) {
        return 0;
    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public long seedingData() {
        return 0;
    }
}
