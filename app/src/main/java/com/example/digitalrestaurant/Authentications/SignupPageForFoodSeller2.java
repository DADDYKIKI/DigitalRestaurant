package com.example.digitalrestaurant.Authentications;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.Menu;
import com.example.digitalrestaurant.R;

public class SignupPageForFoodSeller2 extends AppCompatActivity {

    private EditText signupName,signupEmail,signupPaswd;

    private Button signSubBtnV;

    private DatabaseHelper helper;

    private TextView homeKey,menuKey;


    @Override
    public void onBackPressed() {//Move Backward

            Intent i = new Intent(this, FoodSeller.class);
            startActivity(i);

        }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page_for_vendor);

        homeKey=findViewById(R.id.pageOneomekey);
        menuKey=findViewById(R.id.menuKeyS);

        signupName = findViewById(R.id.signupNameV);
        signupName.setHint("Enter Restaurant");
        signupEmail = findViewById(R.id.signupEmailV);
        signupEmail.setHint("Enter Email");
        signupPaswd = (findViewById(R.id.signUpPassword));
        signupPaswd.setHint("Enter password");

        signSubBtnV = (findViewById(R.id.signSubBtnV));


        signupV();

    }


    public void signupV(){
        signSubBtnV.setOnClickListener(v -> {//For login authentication

            helper=new DatabaseHelper(this);


            String name= signupName.getText().toString().replaceAll("\\s+","").toLowerCase();
            String email= signupEmail.getText().toString();
            String password= signupPaswd.getText().toString();


            if (name.equals("") || email.equals("")|| password.equals("")){

                Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();

            }

            if (name.equals("adakitchen") ||name.equals("approkokitchen")|| name.equals("obandekitchen")|| name.equals("stainless")){

                if (!isEmailValid(email))
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();

            else if (!isPaswordValid(password))
                Toast.makeText(this, "Password must be greater than 3", Toast.LENGTH_SHORT).show();

            else {
                boolean check=helper.checkforVendorsUniqueEmailAddress(email);

                if(check==true)Toast.makeText(this, "Email address already in use.\nTry another",
                        Toast.LENGTH_SHORT).show();

                else {

                    boolean signup =
                            helper.addVendorData(name, email, password);

                    if (signup == true) {
                        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                        signupName.setText("");
                        signupEmail.setText("");
                        signupPaswd.setText("");
                        Intent i = new Intent(this, LoginPageForFoodSeller2.class);
                        startActivity(i);
                        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

                    } else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();

                }}}

            else {Toast.makeText(this, "Check your spellings", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "You are only allowed to use\nAda Kitchen, Approkokichen, Obande Kitchen", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "and, Stainless, for the\nthe sake of this project", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "However,\nletter case does not really matter\nThanks", Toast.LENGTH_SHORT).show();}


        });
        }


    public boolean isEmailValid(String email){

        return email.contains("@");
    }

    public boolean isPaswordValid(String password){

        return password.length()>3;
    }






}