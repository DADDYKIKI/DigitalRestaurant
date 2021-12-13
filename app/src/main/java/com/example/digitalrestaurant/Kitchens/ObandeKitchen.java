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


        floater=findViewById(R.id.floatingActionButton);

        obandeItems=new ArrayList<>();

        helper=new DatabaseHelper(this);

        Toast.makeText(this, "Make your choice \n scrolling food items\nvertically", Toast.LENGTH_SHORT).show();

        makeObandeRestaurantAdaptor();



        gotoBasket();

        homeKey();
        menuKey();

}

    public void homeKey(){//Back home
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
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeObandeRestaurantAdaptor(){//Attaching list of food items with recycler view for display

        setObandeOnclickListener();

        obandeItems=new AdminPage().populateObandePage(LoginPage.getAge());

        obandeRecycler =findViewById(R.id.obandeKitchen);

        obandeRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        obandeAdaptor=new PopulateKitchensWithItemsAdaptor(obandeItems,obandelistener2);

        obandeRecycler.setAdapter(obandeAdaptor);



    }





    public void gotoBasket(){//................Add to Database...................

        floater.setOnClickListener(v -> {

            Intent intent=new Intent(this, Order.class);

            startActivity(intent);

        });

    }
            public void setObandeOnclickListener(){//This will send my order details to my order/basket page

           obandelistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",obandeItems.get(position).getName());
            intent5.putExtra("imageUrl",obandeItems.get(position).getImageURL());
            intent5.putExtra("nationality",obandeItems.get(position).getNationality());
            intent5.putExtra("price",obandeItems.get(position).getPrice());
               intent5.putExtra("restaurant","Obande Kitchen");

            startActivity(intent5);
        };

    }


}
