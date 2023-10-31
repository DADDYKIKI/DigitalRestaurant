package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class VendorOrderDetails implements Serializable {

    private String foodName, cusName, totalFoodPrice, quantity,phone;


    public VendorOrderDetails(String foodName, String cusName, String totalFoodPrice, String quantity, String phone) {
        this.foodName = foodName;
        this.cusName = cusName;
        this.totalFoodPrice = totalFoodPrice;
        this.quantity = quantity;
        this.phone = phone;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getCusName() {
        return cusName;
    }

    public String getTotalFoodPrice() {
        return totalFoodPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPhone() {
        return phone;
    }
}