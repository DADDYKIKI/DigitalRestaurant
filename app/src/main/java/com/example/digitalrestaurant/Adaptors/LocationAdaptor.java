package com.example.digitalrestaurant.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.Details.LocationDetails.LocationDetails;
import com.example.digitalrestaurant.R;

import java.util.ArrayList;
import java.util.List;

public class LocationAdaptor extends RecyclerView.Adapter<LocationAdaptor.LocationViewHolder>{

    LocationListener listener;

    private List<LocationDetails>  locationLists;



    public LocationAdaptor(List<LocationDetails> locationLists, LocationListener listener) {
        this.locationLists= locationLists;
        this.listener= listener;
    }



    public class LocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{//View holder class

        TextView locationName,restaurants;


        public LocationViewHolder(@NonNull View itemView) {

            super(itemView);

            itemView.setOnClickListener(this);

            locationName = itemView.findViewById(R.id.locationName);
            restaurants = itemView.findViewById(R.id.restaurant);
        }


        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());
        }
    }



        @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View locations= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_locations_container,parent,false );
            return new LocationAdaptor.LocationViewHolder(locations);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {

        holder.locationName.setText(locationLists.get(position).getLocation());
        holder.restaurants.setText(locationLists.get(position).getRsetaurants());

    }

    @Override
    public int getItemCount() {

        return locationLists.size();
    }


    public interface LocationListener {//Interface for onclickListener

        void onClick(View v, int position);

    }
}
