package shopping;


import java.util.HashMap;

import customer.Customer;
import domain.Catalog;
import domain.ProductSpecification;

public class Webshop {

    private HashMap<Integer, ShoppingCart> shoppingCarts;
    private HashMap<Integer, Customer> customers;
    private Catalog catalog;
    private static Webshop instance;

    private Webshop() {
        this.initCatalog();
        this.initPlaceholderCart();
        this.initPlaceholderCustomer();
    }

    public static Webshop getInstance() {
        if(instance == null) {
            instance = new Webshop();
        }
        return instance;
    }



    public void addItemToBasket(String sessionID, int productID) {
        ProductSpecification specification = this.catalog.findProductSpecification(productID);
        Item newItem = new Item(specification, 1);
        this.shoppingCarts.get(1).addProduct(newItem);
        System.out.println(newItem.getProductSpecification().getName() + "  :  " + newItem.getAmount() + "  :  " + newItem.getPrice());
    }

    public void createOrder(int customerID) {
        //TODO: ?
    }

    public Customer findCustomer(int customerID) {
        return this.customers.get(customerID);
    }

    private void initCatalog(){
        this.catalog = new Catalog();
    }

    private void initPlaceholderCart() {
        this.shoppingCarts = new HashMap<>();
        this.shoppingCarts.put(1, new ShoppingCart());
    }

    private void initPlaceholderCustomer() {
        this.customers = new HashMap<>();
        this.customers.put(1, new Customer("Mads", 1));
    }





}
