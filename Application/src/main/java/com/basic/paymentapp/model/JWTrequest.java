package com.basic.paymentapp.model;


public class JWTrequest {

    private String username;
    private String password;

    public JWTrequest() {
    }

    @Override
    public String toString() {
        return "JWTrequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public JWTrequest(String username, String password) {
        this.username = username;
        this.password = password;
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
}
