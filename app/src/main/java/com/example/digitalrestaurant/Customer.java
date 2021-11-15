package com.example.digitalrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Customer extends AppCompatActivity //implements AdapterView.OnItemSelectedListener
                                                         {


    TextView loginText1,signupText1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginText1= (TextView) findViewById(R.id.customerloginBut);
        signupText1= (TextView) findViewById(R.id.customersignupBut);

       // signupBut= (Button) findViewById(R.id.loginSubBtn);




        loginText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click1(LoginPage.class);

            }
        });

        signupText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click1(SignupPage.class);
            }
        });






     /*   //SignupPage Spinner code
        Spinner spinner1= (Spinner)findViewById(R.id.signupSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.locator,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

*/
    }

    public void click1(Object x){
        Intent intent=new Intent(this, (Class<?>) x);

        startActivity(intent);

    }
/*


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String string= parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),string,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}


