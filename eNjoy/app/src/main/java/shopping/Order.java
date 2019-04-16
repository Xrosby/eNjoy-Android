package shopping;

import java.util.ArrayList;
import java.util.Date;

import customer.Payment;

public class Order {

    private int orderNumber;
    private double shippingPrice;
    private double membershipDiscount;
    private int earnedPoints;
    private Payment payment;
    private Date dateRaised;
    private Date dateShipped;
    private Date[] dateCancelled;
    private ArrayList<Item> orderItems;

    public Order(ShoppingCart shoppingCart) {
        this.orderItems = shoppingCart.getItems();
        this.dateRaised = new Date();
    }

    public void confirm() {
        //TODO: Should confirm validity of the payment and set the status to confirmed
    }

    public void pay() {
        //TODO: Should handle the payment of the items and set the status to payed
    }

    public void makePending() {
        //TODO: Should set the status to pending
    }

    public void ship() {
        //TODO: Should initiate the shipping process and set the status to shipped when finished
    }

    public void cancel() {
        //TODO: Should cancel the order process and set the status to cancelled
    }

    public double calculateVAT() {
        return -1; //TODO: Should calculate and return the VAT
    }

    public double calculateTotalPrice() {
        return -1; //TODO: Should calculate the total price of each items price * amount in the orderItems list, and return it
    }

    public ArrayList<Item> getOrderItems() {
        return this.orderItems;
    }

    public int getEarnedPoints() {
        return this.earnedPoints;
    }

}
