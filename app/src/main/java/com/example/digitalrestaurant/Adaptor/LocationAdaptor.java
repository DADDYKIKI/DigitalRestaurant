package com.example.digitalrestaurant.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.LocationDetails.LocationDetails;
import com.example.digitalrestaurant.R;

import java.util.ArrayList;

public class LocationAdaptor extends RecyclerView.Adapter<LocationAdaptor.LocationViewHolder>{

    ArrayList<LocationDetails>  locationLists;

    public LocationAdaptor(ArrayList<LocationDetails> locationLists) {
        this.locationLists= locationLists;
        // this.context = context;

    }


    public class LocationViewHolder extends RecyclerView.ViewHolder {

        TextView LocationName;


        public LocationViewHolder(@NonNull View itemView) {

            super(itemView);

            LocationName = itemView.findViewById(R.id.locationName);
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

        holder.LocationName.setText(locationLists.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return locationLists.size();
    }


}
