package com.example.digitalrestaurant.Authentications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.R;

public class LoginPageForFoodSeller2 extends AppCompatActivity {

    private Button loginBut;
    private EditText loginName,loginPass;
    private TextView loginWarningText;

    //String email="abc@gmail.com";
    //String password="aba1";

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginName = findViewById(R.id.enterLoginEmail);
        loginPass = findViewById(R.id.enterLoginPaswd);
        loginWarningText = findViewById(R.id.loginWarningText);
        loginBut = (findViewById(R.id.signSubBtnV));


        dbHelper=new DatabaseHelper(this);




        login();

    }


        public void login(){
            loginBut.setOnClickListener(v -> {

                click3(SellerUploadPage.class);

              /*   if (loginName.getText().toString().equals("") || loginPass.getText().toString().equals("")){

                     Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();

                         LoginPage.this.setTextVisible(v);}

                  else {
                      Boolean insert=dbHelper.checkUserNameAndPassword(loginEmail.getText().toString(),
                              loginPass.getText().toString());

                      if(insert==true){

                          LoginPage.this.setTextInvisible(v);

                      click2(HomePage.class);
                          loginEmail.setText("");
                          loginPass.setText("");

                  }
                      else LoginPage.this.setTextVisible(v);

                  }*/

            });
        }






    public void click3(Object x){

        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);

        }


    void setTextVisible(View view){
        loginWarningText.setVisibility(View.VISIBLE);

    }

    void setTextInvisible(View view){
        loginWarningText.setVisibility(View.INVISIBLE);

    }

}