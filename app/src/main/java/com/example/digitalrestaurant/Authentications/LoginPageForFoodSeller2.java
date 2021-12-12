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
import com.example.digitalrestaurant.Restaurants.AdaPage;
import com.example.digitalrestaurant.Restaurants.ApprokoPage;
import com.example.digitalrestaurant.Restaurants.ObandePage;
import com.example.digitalrestaurant.Restaurants.StainlessPage;

public class LoginPageForFoodSeller2 extends AppCompatActivity {

    private Button loginButV,signUpButV ;
    private EditText loginEmail,loginPassV;
    private TextView loginWarningTextV;

    private int attempts=6;

    DatabaseHelper data;






    @Override
    public void onBackPressed() {


            Intent i = new Intent(this, FoodSeller.class);
            startActivity(i);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vendor_login);

        loginEmail = findViewById(R.id.enterLoginEmailV);
        loginPassV = findViewById(R.id.enterLoginPaswdV);
        loginWarningTextV = findViewById(R.id.loginWarningTextV);
        loginButV = (findViewById(R.id.signSubBtnV));

        signUpButV = findViewById(R.id.signupV);


        loginV();
        toSignUp();

    }


    public void toSignUp() {

        signUpButV.setOnClickListener(v -> {

            Intent intent=new Intent(this, SignupPageForFoodSeller2.class);
            startActivity(intent);


        });
    }


public void loginV(){
        loginButV.setOnClickListener(v -> {

                data=new DatabaseHelper(this);


        if (loginEmail.getText().toString().equals("") || loginPassV.getText().toString().equals("")) {

                    Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();
                }


        else {this.setTextInvisible(v);

                    Boolean insert=data.getVendorLoginDetails(loginEmail.getText().toString(),loginPassV.getText().toString());

             if (insert==true) {


                    String restaurant=data.checkRestaurant(loginEmail.getText().toString());

                        if(restaurant.equals("adakitchen")){

                          Toast.makeText(this, "Success!!!", Toast.LENGTH_SHORT).show();
                            click3(AdaPage.class);
                            }

                        if(restaurant.equals("approkokitchen")){

                            Toast.makeText(this, "Success!!!", Toast.LENGTH_SHORT).show();
                            click3(ApprokoPage.class);
                            }

                        if(restaurant.equals("obandekitchen")){
                            Toast.makeText(this, "Success!!!", Toast.LENGTH_SHORT).show();
                            click3(ObandePage.class);
                            }

                        if(restaurant.equals("stainless")){
                            Toast.makeText(this, "Success!!!", Toast.LENGTH_SHORT).show();
                            click3(StainlessPage.class);
                            }




             }

             else{
                    this.setTextVisible(v);
                    this.setButtonVisible(v);

                    attempts--;

                    Toast.makeText(this, "Not Successful\nYou have " + attempts + " attempt left", Toast.LENGTH_SHORT).show();

                    if (attempts == 2) {
                        Toast.makeText(this, "You might Just be playing with this app\nWho Know!!!",
                                Toast.LENGTH_SHORT).show();
                        Toast.makeText(this, "Giving you two chances",
                                Toast.LENGTH_SHORT).show();

                    }
                    if (attempts == 0) {

                        loginEmail.setEnabled(false);
                        loginPassV.setEnabled(false);

                        Toast.makeText(this, "Sorry!!\n\nYou have usedup all your chances",
                                Toast.LENGTH_SHORT).show();

                        setButtonInvisible(v);

                        Toast.makeText(this, "You might want to signup",
                                Toast.LENGTH_SHORT).show();

                        Toast.makeText(this, "Try signing Up if you haven't done so",
                                Toast.LENGTH_SHORT).show();

                        Toast.makeText(this, "Close your app and re-run it Again",
                                Toast.LENGTH_SHORT).show();
                        Toast.makeText(this, "Or I will advice you to \nsign up if you haven't done so",
                                Toast.LENGTH_SHORT).show();
                    }

                }




            }


});}


    public void click3(Object x){

        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);

        }


    void setTextVisible(View view){
        loginWarningTextV.setVisibility(View.VISIBLE);

    }

    void setButtonInvisible(View view){
        loginButV.setVisibility(View.INVISIBLE);


    }

    void setTextInvisible(View view){
        loginWarningTextV.setVisibility(View.INVISIBLE);

    }

    void setButtonVisible(View view){

        signUpButV.setVisibility(View.VISIBLE);}

}