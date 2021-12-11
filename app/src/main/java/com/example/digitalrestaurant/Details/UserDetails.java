package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class UserDetails implements Serializable {

    String nameOfUser,email,password,maidenName,country;
    int age,phone;





    public UserDetails(String nameOfUser, String email, int age,int phone, String maidenName, String country, String password) {
        this.nameOfUser = nameOfUser;
        this.email = email;
        this.password = password;
        this.age = age;
        this.country=country;
        this.phone=phone;
        this.maidenName=maidenName;
    }

    public String getMaidenName() {
        return maidenName;
    }
    public void setMaideName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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
