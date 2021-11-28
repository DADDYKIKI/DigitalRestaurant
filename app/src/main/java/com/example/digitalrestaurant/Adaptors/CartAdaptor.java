package com.example.digitalrestaurant.Adaptors;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Details.OrderDetails;

import java.util.ArrayList;

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.CartViewHolder>{


    ArrayList<OrderDetails> myOder;

    public CartAdaptor(ArrayList<OrderDetails> myOder) {
        this.myOder = myOder;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{

        TextView foodName,foodTotalPrice,quantity;


        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
