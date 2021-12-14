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
        adaItems.add(new ItemData(3, "Xclusic", "European", R.drawable.euro2, ""));
        adaItems.add(new ItemData(11, "Classic", "European", R.drawable.euro3, ""));
        adaItems.add(new ItemData(7, "Runtown", "Europena", R.drawable.euro3, ""));
        adaItems.add(new ItemData(23, "Exotic", "", R.drawable.euro4, ""));
        adaItems.add(new ItemData(30, "Vintage", "", R.drawable.euro5, ""));
        adaItems.add(new ItemData(7, "Chin-Chin", "African", R.drawable.obandechinchin, ""));
        adaItems.add(new ItemData(11, "Fried Rice with goat meat", "African", R.drawable.friedriceone, ""));
        adaItems.add(new ItemData(14, "Porridge bean and Plantain ", "African", R.drawable.obandepouridgebeans, ""));
        adaItems.add(new ItemData(5, "Soft drinks", "", R.drawable.adasoftdrinks, ""));
        adaItems.add(new ItemData(20, "Goat Peppered soup", "African", R.drawable.adapepersoup, ""));
        adaItems.add(new ItemData(10, "Heineken Pride", "", R.drawable.adachilledheineken, "alcoholic"));
        adaItems.add(new ItemData(12, "Hero bear", "", R.drawable.adaherobear, "alcoholic"));
        adaItems.add(new ItemData(25, "Extra Stout", "", R.drawable.adaguinessbeer, "alcoholic"));



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


        obandeItems.add(new ItemData(7, "Vegeterian", "Asia", R.drawable.vegeterian, ""));
        obandeItems.add(new ItemData(15, "Vegeterian", "Asia", R.drawable.vegeterian2, ""));
        obandeItems.add(new ItemData(10, "Vegeterian", "Europian", R.drawable.vegeterian3, ""));
        obandeItems.add(new ItemData(15, "Vegeterian", "Asia", R.drawable.vegeterian4, ""));
        obandeItems.add(new ItemData(21, "Vegeterian", "European", R.drawable.vegeterian5, ""));
        obandeItems.add(new ItemData(9, "Vegeterian", "Asia", R.drawable.vegeterian6, ""));
        obandeItems.add(new ItemData(10, "Vegeterian", "Asia", R.drawable.vegeterian7, ""));
        obandeItems.add(new ItemData(12, "Vegeterian", "European", R.drawable.vegeterian8, ""));
        obandeItems.add(new ItemData(21, "Vegeterian", "European", R.drawable.vegeterian9, ""));
        obandeItems.add(new ItemData(9, "Vegeterian", "Asia", R.drawable.vegeterian10, ""));
        obandeItems.add(new ItemData(10, "Vegeterian", "Asia", R.drawable.vegeterian11, ""));
        obandeItems.add(new ItemData(12, "Vegeterian", "European", R.drawable.vegeterian12, ""));
        obandeItems.add(new ItemData(21, "Fired chicken", "African", R.drawable.friedwholechicken, ""));
        obandeItems.add(new ItemData(9, "Chicken and chips", "Asia", R.drawable.chickenwithchips, ""));
        obandeItems.add(new ItemData(10, "Chips", "European", R.drawable.euro9, ""));
        obandeItems.add(new ItemData(12, "Vegeterian", "European", R.drawable.vegeterian8, ""));

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

        stainlessItems.add(new ItemData(7, "Extra Stout", "European", R.drawable.adaguinessbeer, "alcoholic"));
        stainlessItems.add(new ItemData(21, "Hero Special", "African", R.drawable.adaherobear, "alcoholic"));
        stainlessItems.add(new ItemData(19, "Best Bears", "European", R.drawable.adaassortedbear, "alcoholic"));
        stainlessItems.add(new ItemData(13, "Budacos", "European", R.drawable.budacos, "alcoholic"));
        stainlessItems.add(new ItemData(18, "Best Bears", "European", R.drawable.adaassortedbear, "alcoholic"));
        stainlessItems.add(new ItemData(13, "crsytal", "European", R.drawable.crystalcopy, "alcoholic"));
        stainlessItems.add(new ItemData(22, "dos", "European", R.drawable.dos, "alcoholic"));
        stainlessItems.add(new ItemData(13, "Bud", "European", R.drawable.budcopy, "alcoholic"));
        stainlessItems.add(new ItemData(20, "Luadini Collection", "European", R.drawable.luadini, "alcoholic"));
        stainlessItems.add(new ItemData(50, "Full Collection", "European", R.drawable.collecetedbeer, "alcoholic"));
        stainlessItems.add(new ItemData(32, "London Pale", "European", R.drawable.londonpalealeopy, "alcoholic"));
        stainlessItems.add(new ItemData(20, "Heineken", "European", R.drawable.henekencopy, "alcoholic"));


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
        myItems.add(new AdvertItems(13, "Budacos", "European", R.drawable.budacos, "alcoholic","Stainless"));
        myItems.add(new AdvertItems(18, "Best Bears", "European", R.drawable.adaassortedbear, "alcoholic","Stainless"));
        myItems.add(new AdvertItems(13, "crsytal", "European", R.drawable.crystalcopy, "alcoholic","Stainless"));
        myItems.add(new AdvertItems(11,"Fried Rice with goat meat","African" ,R.drawable.friedriceone,"",""));
        myItems.add(new AdvertItems(7, "Runtown", "Europena", R.drawable.euro3, "","Ada Kitchen"));
        myItems.add(new AdvertItems(23, "Exotic", "", R.drawable.euro4, "","Ada Kitchen"));
        myItems.add(new AdvertItems(30, "Vintage", "", R.drawable.euro5, "","Ada Kitchen"));
        myItems.add(new AdvertItems(7, "Chin-Chin", "African", R.drawable.obandechinchin, "","Ada Kitchen"));
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



