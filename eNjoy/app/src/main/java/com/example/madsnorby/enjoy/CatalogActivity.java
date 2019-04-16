package com.example.madsnorby.enjoy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.madsnorby.enjoy.adapters.ProductAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import domain.ProductSpecification;
import shopping.Webshop;

public class CatalogActivity extends AppCompatActivity {

    private RecyclerView productRecyclerView;
    private ArrayList<ProductSpecification> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initPlaceholderProducts();
        this.initListeners();
        this.initRecyclerView();
    }

    private void goToShoppingBasket() {
        Intent intent = new Intent(this, ShoppingBasketActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void initListeners() {
        Button btnGoToShoppingCart = findViewById(R.id.btnShoppingCart);
        btnGoToShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToShoppingBasket();
            }
        });

    }

    private void initRecyclerView() {
        ProductAdapter productAdapter = new ProductAdapter(this, this.products );
        productRecyclerView = findViewById(R.id.productRecyclerView);

        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.setAdapter(productAdapter);
        this.addItemDecoration();
    }

    private void addItemDecoration() {
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }



    private void initPlaceholderProducts() {
        this.products = new ArrayList<>();
        HashMap<Integer, ProductSpecification> productsMap = new HashMap<>();
        productsMap.put(1, new ProductSpecification(
                "iPhone",
                "Brand spanking new iPhone",
                100000,
                10,
                1));
        productsMap.put(2, new ProductSpecification(
                "French press",
                "Its a french press for coffee",
                50,
                3,
                2));
        productsMap.put(3, new ProductSpecification(
                "Elephant",
                "Its huge and grey and it can be yours",
                90,
                88,
                3));
        this.products.addAll(productsMap.values());
    }

}
