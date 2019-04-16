package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Catalog {

    private HashMap<Integer, ProductSpecification> products;

    public Catalog() {
        this.initPlaceholderProducts();
    }

    public ProductSpecification findProductSpecification(int productID) {
        return this.products.get(productID);
    }

    public Collection<ProductSpecification> getAllSpecifications() {
        return this.products.values();
    }

    private void initPlaceholderProducts() {
        this.products = new HashMap<>();
        this.products.put(1, new ProductSpecification(
                "iPhone",
                "Brand spanking new iPhone",
                100000,
                10,
                1));
        this.products.put(2, new ProductSpecification(
                "French press",
                "Its a french press for coffee",
                50,
                3,
                2));
        this.products.put(3, new ProductSpecification(
                "Elephant",
                "Its huge and grey and it can be yours",
                90,
                88,
                3));
    }
}

