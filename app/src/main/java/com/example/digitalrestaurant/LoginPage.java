package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {

    Button loginBut;

    TextView loginEmail,loginPass,loginWarningText;

    String email="abc@gmail.com";
    String password="aba1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);
        loginEmail= (TextView) findViewById(R.id.enterLoginEmail);
        loginPass= (TextView) findViewById(R.id.enterLoginPaswd);
        loginWarningText= (TextView) findViewById(R.id.loginWarningText);
        loginBut = (Button)findViewById(R.id.loginSubBtn);


        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loginEmail.getText().toString().equals(email)&&loginPass.getText().toString().equals(password)){
                click2(PageOne.class);

                    setTextInvisible(v);

           }

                      else{ setTextVisible( v) ;   }

            }
        });
        }


    public void click2(Object x){

        Intent intent=new Intent(LoginPage.this, (Class<?>) x);

        startActivity(intent);

        }


    void setTextVisible(View view){
        loginWarningText.setVisibility(View.VISIBLE);

    }

    void setTextInvisible(View view){
        loginWarningText.setVisibility(View.INVISIBLE);

    }

}