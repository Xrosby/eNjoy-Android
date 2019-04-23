package domain.shopping;

import java.util.ArrayList;
import java.util.HashMap;

import domain.customer.Customer;
import domain.product.Catalog;
import domain.product.ProductSpecification;

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

    public ArrayList<ProductSpecification> getAllProducts() {
        return this.catalog.getAllProducts();
    }


    public ShoppingCart getShoppingCart(int customerId) {
        return this.shoppingCarts.get(customerId);
    }


    public void addItemToBasket(int customerID, int productID, int amount) {
        if(shoppingCarts.get(customerID) == null) {
            shoppingCarts.put(customerID, new ShoppingCart());
        }
        ProductSpecification specification = this.catalog.findProductSpecification(productID);
        this.shoppingCarts.get(customerID).addProduct(specification, amount);
    }

    public void createOrder(int customerID) {
        //TODO: Use the Customers @CustomerID's shoppingcart and initiate an order with the items
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
