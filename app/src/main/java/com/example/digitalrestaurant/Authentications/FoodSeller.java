package com.example.digitalrestaurant.Authentications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalrestaurant.R;

public class FoodSeller extends AppCompatActivity {

    TextView sellerLoginTxt,sellerSignUpTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_seller);

        sellerLoginTxt= findViewById(R.id.foodSellerloginBut);
        sellerSignUpTxt= findViewById(R.id.foodsellerSignupBut);

        sellerLoginTxt.setOnClickListener(v -> click1(LoginPageForFoodSeller2.class));

        sellerSignUpTxt.setOnClickListener(v -> click1(SignupPageForFoodSeller2.class));
    }

    public void click1(Object x){
        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);
    }
}
