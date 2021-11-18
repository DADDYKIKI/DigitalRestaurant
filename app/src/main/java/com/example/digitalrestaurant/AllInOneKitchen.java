package com.example.digitalrestaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.digitalrestaurant.Adaptor.PopularDishAdaptor;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class AllInOneKitchen extends AppCompatActivity {


    RecyclerView.Adapter allInOneAdaptor;

    RecyclerView allInOneRecycler;

    ArrayList<ItemData> myItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aproko_resataurant_homepage);

        myItems=new ArrayList<ItemData>();
        makAllRestaurantAdaptor();

    }

    public void makAllRestaurantAdaptor(){

        allInOneRecycler =findViewById(R.id.allInOneContainer);

        allInOneRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        allInOneAdaptor=new PopularDishAdaptor(populateAdaPage());

        allInOneRecycler.setAdapter(allInOneAdaptor);



    }

    public ArrayList<ItemData> populateAdaPage(){


        myItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        myItems.add(new ItemData(8,"Rice/Plantain","African" ,R.drawable.jelofplantrain));
        myItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        myItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
        myItems.add(new ItemData(21,"Fried Rice","African" ,R.drawable.friedriceone));
        myItems.add(new ItemData(7,"Assorted meats","Asian" ,R.drawable.tablefoodpic));
        myItems.add(new ItemData(10,"Pounded Yam","African" ,R.drawable.towel));
        myItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return myItems;
    }

    public ArrayList<ItemData> populateObandePage(){


        myItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        myItems.add(new ItemData(8,"Rice/Plantain","European" ,R.drawable.jelofplantrain));
        myItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        myItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
        myItems.add(new ItemData(21,"Fried Rice","European" ,R.drawable.friedriceone));
        myItems.add(new ItemData(7,"Assorted meats","European" ,R.drawable.tablefoodpic));
        myItems.add(new ItemData(10,"Pounded Yam","European" ,R.drawable.towel));
        myItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return myItems;
    }

    public ArrayList<ItemData> populateAprokoPage(){


        myItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        myItems.add(new ItemData(8,"Rice/Plantain","European" ,R.drawable.jelofplantrain));
        myItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        myItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
        myItems.add(new ItemData(21,"Fried Rice","European" ,R.drawable.friedriceone));
        myItems.add(new ItemData(7,"Assorted meats","European" ,R.drawable.tablefoodpic));
        myItems.add(new ItemData(10,"Pounded Yam","European" ,R.drawable.towel));
        myItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return myItems;
    }

    public ArrayList<ItemData> populateStainlessPage(){


        myItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        myItems.add(new ItemData(8,"Rice/Plantain","European" ,R.drawable.jelofplantrain));
        myItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        myItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
        myItems.add(new ItemData(21,"Fried Rice","European" ,R.drawable.friedriceone));
        myItems.add(new ItemData(7,"Assorted meats","European" ,R.drawable.tablefoodpic));
        myItems.add(new ItemData(10,"Pounded Yam","European" ,R.drawable.towel));
        myItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return myItems;
    }


}
