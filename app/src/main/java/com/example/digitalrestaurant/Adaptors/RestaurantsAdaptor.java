package com.example.digitalrestaurant.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.Details.RestaurantsData.RestaurantsDetails;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsAdaptor extends RecyclerView.Adapter<RestaurantsAdaptor.RestaurantsViewHolder>{

    private ArrayList<RestaurantsDetails> restaurantslist;

    private AllInOneRecyclerViewListener allInOneListener;

    public RestaurantsAdaptor(ArrayList<RestaurantsDetails> restaurantslist, AllInOneRecyclerViewListener allInOneListener) {
        this.restaurantslist = restaurantslist;
        this.allInOneListener=allInOneListener;


    }



    public class RestaurantsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView restaurantName,restaurantLocation,restaurantNationality;
        ConstraintLayout restaurantImage;

        public RestaurantsViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);


            restaurantName = itemView.findViewById(R.id.restaurantName);
            restaurantLocation = itemView.findViewById(R.id.restaurantLocation);
            restaurantNationality=itemView.findViewById(R.id.restaurantNationality);
            restaurantImage=itemView.findViewById(R.id.restaurantImage);
        }

        @Override
        public void onClick(View v) {
            allInOneListener.onClickMe(itemView,getAdapterPosition());

        }
    }


    @NonNull
    @Override
    public RestaurantsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View restaurantView= LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_page_container,parent,false );
        return new RestaurantsAdaptor.RestaurantsViewHolder(restaurantView);
    }


    @Override
    public void onBindViewHolder(@NonNull RestaurantsViewHolder holder, int position) {

        holder.restaurantName.setText(restaurantslist.get(position).getRestaurantsName());
        holder.restaurantLocation.setText(restaurantslist.get(position).getRestaurantsLocation());
        holder.restaurantNationality.setText(restaurantslist.get(position).getRestaurantNationality());

        holder.restaurantImage.setBackground(ContextCompat.getDrawable(holder.itemView.
                getContext(),restaurantslist.get(position).getRestaurantImage()));


    }

            @Override
            public int getItemCount() {

        return restaurantslist.size();
            }


    public interface AllInOneRecyclerViewListener{

        void onClickMe(View v, int position);

    }


}
