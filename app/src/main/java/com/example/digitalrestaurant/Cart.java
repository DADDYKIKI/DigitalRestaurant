package com.example.digitalrestaurant;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.digitalrestaurant.Adaptors.OrderAdaptor;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.OrderDetails;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    private OrderAdaptor.OderListener orderListener;



    private RecyclerView.Adapter orderAdaptor;



    private RecyclerView cartRecycler;

    ArrayList<OrderDetails> myOrder;

    TextView homeKey,menuKey;



    public static final String MY_ORDER="MY_ORDER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);



       myOrder=new ArrayList<>();

        homeKey=findViewById(R.id.homeKey);
        menuKey=findViewById(R.id.menuKey);


        homeKey();
        menuKey();


        //addItems();
       setMyAdaptor();


    }

    public void homeKey(){
        homeKey.setOnClickListener(v -> {
            Intent intent=new Intent(this, HomePage.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out);

        });

    }

    public void menuKey(){
        menuKey.setOnClickListener(v -> {
            Intent intent2=new Intent(this, Menu.class);
            startActivity(intent2);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }



    public void setMyAdaptor(){
        cartRecycler=findViewById(R.id.orderRecyclerview);
        cartRecycler.setLayoutManager(new LinearLayoutManager(this));
        orderAdaptor=new OrderAdaptor(orderListener,new DatabaseHelper(this).viewMyItemsData());
        cartRecycler.setAdapter(orderAdaptor);


    }



}


