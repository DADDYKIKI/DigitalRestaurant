package com.example.digitalrestaurant;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.digitalrestaurant.Authentications.LoginPage;
import com.example.digitalrestaurant.Details.AdvertItems;
import com.example.digitalrestaurant.Details.ItemData;
import com.example.digitalrestaurant.Details.LocationDetails.LocationDetails;
import com.example.digitalrestaurant.Details.RestaurantsData.RestaurantsDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminPage {


    //Initializing all containers for each restaurant properties
    private List<ItemData> adaItems = new ArrayList<>();
    private List<ItemData> aprokoItems = new ArrayList<>();
    private List<ItemData> obandeItems= new ArrayList<>();
    private List<ItemData> stainlessItems= new ArrayList<>();
    private List<AdvertItems> myItems = new ArrayList<>();
    private List<RestaurantsDetails> restaurantslist = new ArrayList<>();
    private List<LocationDetails> locationLists= new ArrayList<>();


//......................................................................................................................

    //..........................Strickly for Ada Restaurant.............................................................



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



        //This uses stream Api to filter out alcoholic food items if your location is Nigeria
        List<ItemData> allMatch = adaItems.stream().filter(p -> p.getAlcoholic().equals(""))
                .collect(Collectors.toList());

        if (!LoginPage.getCountry().equals("Nigeria")) return adaItems;

        else {

            if (age >= 18) return adaItems;

            else return allMatch;
        }

    }

    //......................................................................................................................

    //..........................Strickly for Approko Restaurant.............................................................



    @RequiresApi(api = Build.VERSION_CODES.N)
    public  List<ItemData> populateAprokoPage(int age) {


        aprokoItems.add(new ItemData(12, "Meat", "European", R.drawable.justmeats, ""));
        aprokoItems.add(new ItemData(8, "Rice/Plantain", "Asian", R.drawable.jelofplantrain, ""));
        aprokoItems.add(new ItemData(4, "Hot Dog", "European", R.drawable.uktwo, ""));
        aprokoItems.add(new ItemData(15, "Sauce", "Asain", R.drawable.mixture, ""));
        aprokoItems.add(new ItemData(15, "Sauce", "Asain", R.drawable.mixture, ""));
        aprokoItems.add(new ItemData(21, "Fried Rice", "African", R.drawable.friedriceone, ""));
        aprokoItems.add(new ItemData(7, "Assorted meats", "Asian", R.drawable.tablefoodpic, ""));
        aprokoItems.add(new ItemData(10, "Pounded Yam", "African", R.drawable.towel, ""));
        aprokoItems.add(new ItemData(12, "Hot Dog++", "European", R.drawable.uktwo, ""));

        List<ItemData> allMatch = aprokoItems.stream().filter(p -> p.getAlcoholic().equals(""))
                .collect(Collectors.toList());

        if (!LoginPage.getCountry().equals("Nigeria")) return aprokoItems;

        else {

            if (age >= 18) return aprokoItems;

            else return allMatch;
        }


    }



    //......................................................................................................................

    //..........................Strickly for Obande Restaurant.............................................................



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


    //......................................................................................................................

    //..........................Strickly for Stainless Restaurant.............................................................

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<ItemData> populateStainlessPage(int age) {

        stainlessItems.add(new ItemData(7, "Extra Stout", "", R.drawable.adaguinessbeer, "alcoholic"));
        stainlessItems.add(new ItemData(5, "Hero Special", "", R.drawable.adaherobear, "alcoholic"));
        stainlessItems.add(new ItemData(13, "Best Bears", "", R.drawable.adaassortedbear, "alcoholic"));


        List<ItemData> allMatch = stainlessItems.stream().filter(p -> p.getAlcoholic().equals(""))
                .collect(Collectors.toList());

        if (!LoginPage.getCountry().equals("Nigeria")) return stainlessItems;

        else {


            if (age >= 18) return stainlessItems;

            else return allMatch;
        }


    }


    //......................................................................................................................

    //..........................Strickly for Adverts display.............................................................


    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<AdvertItems> populateAdvertsPage(int age) {


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


    //......................................................................................................................

    //..........................Strickly for Restaurants display.............................................................


    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<RestaurantsDetails> populateRestaurants(){


        restaurantslist.add(new RestaurantsDetails("Approko Kitchen","G1",
                "Nigerian",R.drawable.aprokokitchen));
        restaurantslist.add(new RestaurantsDetails("Obande Kitchen","L2",
                "Nigerian",R.drawable.obandekitchen));
        restaurantslist.add(new RestaurantsDetails("Ada Restaurant and Bar",
                "L1","Nigerian",R.drawable.adakitchen));
        restaurantslist.add(new RestaurantsDetails("Stainless",
                "G2","Nigerian",R.drawable.silver));

        return restaurantslist;
    }


    //......................................................................................................................

    //..........................Strickly for adding new Location .............................................................


    public List<LocationDetails> populateLocation(){

        locationLists.add(new LocationDetails("G1","Approko Kitchen"));
        locationLists.add(new LocationDetails("G2","Stainless"));
        locationLists.add(new LocationDetails("G3","No restaurants"));
        locationLists.add(new LocationDetails("L1","Ada Restaurant and Bar"));
        locationLists.add(new LocationDetails("L2","Obande Kitchen"));
        locationLists.add(new LocationDetails("L3","No restaurants"));
        locationLists.add(new LocationDetails("R1","No restaurants"));
        locationLists.add(new LocationDetails("S5","No restaurants"));
        locationLists.add(new LocationDetails("All","No restaurants"));



        return locationLists;
    }

}



