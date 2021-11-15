package com.example.digitalrestaurant.Adaptor.LocationDetails;

import java.io.Serializable;

public class LocationDetails implements Serializable {

    private String name;

    public LocationDetails(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
