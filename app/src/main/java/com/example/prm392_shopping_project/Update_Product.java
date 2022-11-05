package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.prm392_shopping_project.database.ProductDB;
import com.example.prm392_shopping_project.model.Product;

public class Update_Product extends AppCompatActivity {
    EditText edt_name,edt_description,edt_price,edt_unit,edt_quantity,edt_discount;
    ImageView img_imv;
    SQLiteDatabase db;
    ProductDB productDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);
        Bundle bundle= getIntent().getExtras();
        if(bundle==null) return;
        Product pro= (Product) bundle.get("object_product");
        edt_name= findViewById(R.id.edt_newname);
        edt_description= findViewById(R.id.edt_newdescription);
        edt_price= findViewById(R.id.edt_newprice);
        edt_unit= findViewById(R.id.edt_newunit);
        edt_quantity= findViewById(R.id.edt_newquantity);
        edt_discount=findViewById(R.id.edt_newdiscount);
        img_imv= findViewById(R.id.imv_newimg);

        edt_name.setText(pro.getName());
        edt_description.setText(pro.getDescription());
        edt_price.setText(String.valueOf(pro.getPrice()));
        edt_unit.setText(pro.getUnit());
        edt_quantity.setText(String.valueOf(pro.getQuantity()));
        edt_discount.setText(String.valueOf(pro.getDiscount()));
        img_imv.setImageResource(Integer.parseInt(pro.getImageUrl()));


    }

    public void onUpdate(View view) {
        Bundle bundle= getIntent().getExtras();
        if(bundle==null) return;
        Product pro= (Product) bundle.get("object_product");

        pro.setName(edt_name.getText().toString());
        pro.setDescription(edt_description.getText().toString());
        pro.setPrice(Double.valueOf(edt_price.getText().toString()));
        pro.setUnit(edt_unit.getText().toString());
        pro.setQuantity(Integer.parseInt(edt_quantity.getText().toString()));
        pro.setDiscount(Integer.parseInt(edt_discount.getText().toString()));

        productDB= new ProductDB(this);
        db = productDB.getWritableDatabase();
        productDB.update(pro);
        Toast.makeText(Update_Product.this,"Update thanh cong",Toast.LENGTH_LONG).show();
    }
}