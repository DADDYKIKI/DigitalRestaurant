package com.example.digitalrestaurant.Authentications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.R;

public class LoginPageForFoodSeller2 extends AppCompatActivity {

    private Button loginBut;
    private EditText loginName,loginPass;
    private TextView loginWarningText;

    private int attempts=6;
    DatabaseHelper dbHelper;

    DatabaseHelper data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginName = findViewById(R.id.enterLoginEmail);
        loginPass = findViewById(R.id.enterLoginPaswd);
        loginWarningText = findViewById(R.id.loginWarningText);
        loginBut = (findViewById(R.id.signSubBtnV));

        signUpButV = findViewById(R.id.signupV);


        dbHelper=new DatabaseHelper(this);




        login();

    }


        public void login(){
            loginBut.setOnClickListener(v -> {

                click3(SellerUploadPage.class);
                data=new DatabaseHelper(this);


                if (loginName.getText().toString().equals("") || loginPass.getText().toString().equals("")){

                    Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();

                }

                else {

                    Boolean insert=data.getCustomerLoginDetails(loginName.getText().toString(),loginPass.getText().toString());

                    if (insert==true) {

                        LoginPage.this.setTextInvisible(v);
                        Toast.makeText(this, "Success!!!", Toast.LENGTH_SHORT).show();

                        click3(HomePage.class);

                        loginName.setText("");
                        loginPass.setText("");
                    }

                    else {
                        LoginPage.this.setTextVisible(v);

                        attempts--;

                        Toast.makeText( this, "Not Successful\nYou have "+attempts+" attempt left", Toast.LENGTH_SHORT).show();

                        if(attempts==2){
                            Toast.makeText(this, "You might Just be playing with this app\nWho Know!!!",
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(this, "Giving you two chances",
                                    Toast.LENGTH_SHORT).show();

                        }
                        if(attempts==0){

                            loginName.setEnabled(false);
                            loginPass.setEnabled(false);

                            Toast.makeText(this, "Sorry!!\n\nYou have usedup all your chances",
                                    Toast.LENGTH_SHORT).show();

                            setButtonInvisible(v);

                            Toast.makeText(this, "You might want to signup",
                                    Toast.LENGTH_SHORT).show();

                            this.setButtonVisible(v);




                            Toast.makeText(this, "Try signing Up if you haven't done so",
                                    Toast.LENGTH_SHORT).show();

                            Toast.makeText(this, "Close your app and re-run it Again",
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(this, "Or I will advice you to \nsign up if you haven't done so",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            });
        }




    public void click3(Object x){

        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);

        }


    void setTextVisible(View view){
        loginWarningText.setVisibility(View.VISIBLE);

    }

    void setButtonInvisible(View view){
        loginBut.setVisibility(View.INVISIBLE);


    }

    void setTextInvisible(View view){
        loginWarningText.setVisibility(View.INVISIBLE);

    }

    void setButtonVisible(View view){

        signUpBut.setVisibility(View.VISIBLE);}

}