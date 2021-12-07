package com.example.digitalrestaurant;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;


import com.example.digitalrestaurant.Adaptors.PopulateAdvertismentAdaptor;
import com.example.digitalrestaurant.Adaptors.PopulateKitchensWithItemsAdaptor;
import com.example.digitalrestaurant.Adaptors.LocationAdaptor;
import com.example.digitalrestaurant.Authentications.LoginPage;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.AdvertItems;
import com.example.digitalrestaurant.Details.ItemData;
import com.example.digitalrestaurant.Kitchens.AdaKitchen;
import com.example.digitalrestaurant.Kitchens.ApprokoKitchen;
import com.example.digitalrestaurant.Kitchens.ObandeKitchen;
import com.example.digitalrestaurant.Kitchens.Stainless;
import com.example.digitalrestaurant.Details.LocationDetails.LocationDetails;
import com.example.digitalrestaurant.Adaptors.RestaurantsAdaptor;
import com.example.digitalrestaurant.Details.RestaurantsData.RestaurantsDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends AppCompatActivity {

    //Parameters for horizontal dish display
    RecyclerView.Adapter godwinAdaptor,godwinAdaptor2,godwinAdaptor3;

    private RestaurantsAdaptor.AllInOneRecyclerViewListener AllInOneListener2;

    private PopulateKitchensWithItemsAdaptor.RestaurantsRecyclerViewListener restaurantslistener2;

    private RecyclerView recyclerView,recyclerView2,recyclerView3;


    private List<AdvertItems> myItems;
    Context context;


    //Parameters for horizontal Restaurants name display

    private ArrayList<RestaurantsDetails> restaurantslist;


    //Parameters for horizontal Location name display

    private ArrayList<LocationDetails> locationLists;

    private RestaurantsAdaptor.AllInOneRecyclerViewListener listener2;

    TextView menuKey,customerWelcomeName;

    DatabaseHelper helper;

    LoginPage login;




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        getSupportActionBar().setTitle("WELCOME TO OBANDE FOOD");

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        menuKey=findViewById(R.id.menuKeyS);
        customerWelcomeName=findViewById(R.id.customerWelcomeName);

        myItems=new ArrayList<>();
        restaurantslist=new ArrayList<>();
        locationLists=new ArrayList<>();

        login=new LoginPage();

        helper=new DatabaseHelper(this);




        makeAdaptor();
        menuKey();
        //setWelcomeText();


    }

    public void setWelcomeText(){



        customerWelcomeName.setText(login.setCustomerWelcomeTextF());


    }

    public void menuKey(){
            menuKey.setOnClickListener(v -> {
            Intent intent2=new Intent(this, Menu.class);
            startActivity(intent2);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeAdaptor(){


        setMyOnclickListener();


        recyclerView=findViewById(R.id.obandeKitchen);
        recyclerView2=findViewById(R.id.restaurantsRecycler);
        recyclerView3=findViewById(R.id.locationRecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        godwinAdaptor=new PopulateAdvertismentAdaptor(populateAdaPage(LoginPage.getAge()),this);
        godwinAdaptor2=new RestaurantsAdaptor(populateItemInfo2(),AllInOneListener2);
        godwinAdaptor3=new LocationAdaptor(populateItemInfo3());

        recyclerView.setAdapter(godwinAdaptor);
        recyclerView2.setAdapter(godwinAdaptor2);
        recyclerView3.setAdapter(godwinAdaptor3);






    }



    public void setMyOnclickListener(){

        AllInOneListener2= (v, position) -> {

            Intent intent =new Intent(getApplicationContext(), ApprokoKitchen.class);
            Intent intent2 =new Intent(getApplicationContext(), ObandeKitchen.class);
            Intent intent3 =new Intent(getApplicationContext(), AdaKitchen.class);
            Intent intent4 =new Intent(getApplicationContext(), Stainless.class);

            if(restaurantslist.get(position).getRestaurantsName().equals("Approko Kitchen")){



                startActivity(intent);
            }

            else if(restaurantslist.get(position).getRestaurantsName().equals("Obande Kitchen")){



                startActivity(intent2);
            }

            else if (restaurantslist.get(position).getRestaurantsName().equals("Ada Restaurant and Bar")){



                startActivity(intent3);
            }

            else if (restaurantslist.get(position).getRestaurantsName().equals("Stainless")){

                startActivity(intent4);
            }
        };
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<AdvertItems> populateAdaPage(int age) {


        myItems.add(new AdvertItems(12,"Catfish peppered soup","African" ,R.drawable.adacatfish,"","Ada Kitchen"));
        myItems.add(new AdvertItems(9,"MoiMoi","African" ,R.drawable.obandemoimoi,"","Stainless"));
        myItems.add(new AdvertItems(18,"Egusi soup","African" ,R.drawable.obandeegusisoup,"","Approko Kitchen"));
        myItems.add(new AdvertItems(6,"Alcoholic drinks","" ,R.drawable.adaassortedbear,"alcoholic",""));
        myItems.add(new AdvertItems(3,"Chin-Chin","African" ,R.drawable.obandechinchin,"",""));
        myItems.add(new AdvertItems(11,"Fried Rice with goat meat","African" ,R.drawable.friedriceone,"",""));
        myItems.add(new AdvertItems(7,"Porridge bean and Plantain ","African" ,R.drawable.obandepouridgebeans,"Stainless",""));
        myItems.add(new AdvertItems(3,"Soft drinks","" ,R.drawable.adasoftdrinks,"",""));
        myItems.add(new AdvertItems(20,"Goat Peppered soup","African" ,R.drawable.adapepersoup,"",""));
        myItems.add(new AdvertItems(5,"Heineken Pride","" ,R.drawable.adachilledheineken,"alcoholic",""));
        myItems.add(new AdvertItems(5,"Hero bear","" ,R.drawable.adaherobear,"alcoholic","Stainless"));
        myItems.add(new AdvertItems(7,"Extra Stout","" ,R.drawable.adaguinessbeer,"alcoholic","Ada Kitchen"));


        List<AdvertItems> allMatch=myItems.stream().filter(p->p.getAlcoholic().equals(""))
                .collect(Collectors.toList());


        if (!LoginPage.getCountry().equals("Nigeria")) return myItems;

        else {


            if(age>=18)return myItems;

       else return allMatch;
    }}


    public ArrayList<RestaurantsDetails> populateItemInfo2(){

        restaurantslist.add(new RestaurantsDetails("Approko Kitchen","G1",
                "Nigerian",R.drawable.aprokokitchen));
        restaurantslist.add(new RestaurantsDetails("Obande Kitchen","L2",
                "Nigerian",R.drawable.obandekitchen));
        restaurantslist.add(new RestaurantsDetails("Ada Restaurant and Bar",
                "L1","Nigerian",R.drawable.adakitchen));
        restaurantslist.add(new RestaurantsDetails("Stainless",
                "G3","Nigerian",R.drawable.silver));

        return restaurantslist;
    }



    public ArrayList<LocationDetails> populateItemInfo3(){

        locationLists.add(new LocationDetails("G1"));
        locationLists.add(new LocationDetails("G2"));
        locationLists.add(new LocationDetails("G3"));
        locationLists.add(new LocationDetails("L1"));
        locationLists.add(new LocationDetails("L2"));
        locationLists.add(new LocationDetails("L3"));
        locationLists.add(new LocationDetails("R1"));
        locationLists.add(new LocationDetails("S5"));

        return locationLists;
    }





    public void click2(Object x){

        startActivity(new Intent(this, (Class<?>) x));

    }
}
