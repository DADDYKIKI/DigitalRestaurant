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

public class ObandeKitchen extends AppCompatActivity {

    private PopulateKitchensWithItemsAdaptor.RestaurantsRecyclerViewListener obandelistener2;

    private RecyclerView.Adapter obandeAdaptor;

    private RecyclerView obandeRecycler;

    private List<ItemData> obandeItems;

    private FloatingActionButton floater;

    private TextView homeKey,menuKey;

    private DatabaseHelper helper;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obande_restaurant_homepage);

        homeKey=findViewById(R.id.homeKey);
        menuKey=findViewById(R.id.menuKeyS);


        Toast.makeText(this, "Make your choice\n scrolling food items\nhorizontally", Toast.LENGTH_SHORT).show();


        floater=findViewById(R.id.floatingActionButton);

        obandeItems=new ArrayList<>();

        helper=new DatabaseHelper(this);



        makeObandeRestaurantAdaptor();



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
    public void makeObandeRestaurantAdaptor(){

        setObandeOnclickListener();

        obandeRecycler =findViewById(R.id.obandeKitchen);

        obandeRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        obandeAdaptor=new PopulateKitchensWithItemsAdaptor(populateObandePage(LoginPage.getAge()),obandelistener2);

        obandeRecycler.setAdapter(obandeAdaptor);



    }





    public void gotoBasket(){//................Add to Database...................

        floater.setOnClickListener(v -> {

            Intent intent=new Intent(this, Cart.class);

            startActivity(intent);

        });

    }
            public void setObandeOnclickListener(){

           obandelistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",obandeItems.get(position).getName());
            intent5.putExtra("imageUrl",obandeItems.get(position).getImageURL());
            intent5.putExtra("nationality",obandeItems.get(position).getNationality());
            intent5.putExtra("price",obandeItems.get(position).getPrice());
               intent5.putExtra("RestaurantName","Obande Kitchen");

            startActivity(intent5);
        };

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<ItemData> populateObandePage(int age) {


        obandeItems.add(new ItemData(7, "MoiMoi", "African", R.drawable.obandemoimoi, ""));
        obandeItems.add(new ItemData(15, "Egusi soup", "African", R.drawable.obandeegusisoup, ""));
        obandeItems.add(new ItemData(10, "Fried Rice", "African", R.drawable.obandefriedrice, ""));
        obandeItems.add(new ItemData(4, "Chin-Chin", "African", R.drawable.obandechinchin, ""));
        obandeItems.add(new ItemData(21, "Fried Rice with goat meat", "African", R.drawable.friedriceone, ""));
        obandeItems.add(new ItemData(7, "Pouridge bean and Plantain ", "African", R.drawable.obandepouridgebeans, ""));
        obandeItems.add(new ItemData(10, "Pounded Yam", "African", R.drawable.towel, ""));
        obandeItems.add(new ItemData(12, "Hot Dog++", "European", R.drawable.uktwo, ""));

        List<ItemData> allMatch = obandeItems.stream().filter(p -> p.getAlcoholic().equals(""))
                .collect(Collectors.toList());

        if (!LoginPage.getCountry().equals("Nigeria")) return obandeItems;

        else {

            if (age >= 18) return obandeItems;

            else return allMatch;
        }
    }

}
