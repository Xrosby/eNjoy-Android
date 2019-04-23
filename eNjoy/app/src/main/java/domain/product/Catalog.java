package domain.product;

import java.util.ArrayList;
import java.util.HashMap;

public class Catalog {

    private HashMap<Integer, ProductSpecification> products;

    public Catalog() {
        this.initPlaceholderProducts();
    }

    public ProductSpecification findProductSpecification(int productID) {
        return this.products.get(productID);
    }

    public ArrayList<ProductSpecification> getAllProducts() {
        ArrayList<ProductSpecification> productList = new ArrayList<>();
        productList.addAll(this.products.values());
        return productList;
    }


    private void initPlaceholderProducts() {
        this.products = new HashMap<>();
        this.products.put(1, new ProductSpecification(
                "Three Body Problem",
                "Probably the best book ever written. Written by Liu Cixin",
                249,
                10,
                1));
        this.products.put(2, new ProductSpecification(
                "Arcade Fire - Everything Now",
                "2017 album by Arcade Fire",
                100,
                3,
                2));
        this.products.put(3, new ProductSpecification(
                "The Dark Forest",
                "Second book in the Three Body trilogy. Arguably even better than the first. Written by Liu Cixin",
                349,
                10,
                3));
        this.products.put(4, new ProductSpecification(
                "Death's End",
                "Third book in the Three Body trilogy. Written by Liu Cixin",
                349,
                7,
                4));
        this.products.put(5, new ProductSpecification(
                "Feist - Metals",
                "2011 album by Feist",
                199,
                3,
                5));
    }
}

