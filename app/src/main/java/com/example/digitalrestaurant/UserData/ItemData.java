package com.example.digitalrestaurant.UserData;


import java.io.Serializable;

public class ItemData implements Serializable {

    private int price, imageURL;
    private String name, nationality;

    public ItemData(int price,  String name, String nationality, int imageURL) {
        this.price = price;
        this.name = name;
        this.nationality = nationality;
        this.imageURL= imageURL;

    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public Integer getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }
}
