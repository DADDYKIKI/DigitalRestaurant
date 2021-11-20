package com.example.digitalrestaurant;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptor.PopularDishAdaptor;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class Stainless extends AppCompatActivity {


    private PopularDishAdaptor.AdaRecyclerViewListener adalistener2;

    private RecyclerView.Adapter stainlessAdaptor;

    private RecyclerView stainlessRecycler;

    private ArrayList<ItemData> stainlessItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stainless_restaurant_homepage2);

        stainlessItems=new ArrayList<ItemData>();

        makeAdaRestaurantAdaptor();

    }
    public void makeAdaRestaurantAdaptor(){

        setStainlessOnclickListener();

        stainlessRecycler =findViewById(R.id.stainlessKitchen);

        stainlessRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //stainlessAdaptor=new PopularDishAdaptor(populateStainlessPage());

        stainlessRecycler.setAdapter(stainlessAdaptor);



    }

    public void setStainlessOnclickListener(){

        adalistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",stainlessItems.get(position).getName());
            intent5.putExtra("imageUrl",stainlessItems.get(position).getImageURL());
            intent5.putExtra("nationality",stainlessItems.get(position).getNationality());
            intent5.putExtra("price",stainlessItems.get(position).getPrice());

            startActivity(intent5);};

    }

    public ArrayList<ItemData> populateStainlessPage(){

        stainlessItems.add(new ItemData(12,"Catfish peppered soup","African" ,R.drawable.adacatfish));
        stainlessItems.add(new ItemData(9,"MoiMoi","African" ,R.drawable.obandemoimoi));
        stainlessItems.add(new ItemData(18,"Egusi soup","African" ,R.drawable.obandeegusisoup));
        stainlessItems.add(new ItemData(6,"Acolic drinks","" ,R.drawable.adaassortedbear));
        stainlessItems.add(new ItemData(3,"Chin-Chin","African" ,R.drawable.obandechinchin));
        stainlessItems.add(new ItemData(11,"Fried Rice with goat meat","African" ,R.drawable.friedriceone));
        stainlessItems.add(new ItemData(7,"Porridge bean and Plantain ","African" ,R.drawable.obandepouridgebeans));
        stainlessItems.add(new ItemData(3,"Soft drinks","" ,R.drawable.adasoftdrinks));
        stainlessItems.add(new ItemData(20,"Goat Peppered soup","African" ,R.drawable.adapepersoup));
        stainlessItems.add(new ItemData(5,"Heineken Pride","" ,R.drawable.adachilledheineken));
        stainlessItems.add(new ItemData(5,"Hero bear","" ,R.drawable.adaherobear));
        stainlessItems.add(new ItemData(7,"Extra Stout","" ,R.drawable.adaguinessbeer));

        return stainlessItems;
    }}

