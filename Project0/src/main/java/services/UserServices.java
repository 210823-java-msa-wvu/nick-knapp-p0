package services;

import models.Item;
import models.User;
import repositories.ItemRepo;
import repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServices {
    //login
    //buy products
    //edit inventory (employees only)

    public static Scanner scanner = new Scanner(System.in);


    UserRepo userRepo = new UserRepo();
    ItemRepo itemRepo = new ItemRepo();

    public User login(String username, String password) {


        User u = userRepo.getByUsername(username);
        return u;

        // check to make sure User object is not null
        /*if (u != null) {
            // now check to make sure it matches
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;*/
    }
    //display user menu, different for each type of user
    public int displayUserMenu(User u){

        if (u.getType()=="Customer") {
            boolean x = true;
            while (x) {
                System.out.println("Welcome User, please choose an option below.");
                System.out.println("1. Log Out\n2. View Profile \n3. View Merchandise \n4. Log Out and Quit");
                int input = scanner.nextInt();
                if (input == 1 || input == 2) {
                    //x = false;
                    return input;
                }
                if (input == 3 || input == 4) {
                    //x = false;
                    return input;
                }
                if (input != 1 && input != 2) {
                    if (input != 3 && input != 4) {
                        System.out.println("Please enter either 1, 2, 3, or 4 to choose an option.");
                        //x = true;
                        //input = scanner.nextInt();
                    }
                }
            }
        }
        if (u.getType()=="Employee") {
            boolean x = true;
            while (x) {
                System.out.println("Welcome User, please choose an option below.");
                System.out.println("1. Log Out\n2. View Profile \n3. View Merchandise \n4. Edit Merchandise \n5. Log Out and Quit");
                int input = scanner.nextInt();
                int[] ints = {1,2,3,4,5};
                for (int i: ints){
                    if (input == i){
                        return input;
                    }
                }
                System.out.println("Please enter either 1, 2, 3, 4, or 5 to choose an option.");
                /*
                if (input == 1 || input == 2) {
                    //x = false;
                    return input;
                }
                if (input == 3 || input == 4) {
                    //x = false;
                    return input;
                }
                if (input != 1 && input != 2) {
                    if (input != 3 && input != 4) {
                        System.out.println("Please enter either 1, 2, 3, or 4 to choose an option.");
                        //x = true;
                        //input = scanner.nextInt();
                    }
                }*/
            }
        }
        return 0;

    }

    //view profile
    public int viewProfile(User u){
        if (u.getType()=="Customer") {
            boolean x = true;
            while (x) {
                System.out.println("Profile for" + u.getUsername());
                System.out.println("1. Back\n2. View Order History \n3. View Shopping Cart \n4. Log Out and Quit");
                int input = scanner.nextInt();
                if (input == 4){
                    return 4;
                }
                int[] ints = {1,2,3,4};
                for (int i: ints){

                    if (input == i){
                        return input;
                    }
                }
                System.out.println("Please enter either 1, 2, 3, 4, or 5 to choose an option.");

            }
        }
        /*if (u.getType()=="Employee") {
            boolean x = true;
            while (x) {
                System.out.println("Welcome User, please choose an option below.");
                System.out.println("1. Log Out\n2. View Profile \n3. View Merchandise \n4. Edit Merchandise \n5. Log Out and Quit");
                int input = scanner.nextInt();
                int[] ints = {1,2,3,4,5};
                for (int i: ints){
                    if (input == i){
                        return input;
                    }
                }
                System.out.println("Please enter either 1, 2, 3, 4, or 5 to choose an option.");
                /*
                if (input == 1 || input == 2) {
                    //x = false;
                    return input;
                }
                if (input == 3 || input == 4) {
                    //x = false;
                    return input;
                }
                if (input != 1 && input != 2) {
                    if (input != 3 && input != 4) {
                        System.out.println("Please enter either 1, 2, 3, or 4 to choose an option.");
                        //x = true;
                        //input = scanner.nextInt();
                    }
                }
            }
        }*/
        return 0;

    }
    //buy products
    public int printMerch(){
        //print all items in database
        System.out.println("Item ID | Item Name | Item Specifications | Quantity Available | Price per Unit");
        List<Item> listI = itemRepo.getAll();
        for (Item it : listI){
            System.out.println("\n" + it.getItemID() + "|" +
                    it.getItemName() + "|" +
                    it.getItemSpecs() + "|" +
                    it.getNumInStock() + "| $" +
                    it.getItemPrice());
        }
        System.out.println("Enter item ID to order item. Enter multiple values to order multiple items.  " +
                "\nEnter the item ID more than once to get multiple of the same item." +
                "\nEnter 0 to place order.  Enter -1 to quit without placing order.");
        try{
            ArrayList<Integer> items = new ArrayList<Integer>();
            boolean c = true;
            while(c) {

                int input = scanner.nextInt();
                items.add(input);
                if (input == 0){
                    c = false;
                }
                if (input == -1){
                    return -1;
                }

            }
            for (Integer itemID : items){
                //remove 1 from inventory
                //int itemID = itemID;
                Item it = itemRepo.getById(itemID);
                int n = it.getNumInStock();
                int m = n - 1;
                it.setNumInStock(m);
                itemRepo.update(it);
                //add record to order history


            }

            /*
            if (input == 4){
                return 4;
            }
            int[] ints = {1,2,3,4};
            for (int i: ints){

                if (input == i){
                    return input;
                }
            }*/
            throw new OrderRequestException("Invalid input.");
        } catch (OrderRequestException e){
            System.out.println(e);
        }
        return -99;

        //not enough inventory exception
    }
    //update database
    //reduce quantity of item, add transaction to order history

    //edit inventory: add or update 'items' table in database
}
