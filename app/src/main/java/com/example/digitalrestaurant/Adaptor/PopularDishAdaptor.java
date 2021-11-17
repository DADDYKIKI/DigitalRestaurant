package com.example.digitalrestaurant.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;



public class PopularDishAdaptor extends RecyclerView.Adapter<PopularDishAdaptor.GodwinViewHolder> {

    //Context context;

    AllInOneRecyclerViewListener listener;

    ArrayList<ItemData> itemDatalist;

    public PopularDishAdaptor(ArrayList<ItemData> itemDatalist, AllInOneRecyclerViewListener listener) {
        this.itemDatalist = itemDatalist;
        this.listener=listener;
       // this.context = context;

    }

    public class GodwinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView price,name,nationality;
        RatingBar ratingBar;
        ImageView horizontalImages,verticalImages;
        //ConstraintLayout myPage;

        public GodwinViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            price=itemView.findViewById(R.id.adaPrice);
            name=itemView.findViewById(R.id.jelof1);
            nationality=itemView.findViewById(R.id.nigerian1);
            horizontalImages=itemView.findViewById(R.id.pic1);
            //verticalImages=itemView.findViewById(R.id.pic1);
            //myPage=itemView.findViewById(R.id.pageHolder);


        }

        @Override
        public void onClick(View v) {

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
        Glide.with(holder.itemView.getContext()).load(itemDatalist.get(position).getImageURL()).into(holder.horizontalImages);
        //holder.images.setImageResource(itemDatalist.get(position).getImageURL());


    }

    @Override
    public int getItemCount() {
        return itemDatalist.size();
    }

    public interface AllInOneRecyclerViewListener{

        void onClickMe(View v, int position);

    }

}
