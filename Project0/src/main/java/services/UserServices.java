package services;

import models.User;
import repositories.UserRepo;

public class UserServices {
    //login
    //buy products
    //edit inventory (employees only)


    UserRepo userRepo = new UserRepo();

    public boolean login(String username, String password) {


        User u = userRepo.getByUsername(username);

        // check to make sure User object is not null
        if (u != null) {
            // now check to make sure it matches
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
    //buy products
    //update database
    //reduce quantity of item, add transaction to order history

    //edit inventory: add or update 'items' table in database
}
