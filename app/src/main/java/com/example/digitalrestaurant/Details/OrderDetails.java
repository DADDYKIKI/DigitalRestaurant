package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class OrderDetails implements Serializable {


    private String foodName,restaurantName,totalFoodPrice,quantity;

    public OrderDetails(String foodName, String quantity, String totalFoodPrice,String restaurantName) {
        this.totalFoodPrice = totalFoodPrice;
        this.quantity = quantity;
        this.foodName = foodName;
        this.restaurantName = restaurantName;

    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getTotalFoodPrice() {
        return totalFoodPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getFoodName() {
        return foodName;
    }
}
