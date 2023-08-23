package com.osttra.onlinebook.service;


import com.osttra.onlinebook.dto.User;
import com.osttra.onlinebook.dao.UserDAO;

import java.util.Scanner;
import java.util.List;
public class UserService {

    Scanner sc = new Scanner(System.in);

    UserDAO userDAO = new UserDAO();

    public void register() {

        System.out.println("Enter your Username:");
        String username = sc.next();

        System.out.println("Enter your EmailId:");
        String emailId = sc.next();

        System.out.println("Enter your FirstName:");
        String firstName = sc.next();

        System.out.println("Enter your LastName:");
        String lastName = sc.next();


        System.out.println("Enter your Password:");
        String password = sc.next();

        System.out.println("Enter your Usertype:");
        String usertype = sc.next();


        User user = new User(username,emailId,firstName,lastName,password,usertype);

        userDAO.addUser(user);
    }
   public static String userName;
    public int login() {

        int loginStatus = -1;

        System.out.println("Enter your Username!!");
        userName = sc.next();

        System.out.println("Enter your password!!");
        String password = sc.next();

        User user = userDAO.getUser(userName, password);

        if (user != null) {
            if (user.getUserType().equals("normal")) {
                loginStatus=1;

            } else {
                loginStatus=2;
            }

        }
        return loginStatus;
    }
    public void getUsers(){
        List<User> users=userDAO.getUserDetails();
        for(User user:users){
           // System.out.println(user);
                System.out.println("User name :"+user.getUsername());
                System.out.println("Email :"+user.getEmailId());
                System.out.println("First name: "+user.getFirstName());
                System.out.println("Last name: "+user.getLastName());
                System.out.println("Password :"+user.getPassword());
                System.out.println("Usertype :"+user.getUserType());
            System.out.println("------------------");
        }
    }


}