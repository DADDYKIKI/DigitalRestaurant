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

public class ObandePage extends AppCompatActivity {

    DatabaseHelper myOrders3;

    List<VendorOrderDetails> vOrders3;

    RecyclerView obandeRecycler;

    RecyclerView.Adapter orderAdaptors3;

    private  static List<VendorOrderDetails> myOrder5=new ArrayList<>();

    Button obandecleare;

    private long press;


    @Override
    public void onBackPressed() {//Exit app


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
        setContentView(R.layout.activity_obande_page);

        myOrders3=new DatabaseHelper(this);

        obandecleare=findViewById(R.id.obandecleare);

        vOrders3=new ArrayList<>();

        MyOrders3();
        clearData();


    }

    public void clearData(){//Clear order items from Obande kitchen
        obandecleare.setOnClickListener(v -> {

            myOrders3.clearItemsFromObande();

            Intent intent = new Intent(this, ObandePage.class);

            startActivity(intent);

        });


    }


    public static List<VendorOrderDetails> getMyOrder5() {
        return myOrder5;
    }


    public static void setMyOrder5(List<VendorOrderDetails> order) {

        myOrder5=order;
    }



    public void MyOrders3(){//Controls which restaurant  will receive items needed from them

        vOrders3=myOrders3.getObandeCartItems();

        obandeRecycler=findViewById(R.id.obandeMainRecyclerView);

        LinearLayoutManager layout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        obandeRecycler.setLayoutManager(layout);

        layout.setReverseLayout(true);

        layout.setStackFromEnd(true);

        //Swiping and deleting

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
                vOrders3.remove(viewHolder.getAdapterPosition());
                orderAdaptors3.notifyDataSetChanged();


                setMyOrder5(vOrders3);//current order received

                myOrders3.clearItemsFromObande();

                for (VendorOrderDetails x : getMyOrder5()) {

                    VendorOrderDetails oders2 = new VendorOrderDetails(x.getFoodName(), x.getCusName(), x.getTotalFoodPrice(),x.getQuantity()
                            , x.getPhone());


                    myOrders3.addObandeData(oders2);//Current order stored


                }
            }


        };

        orderAdaptors3=new RestaurantOrdersAdaptor(vOrders3);

        new ItemTouchHelper(itemtouch).attachToRecyclerView(obandeRecycler);

       obandeRecycler.setAdapter( orderAdaptors3);




    }
}