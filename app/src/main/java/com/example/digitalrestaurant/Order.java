package com.example.digitalrestaurant;

import android.os.Bundle;
import android.text.Layout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;

public class Order extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);


        TextView adaFoodPrice=findViewById(R.id.adaPrice);
        TextView adaFoodNationality=findViewById(R.id.adaFoodNationality);
        TextView adaFoodName=findViewById(R.id.adaFoodName);
        ConstraintLayout adaFoodImages=findViewById(R.id.adarestaurantcard);

        String foodName = "";
        String foodNationality = "";
        //int foodPrice=0;
        //ConstraintLayout foodImage=0;

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            foodName= extras.getString("name");
            foodNationality= extras.getString("nationality");
            //foodPrice=extras.getInt("price");
            //foodImage=extras.getInt("imageUrl");

        }
       // adaFoodPrice.setText(foodPrice);
        adaFoodName.setText(foodName);
        adaFoodNationality.setText(foodNationality);
        //adaFoodImages.setBackground(foodImage);

}}
