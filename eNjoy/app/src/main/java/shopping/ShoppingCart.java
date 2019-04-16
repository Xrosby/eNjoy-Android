package shopping;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import domain.ProductSpecification;

public class ShoppingCart {

    private ArrayList<Item> items;
    private Date dateRaised;

    public ShoppingCart() {
        this.items = new ArrayList<>();

    }

    public void addProduct(ProductSpecification productSpecification) {

        if (items.size() == 0) {
            Item newItem = new Item(productSpecification, 1);
            this.items.add(newItem);
        } else {
            for (Iterator<Item> iterator = items.iterator(); iterator.hasNext(); ) {
                Item item = iterator.next();
                if (item.getProductSpecification().getProductID() == productSpecification.getProductID()) {
                    item.addAmount(1);
                } else {
                    Item newItem = new Item(productSpecification, 1);
                    this.items.add(newItem);
                }
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
        return this.items;
    }
}
