package com.example.digitalrestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalrestaurant.Authentications.LoginPage;

public class Menu extends AppCompatActivity {

    TextView logout,basket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        logout=findViewById(R.id.logout);
        basket=findViewById(R.id.basket);

       logout();
        basket();
}
    public void logout(){
        logout.setOnClickListener(v -> {
            Intent intent=new Intent(this, LoginPage.class);
            startActivity(intent);


        });

    }

    public void basket(){
        basket.setOnClickListener(v -> {
            Intent intent=new Intent(this, Cart.class);
            startActivity(intent);


        });

    }


}
