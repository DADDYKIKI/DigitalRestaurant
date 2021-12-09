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


        customerTxt.setOnClickListener(v -> clickIntro(Customer.class));



       foodSellerTxt.setOnClickListener(v -> clickIntro(FoodSeller.class));


    }


    public void clickIntro(Object x){

        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

    }
}