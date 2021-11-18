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

        obandeAdaptor=new PopularDishAdaptor(populateObandePage());

        obandeRecycler.setAdapter(obandeAdaptor);



    }

    public ArrayList<ItemData> populateObandePage(){


        obandeItems.add(new ItemData(7,"MoiMoi","African" ,R.drawable.obandemoimoi));
        obandeItems.add(new ItemData(15,"Egusi soup","African" ,R.drawable.obandeegusisoup));
        obandeItems.add(new ItemData(10,"Fried Rice","African" ,R.drawable.obandefriedrice));
        obandeItems.add(new ItemData(4,"Chin-Chin","African" ,R.drawable.obandechinchin));
        obandeItems.add(new ItemData(21,"Fried Rice with goat meat","African" ,R.drawable.friedriceone));
        obandeItems.add(new ItemData(7,"Pouridge bean and Plantain ","African" ,R.drawable.obandepouridgebeans));
        obandeItems.add(new ItemData(10,"Pounded Yam","African" ,R.drawable.towel));
        obandeItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return obandeItems;
    }


}
