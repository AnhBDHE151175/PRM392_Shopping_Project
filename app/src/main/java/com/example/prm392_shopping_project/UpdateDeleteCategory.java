package com.example.prm392_shopping_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.prm392_shopping_project.model.Category;

public class UpdateDeleteCategory extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_category);
        tv = findViewById(R.id.tem);
        Intent intent = getIntent();
        String name = (String) intent.getSerializableExtra("name");
        int id = (int) intent.getSerializableExtra("id");
        String img = (String) intent.getSerializableExtra("image");
        tv.setText("Name: " +name +"/id: " + id + "/Anh: " +img);
    }
}