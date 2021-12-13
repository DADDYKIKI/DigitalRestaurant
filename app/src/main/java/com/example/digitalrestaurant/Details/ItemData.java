package com.example.digitalrestaurant.Details;


import android.graphics.Bitmap;

import java.io.Serializable;

public class ItemData implements Serializable {

    private int price,imageURL;
    private String name, nationality,alcoholic,pictureLabel;

    public ItemData(int price,  String name, String nationality,int imageURL,String alcoholic) {
        this.price = price;
        this.name = name;
        this.nationality = nationality;
        this.alcoholic=alcoholic;
        this.imageURL= imageURL;

    }

    public String getAlcoholic() {
        return alcoholic;
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

    public int getImageURL() {
        return imageURL;
    }

}
