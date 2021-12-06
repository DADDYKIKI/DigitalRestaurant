package com.example.digitalrestaurant.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.digitalrestaurant.Details.AdvertItems;
import com.example.digitalrestaurant.Details.ItemData;
import com.example.digitalrestaurant.R;

import java.util.List;

public class PopulateAdvertismentAdaptor extends RecyclerView.Adapter<PopulateAdvertismentAdaptor.PopulateAdvertismentViewHolder>{

       List<AdvertItems> itemDatalist;
        Context context;

    public PopulateAdvertismentAdaptor(List<AdvertItems> itemDatalist,Context context) {
        this.itemDatalist = itemDatalist;
        this.context=context;
    }

    public class PopulateAdvertismentViewHolder extends RecyclerView.ViewHolder{

        TextView price,name,nationality,restaurantName;
        ImageView foodImages;


        public PopulateAdvertismentViewHolder(@NonNull View itemView) {
            super(itemView);

            price=itemView.findViewById(R.id.orderPrice);
            name=itemView.findViewById(R.id.jelof);
            nationality=itemView.findViewById(R.id.nigerian1);
            foodImages=itemView.findViewById(R.id.pic1);
            restaurantName=itemView.findViewById(R.id.restaurantName);

        }
    }

    @NonNull
    @Override
    public PopulateAdvertismentAdaptor.PopulateAdvertismentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemise= LayoutInflater.from(parent.getContext()).inflate(R.layout.advertisment_container,parent,false );
        return new PopulateAdvertismentViewHolder(itemise);
    }

    @Override
    public void onBindViewHolder(@NonNull PopulateAdvertismentAdaptor.PopulateAdvertismentViewHolder holder, int position) {

        holder.price.setText(String.valueOf(itemDatalist.get(position).getPrice()));
        holder.name.setText(itemDatalist.get(position).getName());
        holder.nationality.setText(itemDatalist.get(position).getNationality());
        holder.restaurantName.setText(itemDatalist.get(position).getRestaurantName());
        Glide.with(holder.itemView.getContext()).load(itemDatalist.get(position).getImageURL()).into(holder.foodImages);

    }

    @Override
    public int getItemCount() {
        return itemDatalist.size();
    }
}
