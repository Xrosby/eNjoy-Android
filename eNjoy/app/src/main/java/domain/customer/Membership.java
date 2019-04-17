package domain.customer;

import java.util.Date;

public class Membership {

    private Date registrationDate;
    private int points;

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void subtractPoints(int points) {
        this.points -= points;
    }
}
