package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.digitalrestaurant.Adaptor.PopularDishAdaptor;
import com.example.digitalrestaurant.Adaptor.LocationAdaptor;
import com.example.digitalrestaurant.LocationDetails.LocationDetails;
import com.example.digitalrestaurant.Adaptor.RestaurantsAdaptor;
import com.example.digitalrestaurant.RestaurantsData.RestautantsDetails;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    //Parameters for horizontal dish display
    RecyclerView.Adapter godwinAdaptor,godwinAdaptor2,godwinAdaptor3;

    private RestaurantsAdaptor.AllInOneRecyclerViewListener AllInOneListener2;

    private RecyclerView recyclerView,recyclerView2,recyclerView3;


    private ArrayList<ItemData> myItems;
    Context context;


    //Parameters for horizontal Restaurants name display

    private ArrayList<RestautantsDetails> restaurantslist;


    //Parameters for horizontal Location name display

    private ArrayList<LocationDetails> locationLists;

    private RestaurantsAdaptor.AllInOneRecyclerViewListener listener2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        myItems=new ArrayList<ItemData>();
        restaurantslist=new ArrayList<RestautantsDetails>();
        locationLists=new ArrayList<LocationDetails>();

        //TextView restaurantName= (TextView) findViewById(R.id.enterLoginEmail);



        makeAdaptor();



    }


    public void makeAdaptor(){


        setMyOnclickListener();


        recyclerView=findViewById(R.id.obandeKitchen);
        recyclerView2=findViewById(R.id.restaurantsRecycler);
        recyclerView3=findViewById(R.id.locationRecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        godwinAdaptor=new PopularDishAdaptor(populateAdaPage());
        godwinAdaptor2=new RestaurantsAdaptor(populateItemInfo2(),AllInOneListener2);
        godwinAdaptor3=new LocationAdaptor(populateItemInfo3());

        recyclerView.setAdapter(godwinAdaptor);
        recyclerView2.setAdapter(godwinAdaptor2);
        recyclerView3.setAdapter(godwinAdaptor3);


    }



    public void setMyOnclickListener(){

        AllInOneListener2=new RestaurantsAdaptor.AllInOneRecyclerViewListener() {
            @Override
            public void onClickMe(View v, int position) {
                Intent intent =new Intent(getApplicationContext(), ApprokoKitchen.class);
                Intent intent2 =new Intent(getApplicationContext(), ObandeKitchen.class);
                Intent intent3 =new Intent(getApplicationContext(), AdaKitchen.class);
                Intent intent4 =new Intent(getApplicationContext(), Stainless.class);

                intent.putExtra("name",restaurantslist.get(position).getRestaurantsName());
                intent.putExtra("location",restaurantslist.get(position).getRestaurantsLocation());
                intent.putExtra("nationality",restaurantslist.get(position).getRestaurantNationality());

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


            }
        };


    }





   public ArrayList<ItemData> populateAdaPage(){


       myItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
       myItems.add(new ItemData(8,"Rice/Plantain","African" ,R.drawable.jelofplantrain));
       myItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
       myItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
       myItems.add(new ItemData(21,"Fried Rice","African" ,R.drawable.friedriceone));
       myItems.add(new ItemData(7,"Assorted meats","Asian" ,R.drawable.tablefoodpic));
       myItems.add(new ItemData(10,"Pounded Yam","African" ,R.drawable.towel));
       myItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return myItems;
    }

    public ArrayList<ItemData> populateObandePage(){


        myItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        myItems.add(new ItemData(8,"Rice/Plantain","European" ,R.drawable.jelofplantrain));
        myItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        myItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
        myItems.add(new ItemData(21,"Fried Rice","European" ,R.drawable.friedriceone));
        myItems.add(new ItemData(7,"Assorted meats","European" ,R.drawable.tablefoodpic));
        myItems.add(new ItemData(10,"Pounded Yam","European" ,R.drawable.towel));
        myItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return myItems;
    }

    public ArrayList<ItemData> populateAprokoPage(){


        myItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        myItems.add(new ItemData(8,"Rice/Plantain","European" ,R.drawable.jelofplantrain));
        myItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        myItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
        myItems.add(new ItemData(21,"Fried Rice","European" ,R.drawable.friedriceone));
        myItems.add(new ItemData(7,"Assorted meats","European" ,R.drawable.tablefoodpic));
        myItems.add(new ItemData(10,"Pounded Yam","European" ,R.drawable.towel));
        myItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return myItems;
    }

    public ArrayList<ItemData> populateStainlessPage(){


        myItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        myItems.add(new ItemData(8,"Rice/Plantain","European" ,R.drawable.jelofplantrain));
        myItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        myItems.add(new ItemData(15,"Sauce","European" ,R.drawable.mixture));
        myItems.add(new ItemData(21,"Fried Rice","European" ,R.drawable.friedriceone));
        myItems.add(new ItemData(7,"Assorted meats","European" ,R.drawable.tablefoodpic));
        myItems.add(new ItemData(10,"Pounded Yam","European" ,R.drawable.towel));
        myItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return myItems;
    }



    public ArrayList<RestautantsDetails> populateItemInfo2(){

        restaurantslist.add(new RestautantsDetails("Approko Kitchen","G1",
                                "Nigerian",R.drawable.aprokokitchen,populateAprokoPage()));
        restaurantslist.add(new RestautantsDetails("Obande Kitchen","L2",
                            "Nigerian",R.drawable.obandekitchen,populateObandePage()));
        restaurantslist.add(new RestautantsDetails("Ada Restaurant and Bar",
                "L1","Nigerian",R.drawable.adakitchen,populateAdaPage()));
        restaurantslist.add(new RestautantsDetails("Stainless",
                "G3","Nigerian",R.drawable.silver,populateStainlessPage()));

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