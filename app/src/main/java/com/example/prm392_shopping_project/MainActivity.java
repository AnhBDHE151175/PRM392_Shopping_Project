package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_shopping_project.adapter.CategoryAdapter;
import com.example.prm392_shopping_project.adapter.DiscountedProductAdapter;
import com.example.prm392_shopping_project.adapter.RecentlyViewedAdapter;
import com.example.prm392_shopping_project.database.AppDatabaseContext;
import com.example.prm392_shopping_project.database.CategoryDB;
import com.example.prm392_shopping_project.database.ProductDB;
import com.example.prm392_shopping_project.model.Category;
import com.example.prm392_shopping_project.model.Product;
import com.example.prm392_shopping_project.model.RecentlyViewed;

import static com.example.prm392_shopping_project.R.drawable.*;
import static com.example.prm392_shopping_project.database.DatabaseConfig.PRODUCT_TABLE;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabaseContext _context;
    ProductDB productDB = new ProductDB(this);
    CategoryDB categoryDB = new CategoryDB(this);
    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<Product> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<Product> recentlyViewedList;

    TextView allCategory;
    ImageView cart,setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _context = new AppDatabaseContext(this);
        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);
        cart = findViewById(R.id.cart_main);
        setting = findViewById(R.id.setting_main);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AllCategory.class);
                startActivity(i);
            }
        });
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });
        // seedingData
        List<Category> allCategory = categoryDB.getAll();
        if (allCategory.size() == 0){
            long count = categoryDB.seedingData();
        }

        List<Product> allProduct = productDB.getAll();
        if(allProduct.size() == 0){
            productDB.seedingData();
        }

        // adding data to model
        discountedProductsList = productDB.getAll();

        // adding data to model
        categoryList = categoryDB.getAll();

        // adding data to model
        recentlyViewedList = productDB.getAll();

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }

    private void setDiscountedRecycler(List<Product> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<Product> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this, recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }


}