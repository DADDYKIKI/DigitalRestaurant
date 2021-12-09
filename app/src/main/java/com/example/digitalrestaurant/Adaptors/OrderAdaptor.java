package com.example.digitalrestaurant.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.R;

import java.util.ArrayList;
import java.util.List;

public class OrderAdaptor extends RecyclerView.Adapter<OrderAdaptor.OrderViewHolder>{

    private OrderListener orderListener;

    ArrayList<OrderDetails> myOder;
    RecyclerView orderRecycler;
    Context context;

    public OrderAdaptor(ArrayList<OrderDetails> myOder, Context context ) {
        this.myOder = myOder;
        this. context =  context;
    }


    public  class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView foodName, foodTotalPrice, quantity,restaurant;


        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            foodName = itemView.findViewById(R.id.itemName);
            foodTotalPrice = itemView.findViewById(R.id.itemPrice);
            quantity = itemView.findViewById(R.id.itemQuantity);
            restaurant = itemView.findViewById(R.id.resaurantNameB);


        }


        @Override
        public void onClick(View v) {
            orderListener.onClick(itemView,getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cartView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_container,parent,false );


        return  new OrderViewHolder(cartView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdaptor.OrderViewHolder myHolder, int position) {

        myHolder.foodName.setText(myOder.get(position).getFoodName());
        myHolder.quantity.setText(myOder.get(position).getQuantity());
        myHolder.foodTotalPrice.setText(myOder.get(position).getTotalFoodPrice());
        myHolder.restaurant.setText(myOder.get(position).getFoodName());

    }

    @Override
    public int getItemCount() {

        return myOder.size();
    }


    public interface OrderListener {

        void onClick(View v, int position);

    }

}
