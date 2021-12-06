package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digitalrestaurant.R;

public class IntroPage extends AppCompatActivity {

    TextView customerTxt, foodSellerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        customerTxt= findViewById(R.id.introCustmerText);
        foodSellerTxt= findViewById(R.id.introFoodsellerText);

        Toast.makeText(this, "I will advice you to watchout\nfor messages like this.", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "They will help you alot", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Most will teach you how to operate the app", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "You can now go in as \na Customer or Food Seller", Toast.LENGTH_SHORT).show();


        customerTxt.setOnClickListener(v -> clickIntro(Customer.class));



       foodSellerTxt.setOnClickListener(v -> clickIntro(FoodSeller.class));


    }


    public void clickIntro(Object x){

        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);

    }
}