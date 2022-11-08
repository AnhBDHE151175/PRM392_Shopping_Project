package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.prm392_shopping_project.adapter.ListProductAdapter;
import com.example.prm392_shopping_project.database.ProductDB;
import com.example.prm392_shopping_project.model.Product;

import java.util.List;

public class ListProduct extends AppCompatActivity {
    RecyclerView listProductRecyclerView;
    List<Product> listProduct;
    ProductDB productDB = new ProductDB(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product2);
        
        List<Product> getAll = productDB.getAll();
        listProductRecyclerView = findViewById(R.id.listPrd);
        ListProductAdapter adapter = new ListProductAdapter(this, getAll);
        listProductRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listProductRecyclerView.setAdapter(adapter);


    }
}