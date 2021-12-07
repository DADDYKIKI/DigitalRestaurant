package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class OrderDetails implements Serializable {

    private int totalFoodPrice,quantity;
    private String foodName,restaurantName;

    public OrderDetails(String foodName, int quantity, int totalFoodPrice,String restaurantName) {
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

    public int getTotalFoodPrice() {
        return totalFoodPrice;
    }

    public void setTotalFoodPrice(int totalFoodPrice) {
        this.totalFoodPrice = totalFoodPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
