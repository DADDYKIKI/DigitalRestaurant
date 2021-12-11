package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class AdaDetails implements Serializable {

    private String adafoodName,cusName,adatotalFoodPrice,adaquantity;
    private int phone;

    public AdaDetails(String adafoodName, String adaquantity, String adatotalFoodPrice, String custName,int phone) {
        this.adafoodName = adafoodName;
        this.cusName = cusName;
        this.adatotalFoodPrice = adatotalFoodPrice;
        this.adaquantity = adaquantity;
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

    public String getAdafoodName() {
        return adafoodName;
    }

    public void setAdafoodName(String adafoodName) {
        this.adafoodName = adafoodName;
    }


    public String getAdatotalFoodPrice() {
        return adatotalFoodPrice;
    }

    public void setAdatotalFoodPrice(String adatotalFoodPrice) {
        this.adatotalFoodPrice = adatotalFoodPrice;
    }

    public String getAdaquantity() {
        return adaquantity;
    }

    public void setAdaquantity(String adaquantity) {
        this.adaquantity = adaquantity;
    }
}


