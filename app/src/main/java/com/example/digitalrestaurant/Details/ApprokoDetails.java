package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class ApprokoDetails implements Serializable {

    private String approkofoodName,cusName,approkototalFoodPrice,approkoquantity;
    private int phone;

    public ApprokoDetails(String approkofoodName, String approkoquantity, String approkototalFoodPrice, String cusName,int phone) {
        this.approkofoodName = approkofoodName;
        this.cusName = cusName;
        this.approkototalFoodPrice = approkototalFoodPrice;
        this.approkoquantity = approkoquantity;
        this.phone=phone;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getApprokofoodName() {
        return approkofoodName;
    }

    public void setApprokofoodName(String approkofoodName) {
        this.approkofoodName = approkofoodName;
    }


    public String getApprokototalFoodPrice() {
        return approkototalFoodPrice;
    }

    public void setApprokototalFoodPrice(String approkototalFoodPrice) {
        this.approkototalFoodPrice = approkototalFoodPrice;
    }

    public String getApprokoquantity() {
        return approkoquantity;
    }

    public void setApprokoquantity(String approkoquantity) {
        this.approkoquantity = approkoquantity;
    }
}


