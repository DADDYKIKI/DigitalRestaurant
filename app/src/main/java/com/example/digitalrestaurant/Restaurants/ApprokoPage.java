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

public class ApprokoPage extends AppCompatActivity {

    DatabaseHelper myOrders2;

    List<VendorOrderDetails> vOrders2;

    RecyclerView approkoRecycler;

    RecyclerView.Adapter orderAdaptors2;

    private  static List<VendorOrderDetails> myOrder4=new ArrayList<>();

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

        vOrders2=new ArrayList<>();

        MyOrders2();


    }

    public static List<VendorOrderDetails> getMyOrder4() {
        return myOrder4;
    }


    public static void setMyOrder4(List<VendorOrderDetails> order) {

        myOrder4=order;
    }

    public void MyOrders2(){

        vOrders2=myOrders2.getApprokoCartItems();

        approkoRecycler=findViewById(R.id.aPprokoMainRecyclerView);

        approkoRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

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


                setMyOrder4(vOrders2);

                myOrders2.clearItemsFromAPProkoTabel();

                for (VendorOrderDetails x : getMyOrder4()) {

                    VendorOrderDetails oders2 = new VendorOrderDetails(x.getFoodName(), x.getCusName(), x.getTotalFoodPrice(),x.getQuantity()
                            , x.getPhone());


                    myOrders2.addApprokoData(oders2);


                }
            }


        };

        orderAdaptors2=new RestaurantOrdersAdaptor(vOrders2);

        new ItemTouchHelper(itemtouch).attachToRecyclerView(approkoRecycler);

        approkoRecycler.setAdapter( orderAdaptors2);



    }}