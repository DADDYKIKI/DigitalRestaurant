package com.example.digitalrestaurant.Details.LocationDetails;

import java.io.Serializable;

public class LocationDetails implements Serializable {

    private String location, restaurants;


    public LocationDetails(String location,String restaurants) {
        this.location = location;
        this.restaurants = restaurants;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.location = location;
    }

    public String getRsetaurants() {
        return restaurants;
    }

}
