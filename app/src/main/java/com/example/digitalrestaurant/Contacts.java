package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);


    }

    @Override
    public void onBackPressed() {


        Intent intent5 =new Intent(getApplicationContext(), HomePage.class);

        startActivity(intent5);

    }
}