package com.example.digitalrestaurant.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.RestaurantsData.RestautantsDetails;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class RestaurantsAdaptor extends RecyclerView.Adapter<RestaurantsAdaptor.RestaurantsViewHolder>{

    ArrayList<RestautantsDetails> restaurantslist;

    public RestaurantsAdaptor(ArrayList<RestautantsDetails> restaurantslist) {
        this.restaurantslist = restaurantslist;
        // this.context = context;

    }



    public class RestaurantsViewHolder extends RecyclerView.ViewHolder {

        TextView restaurantName,restaurantLocation,restaurantNationality;
        ConstraintLayout restaurantImage;

        public RestaurantsViewHolder(@NonNull View itemView) {
            super(itemView);
            restaurantName = itemView.findViewById(R.id.restaurantName);
            restaurantLocation = itemView.findViewById(R.id.restaurantLocation);
            restaurantNationality=itemView.findViewById(R.id.restaurantNationality);
            restaurantImage=itemView.findViewById(R.id.restaurantImage);
        }
            }


    @NonNull
    @Override
    public RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View restaurantView= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_restaurants,parent,false );
        return new RestaurantsAdaptor.RestaurantsViewHolder(restaurantView);
    }


    @Override
    public void onBindViewHolder(@NonNull RestaurantsViewHolder holder, int position) {

        holder.restaurantName.setText(restaurantslist.get(position).getRestaurantsName());
        holder.restaurantLocation.setText(restaurantslist.get(position).getRestaurantsLocation());
        holder.restaurantNationality.setText(restaurantslist.get(position).getRestaurantNationality());
        holder.restaurantImage.setBackground(ContextCompat.getDrawable(holder.itemView.
                getContext(),restaurantslist.get(position).getRestaurantImage()));//recycler background image



    }

            @Override
            public int getItemCount() {
                return restaurantslist.size();
            }


}
