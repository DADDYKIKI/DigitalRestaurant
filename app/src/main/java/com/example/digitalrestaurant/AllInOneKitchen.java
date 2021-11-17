package com.example.digitalrestaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptor.AllInOneKitchenAdaptor;

import java.util.ArrayList;

public class AllInOneKitchen extends AppCompatActivity {

    ArrayList<AllInOneKitchenData> allInOneKitchenDatalist;

    RecyclerView.Adapter adaAdaptor;

    RecyclerView adaRecycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        allInOneKitchenDatalist =new ArrayList<AllInOneKitchenData>();


    }

    public void makeAdaAdaptor(){

        adaRecycler =findViewById(R.id.adaRecycler1);

        adaRecycler .setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adaAdaptor=new AllInOneKitchenAdaptor(populateAdaPageWithData());

        adaRecycler.setAdapter(adaAdaptor);



    }

    public ArrayList<AllInOneKitchenData> populateAdaPageWithData(){

        allInOneKitchenDatalist.add(new AllInOneKitchenData(12,"Meat","European" ,R.drawable.justmeats));
        allInOneKitchenDatalist.add(new AllInOneKitchenData(8,"Rice/Plantain","European" ,R.drawable.jelofplantrain));
        allInOneKitchenDatalist.add(new AllInOneKitchenData(4,"Hot Dog","European" ,R.drawable.uktwo));
        allInOneKitchenDatalist.add(new AllInOneKitchenData(15,"Sauce","European" ,R.drawable.mixture));
        allInOneKitchenDatalist.add(new AllInOneKitchenData(21,"Fried Rice","European" ,R.drawable.friedriceone));
        allInOneKitchenDatalist.add(new AllInOneKitchenData(7,"Assorted meats","European" ,R.drawable.tablefoodpic));
        allInOneKitchenDatalist.add(new AllInOneKitchenData(10,"Pounded Yam","European" ,R.drawable.towel));
        allInOneKitchenDatalist.add(new AllInOneKitchenData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return allInOneKitchenDatalist;

    }
    }
