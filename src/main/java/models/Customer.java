package models;

public class Customer extends User{

    public Customer(String username, String password, String paymentInfo, String email) {
        super(username, password, paymentInfo, email);
    }
}
