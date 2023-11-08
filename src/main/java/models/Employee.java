package models;

public class Employee extends Customer{
    public Employee(String username, String password, String paymentInfo, String email) {
        super(username, password, paymentInfo, email);
    }
    //Employee class has same functionality as customer, i.e. ability to purchase items
    //additional functionality, exclusive to Employee class: add/remove inventory, change prices, employee discount

}
