package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digitalrestaurant.Database.DatabaseHelper;

public class DeleteCartItem extends AppCompatActivity {

    TextView yes, no;

    String foodName="",restaurantName="";

    DatabaseHelper data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_cart_item);

        data = new DatabaseHelper(this);

        no = findViewById(R.id.no);
        yes = findViewById(R.id.yes);


        Bundle extras = getIntent().getExtras();

        foodName = extras.getString("name");
        restaurantName = extras.getString("restaurantName");


        deleteItem();
        returnBack();

    }

    public void deleteItem(){

        yes.setOnClickListener(v -> {

            Boolean yes=data.deleteItemsFromCart(foodName,restaurantName);

            if(yes==true){
                Toast.makeText(this, foodName+" bought from "+restaurantName+
                        "\n deleted successfully", Toast.LENGTH_SHORT).show();

                Intent intent5 =new Intent(getApplicationContext(), Order.class);

                startActivity(intent5);
            }
            else Toast.makeText(this, "Item not deleted", Toast.LENGTH_SHORT).show();
        });

        }



    public void returnBack(){

        no.setOnClickListener(v -> {

            Intent intent5 =new Intent(getApplicationContext(), Order.class);

            startActivity(intent5);

    });


        }}
