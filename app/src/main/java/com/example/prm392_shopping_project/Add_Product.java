package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prm392_shopping_project.database.CategoryDB;
import com.example.prm392_shopping_project.database.ProductDB;
import com.example.prm392_shopping_project.model.Category;
import com.example.prm392_shopping_project.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Add_Product extends AppCompatActivity {
    ProductDB productDB;
    CategoryDB categoryDB;
    EditText edt_name,edt_description,edt_price,edt_unit,edt_quantity,edt_discount;
    ImageView img;
    Spinner spinner_category;
    int id_cate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        edt_name=findViewById(R.id.edt_addname);
        edt_description=findViewById(R.id.edt_adddescription);
        edt_price=findViewById(R.id.edt_addprice);
        edt_unit=findViewById(R.id.edt_addunit);
        edt_quantity=findViewById(R.id.edt_addquantity);
        edt_discount=findViewById(R.id.edt_adddiscount);
        spinner_category=findViewById(R.id.spinner_category);
//
        categoryDB = new CategoryDB(this);
        List<String> listNameCategory= categoryDB.getNameCategory();
        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_spinner_item,listNameCategory);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_category.setAdapter(arrayAdapter);
//
        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
             id_cate= categoryDB.getIdbyName(listNameCategory.get(position));
             Toast.makeText(Add_Product.this,""+id_cate,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(Add_Product.this,"You need select Category",Toast.LENGTH_LONG).show();
            }
        } );

    }

    public void addProduct(View view) {

        String name = edt_name.getText().toString();
        String description=edt_description.getText().toString();
        Double price =Double.valueOf(edt_price.getText().toString()) ;
        int quantity = Integer.parseInt(edt_quantity.getText().toString());
        String unit = edt_unit.getText().toString();
        int discount = Integer.parseInt(edt_discount.getText().toString());
        String imgUrl= String.valueOf(R.drawable.ic_launcher_background);
        String bigImgUrl=String.valueOf(R.drawable.ic_launcher_background);

        Product p= new Product(name,description,price,quantity,unit,id_cate,discount,imgUrl,bigImgUrl);
        productDB = new ProductDB(this);
        productDB.insert(p);
        Toast.makeText(Add_Product.this,p.getName(),Toast.LENGTH_LONG).show();

    }
}