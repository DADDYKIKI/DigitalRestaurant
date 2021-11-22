package com.example.digitalrestaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptor.OrderAdaptor;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    private OrderAdaptor.OderListener orderListener;



    private RecyclerView.Adapter cartAdaptor;

    private RecyclerView cartRecycler;

    ArrayList<OrderDetails> myOrder;

    public static final String MY_ORDER="MY_ORDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);




        setMyCart();




    }

    public void setMyCart(){

        myOrder= (ArrayList<OrderDetails>)getIntent().getSerializableExtra(MY_ORDER);

        cartRecycler =findViewById(R.id.cartRecycler);
        cartRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        cartAdaptor=new OrderAdaptor(orderListener,myOrder);
        cartRecycler.setAdapter(cartAdaptor);

    }
}
