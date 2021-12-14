package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class UserDetails implements Serializable {

    String nameOfUser,email,password,maidenName,country, age,phone;



    public UserDetails(String nameOfUser, String email, String age,String phone, String maidenName, String country, String password) {
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

    public String getCountry() {
        return country;
    }

    public String getPhone() {
        return phone;
    }

    public String getNameOfUser() {
        return nameOfUser;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
