package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prm392_shopping_project.model.Cart;
import com.nex3z.notificationbadge.NotificationBadge;

public class ProductDetails extends AppCompatActivity {

    ImageView img, back, btn_cart, cart;
    TextView proName, proPrice, proDesc, proQty, proUnit;

    String id, name, price, desc, qty, unit;
    int image;
    NotificationBadge bage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent i = getIntent();

        id = i.getStringExtra("id");
        name = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.b1);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");
        unit = i.getStringExtra("unit");

        init();


        proName.setText(name);
        proPrice.setText(price + " $");
        proDesc.setText(desc);
        proQty.setText(qty);
        proUnit.setText(unit);


        img.setImageResource(image);
        if (MainActivity.cartList.size() > 0) {
            bage.setText(String.valueOf(MainActivity.cartList.size()));
        }

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetails.this, CartActivity.class);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.cartList.size() > 0) {
                    Cart productAdd = new Cart(Integer.parseInt(id), name, Double.parseDouble(price), unit, 1);
                    boolean flag = false;
                    for (int i = 0; i < MainActivity.cartList.size(); i++) {
                        if (MainActivity.cartList.get(i).getName().equals(productAdd.getName())) {
                            MainActivity.cartList.get(i).setQuantity(MainActivity.cartList.get(i).getQuantity() + 1);
                            flag = true;
                        }
                    }
                    if (!flag) {
                        MainActivity.cartList.add(productAdd);
                    }
                } else {
                    MainActivity.cartList.add(new Cart(Integer.parseInt(id), name, Double.parseDouble(price), unit, 1));
                }
                bage.setText(String.valueOf(MainActivity.cartList.size()));
                Intent i = new Intent(ProductDetails.this, CartActivity.class);
                startActivity(i);
            }
        });
    }

    public void init() {
        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.back2);
        proQty = findViewById(R.id.qty);
        proUnit = findViewById(R.id.unit);
        btn_cart = findViewById(R.id.btn_cart);
        cart = findViewById(R.id.cart);
        bage = findViewById(R.id.badge);
    }
}
