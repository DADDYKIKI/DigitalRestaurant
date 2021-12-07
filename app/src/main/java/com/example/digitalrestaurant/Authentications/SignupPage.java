package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.UserDetails;
import com.example.digitalrestaurant.Order;
import com.example.digitalrestaurant.R;


public class SignupPage extends AppCompatActivity {

    private EditText signupName,signupEmail,signupAge,signupPhone,signupAddress,signupPaswd,signupCountry;

   private  Button signSubBtn;

    private DatabaseHelper helper;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);



        signupName = findViewById(R.id.signupNameV);
        signupEmail = findViewById(R.id.signupEmailV);
        signupAge = findViewById(R.id.signupAge);
        signupPhone = findViewById(R.id.signUpPhone);
        signupAddress= findViewById(R.id.enterhomeaddress);
        signupPaswd = findViewById(R.id.signUpPassV3);
        signupCountry = findViewById(R.id.enterCountry);

        signSubBtn = (findViewById(R.id.signSubBtnV));


        signUpC();
    }

    public void signUpC(){
        signSubBtn.setOnClickListener(v -> {

            helper = new DatabaseHelper(this);

            String name = signupName.getText().toString();
            String email = signupEmail.getText().toString();
            String age = signupAge.getText().toString();
            String phone = signupPhone.getText().toString();
            String address = signupAddress.getText().toString();
            String password = signupPaswd.getText().toString();
            String country= signupCountry.getText().toString();

            if (name.equals("") || email.equals("") || age.equals("") || phone.equals("") ||
                    password.equals("") || address.equals("")|| country.equals("")) {

                Toast.makeText(this, "All fields must be entered", Toast.LENGTH_SHORT).show();

            }

            else if (!isEmailValid(email))
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();

            else if (!isPaswordValid(password))
                Toast.makeText(this, "Password must be greater than 3", Toast.LENGTH_SHORT).show();




            else {
                             boolean check=helper.checkforUniqueEmailAddress(email);

                         if(check==true)Toast.makeText(this, "Email address already in use.\nTry another",
                                 Toast.LENGTH_SHORT).show();

                          else{
                             try {
                                   boolean signup =
                                        helper.addCustomerUserAndPAss(name, email, Integer.parseInt(age),
                                                Integer.parseInt(phone), address,country, password);


                        if (signup == true) {

                            Intent i = new Intent(this, Order.class);
                            i.putExtra("customerName", name);
                            i.putExtra("phone", phone);
                            i.putExtra("address", address);

                            Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();

                            signupName.setText("");
                            signupEmail.setText("");
                            signupAge.setText("");
                            signupPhone.setText("");
                            signupAddress.setText("");
                            signupPaswd.setText("");

                            Intent intent = new Intent(this, LoginPage.class);
                            startActivity(intent);

                        } else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();

                    }catch (Exception e){Toast.makeText(this, "Your age or phone number\n must be in number format", Toast.LENGTH_SHORT).show();}

            }}

        });
    }





public boolean isEmailValid(String email){

        return email.contains("@");
        }

public boolean isPaswordValid(String password){

        return password.length()>3;
        }







        }