package com.example.digitalrestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalrestaurant.Authentications.LoginPage;
import com.example.digitalrestaurant.Authentications.SignupPage;

public class Menu extends AppCompatActivity {

    TextView logout,basket,contacts,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        logout=findViewById(R.id.logout);
        basket=findViewById(R.id.basket);
        contacts=findViewById(R.id.contacts);
        signup=findViewById(R.id.signupas);

        logout();
        basket();
        contacts();
        signupN();
}
    public void logout(){
        logout.setOnClickListener(v -> {
            Intent intent=new Intent(this, LoginPage.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

        });

    }

    public void contacts(){
        contacts.setOnClickListener(v -> {
            Intent intent=new Intent(this, Contacts.class);
            startActivity(intent);



        });

    }

    public void signupN(){
        signup.setOnClickListener(v -> {
            Intent intent=new Intent(this, SignupPage.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }

    public void basket(){
        basket.setOnClickListener(v -> {
            Intent intent=new Intent(this, Cart.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }


}
