package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digitalrestaurant.GetMyLocation;
import com.example.digitalrestaurant.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class IntroPage extends AppCompatActivity {

    TextView customerTxt, foodSellerTxt;


    @Override
    public void onBackPressed() {




        Intent intent5 =new Intent(getApplicationContext(), IntroPage.class);

        intent5.putExtra("Exit",true);
        startActivity(intent5);

        finish();
        System.exit(0);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        customerTxt = findViewById(R.id.introCustmerText);
        foodSellerTxt = findViewById(R.id.introFoodsellerText);

        customerTxt.setOnClickListener(v -> clickIntro(Customer.class));


        foodSellerTxt.setOnClickListener(v -> clickIntro(FoodSeller.class));
    }





        public void clickIntro(Object x){

        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


}}