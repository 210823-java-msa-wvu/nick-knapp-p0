package models;

public class User {

    String username;
    String password;
    String accountID;
    String paymentInfo;
    String email;

    public User(String username, String password, String paymentInfo, String email) {
        this.username = username;
        this.password = password;
        this.paymentInfo = paymentInfo;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
