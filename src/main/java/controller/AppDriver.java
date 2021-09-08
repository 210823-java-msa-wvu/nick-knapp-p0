package controller;

import java.util.Scanner;

public class AppDriver {
    public static Scanner scanner = new Scanner(System.in);

    //private static UserServices userServices = new UserServices();

    public void mainMenu(){
        //prints main menu
    }

    public void loginMenu(){
        //prints login menu
    }

    public void customerMenu(){

    }

    public void employeeMenu(){

    }

    public void managerMenu(){

    }


    public static void main(String[] args) {

        System.out.println("Welcome to the Online Audio Electronics Shop!\nPlease choose an option below");
        System.out.println("1. Login\n2. Create Account \n3. View Merchandise \n4. Quit");

        int input = scanner.nextInt();
        //validate input: must be 1, 2, or 3.

        switch (input) {

            case 1: {
                // calling this once to clear anything in the input stream
                scanner.nextLine();

                System.out.println("Please enter your username: ");
                String username = scanner.nextLine();

                System.out.println("Please enter your password: ");
                String password = scanner.nextLine();//figure out how to get *** for the password input

                // We need a login service to check if username and password match credentials stored in the database
                //boolean signInResponse = userServices.login(username, password);

                /*if (signInResponse) {
                    System.out.println("Successfully logged in...");
                } else {
                    System.out.println("Credentials do not match. ");
                }*/
                break;
            }
            case 2: {
                //create new account4
                break;
            }
            case 3:{
                //print merchandise
                //print menu
            }
            case 4: {
                System.out.println("Program terminated.");
            }
        }


        scanner.close();

    }
}

