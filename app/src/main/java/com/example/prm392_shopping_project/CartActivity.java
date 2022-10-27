package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.prm392_shopping_project.adapter.CartAdapter;
import com.example.prm392_shopping_project.model.Cart;

import java.util.List;

public class CartActivity extends AppCompatActivity {
    CartAdapter cartAdapter;
    RecyclerView rcCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        rcCart = findViewById(R.id.cart_rv);
        if (MainActivity.cartList.size() != 0) {
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            cartAdapter = new CartAdapter( MainActivity.cartList,this);
            rcCart.setLayoutManager(layoutManager);
            rcCart.setAdapter(cartAdapter);
        }else{
            findViewById(R.id.cart_empty).setVisibility(View.VISIBLE);
        }

    }
    public void onCheckoutClicked(View view) {

        startActivity(new Intent(getApplicationContext(), MainActivity.class));

    }
}