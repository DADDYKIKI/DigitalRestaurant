package com.example.digitalrestaurant.Kitchens;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Adaptors.PopulateKitchensWithItemsAdaptor;
import com.example.digitalrestaurant.Authentications.LoginPage;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.Menu;
import com.example.digitalrestaurant.Order;
import com.example.digitalrestaurant.AdminPage;
import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.Details.ItemData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class AdaKitchen extends AppCompatActivity {

    private PopulateKitchensWithItemsAdaptor.RestaurantsRecyclerViewListener adalistener2;

    private RecyclerView.Adapter adaAdaptor;

    private RecyclerView adaRecycler;

    private List<ItemData> adaItems;

    private FloatingActionButton basket;

    private TextView homeKey,menuKey;

    private DatabaseHelper helper;




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ada_restaurant_homepage);

        homeKey=findViewById(R.id.homeKey);

        menuKey=findViewById(R.id.menuKeyS);

        adaItems= new ArrayList<>();

        basket=findViewById(R.id.floatingActionButton);

        helper=new DatabaseHelper(this);


        Toast.makeText(this, "Make your choice\n scrolling food items\nvertically", Toast.LENGTH_SHORT).show();


        openMyBasket();

        makeAdaRestaurantAdaptor();



        homeKey();
        menuKey();

    }

    public void homeKey(){//Take back to home
        homeKey.setOnClickListener(v -> {
            Intent intent=new Intent(this, HomePage.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out);

        });

    }

    public void menuKey(){//Menu
        menuKey.setOnClickListener(v -> {



            Intent intent2=new Intent(this, Menu.class);

            startActivity(intent2);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }

    public void openMyBasket(){//View basket

        basket.setOnClickListener(v -> {


            Intent intent =new Intent(AdaKitchen.this, Order.class);


            startActivity(intent);


        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeAdaRestaurantAdaptor(){//Attaching list of food items with recycler view for display


        setAdaOnclickListener();

        adaItems=new AdminPage().populateAdaPage(LoginPage.getAge());

        adaRecycler =findViewById(R.id.adaKitchenRecycler);

        LinearLayoutManager linear=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        adaRecycler.setLayoutManager(linear);

        linear.setReverseLayout(true);

        linear.setStackFromEnd(true);

        adaAdaptor=new PopulateKitchensWithItemsAdaptor(adaItems,adalistener2);

        adaRecycler.setAdapter(adaAdaptor);

    }



    public void setAdaOnclickListener(){//This will send my order details to my order/basket page

        adalistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",adaItems.get(position).getName());
            intent5.putExtra("imageUrl",adaItems.get(position).getImageURL());
            intent5.putExtra("nationality",adaItems.get(position).getNationality());
            intent5.putExtra("price",adaItems.get(position).getPrice());
            intent5.putExtra("restaurant","Ada Kitchen");

            startActivity(intent5);};

    }

    }

