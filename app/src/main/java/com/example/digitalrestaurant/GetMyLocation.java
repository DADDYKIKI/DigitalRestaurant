package com.example.digitalrestaurant;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.digitalrestaurant.Authentications.Customer;
import com.example.digitalrestaurant.Authentications.FoodSeller;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GetMyLocation extends AppCompatActivity {


    //This code was not used for getting location in this project. THis is because, it will affect testing by my scorers

    private static String MYCOUNTRYOFLOCATION = "";

    Double longitude = 0.0;
    Double latitude = 0.0;
    Location gsm = null, network = null, finalock = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        Toast.makeText(this, "Hello" + getMYCOUNTRYOFLOCATION(), Toast.LENGTH_SHORT).show();



        LocationManager myLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
        }

        try {
            gsm = myLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            network = myLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);


        } catch (Exception e) {
            e.printStackTrace();
        }

        if (gsm == null) {
            finalock = gsm;
            longitude = finalock.getLongitude();
            latitude = finalock.getLatitude();
        } else if (network == null) {
            finalock = network;
            longitude = finalock.getLongitude();
            latitude = finalock.getLatitude();

        } else {
            latitude = 0.0;
            longitude = 0.0;
        }

        try {
            Geocoder geo = new Geocoder(getApplicationContext(), Locale.getDefault());

            List<Address> myaddress = geo.getFromLocation(latitude, longitude, 1);

            if (myaddress != null && myaddress.size() > 0) {

                setMYCOUNTRYOFLOCATION(myaddress.get(0).getCountryName());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getMYCOUNTRYOFLOCATION() {
        return MYCOUNTRYOFLOCATION;
    }

    public static void setMYCOUNTRYOFLOCATION(String location) {
        MYCOUNTRYOFLOCATION = location;
    }







}
