package com.example.madsnorby.enjoy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madsnorby.enjoy.adapters.CartItemAdapter;

import shopping.Item;
import shopping.ShoppingCart;
import shopping.Webshop;

public class ShoppingBasketActivity extends AppCompatActivity {

    private ShoppingCart shoppingCart;
    private RecyclerView cartItemRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_basket);

        this.initListeners();
        this.initShoppingCart();
        this.setTotalPrice();
        this.initRecyclerView();



    }


    private void initListeners() {

        Button btnGoToCatalog = findViewById(R.id.btnGoToCatalog);

        btnGoToCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToShoppingCatalog();
            }
        });

    }

    private void initRecyclerView() {
        CartItemAdapter cartItemAdapter = new CartItemAdapter(this, this.shoppingCart.getItems());
        cartItemRecyclerView = findViewById(R.id.cartItemRecyclerView);
        cartItemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartItemRecyclerView.setAdapter(cartItemAdapter);
        addItemDecoration();
    }

    private void addItemDecoration() {
        this.cartItemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.cartItemRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void setTotalPrice() {
        TextView totalPriceTextView = this.findViewById(R.id.totalPrice);
        double totalPriceValue = this.shoppingCart.calculateTotalPrice();
        String totalPriceString = "";
        if(totalPriceValue == -1) {
            totalPriceString = "Needs implementation!";
        } else {
            totalPriceString = String.valueOf(totalPriceValue);
        }
        totalPriceTextView.setText(totalPriceString);
    }


    private void goToShoppingCatalog() {
        Intent intent = new Intent(this, CatalogActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initShoppingCart() {
        Webshop webshop = Webshop.getInstance();
        this.shoppingCart = webshop.getShoppingCart(1);

        for(Item item: this.shoppingCart.getItems()) {
            Log.d("Shoppingcart", item.getProductSpecification().getName() + " Er blevet fundet i indkøbskurven");
        }

    }
}
