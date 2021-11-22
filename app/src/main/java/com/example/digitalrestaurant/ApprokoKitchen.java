package com.example.digitalrestaurant;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.digitalrestaurant.Adaptor.PopularDishAdaptor;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class ApprokoKitchen extends AppCompatActivity {

    private PopularDishAdaptor.RestaurantsRecyclerViewListener adalistener2;


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



        setAprokoOnclickListener();

        aprokoRecycler =findViewById(R.id.aprokoKitchen);

        aprokoRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        aprokoAdaptor=new PopularDishAdaptor(populateAprokoPage(),adalistener2);

        aprokoRecycler.setAdapter(aprokoAdaptor);



    }

    public void setAprokoOnclickListener(){

        adalistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",aprokoItems.get(position).getName());
            intent5.putExtra("imageUrl",aprokoItems.get(position).getImageURL());
            intent5.putExtra("nationality",aprokoItems.get(position).getNationality());
            intent5.putExtra("price",aprokoItems.get(position).getPrice());

            startActivity(intent5);};

    }

    public  ArrayList<ItemData> populateAprokoPage(){


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
