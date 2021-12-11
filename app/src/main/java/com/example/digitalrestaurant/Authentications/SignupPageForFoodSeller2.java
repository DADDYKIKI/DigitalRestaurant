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
    public void onBackPressed() {




        Intent intent5 =new Intent(getApplicationContext(), IntroPage.class);

        intent5.putExtra("Exit",true);
        startActivity(intent5);

        finish();
        System.exit(0);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page_for_vendor);

        homeKey=findViewById(R.id.pageOneomekey);
        menuKey=findViewById(R.id.menuKeyS);

        signupName = findViewById(R.id.signupNameV);
        signupEmail = findViewById(R.id.signupEmailV);
        signupPaswd = (findViewById(R.id.signUpPassword));

        signSubBtnV = (findViewById(R.id.signSubBtnV));


        menuKey2();


        signupV();

    }


    public void menuKey2(){
        menuKey.setOnClickListener(v -> {
            Intent intent2=new Intent(this, Menu.class);
            startActivity(intent2);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }

    public void signupV(){
        signSubBtnV.setOnClickListener(v -> {

            helper=new DatabaseHelper(this);


            String name= signupName.getText().toString();
            String email= signupEmail.getText().toString();
            String password= signupPaswd.getText().toString();


            if (name.equals("") || email.equals("")|| password.equals("")){

                Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();

            }


            else if (!isEmailValid(email))
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();

            else if (!isPaswordValid(password))
                Toast.makeText(this, "Password must be greater than 3", Toast.LENGTH_SHORT).show();





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
                    overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

                } else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();


            }

        });
        }


    public boolean isEmailValid(String email){

        return email.contains("@");
    }

    public boolean isPaswordValid(String password){

        return password.length()>3;
    }






}