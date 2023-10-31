package com.example.digitalrestaurant.Details.RestaurantsData;

import com.example.digitalrestaurant.Details.ItemData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RestaurantsDetails implements Serializable {

    private String restaurantsName, restaurantsLocation,restaurantNationality;


    private int restaurantImage;



    public RestaurantsDetails(String restaurantsName, String restaurantsLocation, String restaurantNationality,
                              int restaurantImage){

        this.restaurantsName=restaurantsName;
        this.restaurantsLocation=restaurantsLocation;
        this.restaurantNationality=restaurantNationality;
        this.restaurantImage=restaurantImage;
    }



    public int getRestaurantImage() {
        return restaurantImage;
    }

    public String getRestaurantNationality() {
        return restaurantNationality;
    }

    public String getRestaurantsName() {
        return restaurantsName;
    }

    public String getRestaurantsLocation() {
        return restaurantsLocation;
    }
}
