package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digitalrestaurant.Authentications.LoginPage;
import com.example.digitalrestaurant.Database.DatabaseHelper;

public class NewPassword extends AppCompatActivity {

    Button submitButton;
    EditText newPassword,confrimNewPassword;

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
    }

    public void updateUser() {

       submitButton.setOnClickListener(v -> {
           if(!newPassword.getText().toString().equals(confrimNewPassword.getText().toString())){
               Toast.makeText(this, "Password mismatch", Toast.LENGTH_SHORT).show();
               Toast.makeText(this, "Make sure your chosen \npasswords are similar", Toast.LENGTH_SHORT).show();}
           else{

               Boolean success=data.updateUserPassword(newPassword.getText().toString());
           if(success==true)

               Toast.makeText(this, "Password Updated successfuly", Toast.LENGTH_SHORT).show();

               Intent intent=new Intent(this, LoginPage.class);
               startActivity(intent);

           }

       });}
}