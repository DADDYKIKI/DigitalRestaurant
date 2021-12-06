package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.UserDetails;
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.R;

import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    private Button loginBut;
    private EditText loginEmail,loginPass;
    private     TextView loginWarningText;



    //String email="abc@gmail.com";
    //String password="aba1";

    DatabaseHelper data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginEmail = findViewById(R.id.enterLoginEmail);
        loginPass = findViewById(R.id.enterLoginPaswd);
        loginWarningText = findViewById(R.id.loginWarningText);
        loginBut = (findViewById(R.id.signSubBtn));


       // data=new DatabaseHelper(this);



        login();

    }


        public void login(){
            loginBut.setOnClickListener(v -> {

                data=new DatabaseHelper(this);

                //DatabaseHelper data=new DatabaseHelper(this);

               // click2(HomePage.class);

              if (loginEmail.getText().toString().equals("") || loginPass.getText().toString().equals("")){

                     Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();

                         }

                  else {
                  //  if(dbHelper.getCustomerLoginDetails().contains(loginEmail.getText().toString()
                  Boolean insert=data.getCustomerLoginDetails(loginEmail.getText().toString(),loginPass.getText().toString());

                  // )) Toast.makeText(this, "hurrayy", Toast.LENGTH_SHORT).show();
                  // Boolean insert=dbHelper.getCustomerLoginDetails(loginEmail.getText().toString(),
                  // loginPass.getText().toString());

                 // Boolean insert = dbHelper.checkUserNameAndPassword(loginEmail.getText().toString(), loginPass.getText().toString());

                  if (insert==true) {

                      LoginPage.this.setTextInvisible(v);

                      click2(HomePage.class);

                      loginEmail.setText("");
                      loginPass.setText("");
                  }
/*
                  attempts--;
                  Toast.makeText(SignupPage.this, "Not added\nYou have "+attempts+"chances left", Toast.LENGTH_SHORT).show();
                  if(attempts==0)signSubBtn.setEnabled(false);
                  Toast.makeText(SignupPage.this, "Sorry!!\n\nYou have usedup all your chances",
                          Toast.LENGTH_SHORT).show();
                  Toast.makeText(SignupPage.this, "Try signing Up if you haven't done so",
                          Toast.LENGTH_SHORT).show();




*/           else LoginPage.this.setTextVisible(v);
              }

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