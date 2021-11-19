package com.example.digitalrestaurant;

import com.example.digitalrestaurant.RestaurantsData.RestautantsDetails;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;


public class PopulateRestaurant {
    public ArrayList<RestautantsDetails> getRestaurantslist() {
        return restaurantslist;
    }

    public void setRestaurantslist(ArrayList<RestautantsDetails> restaurantslist) {
        this.restaurantslist = restaurantslist;
    }

    public PopulateRestaurant(ArrayList<RestautantsDetails> restaurantslist) {
        this.restaurantslist = restaurantslist;
    }

    private ArrayList<RestautantsDetails> restaurantslist=new ArrayList<RestautantsDetails>();


    private ArrayList<ItemData> stainlessItems = new ArrayList<ItemData>();

    private ArrayList<ItemData> adaItems = new ArrayList<ItemData>();

    private ArrayList<ItemData>  aprokoItems=new ArrayList<ItemData>();

    private ArrayList<ItemData> obandeItems=new ArrayList<ItemData>();


    public ArrayList<RestautantsDetails> populateRestaurant(){

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

    public ArrayList<ItemData> populateStainlessPage() {

        stainlessItems.add(new ItemData(12, "Catfish peppered soup", "African", R.drawable.adacatfish));
        stainlessItems.add(new ItemData(9, "MoiMoi", "African", R.drawable.obandemoimoi));
        stainlessItems.add(new ItemData(18, "Egusi soup", "African", R.drawable.obandeegusisoup));
        stainlessItems.add(new ItemData(6, "Acolic drinks", "", R.drawable.adaassortedbear));
        stainlessItems.add(new ItemData(3, "Chin-Chin", "African", R.drawable.obandechinchin));
        stainlessItems.add(new ItemData(11, "Fried Rice with goat meat", "African", R.drawable.friedriceone));
        stainlessItems.add(new ItemData(7, "Porridge bean and Plantain ", "African", R.drawable.obandepouridgebeans));
        stainlessItems.add(new ItemData(3, "Soft drinks", "", R.drawable.adasoftdrinks));
        stainlessItems.add(new ItemData(20, "Goat Peppered soup", "African", R.drawable.adapepersoup));
        stainlessItems.add(new ItemData(5, "Heineken Pride", "", R.drawable.adachilledheineken));
        stainlessItems.add(new ItemData(5, "Hero bear", "", R.drawable.adaherobear));
        stainlessItems.add(new ItemData(7, "Extra Stout", "", R.drawable.adaguinessbeer));

        return stainlessItems;
    }

    public ArrayList<ItemData> populateAdaPage() {

        adaItems.add(new ItemData(12, "Catfish peppered soup", "African", R.drawable.adacatfish));
        adaItems.add(new ItemData(9, "MoiMoi", "African", R.drawable.obandemoimoi));
        adaItems.add(new ItemData(18, "Egusi soup", "African", R.drawable.obandeegusisoup));
        adaItems.add(new ItemData(6, "Acolic drinks", "", R.drawable.adaassortedbear));
        adaItems.add(new ItemData(3, "Chin-Chin", "African", R.drawable.obandechinchin));
        adaItems.add(new ItemData(11, "Fried Rice with goat meat", "African", R.drawable.friedriceone));
        adaItems.add(new ItemData(7, "Porridge bean and Plantain ", "African", R.drawable.obandepouridgebeans));
        adaItems.add(new ItemData(3, "Soft drinks", "", R.drawable.adasoftdrinks));
        adaItems.add(new ItemData(20, "Goat Peppered soup", "African", R.drawable.adapepersoup));
        adaItems.add(new ItemData(5, "Heineken Pride", "", R.drawable.adachilledheineken));
        adaItems.add(new ItemData(5, "Hero bear", "", R.drawable.adaherobear));
        adaItems.add(new ItemData(7, "Extra Stout", "", R.drawable.adaguinessbeer));

        return adaItems;


    }

    public ArrayList<ItemData> populateAprokoPage(){


        aprokoItems.add(new ItemData(12,"Meat","European" ,R.drawable.justmeats));
        aprokoItems.add(new ItemData(8,"Rice/Plantain","Asian" ,R.drawable.jelofplantrain));
        aprokoItems.add(new ItemData(4,"Hot Dog","European" ,R.drawable.uktwo));
        aprokoItems.add(new ItemData(15,"Sauce","Asain" ,R.drawable.mixture));
        aprokoItems.add(new ItemData(15,"Sauce","Asain" ,R.drawable.mixture));
        aprokoItems.add(new ItemData(21,"Fried Rice","African" ,R.drawable.friedriceone));
        aprokoItems.add(new ItemData(7,"Assorted meats","Asian" ,R.drawable.tablefoodpic));
        aprokoItems.add(new ItemData(10,"Pounded Yam","African" ,R.drawable.towel));
        aprokoItems.add(new ItemData(12,"Hot Dog++","European" ,R.drawable.uktwo));

        return aprokoItems;
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