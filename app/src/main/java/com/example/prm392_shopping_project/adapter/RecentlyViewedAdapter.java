package com.example.prm392_shopping_project.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_shopping_project.ProductDetails;
import com.example.prm392_shopping_project.R;
import com.example.prm392_shopping_project.model.Product;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder>{
    Context context;
    List<Product> recentlyViewedList;

    public RecentlyViewedAdapter(Context context, List<Product> recentlyViewedList) {
        this.context = context;
        this.recentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false);

        return new RecentlyViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, final int position) {

        Product product = recentlyViewedList.get(position);
        holder.name.setText(product.getName());
        holder.description.setText(product.getDescription());
        holder.price.setText(product.getPrice() + "$/");
        holder.unit.setText(product.getUnit());
        holder.discount.setText(String.valueOf(product.getDiscount()));
        holder.bg.setBackgroundResource(Integer.parseInt(recentlyViewedList.get(position).getImageUrl()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, ProductDetails.class);
                i.putExtra("id", recentlyViewedList.get(position).getId()+"");
                i.putExtra("name", recentlyViewedList.get(position).getName());
                i.putExtra("image", recentlyViewedList.get(position).getBigImageUrl());
                i.putExtra("price",recentlyViewedList.get(position).getPrice()+"");
                i.putExtra("desc",recentlyViewedList.get(position).getDescription());
                i.putExtra("unit",recentlyViewedList.get(position).getUnit());
                i.putExtra("discount",recentlyViewedList.get(position).getDiscount());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recentlyViewedList.size();
    }

    public static class RecentlyViewedViewHolder extends RecyclerView.ViewHolder{

        TextView name, description, price, discount, unit;
        ConstraintLayout bg;

        public RecentlyViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description);
            unit = itemView.findViewById(R.id.unit);
            price = itemView.findViewById(R.id.price);
            discount = itemView.findViewById(R.id.discount);
            bg = itemView.findViewById(R.id.recently_layout);

        }
    }
}
