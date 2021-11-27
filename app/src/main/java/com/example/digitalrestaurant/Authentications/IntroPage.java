package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.digitalrestaurant.R;

public class IntroPage extends AppCompatActivity {

    TextView customerTxt, foodSellerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        customerTxt= (TextView) findViewById(R.id.introCustmerText);
        foodSellerTxt= (TextView) findViewById(R.id.introFoodsellerText);

        customerTxt.setOnClickListener(v -> clickIntro(Customer.class));

        foodSellerTxt.setOnClickListener(v -> clickIntro(FoodSeller.class));
    }


    public void clickIntro(Object x){

        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);

    }
}