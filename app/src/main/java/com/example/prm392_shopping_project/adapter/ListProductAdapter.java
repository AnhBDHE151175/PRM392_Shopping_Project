package com.example.prm392_shopping_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prm392_shopping_project.R;
import com.example.prm392_shopping_project.model.Product;

import org.w3c.dom.Text;

import java.util.List;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ProductHolder> {
    Context context;
    List<Product> listProduct;
    public ListProductAdapter(Context context, List<Product> listProduct){
        this.context = context;
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public ListProductAdapter.ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_product,parent,false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductAdapter.ProductHolder holder, int position) {
        Product product = listProduct.get(position);
        holder.prdName.setText(product.getName());
        holder.prdPrice.setText(product.getPrice()+" $/");
        holder.imgPrd.setImageResource(Integer.parseInt(product.getImageUrl()));
//        holder.quan.setText(product.getQuantity());
        holder.unit1.setText(product.getUnit());
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }
    public  static class ProductHolder extends RecyclerView.ViewHolder{

        ImageView imgPrd;
        TextView prdName;
        TextView prdPrice;
//        TextView quan;
        TextView unit1;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            imgPrd = itemView.findViewById(R.id.imgPrd);
            prdName = itemView.findViewById(R.id.prdName);
            prdPrice = itemView.findViewById(R.id.prdPrice);
//            quan = itemView.findViewById(R.id.quan);
            unit1 = itemView.findViewById(R.id.unit1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                }
            });
        }
    }
}
