package com.example.digitalrestaurant;

import java.io.Serializable;

public class AdaData implements Serializable {

    private int adaPrice, adaImage;
    private String adaName, adaNationality;

    public AdaData(int adaPrice,  String adaName, String adaNationalityint, int adaImage) {
        this.adaPrice = adaPrice;
        this.adaImage = adaImage;
        this.adaName = adaName;
        this.adaNationality = adaNationality;
    }

    public int getAdaPrice() {
        return adaPrice;
    }

    public void setAdaPrice(int adaPrice) {
        this.adaPrice = adaPrice;
    }

    public int getAdaImage() {
        return adaImage;
    }

    public void setAdaImage(int adaImage) {
        this.adaImage = adaImage;
    }

    public String getAdaName() {
        return adaName;
    }

    public void setAdaName(String adaName) {
        this.adaName = adaName;
    }

    public String getAdaNationality() {
        return adaNationality;
    }

    public void setAdaNationality(String adaNationality) {
        this.adaNationality = adaNationality;
    }
}

