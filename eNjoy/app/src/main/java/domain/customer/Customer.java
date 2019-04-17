package domain.customer;

public class Customer {

    private Membership membership;
    private String name;
    private int customerID;
    private String email;
    private CreditCard creditCard;

    public Customer(String name, int id) {
        this.name = name;
        this.customerID = id;
    }


    public String getName() {
        return this.name;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.customerID;
    }
}
