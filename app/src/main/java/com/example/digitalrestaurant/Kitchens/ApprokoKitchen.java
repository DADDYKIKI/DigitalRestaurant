package com.example.digitalrestaurant.Kitchens;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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

public class ApprokoKitchen extends AppCompatActivity {

    private PopularDishAdaptor.RestaurantsRecyclerViewListener approkolistener2;

    private RecyclerView.Adapter aprokoAdaptor;

    private RecyclerView aprokoRecycler;

    private List<ItemData> aprokoItems;

    private FloatingActionButton floater;

    private TextView homeKey,menuKey;

    private DatabaseHelper helper;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aproko_resataurant_homepage);

        homeKey=findViewById(R.id.homeKey);
        menuKey=findViewById(R.id.menuKey);

        floater=findViewById(R.id.floatingActionButton);

        aprokoItems=new ArrayList<>();

        helper=new DatabaseHelper(this);

        makeApprokoRestaurantAdaptor();

       // gotoBasket();

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



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeApprokoRestaurantAdaptor(){

        setAprokoOnclickListener();

        aprokoRecycler =findViewById(R.id.aprokoKitchen);

        aprokoRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        aprokoAdaptor=new PopularDishAdaptor(populateAprokoPage(20),approkolistener2);

        aprokoRecycler.setAdapter(aprokoAdaptor);



    }

    public void gotoBasket(){//................Add to Database...................

        floater.setOnClickListener(v -> {

            Intent intent=new Intent(this, Cart.class);

            startActivity(intent);

        });

    }

    public void setAprokoOnclickListener(){

            approkolistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",aprokoItems.get(position).getName());
            intent5.putExtra("imageUrl",aprokoItems.get(position).getImageURL());
            intent5.putExtra("nationality",aprokoItems.get(position).getNationality());
            intent5.putExtra("price",aprokoItems.get(position).getPrice());
                intent5.putExtra("RestaurantName","Approko Kitchen");

            startActivity(intent5);
        };

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public  List<ItemData> populateAprokoPage(int age){


        aprokoItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats,""));
        aprokoItems.add(new ItemData(8,"Rice/Plantain","Asian" ,R.drawable.jelofplantrain,""));
        aprokoItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo,""));
        aprokoItems.add(new ItemData(15,"Sauce","Asain" ,R.drawable.mixture,""));
        aprokoItems.add(new ItemData(15,"Sauce","Asain" ,R.drawable.mixture,""));
        aprokoItems.add(new ItemData(21,"Fried Rice","African" ,R.drawable.friedriceone,""));
        aprokoItems.add(new ItemData(7,"Assorted meats","Asian" ,R.drawable.tablefoodpic,""));
        aprokoItems.add(new ItemData(10,"Pounded Yam","African" ,R.drawable.towel,""));
        aprokoItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo,""));

        List<ItemData> allMatch=aprokoItems.stream().filter(p->p.getAlcoholic().equals(""))
                .collect(Collectors.toList());

        if(age<18)return allMatch;

        return aprokoItems;
    }

}
