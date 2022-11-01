package com.example.prm392_shopping_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyConfirm extends AppCompatActivity {

    EditText ed_name, ed_phone, ed_email, ed_address;
    TextView confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_confirm);
        init();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed_name.getText().toString();
                String phone = ed_phone.getText().toString();
                String email = ed_email.getText().toString();
                String address = ed_address.getText().toString();
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(email) && TextUtils.isEmpty(address)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
                    builder.setTitle("Thông báo");
                    builder.setMessage("Xin vui lòng nhập đầy đủ thông tin.");
                    builder.show();

                } else {
                    Intent i = new Intent(getApplicationContext(), CartActivity.class);
                    startActivity(i);
                }


            }
        });
    }

    public void init() {
        ed_name = findViewById(R.id.ed_ten);
        ed_phone = findViewById(R.id.ed_sodienthoai);
        ed_email = findViewById(R.id.ed_email);
        ed_address = findViewById(R.id.ed_diachi);
        confirm = findViewById(R.id.txt_dathang);
    }
}