package com.example.digitalrestaurant;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptors.CartAdaptor;
//import com.example.digitalrestaurant.Adaptors.OrderAdaptor;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.Kitchens.AdaKitchen;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {

    private TextView plusBtn,minusBtn,addToCartBtn,quantityText,orderFoodName,orderNationality,orderPrice,totalOrderPrice;
    private ConstraintLayout adaFoodImages;
    private int quantityNumber=1;
    private int foodPrice=0;
    private String foodName = "";
    private String foodNationality = "";
    private int foodImage=0;
    FloatingActionButton basket;


    private RecyclerView.Adapter orderAdaptor;

    //private OrderAdaptor.OderListener orderListener;

    private RecyclerView cartRecycler;

    ArrayList<OrderDetails> orderList;


    DatabaseHelper myCartDatabaseHelper;








    //...................Database .........................



    //................................................

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
        basket=findViewById(R.id.floatingActionButton);

        orderList=new ArrayList<>();

        myCartDatabaseHelper=new DatabaseHelper(this);




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

        AddToCartBtnListener();

       viewMyItems();

        openMyBasket();


       // setMyAdaptor();



}

        public void viewMyItems(){

            DatabaseHelper myCartDatabaseHelper=new DatabaseHelper(this);

            orderList=myCartDatabaseHelper.viewCartItems();


            cartRecycler=findViewById(R.id.orderRecyclerview);

            orderAdaptor=new CartAdaptor(orderList,this);
            cartRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,
                    false));
           cartRecycler.setAdapter(orderAdaptor);





        }



        public void setOrderQuantity(){//............Calculating total quantity and total price..........

            plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    quantityNumber++;
                    quantityText.setText(String.valueOf(quantityNumber));
                    totalOrderPrice.setText(String.valueOf(foodPrice*quantityNumber));


                }});

                    minusBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                        if(quantityNumber>1) {

                            quantityNumber--;
                            quantityText.setText(String.valueOf(quantityNumber));
                            totalOrderPrice.setText(String.valueOf(foodPrice*quantityNumber));


                        }

                }});


    }

    public void openMyBasket(){

        basket.setOnClickListener(v -> {

            Intent intent =new Intent(this, Cart.class);
            startActivity(intent);


        });




    }

    public void AddToCartBtnListener(){//................Add to Database...................




        addToCartBtn.setOnClickListener(v -> {

            boolean addToCart=
                    myCartDatabaseHelper.addData(foodName,String.valueOf(quantityNumber),String.valueOf(foodPrice*quantityNumber));

           if(addToCart==true)
            Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
           else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();


        });



    }}









