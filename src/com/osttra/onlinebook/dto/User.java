package com.osttra.onlinebook.dto;

public class User {
    private String username;

    private String emailId;
    private String password;
    private String firstName;

    private String lastName;
    private String userType;

    //private new books
    //private fav. books
    //private completed books

    public User() {

    }
    public User(String username, String emailId, String firstName, String lastName, String password,String userType) {

        this.username = username;
        this.emailId = emailId;
        this.password=password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.password = emailId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName= lastName;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
}
