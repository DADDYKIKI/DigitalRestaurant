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

public class ApprokoPage extends AppCompatActivity {

    DatabaseHelper myOrders2;

    List<VendorOrderDetails> vOrders2;

    RecyclerView approkoRecycler;

    RecyclerView.Adapter orderAdaptors2;

    private  static List<VendorOrderDetails> myOrder4=new ArrayList<>();

    Button Approkoclearer;

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

        setContentView(R.layout.activity_approko_page);

        myOrders2=new DatabaseHelper(this);

        Approkoclearer=findViewById(R.id.Approkoclearer);

        vOrders2=new ArrayList<>();

        MyOrders2();
        clearData();


    }

    public void clearData(){
        Approkoclearer.setOnClickListener(v -> {

            myOrders2.clearItemsFromAPProkoTabel();

            Intent intent = new Intent(this, ApprokoPage.class);

            startActivity(intent);

        });


    }

    public static List<VendorOrderDetails> getMyOrder4() {
        return myOrder4;
    }


    public static void setMyOrder4(List<VendorOrderDetails> order) {

        myOrder4=order;
    }



    public void MyOrders2(){//Controls which restaurant  will receive items needed from them

        vOrders2=myOrders2.getApprokoCartItems();

        approkoRecycler=findViewById(R.id.aPprokoMainRecyclerView);

        LinearLayoutManager layout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        approkoRecycler.setLayoutManager(layout);

        layout.setReverseLayout(true);

        layout.setStackFromEnd(true);


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
                vOrders2.remove(viewHolder.getAdapterPosition());
                orderAdaptors2.notifyDataSetChanged();


                setMyOrder4(vOrders2);//Receive current state

                myOrders2.clearItemsFromAPProkoTabel();

                for (VendorOrderDetails x : getMyOrder4()) {

                    VendorOrderDetails oders2 = new VendorOrderDetails(x.getFoodName(), x.getCusName(), x.getTotalFoodPrice(),x.getQuantity()
                            , x.getPhone());


                    myOrders2.addApprokoData(oders2);//Store current state


                }
            }


        };

        orderAdaptors2=new RestaurantOrdersAdaptor(vOrders2);

        new ItemTouchHelper(itemtouch).attachToRecyclerView(approkoRecycler);

        approkoRecycler.setAdapter( orderAdaptors2);



    }}