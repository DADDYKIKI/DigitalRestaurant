package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.R;

public class LoginPage extends AppCompatActivity {

    Button loginBut;
    EditText loginEmail,loginPass;
    TextView loginWarningText;

    //String email="abc@gmail.com";
    //String password="aba1";

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);

        loginEmail = findViewById(R.id.enterLoginEmail);
        loginPass = findViewById(R.id.enterLoginPaswd);
        loginWarningText = findViewById(R.id.loginWarningText);
        loginBut = (findViewById(R.id.signSubBtn));

        dbHelper=new DatabaseHelper(this);




        login();

    }


        public void login(){
            loginBut.setOnClickListener(v -> {

                click2(HomePage.class);

               /*  if (loginEmail.getText().toString().equals("") || loginPass.getText().toString().equals("")){

                LoginPage.this.setTextVisible(v);}

                  else {
                      Boolean insert=dbHelper.checkUserNameAndPassword(loginEmail.getText().toString(),
                              loginPass.getText().toString());

                      if(insert==true){

                          LoginPage.this.setTextInvisible(v);

                      click2(HomePage.class);

                  }
                      else LoginPage.this.setTextVisible(v);

                  } */

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