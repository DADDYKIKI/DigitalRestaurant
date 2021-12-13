package com.example.digitalrestaurant.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Details.VendorOrderDetails;
import com.example.digitalrestaurant.R;

import java.util.List;

public class RestaurantOrdersAdaptor extends RecyclerView.Adapter<RestaurantOrdersAdaptor.RestaurantViewHolder>{

    List<VendorOrderDetails> vOrders;


    public RestaurantOrdersAdaptor(List<VendorOrderDetails> vOrders) {//Constructor

        this.vOrders = vOrders;
    }



    public class RestaurantViewHolder extends RecyclerView.ViewHolder{//View holder

        TextView customerName, phone, itemName,quantity,totalPrice;


        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            customerName = itemView.findViewById(R.id.vCusName);
            phone = itemView.findViewById(R.id.vCusPhone);
            itemName = itemView.findViewById(R.id.vItemName);
            quantity = itemView.findViewById(R.id.vItemQuantity);
            totalPrice = itemView.findViewById(R.id.vItemTotalPrice);
        }
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View orders= LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_orders,parent,false);

        return new RestaurantViewHolder(orders);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantOrdersAdaptor.RestaurantViewHolder holder, int position) {// all the view to their positions

        holder.customerName.setText(vOrders.get(position).getCusName());
        holder.phone.setText(vOrders.get(position).getPhone());
        holder.itemName.setText(vOrders.get(position).getFoodName());
        holder.quantity.setText(vOrders.get(position).getQuantity());
        holder.totalPrice.setText(vOrders.get(position).getTotalFoodPrice());

    }

    @Override
    public int getItemCount() {
        return vOrders.size();
    }
}
