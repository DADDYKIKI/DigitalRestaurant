package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class ObandeDetails implements Serializable {

    private String obandefoodName, cusName, obandetotalFoodPrice, obandequantity;
    private int phone;

    public ObandeDetails(String obandefoodName, String obandequantity,String obandetotalFoodPrice, String cusName,int phone) {
        this.obandefoodName = obandefoodName;
        this.cusName = cusName;
        this.obandetotalFoodPrice = obandetotalFoodPrice;
        this.obandequantity = obandequantity;
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

    public String getObandefoodName() {
        return obandefoodName;
    }

    public void setObandefoodName(String obandefoodName) {
        this.obandefoodName = obandefoodName;
    }


    public String getObandetotalFoodPrice() {
        return obandetotalFoodPrice;
    }

    public void setObandetotalFoodPrice(String obandetotalFoodPrice) {
        this.obandetotalFoodPrice = obandetotalFoodPrice;
    }

    public String getObandequantity() {
        return obandequantity;
    }

    public void setObandequantity(String obandequantity) {
        this.obandequantity = obandequantity;
    }
}


