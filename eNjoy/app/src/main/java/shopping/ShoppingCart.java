package shopping;

import java.util.ArrayList;
import java.util.Date;

import domain.ProductSpecification;

public class ShoppingCart {

    private ArrayList<Item> items;
    private Date dateRaised;

    public ShoppingCart() {
        this.items = new ArrayList<>();

    }

    public void addProduct(ProductSpecification productSpecification) {
       for(Item item: items) {
           if(item.getProductSpecification().getProductID() == productSpecification.getProductID()){
               item.addAmount(1);
           } else {
               Item newItem = new Item(productSpecification, 1);
               this.items.add(newItem);
           }
       }
    }

    public double calculateTotalPrice() {
       return -1;
       //TODO: For all items in the basket, add the price * amount to the total price
    }

    public double calculateVAT() {
        return -1;//TODO: Calculate VAT
    }

    public ArrayList<Item> createProducts() {
       return null; //TODO: Create placeholder products
    }

    public void addProduct(Item product) {
        if(product != null) {
            this.items.add(product);
        }
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }
}
