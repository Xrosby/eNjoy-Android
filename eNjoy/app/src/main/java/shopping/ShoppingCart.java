package shopping;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import domain.ProductSpecification;

public class ShoppingCart {

    private HashMap<Integer, Item> items;
    private Date dateRaised;

    public ShoppingCart() {
        this.items = new HashMap<>();

    }

    public void addProduct(ProductSpecification productSpecification) {

        if (items.size() == 0) {
            Item newItem = new Item(productSpecification, 1);
            this.items.put(productSpecification.getProductID(), newItem);
        } else {
            if (items.containsKey(productSpecification.getProductID())) {
                this.items.get(productSpecification.getProductID()).addAmount(1);
            } else {
                Item newItem = new Item(productSpecification, 1);
                this.items.put(productSpecification.getProductID(), newItem);
            }
        }
    }


    public double calculateTotalPrice() {
        return -1;
        //TODO: For all items in the basket, add the price of the Item to the total price
    }

    public double calculateVAT() {
        return -1;//TODO: Calculate VAT
    }


    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.addAll(this.items.values());
        return items;
    }
}
