package com.example.digitalrestaurant.Kitchens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptors.PopularDishAdaptor;
import com.example.digitalrestaurant.Cart;
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.Menu;
import com.example.digitalrestaurant.Order;
import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.Details.ItemData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AdaKitchen extends AppCompatActivity {

    private PopularDishAdaptor.RestaurantsRecyclerViewListener adalistener2;

    private RecyclerView.Adapter adaAdaptor;

    private RecyclerView adaRecycler;

    private ArrayList<ItemData> adaItems;

    FloatingActionButton basket;

    TextView homeKey,menuKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ada_restaurant_homepage);

        homeKey=(TextView) findViewById(R.id.homeKey);
        menuKey=findViewById(R.id.menuKey);

        adaItems= new ArrayList<>();

        basket=findViewById(R.id.floatingActionButton);



        openMyBasket();

        makeAdaRestaurantAdaptor();

        homeKey();
        menuKey();

    }

    public void homeKey(){
        homeKey.setOnClickListener(v -> {
            Intent intent=new Intent(this, HomePage.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out);

        });

    }

    public void menuKey(){
        menuKey.setOnClickListener(v -> {
            Intent intent2=new Intent(this, Menu.class);
            startActivity(intent2);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }

    public void openMyBasket(){

        basket.setOnClickListener(v -> {

            Intent intent =new Intent(AdaKitchen.this, Cart.class);
            startActivity(intent);


        });




    }
    public void makeAdaRestaurantAdaptor(){


        setAdaOnclickListener();

        adaRecycler =findViewById(R.id.adaKitchenRecycler);

        adaRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adaAdaptor=new PopularDishAdaptor(populateAdaPage(),adalistener2);

        adaRecycler.setAdapter(adaAdaptor);



    }

    public void setAdaOnclickListener(){

        adalistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",adaItems.get(position).getName());
            intent5.putExtra("imageUrl",adaItems.get(position).getImageURL());
            intent5.putExtra("nationality",adaItems.get(position).getNationality());
            intent5.putExtra("price",adaItems.get(position).getPrice());

            startActivity(intent5);};

    }








    public ArrayList<ItemData> populateAdaPage(){

        adaItems.add(new ItemData(12,"Catfish peppered soup","African" ,R.drawable.adacatfish));
        adaItems.add(new ItemData(9,"MoiMoi","African" ,R.drawable.obandemoimoi));
        adaItems.add(new ItemData(18,"Egusi soup","African" ,R.drawable.obandeegusisoup));
        adaItems.add(new ItemData(6,"Alcoholic drinks","" ,R.drawable.adaassortedbear));
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
