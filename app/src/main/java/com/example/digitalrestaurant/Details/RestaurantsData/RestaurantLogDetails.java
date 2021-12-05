package com.example.digitalrestaurant.Details.RestaurantsData;

import java.io.Serializable;

public class RestaurantLogDetails implements Serializable {

    String RestaurantName,email,password;

    public RestaurantLogDetails(String restaurantName, String email, String password) {
        RestaurantName = restaurantName;
        this.email = email;
        this.password = password;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
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
}
