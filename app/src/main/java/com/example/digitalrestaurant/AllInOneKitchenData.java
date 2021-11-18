package com.example.digitalrestaurant;

import com.example.digitalrestaurant.UserData.ItemData;

import java.io.Serializable;
import java.util.ArrayList;

public class AllInOneKitchenData implements Serializable {

    private int foodPrice, foodImage;
    private String foodName, foodNationality, kichenName, kitchenLocation;
    ArrayList<ItemData> itemDatalist;


    public AllInOneKitchenData(int foodPrice,  String foodName, String foodNationality,int foodImage) {
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.foodNationality = foodNationality;
    }

    public AllInOneKitchenData(int foodPrice, int foodImage, String foodName, String foodNationality,
                               String kichenName, String kitchenLocation, ArrayList<ItemData> itemDatalist) {
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.foodName = foodName;
        this.foodNationality = foodNationality;
        this.kichenName = kichenName;
        this.kitchenLocation = kitchenLocation;
        this.itemDatalist = itemDatalist;
    }



    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodNationality() {
        return foodNationality;
    }

    public void setFoodNationality(String foodNationality) {
        this.foodNationality = foodNationality;
    }

    public String getKichenName() {
        return kichenName;
    }

    public void setKichenName(String kichenName) {
        this.kichenName = kichenName;
    }

    public String getKitchenLocation() {
        return kitchenLocation;
    }

    public void setKitchenLocation(String kitchenLocation) {
        this.kitchenLocation = kitchenLocation;
    }

    public ArrayList<ItemData> getItemDatalist() {
        return itemDatalist;
    }

    public void setItemDatalist(ArrayList<ItemData> itemDatalist) {
        this.itemDatalist = itemDatalist;
    }
}
