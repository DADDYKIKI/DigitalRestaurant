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

        Toast.makeText(this, "Welcome to Ada Kitchen", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Make your choice\n scrolling food items\nhorizontally", Toast.LENGTH_SHORT).show();


        //openMyBasket();

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


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeAdaRestaurantAdaptor(){


        setAdaOnclickListener();

        adaRecycler =findViewById(R.id.adaKitchenRecycler);

        adaRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adaAdaptor=new PopulateKitchensWithItemsAdaptor(populateAdaPage(LoginPage.getAge()),adalistener2);

        adaRecycler.setAdapter(adaAdaptor);



    }



    public void setAdaOnclickListener(){

        adalistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",adaItems.get(position).getName());
            intent5.putExtra("imageUrl",adaItems.get(position).getImageURL());
            intent5.putExtra("nationality",adaItems.get(position).getNationality());
            intent5.putExtra("price",adaItems.get(position).getPrice());
            intent5.putExtra("RestaurantName","Ada Kitchen");

            startActivity(intent5);};

    }









    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<ItemData> populateAdaPage(int age ) {


        adaItems.add(new ItemData(12, "Catfish peppered soup", "African", R.drawable.adacatfish, ""));
        adaItems.add(new ItemData(9, "MoiMoi", "African", R.drawable.obandemoimoi, ""));
        adaItems.add(new ItemData(18, "Egusi soup", "African", R.drawable.obandeegusisoup, ""));
        adaItems.add(new ItemData(6, "Alcoholic drinks", "", R.drawable.adaassortedbear, "alcoholic"));
        adaItems.add(new ItemData(3, "Chin-Chin", "African", R.drawable.obandechinchin, ""));
        adaItems.add(new ItemData(11, "Fried Rice with goat meat", "African", R.drawable.friedriceone, ""));
        adaItems.add(new ItemData(7, "Porridge bean and Plantain ", "African", R.drawable.obandepouridgebeans, ""));
        adaItems.add(new ItemData(3, "Soft drinks", "", R.drawable.adasoftdrinks, ""));
        adaItems.add(new ItemData(20, "Goat Peppered soup", "African", R.drawable.adapepersoup, ""));
        adaItems.add(new ItemData(5, "Heineken Pride", "", R.drawable.adachilledheineken, "alcoholic"));
        adaItems.add(new ItemData(5, "Hero bear", "", R.drawable.adaherobear, "alcoholic"));
        adaItems.add(new ItemData(7, "Extra Stout", "", R.drawable.adaguinessbeer, "alcoholic"));
        List<ItemData> allMatch = adaItems.stream().filter(p -> p.getAlcoholic().equals(""))
                .collect(Collectors.toList());

        if (!LoginPage.getCountry().equals("Nigeria")) return adaItems;

        else {

            if (age >= 18) return adaItems;

            else return allMatch;
        }


    }
}
