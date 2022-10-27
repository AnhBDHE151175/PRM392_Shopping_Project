package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_shopping_project.adapter.CategoryAdapter;
import com.example.prm392_shopping_project.adapter.DiscountedProductAdapter;
import com.example.prm392_shopping_project.adapter.RecentlyViewedAdapter;
import com.example.prm392_shopping_project.database.RecentlyViewedDB;
import com.example.prm392_shopping_project.model.Cart;
import com.example.prm392_shopping_project.model.Category;
import com.example.prm392_shopping_project.model.DiscountedProducts;
import com.example.prm392_shopping_project.model.RecentlyViewed;

import static com.example.prm392_shopping_project.R.drawable.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecentlyViewedDB _context;


    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView allCategory;
    ImageView cart,setting;

    public static List<Cart> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _context = new RecentlyViewedDB(this);
        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);
        cart = findViewById(R.id.cart_main);
        setting = findViewById(R.id.setting_main);
        if(cartList != null){

        }else{
            cartList = new ArrayList<>();
        }

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
                Intent i = new Intent(MainActivity.this, CartActivity.class);
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

        // adding data to model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, discountberry));
        discountedProductsList.add(new DiscountedProducts(2, discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(3, discountmeat));
        discountedProductsList.add(new DiscountedProducts(4, discountberry));
        discountedProductsList.add(new DiscountedProducts(5, discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(6, discountmeat));

        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, ic_home_fruits));
        categoryList.add(new Category(2, ic_home_fish));
        categoryList.add(new Category(3, ic_home_meats));
        categoryList.add(new Category(4, ic_home_veggies));

        // adding data to model
        recentlyViewedList = new ArrayList<>();
//        RecentlyViewed item = new RecentlyViewed(1,"Dưa hấu", "Dưa hấu có hàm lượng nước cao và cũng cung cấp một số chất xơ.", 1, "1", "KG", card4, b4);
//        RecentlyViewed item2 = new RecentlyViewed(2,"Đu đủ", "Đu đủ là loại trái cây có hàm lượng dinh dưỡng cao và ít calo.", 2, "1", "KG", card3, b3);
//        RecentlyViewed item3 = new RecentlyViewed(3,"Dâu", "Dâu tây là một loại trái cây có giá trị dinh dưỡng cao, chứa nhiều vitamin C.", 3, "1", "KG", card2, b1);
//        RecentlyViewed item4 = new RecentlyViewed(4,"Kiwi", "Chứa đầy đủ các chất dinh dưỡng như vitamin C, vitamin K, vitamin E, folate và kali.", 4, "1", "PC", card1, b2);
//
//        _context.add(item);
//        _context.add(item2);
//        _context.add(item3);
//        _context.add(item4);
        recentlyViewedList = _context.getAll();









//        recentlyViewedList.add(new RecentlyViewed(1,"Dưa hấu", "Dưa hấu có hàm lượng nước cao và cũng cung cấp một số chất xơ.", "$8", "1", "KG", card4, b4));
//        recentlyViewedList.add(new RecentlyViewed("Đu đủ", "Đu đủ là loại trái cây có hàm lượng dinh dưỡng cao và ít calo.", "$5", "1", "KG", card3, b3));
//        recentlyViewedList.add(new RecentlyViewed("Dâu", "Dâu tây là một loại trái cây có giá trị dinh dưỡng cao, chứa nhiều vitamin C.", "$3", "1", "KG", card2, b1));
//        recentlyViewedList.add(new RecentlyViewed("Kiwi", "Chứa đầy đủ các chất dinh dưỡng như vitamin C, vitamin K, vitamin E, folate và kali.", "$10", "1", "PC", card1, b2));

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
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

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this,recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}