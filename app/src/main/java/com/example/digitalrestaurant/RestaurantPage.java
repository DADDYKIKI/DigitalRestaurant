package com.example.digitalrestaurant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptor.RestaurantsAdaptor;

public class RestaurantPage extends AppCompatActivity {

    private RecyclerView.Adapter godwinAdaptor;

    private RecyclerView recyclerView;

    Context context;




    private RestaurantsAdaptor.AllInOneRecyclerViewListener listener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

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
