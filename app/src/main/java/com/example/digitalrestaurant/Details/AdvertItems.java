package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class AdvertItems implements Serializable {

    private int price,imageURL;
    private String name, nationality,alcoholic,restaurantName;

    public AdvertItems(int price,  String name, String nationality, int imageURL,String alcoholic, String restaurantName) {
        this.price = price;
        this.imageURL = imageURL;
        this.name = name;
        this.nationality = nationality;
        this.alcoholic = alcoholic;
        this.restaurantName = restaurantName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAlcoholic() {
        return alcoholic;
    }


    public String getRestaurantName() {
        return restaurantName;
    }

    }
