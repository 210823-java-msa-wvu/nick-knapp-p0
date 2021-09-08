package services;

import repositories.UserRepo;

public class UserServices {
    //login
    //by products
    //edit inventory (employees only)
    UserRepo userRepo = new UserRepo();
/*
    public boolean login(String username, String password) {

        // in order to log in a user, we will need username and password
        // that information is stored in our database
        // the repository layer needs to take care of this

        User u = userRepo.getByUsername(username); // more of the Sole Responsibility Principle at work

        // check to make sure User object is not null
        if (u != null) {
            // now check to make sure it matches
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
*/
}
