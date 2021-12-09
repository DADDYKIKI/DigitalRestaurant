package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class OrderDetails implements Serializable {


    private String foodName,restaurantName,totalFoodPrice,quantity;

    public OrderDetails(String foodName, String quantity, String totalFoodPrice,String restaurantName) {
        this.totalFoodPrice = totalFoodPrice;
        this.quantity = quantity;
        this.foodName = restaurantName;

    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getTotalFoodPrice() {
        return totalFoodPrice;
    }

    public void setTotalFoodPrice(String totalFoodPrice) {
        this.totalFoodPrice = totalFoodPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
