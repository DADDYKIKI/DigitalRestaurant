package com.example.digitalrestaurant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptor.PopularDishAdaptor;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class ObandeKitchen extends AppCompatActivity {

    RecyclerView.Adapter obandeAdaptor;

    RecyclerView obandeRecycler;

    ArrayList<ItemData> obandeItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obande_restaurant_homepage);

        obandeItems=new ArrayList<ItemData>();

        makeAprokoRestaurantAdaptor();

}
    public void makeAprokoRestaurantAdaptor(){

        obandeRecycler =findViewById(R.id.obandeKitchen);

        obandeRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        obandeAdaptor=new PopularDishAdaptor(populateAdaPage());

        obandeRecycler.setAdapter(obandeAdaptor);



    }

    public ArrayList<ItemData> populateAdaPage(){


        obandeItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        obandeItems.add(new ItemData(8,"Rice/Plantain","African" ,R.drawable.jelofplantrain));
        obandeItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        obandeItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
        obandeItems.add(new ItemData(21,"Fried Rice","African" ,R.drawable.friedriceone));
        obandeItems.add(new ItemData(7,"Assorted meats","Asian" ,R.drawable.tablefoodpic));
        obandeItems.add(new ItemData(10,"Pounded Yam","African" ,R.drawable.towel));
        obandeItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return obandeItems;
    }


}
