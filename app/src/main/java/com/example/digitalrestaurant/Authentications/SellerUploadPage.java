package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.R;

public class SellerUploadPage extends AppCompatActivity {

    EditText price,name,nationality,alcoholic,image;
    TextView upload;

    DatabaseHelper helper;

    String foodPrice="";
    String foodName="";
    String foodNationality="";
    String foodImage="";
    String foodAlcohol="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_upload_page);

        helper=new DatabaseHelper(this);


        price=findViewById(R.id.priceOfFood);
        name=findViewById(R.id.nameOfFoodItem);
        nationality=findViewById(R.id.nationalityOfItem);
        image=findViewById(R.id.pictureOfItem);
        alcoholic=findViewById(R.id.alcoholic);
        upload=findViewById(R.id.selleruploadBtn);

        foodPrice=price.getText().toString();
        foodName=name.getText().toString();
       foodNationality=nationality.getText().toString();
        foodImage=image.getText().toString();
        foodAlcohol=alcoholic.getText().toString();

        upload();




}

    public void upload(){//................Add to Database...................


        upload.setOnClickListener(v -> {

            if (foodPrice.equals("") || foodName.equals("")|| foodNationality.equals("")|| foodImage.equals("")|| foodAlcohol.equals("")){

                Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();}

                else{

                     boolean populate=
                     helper.populateFoodData(foodPrice,foodName,foodNationality,foodImage,foodAlcohol);


                if(populate==true){

                        price.setText("");
                        name.setText("");
                        nationality.setText("");
                        image.setText("");
                        alcoholic.setText("");
                        upload.setText("");

                        Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();}

                         else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();}


        });



    }

}