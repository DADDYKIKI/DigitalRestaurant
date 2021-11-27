package com.example.digitalrestaurant.Adaptors;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.R;

public class MyCursorAdaptor extends CursorAdapter {

    TextView name, foodQuantity,totalFoodPrice;


    public MyCursorAdaptor(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.cart_container,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        name= view.findViewById(R.id.itemName);
        foodQuantity= view.findViewById(R.id.itemName);
        totalFoodPrice= view.findViewById(R.id.itemPrice);

        String foodName=cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN2));
        String quantity= cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN3));
        String totalPrice= cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN4));

        name.setText(foodName);
        foodQuantity.setText(quantity);
        totalFoodPrice.setText(totalPrice);
    }
}
