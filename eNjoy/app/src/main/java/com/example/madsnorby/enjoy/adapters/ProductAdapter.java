package com.example.madsnorby.enjoy.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madsnorby.enjoy.R;

import java.util.ArrayList;

import domain.ProductSpecification;

public class ProductAdapter extends ArrayAdapter {

    private final Activity context;
    private ArrayList<ProductSpecification> products;

    public ProductAdapter(Activity context, ArrayList<ProductSpecification> products) {

        super(context, R.layout.item_product);

        this.context = context;
        this.products = products;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View productView=inflater.inflate(R.layout.item_product, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) productView.findViewById(R.id.productName);
        TextView descriptionTextField = (TextView) productView.findViewById(R.id.productDescription);
        TextView priceField= (TextView) productView.findViewById(R.id.productPrice);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(products.get(position).getName());
        descriptionTextField.setText(products.get(position).getDescription());
        priceField.setText(String.valueOf(products.get(position).getPrice()));

        return productView;

    };
}


