package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IntroPage extends AppCompatActivity {

    TextView customerTxt, foodSellerTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        customerTxt= (TextView) findViewById(R.id.introCustmerText);
        foodSellerTxt= (TextView) findViewById(R.id.introFoodsellerText);

        customerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickIntro(Customer.class);

            }
        });

        foodSellerTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickIntro(FoodSeller.class);

            }
        });
    }


    public void clickIntro(Object x){

        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);

    }
}