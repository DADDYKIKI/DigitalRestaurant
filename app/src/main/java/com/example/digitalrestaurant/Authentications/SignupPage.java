package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.R;

public class SignupPage extends AppCompatActivity {

    EditText signupName,signupEmail,signupAge,signupPaswd;

    Button signSubBtn;

    DatabaseHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        signupName = findViewById(R.id.signupName);
        signupEmail = findViewById(R.id.signupEmail);
        signupAge = findViewById(R.id.signupAge);
        signupPaswd = (findViewById(R.id.signupPaswd));

        signSubBtn = (findViewById(R.id.signSubBtn));


        signin();

    }

    public void signin(){
        signSubBtn.setOnClickListener(v -> {

            helper=new DatabaseHelper(this);

            String name= signupName.getText().toString();
            String email= signupEmail.getText().toString();
            String age= signupAge.getText().toString();
            String password= signupPaswd.getText().toString();



            boolean signup=
                    helper.addDataUserAndPAss(name,email,age,password);

            if(signup==true)
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
            else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();


        });
        }




}