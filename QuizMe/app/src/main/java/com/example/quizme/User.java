package com.example.quizme;

public class User {
    private String email , name , pass ,referCode;
    private long coins = 25;

    public User() {
    }

    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }



    public User(String name,String email, String pass, String referCode) {
        this.email = email;
        this.name = name;
        this.pass = pass;
        this.referCode = referCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }
}
