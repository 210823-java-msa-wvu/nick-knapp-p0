package services;

public class OrderRequestException extends Exception{
    String message;
    OrderRequestException (String str){
        message = str;
    }
    public String toString() {
        return ("Order Request Exception occurred: " + message);
    }
}
