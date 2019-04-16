package com.example.madsnorby.enjoy.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madsnorby.enjoy.R;

import java.util.ArrayList;

import domain.ProductSpecification;
import shopping.Webshop;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private ArrayList<ProductSpecification> products;
    private Context context;

    public ProductAdapter(Context context, ArrayList<ProductSpecification> products) {
        this.context = context;
        this.products = products;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        TextView nameTextView = view.findViewById(R.id.productName);
        TextView descriptionTextView = view.findViewById(R.id.productDescription);
        TextView priceTextView = view.findViewById(R.id.productPrice);
        Button btnAddToCart = view.findViewById(R.id.addToCart);

        return new MyViewHolder(view, nameTextView, descriptionTextView, priceTextView, btnAddToCart);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        holder.nameTextView.setText(this.products.get(position).getName());
        holder.descriptionTextView.setText(this.products.get(position).getDescription());
        holder.priceTextView.setText(String.valueOf(this.products.get(position).getPrice()) + " kr");
    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView descriptionTextView;
        private TextView priceTextView;
        private Button addToCart;

        public MyViewHolder(View itemView, TextView nameTextView, TextView descriptionTextView, TextView priceTextView, Button addToCart) {
            super(itemView);
            this.nameTextView = nameTextView;
            this.descriptionTextView = descriptionTextView;
            this.priceTextView = priceTextView;
            this.addToCart = addToCart;

            this.addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    int productSpecificationID = ProductAdapter.this.products.get(position).getProductID();
                    Webshop.getInstance().addItemToBasket(1, productSpecificationID);

                    String addMessage = ProductAdapter.this.products.get(position).getName() + " has been added to your basket";
                    backgroundToast(context, addMessage);

                }

            });


        }

        public void backgroundToast(final Context context,final String msg) {
            if (context != null && msg != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {

                    @Override
                    public void run() {
                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }
}