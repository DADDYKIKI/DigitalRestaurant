package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FoodSeller extends AppCompatActivity {

    TextView sellerLoginTxt,sellerSignUpTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_seller);

        sellerLoginTxt= (TextView) findViewById(R.id.foodSellerloginBut);
        sellerSignUpTxt= (TextView) findViewById(R.id.foodsellerSignupBut);

        sellerLoginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click1(LoginPage.class);

            }
        });

        sellerSignUpTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click1(SignupPage.class);
            }



        });
    }

    public void click1(Object x){
        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);
}}