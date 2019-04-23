package domain.shopping;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import domain.product.ProductSpecification;

public class ShoppingCart {

    private HashMap<Integer, Item> items;
    private Date dateRaised;

    public ShoppingCart() {
        this.items = new HashMap<>();

    }

    public void addProduct(ProductSpecification productSpecification, int amount) {

        if (items.size() == 0) {
            Item newItem = new Item(productSpecification, amount);
            this.items.put(productSpecification.getProductID(), newItem);
        } else {
            if (items.containsKey(productSpecification.getProductID())) {
                this.items.get(productSpecification.getProductID()).addAmount(1);
            } else {
                Item newItem = new Item(productSpecification, amount);
                this.items.put(productSpecification.getProductID(), newItem);
            }
        }
    }


    public double calculateTotalPrice() {
        double totalPrice = 0;
        for(Item item : items.values()) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
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
