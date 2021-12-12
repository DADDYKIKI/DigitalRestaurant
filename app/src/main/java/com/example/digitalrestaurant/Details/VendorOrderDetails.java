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

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}