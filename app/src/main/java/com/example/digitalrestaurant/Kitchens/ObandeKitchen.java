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

public class ObandeKitchen extends AppCompatActivity {

    private PopularDishAdaptor.RestaurantsRecyclerViewListener adalistener2;

    RecyclerView.Adapter obandeAdaptor;

    RecyclerView obandeRecycler;

    ArrayList<ItemData> obandeItems;

    FloatingActionButton floater;

    TextView homeKey,menuKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obande_restaurant_homepage);

        homeKey=(TextView) findViewById(R.id.homeKey);
        menuKey=findViewById(R.id.menuKey);

        floater=(FloatingActionButton)findViewById(R.id.floatingActionButton);

        obandeItems=new ArrayList<ItemData>();

        makeAprokoRestaurantAdaptor();

        gotoBasket();

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
    public void makeAprokoRestaurantAdaptor(){

        setObandeOnclickListener();

        obandeRecycler =findViewById(R.id.obandeKitchen);

        obandeRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        obandeAdaptor=new PopularDishAdaptor(populateObandePage(),adalistener2);

        obandeRecycler.setAdapter(obandeAdaptor);



    }

    public void gotoBasket(){//................Add to Database...................

        floater.setOnClickListener(v -> {

            Intent intent=new Intent(this, Cart.class);

            startActivity(intent);

        });

    }
            public void setObandeOnclickListener(){

        adalistener2= (v, position) -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            intent5.putExtra("name",obandeItems.get(position).getName());
            intent5.putExtra("imageUrl",obandeItems.get(position).getImageURL());
            intent5.putExtra("nationality",obandeItems.get(position).getNationality());
            intent5.putExtra("price",obandeItems.get(position).getPrice());

            startActivity(intent5);};

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
