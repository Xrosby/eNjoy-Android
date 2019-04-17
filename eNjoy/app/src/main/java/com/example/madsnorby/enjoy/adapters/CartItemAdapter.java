package com.example.madsnorby.enjoy.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.madsnorby.enjoy.R;

import java.util.ArrayList;
import domain.shopping.Item;


public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.MyViewHolder> {

    private ArrayList<Item> items;
    private Context context;

    public CartItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public com.example.madsnorby.enjoy.adapters.CartItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_product, parent, false);
        TextView nameTextView = view.findViewById(R.id.productName);
        TextView priceTextView = view.findViewById(R.id.productPrice);
        TextView amountTextView = view.findViewById(R.id.cartItemAmount);

        return new com.example.madsnorby.enjoy.adapters.CartItemAdapter.MyViewHolder(view, nameTextView, priceTextView, amountTextView);
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.madsnorby.enjoy.adapters.CartItemAdapter.MyViewHolder holder, int position) {
        holder.amountTextView.setText(String.valueOf(this.items.get(position).getAmount()));
        holder.nameTextView.setText(this.items.get(position).getProductSpecification().getName());
        holder.priceTextView.setText(String.valueOf(this.items.get(position).getPrice()) + " kr");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView priceTextView;
        private TextView amountTextView;

        public MyViewHolder(View itemView, TextView nameTextView, TextView priceTextView, TextView amountTextView) {
            super(itemView);
            this.amountTextView = amountTextView;
            this.nameTextView = nameTextView;
            this.priceTextView = priceTextView;
        }


    }
}

