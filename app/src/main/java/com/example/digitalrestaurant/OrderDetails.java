package com.example.digitalrestaurant;

import java.io.Serializable;

public class OrderDetails implements Serializable {

    private int totalFoodPrice,quantity;
    private String foodName;

    public OrderDetails(int totalFoodPrice, int quantity, String foodName) {
        this.totalFoodPrice = totalFoodPrice;
        this.quantity = quantity;
        this.foodName = foodName;
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
