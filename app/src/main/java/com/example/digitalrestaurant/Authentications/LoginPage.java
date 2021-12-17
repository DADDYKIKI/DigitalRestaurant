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
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.R;

public class LoginPage extends AppCompatActivity {

    private static String COUNTRY="";
    private static String CUSNAME="";
    private static  int AGE=0;
    private static  String CUSTOMERPHONE="";
    private Button loginBut,signUpBut;
    private EditText loginEmail,loginPass;
    private     TextView loginWarningText,forgotPass;

    private int attempts=6;

    DatabaseHelper data, helperL;


    @Override
    public void onBackPressed() {

        Intent i = new Intent(this, Customer.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        loginEmail = findViewById(R.id.enterLoginEmail);
        loginPass = findViewById(R.id.enterLoginPaswd);
        loginWarningText = findViewById(R.id.loginWarningText);
        loginBut = findViewById(R.id.signSubBtn);
        signUpBut = findViewById(R.id.signupAgain);
        forgotPass=findViewById(R.id.forgotPass);


        forgotPass();
        login();
        toSignUpV();
    }

    public static String getCUSTOMERPHONE() {
        return CUSTOMERPHONE;
    }

    public static void setCUSTOMERPHONE(String phone) {

        CUSTOMERPHONE=phone;
    }

    public static int getAge() {
        return AGE;
    }

    public static void setAge(int age) {

        AGE=age;
    }


    public static String getCountry() {
        return COUNTRY;
    }


    public static void setCountry(String name) {

        COUNTRY=name;
    }

    public static String getCusName() {
        return CUSNAME;
    }


    public static void setCusName(String name) {

        CUSNAME=name;
    }




    public void toSignUpV() {

        signUpBut.setOnClickListener(v -> {

            Intent intent=new Intent(this, SignupPage.class);
            startActivity(intent);

        });
    }

    public void forgotPass() {

        forgotPass.setOnClickListener(v -> {

            Intent intent=new Intent(this, ForgotPassword.class);
            startActivity(intent);

        });
    }


    public String setCustomerWelcomeTextF(){

         helperL=new DatabaseHelper(this);

        String welcome=helperL.setCustomerWelcomeName(loginEmail.getText().toString());

        return welcome;

    }


    public String setCustomerPhone(){
        helperL=new DatabaseHelper(this);

       String phone=helperL.getCustomerPhone(loginEmail.getText().toString());
        return phone;
    }



    public void login(){

        loginBut.setOnClickListener(v -> {//Login authentication

            data=new DatabaseHelper(this);


              if (loginEmail.getText().toString().equals("") || loginPass.getText().toString().equals("")){//Is a text field empty?

                     Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();}



              else {//Are your login details correct?

                  Boolean insert=data.getCustomerLoginDetails(loginEmail.getText().toString(),loginPass.getText().toString());

                  if (insert==true) {


                      LoginPage.this.setTextInvisible(v);

                      Toast.makeText(this, "Success!!!", Toast.LENGTH_SHORT).show();

                      Boolean yes=data.checkforAge(loginEmail.getText().toString());

                      Boolean correct=data.checkCountry(loginEmail.getText().toString());//Is your country Nigeria or else where?

                      setCusName(setCustomerWelcomeTextF());

                      setCUSTOMERPHONE(setCustomerPhone());//Save a customer's phone number with registered email address

                      Intent intent=new Intent(this,HomePage.class);

                      if(yes==true)setAge(17);//set the global age used by other class for age authentication

                      else setAge(18);

                      if(correct==true)setCountry("Nigeria");
                      else setCountry("United Kingdom");

                     startActivity(intent);


                  }

                  else {//Controls number of failed attempts in login

                      setTextVisible(v);



                      attempts--;

                      Toast.makeText( this, "Not Successful\nYou have "+attempts+" attempt left", Toast.LENGTH_SHORT).show();

                      if(attempts==2){
                          Toast.makeText(this, "You might Just be playing with this app\nWho Know!!!",
                                  Toast.LENGTH_SHORT).show();
                          Toast.makeText(this, "Giving you two chances",
                                  Toast.LENGTH_SHORT).show();

                      }
                      if(attempts==0){//Action taken when no login attempts is left

                          loginEmail.setEnabled(false);
                          loginPass.setEnabled(false);

                          Toast.makeText(this, "Sorry!!\n\nYou have usedup all your chances",
                                  Toast.LENGTH_SHORT).show();

                          setButtonInvisible(v);
                          setButtonVisible(v);

                          Toast.makeText(this, "Try forgot password or signup",
                                  Toast.LENGTH_SHORT).show();





                          Toast.makeText(this, "Or I will advice you to \nsign up if you haven't done so",
                                  Toast.LENGTH_SHORT).show();
                      }

                  }
              }

            });
        }







    void setTextVisible(View view){
        loginWarningText.setVisibility(View.VISIBLE);
        forgotPass.setVisibility(View.VISIBLE);
    }

    void setButtonVisible(View view){

        signUpBut.setVisibility(View.VISIBLE);}

    void setTextInvisible(View view){
        loginWarningText.setVisibility(View.INVISIBLE);
        forgotPass.setVisibility(View.INVISIBLE);

    }

    void setButtonInvisible(View view){
        loginBut.setVisibility(View.INVISIBLE);


    }



}