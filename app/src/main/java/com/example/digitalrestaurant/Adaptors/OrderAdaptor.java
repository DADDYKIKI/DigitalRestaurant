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

    private OderListener orderListener;

    ArrayList<OrderDetails> myOder;
    Context context;

    public OrderAdaptor(OderListener orderListener,ArrayList<OrderDetails> myOder) {
        this.orderListener = orderListener;
        this.myOder=myOder;

    }

    public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView foodName,foodTotalPrice,quantity;



        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            foodName= itemView.findViewById(R.id.itemName);
            foodTotalPrice= itemView.findViewById(R.id.itemPrice);
            quantity= itemView.findViewById(R.id.itemQuantity);


        }

        @Override
        public void onClick(View v) {

            orderListener.onClickOrder(itemView,getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View cartView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_container,parent,false );
        return new OrderViewHolder(cartView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        holder.foodName.setText(myOder.get(position).getFoodName());
        holder.foodTotalPrice.setText(String.valueOf(myOder.get(position).getTotalFoodPrice()));
        holder.quantity.setText(String.valueOf(myOder.get(position).getQuantity()));

    }

    @Override
    public int getItemCount() {

        return myOder.size();
    }


    public interface OderListener{

        void onClickOrder(View v, int position);

    }



}

