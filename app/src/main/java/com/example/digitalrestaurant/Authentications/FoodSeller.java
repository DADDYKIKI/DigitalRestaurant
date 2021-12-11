package com.example.digitalrestaurant.Authentications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalrestaurant.R;

public class FoodSeller extends AppCompatActivity {

    TextView sellerLoginTxt,sellerSignUpTxt;


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
        setContentView(R.layout.activity_food_seller);

        sellerLoginTxt= findViewById(R.id.foodSellerloginBut);
        sellerSignUpTxt= findViewById(R.id.foodsellerSignupBut);


        sellerLoginTxt.setOnClickListener(v -> click1(LoginPageForFoodSeller2.class));

        sellerSignUpTxt.setOnClickListener(v -> click1(SignupPageForFoodSeller2.class));
    }

    public void click1(Object x){
        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }
}
