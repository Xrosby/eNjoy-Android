package domain;

import java.util.UUID;

public class ProductSpecification {

    private int productID;
    private String name;
    private String description;
    private double price;
    private int standardAmount = 1;
    private int amountInStore;

    public ProductSpecification(String name, String description, double price, int amountInStore, int productID) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStore = amountInStore;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


    public int getStandardAmount() {
        return standardAmount;
    }

    public int getAmountInStore() {
        return amountInStore;
    }
}
