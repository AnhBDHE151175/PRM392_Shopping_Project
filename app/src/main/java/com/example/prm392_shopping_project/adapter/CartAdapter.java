package com.example.prm392_shopping_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_shopping_project.R;
import com.example.prm392_shopping_project.model.Cart;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    List<Cart> cartList;
    Context context;


    public CartAdapter(List<Cart> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(cartList.get(position).getName());
        holder.price.setText(cartList.get(position).getPrice() + " $");
        holder.quantity.setText(cartList.get(position).getQuantity() + "");
        holder.total.setText(cartList.get(position).getQuantity() * cartList.get(position).getPrice() + " $");

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView price, quantity, name, total;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_giohang_tensp);
            quantity = itemView.findViewById(R.id.item_giohang_soluong);
            total = itemView.findViewById(R.id.item_giohang_giasp2);
            price = itemView.findViewById(R.id.item_giohang_gia);
        }
    }
}
