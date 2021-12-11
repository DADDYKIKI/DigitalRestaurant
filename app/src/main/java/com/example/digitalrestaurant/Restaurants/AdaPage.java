package com.example.digitalrestaurant.Restaurants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.digitalrestaurant.Adaptors.RestaurantOrdersAdaptor;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.VendorOrderDetails;
import com.example.digitalrestaurant.R;

import java.util.ArrayList;
import java.util.List;

public class AdaPage extends AppCompatActivity {

    DatabaseHelper myOrders;

    List<VendorOrderDetails> vOrders;

    RecyclerView adaRecycler;

    RestaurantOrdersAdaptor orderAdaptors;

    private long press;

    private  static List<VendorOrderDetails> myOrder3=new ArrayList<>();

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
        setContentView(R.layout.activity_ada_page);


        myOrders=new DatabaseHelper(this);

        vOrders=new ArrayList<>();

        MyOrders();


    }

    public static List<VendorOrderDetails> getMyOrder3() {
        return myOrder3;
    }


    public static void setMyOrder3(List<VendorOrderDetails> order) {

        myOrder3=order;
    }

    public void MyOrders(){

        vOrders=myOrders.getAdaCartItems();

        adaRecycler=findViewById(R.id.adaMainRecyclerView);

        adaRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

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
                vOrders.remove(viewHolder.getAdapterPosition());
                orderAdaptors.notifyDataSetChanged();


                setMyOrder3(vOrders);

                myOrders.clearItemsFromAdaTabel();

                for (VendorOrderDetails x : getMyOrder3()) {

                   VendorOrderDetails oders2 = new VendorOrderDetails(x.getFoodName(), x.getCusName(), x.getTotalFoodPrice(),x.getQuantity()
                            , x.getPhone());


                    myOrders.addAdaData(oders2);


                }
            }


        };

        orderAdaptors=new RestaurantOrdersAdaptor(vOrders);

        new ItemTouchHelper(itemtouch).attachToRecyclerView(adaRecycler);

        adaRecycler.setAdapter( orderAdaptors);



    }

}