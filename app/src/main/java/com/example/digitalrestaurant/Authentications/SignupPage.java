package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.R;

public class SignupPage extends AppCompatActivity {

    private EditText signupName,signupEmail,signupAge,signupPhone,signupAddress,signupPaswd;

   private  Button signSubBtn;

    private DatabaseHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        signupName = findViewById(R.id.signupNameV);
        signupEmail = findViewById(R.id.signupEmailV);
        signupAge = findViewById(R.id.signupAge);
        signupPhone = findViewById(R.id.phone);
        signupAddress= findViewById(R.id.enterhomeaddress);
        signupPaswd = (findViewById(R.id.phone));

        signSubBtn = (findViewById(R.id.signSubBtnV));


        signUpC();

    }

    public void signUpC(){
        signSubBtn.setOnClickListener(v -> {

            helper=new DatabaseHelper(this);

            String name= signupName.getText().toString();
            String email= signupEmail.getText().toString();
            String age= signupAge.getText().toString();
            String phone= signupPhone.getText().toString();
            String address= signupAddress.getText().toString();
            String password= signupPaswd.getText().toString();

            if (name.equals("") || email.equals("")|| age.equals("")|| phone.equals("")|| password.equals("")|| address.equals("")){

                Toast.makeText(this, "All fields must be entered", Toast.LENGTH_SHORT).show();

            }


        else {

                boolean signup =
                        helper.addCustomerUserAndPAss(name, email, age,phone,address,password);

                if (signup == true) {
                    Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    signupName.setText("");
                    signupEmail.setText("");
                    signupAge.setText("");
                    signupPhone.setText("");
                    signupAddress.setText("");
                    signupPaswd.setText("");

                    Intent i = new Intent(this, LoginPage.class);
                    startActivity(i);
                } else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();


            }

        });
        }




}