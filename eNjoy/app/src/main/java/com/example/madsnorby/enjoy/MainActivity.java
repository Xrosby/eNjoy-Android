package com.example.madsnorby.enjoy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.madsnorby.enjoy.adapters.ProductAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import domain.ProductSpecification;
import shopping.Webshop;

public class MainActivity extends AppCompatActivity {

    private ListView productListView;
    private ArrayList<ProductSpecification> products;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Webshop webshop = Webshop.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductAdapter productAdapter = new ProductAdapter(this, this.products);
        productListView = (ListView) findViewById(R.id.productListView);
        productListView.setAdapter(productAdapter);


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
