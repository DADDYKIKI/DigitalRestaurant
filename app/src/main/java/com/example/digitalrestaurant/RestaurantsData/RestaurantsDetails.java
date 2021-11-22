package com.example.digitalrestaurant.RestaurantsData;

import com.example.digitalrestaurant.UserData.ItemData;

import java.io.Serializable;
import java.util.ArrayList;

public class RestaurantsDetails implements Serializable {

    private String restaurantsName, restaurantsLocation,restaurantNationality;
    ArrayList<ItemData> itemDatalist;

    private int restaurantImage;



    public RestaurantsDetails(String restaurantsName, String restaurantsLocation, String restaurantNationality,
                              int restaurantImage, ArrayList<ItemData> itemData){

        this.restaurantsName=restaurantsName;
        this.restaurantsLocation=restaurantsLocation;
        this.restaurantNationality=restaurantNationality;
        this.restaurantImage=restaurantImage;
    }



    public int getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(int restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public String getRestaurantNationality() {
        return restaurantNationality;
    }

    public void setRestaurantNationality(String restaurantNationality) {
        this.restaurantNationality = restaurantNationality;
    }

    public String getRestaurantsName() {
        return restaurantsName;
    }

    public void setRestaurantsName(String restaurantsName) {
        this.restaurantsName = restaurantsName;
    }

    public String getRestaurantsLocation() {
        return restaurantsLocation;
    }

    public void setRestaurantsLocation(String restaurantsLocation) {
        this.restaurantsLocation = restaurantsLocation;
    }
}
