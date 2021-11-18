package com.example.digitalrestaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptor.PopularDishAdaptor;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class AdaKitchen extends AppCompatActivity {

    private RecyclerView.Adapter adaAdaptor;

    private RecyclerView adaRecycler;

    private ArrayList<ItemData> adaItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ada_restaurant_homepage);

        adaItems=new ArrayList<ItemData>();

        makeAdaRestaurantAdaptor();

    }
    public void makeAdaRestaurantAdaptor(){

        adaRecycler =findViewById(R.id.adaKitchen);

        adaRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adaAdaptor=new PopularDishAdaptor(populateAdaPage());

        adaRecycler.setAdapter(adaAdaptor);



    }

    public ArrayList<ItemData> populateAdaPage(){

        adaItems.add(new ItemData(12,"Catfish peppered soup","African" ,R.drawable.adacatfish));
        adaItems.add(new ItemData(9,"MoiMoi","African" ,R.drawable.obandemoimoi));
        adaItems.add(new ItemData(18,"Egusi soup","African" ,R.drawable.obandeegusisoup));
        adaItems.add(new ItemData(6,"Acolic drinks","" ,R.drawable.adaassortedbear));
        adaItems.add(new ItemData(3,"Chin-Chin","African" ,R.drawable.obandechinchin));
        adaItems.add(new ItemData(11,"Fried Rice with goat meat","African" ,R.drawable.friedriceone));
        adaItems.add(new ItemData(7,"Porridge bean and Plantain ","African" ,R.drawable.obandepouridgebeans));
        adaItems.add(new ItemData(3,"Soft drinks","" ,R.drawable.adasoftdrinks));
        adaItems.add(new ItemData(20,"Goat Peppered soup","African" ,R.drawable.adapepersoup));
        adaItems.add(new ItemData(5,"Heineken Pride","" ,R.drawable.adachilledheineken));
        adaItems.add(new ItemData(5,"Hero bear","" ,R.drawable.adaherobear));
        adaItems.add(new ItemData(7,"Extra Stout","" ,R.drawable.adaguinessbeer));

        return adaItems;
    }}
