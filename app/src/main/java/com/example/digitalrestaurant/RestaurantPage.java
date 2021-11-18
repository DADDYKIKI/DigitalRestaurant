package com.example.digitalrestaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptor.LocationDetails.LocationDetails;
import com.example.digitalrestaurant.Adaptor.PopularDishAdaptor;
import com.example.digitalrestaurant.Adaptor.RestaurantsAdaptor;
import com.example.digitalrestaurant.RestaurantsData.RestautantsDetails;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class RestaurantPage extends AppCompatActivity {

    private RecyclerView.Adapter godwinAdaptor;

    private RecyclerView recyclerView;

    Context context;




    private RestaurantsAdaptor.AllInOneRecyclerViewListener listener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popular_dish_page);

        setOnClickListener();
}

    public void setOnClickListener() {
        listener = new RestaurantsAdaptor.AllInOneRecyclerViewListener() {
            @Override
            public void onClickMe(View v, int position) {
                startActivity(new Intent(getApplicationContext(), AllInOneKitchen.class));


            }
        };






        }



}
