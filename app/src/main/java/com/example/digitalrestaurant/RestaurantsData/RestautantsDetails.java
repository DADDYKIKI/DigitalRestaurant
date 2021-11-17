package com.example.digitalrestaurant.RestaurantsData;

import com.example.digitalrestaurant.UserData.ItemData;

import java.io.Serializable;
import java.util.ArrayList;

public class RestautantsDetails implements Serializable {

    private String restaurantsName, restaurantsLocation,restaurantNationality;
    ArrayList<ItemData> itemDatalist;

    private int restaurantImage;



    public RestautantsDetails(String restaurantsName, String restaurantsLocation,String restaurantNationality,
                              int restaurantImage,ArrayList<ItemData> itemDatalist){

        this.restaurantsName=restaurantsName;
        this.restaurantsLocation=restaurantsLocation;
        this.restaurantNationality=restaurantNationality;
        this.restaurantImage=restaurantImage;
        this.itemDatalist=itemDatalist;
    }

    public ArrayList<ItemData> getItemDatalist() {
        return itemDatalist;
    }

    public void setItemDatalist(ArrayList<ItemData> itemDatalist) {
        this.itemDatalist = itemDatalist;
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
