package shopping;

import domain.ProductSpecification;

public class Item {

    private ProductSpecification productSpecification;
    private int amount;

    public Item(ProductSpecification productSpecification, int amount) {
        this.productSpecification = productSpecification;
        this.amount = amount;
    }

    public ProductSpecification getProductSpecification() {
        return productSpecification;
    }

    public double getPrice() {
        return productSpecification.getPrice() * amount;
    }

    public void addAmount(int amountIncrease) {
        this.amount += amountIncrease;
    }

    public int getAmount() {
        return this.amount;
    }


}
