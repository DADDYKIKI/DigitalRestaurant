package com.example.digitalrestaurant.Kitchens;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptors.PopularDishAdaptor;
import com.example.digitalrestaurant.Cart;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.Menu;
import com.example.digitalrestaurant.Order;
import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.Details.ItemData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stainless extends AppCompatActivity {


    private PopularDishAdaptor.RestaurantsRecyclerViewListener adalistener2;

    private RecyclerView.Adapter stainlessAdaptor;

    private RecyclerView stainlessRecycler;

    private List<ItemData> stainlessItems;
    FloatingActionButton floater;

    TextView homeKey,menuKey;

    private DatabaseHelper helper;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stainless_restaurant_homepage2);

        stainlessItems=new ArrayList<ItemData>();
        floater=findViewById(R.id.floatingActionButton);
        homeKey=(TextView) findViewById(R.id.homeKey);
        menuKey=findViewById(R.id.menuKey);

        helper=new DatabaseHelper(this);

        makeAdaRestaurantAdaptor();
        //gotoBasket();
        homeKey();
        menuKey();

    }

    public void gotoBasket(){//................Add to Database...................

        floater.setOnClickListener(v -> {

            Intent intent=new Intent(this, Cart.class);

            startActivity(intent);

        });

    }

    public void homeKey(){
        homeKey.setOnClickListener(v -> {
            Intent intent=new Intent(Stainless.this, HomePage.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out);

        });

    }

    public void menuKey(){
        menuKey.setOnClickListener(v -> {
            Intent intent2=new Intent(Stainless.this, Menu.class);
            startActivity(intent2);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeAdaRestaurantAdaptor(){

        setStainlessOnclickListener();

        stainlessRecycler =findViewById(R.id.stainlessKitchen);

        stainlessRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        stainlessAdaptor=new PopularDishAdaptor(populateStainlessPage(34),adalistener2);

        stainlessRecycler.setAdapter(stainlessAdaptor);



    }

    public void setStainlessOnclickListener(){

        adalistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",stainlessItems.get(position).getName());
            intent5.putExtra("imageUrl",stainlessItems.get(position).getImageURL());
            intent5.putExtra("nationality",stainlessItems.get(position).getNationality());
            intent5.putExtra("price",stainlessItems.get(position).getPrice());
            intent5.putExtra("RestaurantName","Stainless");

            startActivity(intent5);};

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<ItemData> populateStainlessPage(int age){

        stainlessItems.add(new ItemData(12,"Catfish peppered soup","African" ,R.drawable.adacatfish,""));
        stainlessItems.add(new ItemData(9,"MoiMoi","African" ,R.drawable.obandemoimoi,""));
        stainlessItems.add(new ItemData(18,"Egusi soup","African" ,R.drawable.obandeegusisoup,""));
        stainlessItems.add(new ItemData(3,"Chin-Chin","African" ,R.drawable.obandechinchin,""));
        stainlessItems.add(new ItemData(11,"Fried Rice with goat meat","African" ,R.drawable.friedriceone,""));
        stainlessItems.add(new ItemData(7,"Porridge bean and Plantain ","African" ,R.drawable.obandepouridgebeans,""));
        stainlessItems.add(new ItemData(3,"Soft drinks","" ,R.drawable.adasoftdrinks,""));
        stainlessItems.add(new ItemData(20,"Goat Peppered soup","African" ,R.drawable.adapepersoup,""));
        stainlessItems.add(new ItemData(5,"Heineken Pride","" ,R.drawable.adachilledheineken,""));
        stainlessItems.add(new ItemData(7,"Extra Stout","" ,R.drawable.adaguinessbeer,""));


        List<ItemData> allMatch=stainlessItems.stream().filter(p->p.getAlcoholic().equals(""))
                .collect(Collectors.toList());

        if(age<18)return allMatch;

        return stainlessItems;
    }




    }

