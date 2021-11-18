package com.example.digitalrestaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.digitalrestaurant.Adaptor.PopularDishAdaptor;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class ApprokoKitchen extends AppCompatActivity {


    RecyclerView.Adapter aprokoAdaptor;

    RecyclerView aprokoRecycler;

    ArrayList<ItemData> aprokoItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aproko_resataurant_homepage);

        aprokoItems=new ArrayList<ItemData>();
        makAllRestaurantAdaptor();

    }

    public void makAllRestaurantAdaptor(){

        aprokoRecycler =findViewById(R.id.aprokoKitchen);

        aprokoRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        aprokoAdaptor=new PopularDishAdaptor(populateAdaPage());

        aprokoRecycler.setAdapter(aprokoAdaptor);



    }

    public ArrayList<ItemData> populateAdaPage(){


        aprokoItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        aprokoItems.add(new ItemData(8,"Rice/Plantain","Asian" ,R.drawable.jelofplantrain));
        aprokoItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        aprokoItems.add(new ItemData(15,"Sauce","Asain" ,R.drawable.mixture));
        aprokoItems.add(new ItemData(15,"Sauce","Asain" ,R.drawable.mixture));
        aprokoItems.add(new ItemData(21,"Fried Rice","African" ,R.drawable.friedriceone));
        aprokoItems.add(new ItemData(7,"Assorted meats","Asian" ,R.drawable.tablefoodpic));
        aprokoItems.add(new ItemData(10,"Pounded Yam","African" ,R.drawable.towel));
        aprokoItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return aprokoItems;
    }


}
