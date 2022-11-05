package com.example.prm392_shopping_project.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_shopping_project.R;
import com.example.prm392_shopping_project.UDProductActivity;
import com.example.prm392_shopping_project.model.Category;
import com.example.prm392_shopping_project.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    List<Product> products;
    private Context context;
    private ProductListener ProductListener;

    public ProductAdapter( Context context, List<Product> products) {
        this.products = products;
        this.context = context;
    }

    public ProductAdapter(ProductAdapter.ProductListener productListener) {
        ProductListener = productListener;
    }

    public ProductAdapter.ProductListener getProductListener() {
        return ProductListener;
    }
    public Product getProductAt (int position) {
        return products.get(position);
    }

    public void setProductListener(ProductAdapter.ProductListener productListener) {
        ProductListener = productListener;
    }

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        final Product p= products.get(position);
        holder.img.setImageResource(Integer.parseInt(p.getImageUrl()));
        holder.tv_name.setText(p.getName());
        holder.tv_description.setText(p.getDescription());
        holder.tv_price.setText(String.valueOf(p.getPrice()));
        holder.tv_unit.setText(p.getUnit());
        holder.tv_quantity.setText(String.valueOf(p.getQuantity()));
        holder.tv_discount.setText(String.valueOf(p.getDiscount()));

    }
    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView img;
        TextView tv_name, tv_description, tv_price, tv_unit, tv_quantity, tv_discount;
        CardView layoutItem;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_quantity = itemView.findViewById(R.id.tv_quantity);
            tv_unit = itemView.findViewById(R.id.tv_unit);
            tv_discount = itemView.findViewById(R.id.tv_discount);
            layoutItem = itemView.findViewById(R.id.layout_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (ProductListener != null) {
                ProductListener.onItemClick(view, getAdapterPosition());
            }
        }

    }
    public interface ProductListener {
        void onItemClick(View view, int position);

    }
}


