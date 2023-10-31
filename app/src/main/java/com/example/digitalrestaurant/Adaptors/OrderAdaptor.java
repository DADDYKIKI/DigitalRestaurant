package com.example.digitalrestaurant.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.R;

import java.util.List;

public class OrderAdaptor extends RecyclerView.Adapter<OrderAdaptor.OrderViewHolder>{

    private List<OrderDetails> myOder;

    public OrderAdaptor(List<OrderDetails> myOder) {
        this.myOder = myOder;
    }



    public  class OrderViewHolder extends RecyclerView.ViewHolder {

        TextView foodFName, foodTotalPrice, quantity,restaurantB;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            foodFName = itemView.findViewById(R.id.itemFName);
            foodTotalPrice = itemView.findViewById(R.id.itemPrice);
            quantity = itemView.findViewById(R.id.itemQuantity);
            restaurantB = itemView.findViewById(R.id.resaurantNameBm);
        }
        }

            @NonNull
            @Override
            public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View cartView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_container,parent,false);


                return  new OrderViewHolder(cartView);
            }

             @Override
             public void onBindViewHolder(@NonNull OrderAdaptor.OrderViewHolder myHolder, int position) {

            myHolder.foodFName.setText(myOder.get(position).getFoodName());
            myHolder.quantity.setText(myOder.get(position).getQuantity());
            myHolder.foodTotalPrice.setText(myOder.get(position).getTotalFoodPrice());
            myHolder.restaurantB.setText(myOder.get(position).getRestaurantName());

        }

            @Override
            public int getItemCount() {

                return myOder.size();
            }

            }





