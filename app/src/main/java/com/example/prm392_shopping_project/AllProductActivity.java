package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.prm392_shopping_project.adapter.ProductListAdapter;
import com.example.prm392_shopping_project.database.ProductDB;
import com.example.prm392_shopping_project.model.Product;

import java.util.List;

public class AllProductActivity extends AppCompatActivity implements ProductListAdapter.ProductListener {
    ProductDB db;
    RecyclerView recyclerView;
    ProductListAdapter adapter;
    List<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_product);
        db = new ProductDB(this);
        recyclerView = findViewById(R.id.recyclerProduct);
        list = db.getAll();

        adapter = new ProductListAdapter(list);
        adapter.setProductListener(this);
//        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int position) {

    }
}