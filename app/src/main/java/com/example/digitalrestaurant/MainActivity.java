package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView loginText,signupText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginText= (TextView) findViewById(R.id.loginBut);
        signupText= (TextView) findViewById(R.id.signupBut);


        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(LoginPage.class);
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(signupPage.class);
            }
        });




        //SignupPage Spinner code
        Spinner spinner1= (Spinner)findViewById(R.id.signupSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.locator,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);


    }

    public void click(Object x){
        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String string= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),string,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


