package com.example.digitalrestaurant.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.R;

import java.util.ArrayList;
import java.util.List;

public class OrderAdaptor extends RecyclerView.Adapter<OrderAdaptor.OrderViewHolder>{

  //  private OderListener orderListener;

   List<OrderDetails> myOder;
    Context context;
    RecyclerView orderRecycler;
    final View.OnClickListener click=new OrderListener();

    public OrderAdaptor(List<OrderDetails> myOder, Context context, RecyclerView orderRecycler) {
        this.myOder = myOder;
        this.context = context;
        this.orderRecycler = orderRecycler;
    }


    public static class OrderViewHolder extends RecyclerView.ViewHolder {


        TextView foodName, foodTotalPrice, quantity;


        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);


            foodName = itemView.findViewById(R.id.itemName);
            foodTotalPrice = itemView.findViewById(R.id.itemPrice);
            quantity = itemView.findViewById(R.id.itemQuantity);


        }


    }

    @NonNull
    @Override
    public OrderAdaptor.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cartView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_container,parent,false );
        cartView.setOnClickListener(click);
        OrderViewHolder myHolder=new OrderViewHolder(cartView);
        return  myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdaptor.OrderViewHolder myHolder, int position) {
        OrderDetails details= myOder.get(position);
        myHolder.foodName.setText(details.getFoodName());
        myHolder.quantity.setText(details.getQuantity());
        myHolder.foodTotalPrice.setText(details.getTotalFoodPrice());



       // holder.foodTotalPrice.setText(String.valueOf(myOder.get(position).getTotalFoodPrice()));
        //holder.quantity.setText(String.valueOf(myOder.get(position).getQuantity()));

    }

    @Override
    public int getItemCount() {

        return myOder.size();
    }


    public class OrderListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            int itemPos=orderRecycler.getChildLayoutPosition(v);
            String item=myOder.get(itemPos).getFoodName();
            //Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
        }
    }}

