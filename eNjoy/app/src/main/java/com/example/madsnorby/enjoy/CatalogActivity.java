package com.example.madsnorby.enjoy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.madsnorby.enjoy.adapters.ProductAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import domain.ProductSpecification;

public class CatalogActivity extends AppCompatActivity {

    private ListView productListView;
    private ArrayList<ProductSpecification> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);


        ProductAdapter productAdapter = new ProductAdapter(this, this.products);
        productListView = (ListView) findViewById(R.id.productListView);
        productListView.setAdapter(productAdapter);
    }





}
