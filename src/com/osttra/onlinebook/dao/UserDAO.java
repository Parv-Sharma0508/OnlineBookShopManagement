package com.osttra.onlinebook.dao;

import com.osttra.onlinebook.dto.User;
import com.osttra.onlinebook.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {
    public void addUser(User user) {

        try {

            Connection con = DbUtils.getConnection();

            PreparedStatement statement = con.prepareStatement("insert into user values(?,?,?,?,?,?)");

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmailId());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5,user.getPassword());
            statement.setString(6,user.getUserType());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
    public User getUser(String username, String password) {
        User user = null;

        try {

            Connection conn = DbUtils.getConnection();

            PreparedStatement statement = conn.prepareStatement("select * from user where user_id = ? and password = ?");

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if( resultSet.next()) {

                String uname = resultSet.getString(1);
                String email = resultSet.getString(2);
                String firstname = resultSet.getString(3);
                String lastname = resultSet.getString(4);
                String pssword = resultSet.getString(5);
                String usertype = resultSet.getString(6);

                user = new User(uname, email, firstname, lastname,pssword,usertype);
            }

        } catch (Exception e) {
            System.out.println("inside catch of add() of UserDAO...");
            System.out.println(e);
        }
        return user;
    }
    public List<User> getUserDetails(){
         ResultSet resultSet=null;
        ArrayList<User> users=new ArrayList<User>();
        try {

            Connection conn = DbUtils.getConnection();

            PreparedStatement statement = conn.prepareStatement("select * from user");

            resultSet = statement.executeQuery();

            while( resultSet.next()) {

                String uname = resultSet.getString(1);
                String email = resultSet.getString(2);
                String firstname = resultSet.getString(3);
                String lastname = resultSet.getString(4);
                String pssword = resultSet.getString(5);
                String usertype = resultSet.getString(6);
                User user=new User(uname,email,firstname,lastname,pssword,usertype);
                users.add(user);
//               System.out.print("User name :"+uname);
//                System.out.print("Email :"+email);
//                System.out.print("First name: "+firstname);
//                System.out.print("Last name: "+lastname);
//                System.out.print("Password :"+pssword);
//                System.out.print("Usertype :"+usertype);
//                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println("inside catch of getUserDetails() of UserDAO...");
            e.printStackTrace();
        }
        return  users;

    }

}

