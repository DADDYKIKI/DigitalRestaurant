package com.example.digitalrestaurant.Restaurants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.digitalrestaurant.Adaptors.RestaurantOrdersAdaptor;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.VendorOrderDetails;
import com.example.digitalrestaurant.R;

import java.util.ArrayList;
import java.util.List;

public class StainlessPage extends AppCompatActivity {

    DatabaseHelper myOrders4;

    List<VendorOrderDetails> vOrders4;

    RecyclerView stainlessRecycler;

    RecyclerView.Adapter orderAdaptors4;

    private  static List<VendorOrderDetails> myOrder6=new ArrayList<>();

    Button clear;

    private long press;


    @Override
    public void onBackPressed() {


        if(press+2000>System.currentTimeMillis()){

            finishAffinity();
            System.exit(0);

            return;}

        else {
            Toast.makeText(this, "Press again to exit your app", Toast.LENGTH_SHORT).show();

        }press=System.currentTimeMillis();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stainless_page);

        clear=findViewById(R.id.stainlessClear);

        myOrders4=new DatabaseHelper(this);

        vOrders4=new ArrayList<>();


        MyOrders4();

        clearData();


    }

    public void clearData(){
        clear.setOnClickListener(v -> {

            myOrders4.clearItemsFromStainless();

            Intent intent = new Intent(this,StainlessPage.class);

            startActivity(intent);

        });


    }

    public static List<VendorOrderDetails> getMyOrder6() {
        return myOrder6;
    }


    public static void setMyOrder6(List<VendorOrderDetails> order) {

        myOrder6=order;
    }

    public void MyOrders4(){

        vOrders4=myOrders4.getStainlessCartItems();

        stainlessRecycler=findViewById(R.id.stainlessMainRecyclerView);

        stainlessRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        ItemTouchHelper.SimpleCallback itemtouch=new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                vOrders4.remove(viewHolder.getAdapterPosition());

                orderAdaptors4.notifyDataSetChanged();


                setMyOrder6(vOrders4);

                myOrders4.clearItemsFromStainless();

                for (VendorOrderDetails x : getMyOrder6()) {

                    VendorOrderDetails oders2 = new VendorOrderDetails(x.getFoodName(),x.getCusName(), x.getTotalFoodPrice() ,x.getQuantity()
                            , x.getPhone());


                    myOrders4.addStainlessData(oders2);


                }
            }


        };

        orderAdaptors4=new RestaurantOrdersAdaptor(vOrders4);

        new ItemTouchHelper(itemtouch).attachToRecyclerView(stainlessRecycler);

        stainlessRecycler.setAdapter( orderAdaptors4);




    }
}
