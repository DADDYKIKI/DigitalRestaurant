package com.example.digitalrestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    private TextView plusBtn,minusBtn,addToCartBtn,quantityText,orderFoodName,orderNationality,orderPrice,totalOrderPrice;
    private ConstraintLayout adaFoodImages;
    private int quantityNumber=1;
    private int foodPrice=0;
    private String foodName = "";
    private String foodNationality = "";
    private int foodImage=0;

    ArrayList<OrderDetails> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);


        orderPrice=findViewById(R.id.orderPrice);
        orderNationality=findViewById(R.id.orderNationality);
        orderFoodName=findViewById(R.id.orderFoodName);
        adaFoodImages=findViewById(R.id.adarestaurantcard);
        quantityText=findViewById(R.id.quantityTxt);
        addToCartBtn=findViewById(R.id.addToCartbtn);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        totalOrderPrice=findViewById(R.id.totalOrderPrice);

        orderList=new ArrayList<>();







        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            foodName= extras.getString("name");
            foodNationality= extras.getString("nationality");
            foodPrice=extras.getInt("price");
            foodImage=extras.getInt("imageUrl");

        }
        orderPrice.setText(String.valueOf(foodPrice));
        orderFoodName.setText(foodName);
        orderNationality.setText(foodNationality);
        adaFoodImages.setBackgroundResource(foodImage);
        totalOrderPrice.setText(String.valueOf(foodPrice));



        setOrderQuantity();
        setAddToCartBtnListener();


}

        public void setOrderQuantity(){

            plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    quantityNumber+=1;
                    quantityText.setText(String.valueOf(quantityNumber));
                    totalOrderPrice.setText(String.valueOf(foodPrice*quantityNumber));


                }});

                    minusBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                        if(quantityNumber>1) {
                            quantityNumber -= 1;
                            quantityText.setText(String.valueOf(quantityNumber));
                            totalOrderPrice.setText(String.valueOf(foodPrice*quantityNumber));


                        }

                }});
            orderList.add(new OrderDetails(foodPrice*quantityNumber,quantityNumber,foodName));


    }

    public void setAddToCartBtnListener(){

        addToCartBtn.setOnClickListener(v -> {
            Intent intent=new Intent(this, Cart.class);

            intent.putExtra(Cart.MY_ORDER,orderList);

            Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();

        });



    }



}