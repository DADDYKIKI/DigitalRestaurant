package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digitalrestaurant.Authentications.LoginPage;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.R;

public class NewPassword extends AppCompatActivity {

    Button submitButton;
    EditText newPassword,confrimNewPassword;

    String email="";

    DatabaseHelper data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        newPassword=findViewById(R.id.password);
        confrimNewPassword=findViewById(R.id.password2);

        submitButton=findViewById(R.id.submitButton);

        data=new DatabaseHelper(this);

        updateUser();


        Bundle extras=getIntent().getExtras();

        if(extras!=null){


            email= extras.getString("emailSentForPass");
        }
    }

    public void updateUser() {

       submitButton.setOnClickListener(v -> {

           if (newPassword.getText().toString().equals("") || confrimNewPassword.getText().toString().equals("")) {

               Toast.makeText(this, "All fields must be entered", Toast.LENGTH_SHORT).show();

           }
           else if (!isPaswordValid(confrimNewPassword.getText().toString()))
               Toast.makeText(this, "Password must be greater than 3", Toast.LENGTH_SHORT).show();

           else if (!isPaswordValid(newPassword.getText().toString()))
               Toast.makeText(this, "Password must be greater than 3", Toast.LENGTH_SHORT).show();

            else{

           if(!newPassword.getText().toString().equals(confrimNewPassword.getText().toString())){
               Toast.makeText(this, "Password mismatch", Toast.LENGTH_SHORT).show();
               Toast.makeText(this, "Make sure your chosen \npasswords are similar", Toast.LENGTH_SHORT).show();}
           else{

               Boolean success=data.updateUserPassword(email,newPassword.getText().toString());
           if(success==true)

               Toast.makeText(this, "Password Updated successfuly", Toast.LENGTH_SHORT).show();

               Intent intent=new Intent(this, LoginPage.class);
               startActivity(intent);

           }}

       });}

    public boolean isPaswordValid(String password){

        return password.length()>3;
    }
}