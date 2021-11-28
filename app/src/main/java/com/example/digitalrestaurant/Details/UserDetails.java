package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class UserDetails implements Serializable {

    String nameOfUser,email,password;
    int age;

    public UserDetails(String nameOfUser, String email, int age, String password) {
        this.nameOfUser = nameOfUser;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
