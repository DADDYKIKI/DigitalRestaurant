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
import com.example.digitalrestaurant.R;

public class ForgotPassword extends AppCompatActivity {

    Button checkUser,signup;

    EditText enterEmail,enterMaidenName;

    TextView userExistText;

    DatabaseHelper checker;

    private long press;


    @Override
    public void onBackPressed() {


        if(press+2000>System.currentTimeMillis()){

            finishAffinity();
            System.exit(0);

            return;}

        else {
            Toast.makeText(this, "Press again to exit your app", Toast.LENGTH_SHORT).show();

        }press=System.currentTimeMillis();

    }


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

    public void checkUser() {//Will authenticate your password

        checkUser.setOnClickListener(v -> {

            Boolean yes=checker.forgotPassordChecker(enterEmail.getText().toString(),enterMaidenName.getText().toString());

            if(yes==true){

                Intent intent=new Intent(this, NewPasswordSetup.class);
                intent.putExtra("emailSentForPass",enterEmail.getText().toString());
                startActivity(intent);
            }

            else{   setTextVisible(v);
                Toast.makeText(this, "You can create a new account if you like", Toast.LENGTH_SHORT).show();}


        });
    }

    public void signupAgain() {//back to signup page

        signup.setOnClickListener(v -> {
            Intent intent=new Intent(this,SignupPage.class);
            startActivity(intent);

        });
    }

    void setTextVisible(View view){//sets warning text visibility
        userExistText.setVisibility(View.VISIBLE);

    }

}