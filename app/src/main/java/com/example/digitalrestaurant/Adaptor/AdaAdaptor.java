package com.example.digitalrestaurant.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.digitalrestaurant.AdaData;
import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.UserData.ItemData;

import java.util.ArrayList;

public class AdaAdaptor extends RecyclerView.Adapter<AdaAdaptor.AdaViewHolder>{


    ArrayList<AdaData> adaDatalist;

    public AdaAdaptor(ArrayList<AdaData> adaDatalist) {
        this.adaDatalist = adaDatalist;
    }

    public class AdaViewHolder extends RecyclerView.ViewHolder{

        TextView adaFoodName,adaPrice, adaNationality;

        ConstraintLayout adaConstraintImage;


        public AdaViewHolder(@NonNull View itemView) {

            super(itemView);

            adaFoodName = itemView.findViewById(R.id.adaFoodName);
            adaPrice= itemView.findViewById(R.id.adaPrice);
            adaNationality= itemView.findViewById(R.id.adaFoodNationality);
            adaConstraintImage=itemView.findViewById(R.id.adarestaurantcard);
        }
    }

    @NonNull
    @Override
    public AdaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View adarestaurantView= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_ada_restaurant_card,parent,false );
        return new AdaAdaptor.AdaViewHolder(adarestaurantView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaViewHolder holder, int position) {

        holder.adaFoodName.setText(adaDatalist.get(position).getAdaName());
        holder.adaPrice.setText(String.valueOf(adaDatalist.get(position).getAdaPrice()));
        holder.adaNationality.setText(adaDatalist.get(position).getAdaName());
        holder.adaConstraintImage.setBackground(ContextCompat.getDrawable(holder.itemView.
                getContext(),adaDatalist.get(position).getAdaImage()));

    }

    @Override
    public int getItemCount() {
        return adaDatalist.size();
    }


}
