package com.example.digitalrestaurant.Details;

import java.io.Serializable;

public class AdvertItems implements Serializable {

    private int price,imageURL;
    private String name, nationality,alcoholic,pictureLabel,restaurantName;

    public AdvertItems(int price,  String name, String nationality, int imageURL,String alcoholic, String restaurantName) {
        this.price = price;
        this.imageURL = imageURL;
        this.name = name;
        this.nationality = nationality;
        this.alcoholic = alcoholic;
        this.pictureLabel = pictureLabel;
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

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
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

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getPictureLabel() {
        return pictureLabel;
    }

    public void setPictureLabel(String pictureLabel) {
        this.pictureLabel = pictureLabel;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
