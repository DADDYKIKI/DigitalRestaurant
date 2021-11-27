package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.digitalrestaurant.Authentications.LoginPage;
import com.example.digitalrestaurant.Authentications.SignupPage;
import com.example.digitalrestaurant.Menu;
import com.example.digitalrestaurant.R;

public class Customer extends AppCompatActivity //implements AdapterView.OnItemSelectedListener
                                                         {


    TextView loginText1,signupText1,menuKey;;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuKey=findViewById(R.id.menuKey);

        loginText1= findViewById(R.id.customerloginBut);
        signupText1= findViewById(R.id.customersignupBut);

       // signupBut= (Button) findViewById(R.id.loginSubBtn);


        menuKey();

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
        public void menuKey(){
             menuKey.setOnClickListener(v -> {
                 Intent intent2=new Intent(this, Menu.class);
             startActivity(intent2);
             overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


    });

}

}


