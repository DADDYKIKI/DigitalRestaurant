package com.example.digitalrestaurant;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.digitalrestaurant.Adaptors.CartAdaptor;
//import com.example.digitalrestaurant.Adaptors.OrderAdaptor;
import com.example.digitalrestaurant.Adaptors.OrderAdaptor;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.Kitchens.AdaKitchen;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {

    private TextView plusBtn,minusBtn,addToCartBtn,quantityText,orderFoodName,
            orderNationality,orderPrice,totalOrderPrice,restaurantName;
    private ConstraintLayout adaFoodImages;
    private int quantityNumber=1;
    private int foodPrice=0;
    private String foodName = "";
    private String NameOfRestaurant="";
    private String foodNationality = "";
    private int foodImage=0;
    FloatingActionButton basket;


    RecyclerView.Adapter orderAdaptor;

    //private OrderAdaptor.OderListener orderListener;

    OrderAdaptor myOrderAdaptor;

    private RecyclerView cartRecycler;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<OrderDetails> orderList;


    DatabaseHelper myCartDatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);


        orderPrice=findViewById(R.id.orderPrice);
        orderNationality=findViewById(R.id.orderNationality);
        orderFoodName=findViewById(R.id.orderFoodName);
        adaFoodImages=findViewById(R.id.adarestaurantcard);
        restaurantName=findViewById(R.id.orderRestaurant);
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
            NameOfRestaurant=extras.getString("RestaurantName");

        }
        orderPrice.setText(String.valueOf(foodPrice));
        orderFoodName.setText(foodName);
        orderNationality.setText(foodNationality);
        adaFoodImages.setBackgroundResource(foodImage);
        totalOrderPrice.setText(String.valueOf(foodPrice));
        restaurantName.setText(NameOfRestaurant);










        //viewMyItems();

        openMyBasket();

        AddToCart();


       // setMyAdaptor();



}

        public void viewMyItems(){




              cartRecycler= this.findViewById(R.id.orderRecyclerview);
              myCartDatabaseHelper=new DatabaseHelper(this);


              orderList.add(new OrderDetails(foodName,quantityNumber,foodPrice*quantityNumber));

           // orderList=myCartDatabaseHelper.viewCartItems();
              cartRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


            //orderAdaptor=new OrderAdaptor(orderList);
              cartRecycler.setAdapter(orderAdaptor);


        }



        public void AddToCart(){//............Calculating total quantity and total price..........

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

            addToCartBtn.setOnClickListener(v -> {

                boolean addToCart=
                        myCartDatabaseHelper.addData(foodName,String.valueOf(quantityNumber),
                                String.valueOf(foodPrice*quantityNumber),NameOfRestaurant);

                if(addToCart==true)
                    Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();


            });




        }

    public void openMyBasket(){

        basket.setOnClickListener(v -> {

            Cursor cur1=myCartDatabaseHelper.getOrders();
            Cursor cur2=myCartDatabaseHelper.getCustomerLoginDetails();

            if(cur1.getCount()==0){ Toast.makeText(this, "Basket Empty", Toast.LENGTH_SHORT).show();return;}

            StringBuffer bufferedItems=new StringBuffer();
            while(cur1.moveToNext()){
                bufferedItems.append()

            }






           // Intent intent =new Intent(this, Cart.class);
           // startActivity(intent);


        });

    }
}









