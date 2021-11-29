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

public class CartAdaptor extends RecyclerView.Adapter<CartAdaptor.CartViewHolder>{


    private ArrayList<OrderDetails> myOder;
    private Context context;

    public CartAdaptor(ArrayList<OrderDetails> myOder, Context context) {

        this.myOder = myOder;
        this.context=context;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{

        TextView foodName,foodTotalPrice,quantity;


        public CartViewHolder(@NonNull View itemView) {

            super(itemView);

            foodName= itemView.findViewById(R.id.itemName);
            foodTotalPrice= itemView.findViewById(R.id.itemPrice);
            quantity= itemView.findViewById(R.id.itemQuantity);
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cartView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_container,parent,false );
        return new CartAdaptor.CartViewHolder(cartView);

    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        holder.foodName.setText(myOder.get(position).getFoodName());
        holder.quantity.setText(myOder.get(position).getQuantity());
        holder.foodTotalPrice.setText(myOder.get(position).getTotalFoodPrice());

    }

    @Override
    public int getItemCount() {
        return myOder.size();
    }




}
