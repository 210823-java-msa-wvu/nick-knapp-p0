package models;

public class Manager extends Employee{
    public Manager(String username, String password, String paymentInfo, String email) {
        super(username, password, paymentInfo, email);
    }
    //subset of employees, managers have the ability to authorize the creation of new employee accounts

    public void CreateEmployeeAccount(String username, String password){

    }
}
