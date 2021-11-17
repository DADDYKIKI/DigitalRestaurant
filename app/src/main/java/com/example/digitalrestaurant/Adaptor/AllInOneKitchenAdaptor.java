package com.example.digitalrestaurant.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.AllInOneKitchenData;
import com.example.digitalrestaurant.R;

import java.util.ArrayList;

public class AllInOneKitchenAdaptor extends RecyclerView.Adapter<AllInOneKitchenAdaptor.AllInOneKitchenViewHolder>{


    ArrayList<AllInOneKitchenData> allInOneKitchenDatalist;

    public AllInOneKitchenAdaptor(ArrayList<AllInOneKitchenData> allInOneKitchenDatalist) {
        this.allInOneKitchenDatalist = allInOneKitchenDatalist;
    }

    public class AllInOneKitchenViewHolder extends RecyclerView.ViewHolder{

        TextView foodName,foodPrice, foodNationality;

        ConstraintLayout foodConstraintImage;



        public AllInOneKitchenViewHolder(@NonNull View itemView) {

            super(itemView);

            foodName = itemView.findViewById(R.id.adaFoodName);
            foodPrice= itemView.findViewById(R.id.adaPrice);
            foodNationality= itemView.findViewById(R.id.adaFoodNationality);
            foodConstraintImage=itemView.findViewById(R.id.adarestaurantcard);
        }
    }

    @NonNull
    @Override
    public AllInOneKitchenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View adarestaurantView= LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_page_container,parent,false );
        return new AllInOneKitchenViewHolder(adarestaurantView);
    }

    @Override
    public void onBindViewHolder(@NonNull AllInOneKitchenViewHolder holder, int position) {

        holder.foodName.setText(allInOneKitchenDatalist.get(position).getFoodName());
        holder.foodPrice.setText(String.valueOf(allInOneKitchenDatalist.get(position).getFoodPrice()));
        holder.foodNationality.setText(allInOneKitchenDatalist.get(position).getFoodNationality());
        holder.foodConstraintImage.setBackground(ContextCompat.getDrawable(holder.itemView.
                getContext(), allInOneKitchenDatalist.get(position).getFoodImage()));



    }

    @Override
    public int getItemCount() {
        return allInOneKitchenDatalist.size();
    }


}
