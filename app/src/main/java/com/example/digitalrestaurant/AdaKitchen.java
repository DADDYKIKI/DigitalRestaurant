package com.example.digitalrestaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptor.AdaAdaptor;
import com.example.digitalrestaurant.Adaptor.GodwinAdaptor;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class AdaKitchen extends AppCompatActivity {

    ArrayList<AdaData> adaDatalist;

    RecyclerView.Adapter adaAdaptor;

    RecyclerView adaRecycler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adaDatalist=new ArrayList<AdaData>();


    }

    public void makeAdaAdaptor(){

        adaRecycler =findViewById(R.id.adaRecycler1);

        adaRecycler .setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adaAdaptor=new AdaAdaptor(populateAdaPageWithData());

        adaRecycler.setAdapter(adaAdaptor);



    }

    public ArrayList<AdaData> populateAdaPageWithData(){

        adaDatalist.add(new AdaData(12,"Meat","European" ,R.drawable.justmeats));
        adaDatalist.add(new AdaData(8,"Rice/Plantain","European" ,R.drawable.jelofplantrain));
        adaDatalist.add(new AdaData(4,"Hot Dog","European" ,R.drawable.uktwo));
        adaDatalist.add(new AdaData(15,"Sauce","European" ,R.drawable.mixture));
        adaDatalist.add(new AdaData(21,"Fried Rice","European" ,R.drawable.friedriceone));
        adaDatalist.add(new AdaData(7,"Assorted meats","European" ,R.drawable.tablefoodpic));
        adaDatalist.add(new AdaData(10,"Pounded Yam","European" ,R.drawable.towel));
        adaDatalist.add(new AdaData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return adaDatalist;

    }
    }
