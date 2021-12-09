package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digitalrestaurant.Authentications.SignupPage;
import com.example.digitalrestaurant.Database.DatabaseHelper;

public class ForgotPassword extends AppCompatActivity {

    Button checkUser,signup;
    EditText enterEmail,enterMaidenName;

    TextView userExistText;

    DatabaseHelper checker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        checkUser=findViewById(R.id.checkUser);
        enterEmail=findViewById(R.id.enterEmail);
        signup=findViewById(R.id.signupAgain);
        userExistText=findViewById(R.id.userExistText);
        enterMaidenName=findViewById(R.id.enterMaidenName);

        checker=new DatabaseHelper(this);

        signupAgain();

        checkUser();
    }

    public void checkUser() {

        checkUser.setOnClickListener(v -> {

            Boolean yes=checker.forgotPassordChecker(enterEmail.getText().toString(),enterMaidenName.getText().toString());

            if(yes==true){

                Intent intent=new Intent(this,NewPassword.class);
                startActivity(intent);
            }

            else{   setTextVisible(v);
                Toast.makeText(this, "You can creat a new account", Toast.LENGTH_SHORT).show();}


        });
    }

    public void signupAgain() {

        signup.setOnClickListener(v -> {
            Intent intent=new Intent(this,SignupPage.class);
            startActivity(intent);

        });
    }

    void setTextVisible(View view){
        userExistText.setVisibility(View.VISIBLE);

    }

}