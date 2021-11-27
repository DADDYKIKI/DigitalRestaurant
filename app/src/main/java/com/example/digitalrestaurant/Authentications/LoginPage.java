package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.Menu;
import com.example.digitalrestaurant.R;

public class LoginPage extends AppCompatActivity {

    Button loginBut;

    TextView loginEmail,loginPass,loginWarningText,menuKey;

    String email="abc@gmail.com";
    String password="aba1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);

        menuKey = findViewById(R.id.menuKey);

        loginEmail = findViewById(R.id.enterLoginEmail);
        loginPass = findViewById(R.id.enterLoginPaswd);
        loginWarningText = findViewById(R.id.loginWarningText);
        loginBut = (findViewById(R.id.loginSubBtn));


        menuKey();

        login();

    }


        public void login(){
            loginBut.setOnClickListener(v -> {

                // if (loginEmail.getText().toString().equals(email) && loginPass.getText().toString().equals(password)) {
                LoginPage.this.click2(HomePage.class);

                LoginPage.this.setTextInvisible(v);

                // } else {
                //    LoginPage.this.setTextVisible(v);
                //  }

            });
        }




    public void menuKey(){
        menuKey.setOnClickListener(v -> {
            LoginPage.this.click2(Menu.class);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }


    public void click2(Object x){

        Intent intent=new Intent(LoginPage.this, (Class<?>) x);

        startActivity(intent);

        }


    void setTextVisible(View view){
        loginWarningText.setVisibility(View.VISIBLE);

    }

    void setTextInvisible(View view){
        loginWarningText.setVisibility(View.INVISIBLE);

    }

}