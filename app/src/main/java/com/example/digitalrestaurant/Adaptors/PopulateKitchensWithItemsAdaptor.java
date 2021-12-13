package com.example.digitalrestaurant.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.Details.ItemData;

import java.util.List;


public class PopulateKitchensWithItemsAdaptor extends RecyclerView.Adapter<PopulateKitchensWithItemsAdaptor.GodwinViewHolder> {

    private RestaurantsRecyclerViewListener restaurantListener;

    List<ItemData> itemDatalist;


    public PopulateKitchensWithItemsAdaptor(List<ItemData> itemDatalist, RestaurantsRecyclerViewListener restaurantListener) {
        this.itemDatalist = itemDatalist;
        this.restaurantListener=restaurantListener;

    }


    public class GodwinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView price,name,nationality;
        ImageView foodImages;


        public GodwinViewHolder(@NonNull View itemView) {
            super(itemView);

            price=itemView.findViewById(R.id.orderPrice);
            name=itemView.findViewById(R.id.jelof);
            nationality=itemView.findViewById(R.id.nigerian1);
            foodImages=itemView.findViewById(R.id.pic1);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            restaurantListener.onClick(itemView,getAdapterPosition());
        }
    }

    @NonNull
    @Override
    public GodwinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemise= LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_food_display_container,parent,false );
        return new GodwinViewHolder(itemise);
    }

    @Override
    public void onBindViewHolder(@NonNull GodwinViewHolder holder, int position) {
        holder.price.setText(String.valueOf(itemDatalist.get(position).getPrice()));
        holder.name.setText(itemDatalist.get(position).getName());
        holder.nationality.setText(itemDatalist.get(position).getNationality());
        Glide.with(holder.itemView.getContext()).load(itemDatalist.get(position).getImageURL()).into(holder.foodImages);

    }

    @Override
    public int getItemCount() {


        return itemDatalist.size();
    }



    public interface RestaurantsRecyclerViewListener{

        void onClick(View v, int position);

    }

}
