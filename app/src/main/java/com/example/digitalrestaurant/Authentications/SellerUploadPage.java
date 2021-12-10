package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.ItemData;
import com.example.digitalrestaurant.HomePage;
import com.example.digitalrestaurant.Menu;
import com.example.digitalrestaurant.R;

import java.io.ByteArrayOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SellerUploadPage extends AppCompatActivity {

    private EditText price,name,nationality,alcoholic,image,pictureLabel;
    private TextView upload,vendorName;

    private DatabaseHelper helper;

    private TextView homeKey,menuKey;
   // String foodPrice="";
 //  // String foodName="";
   // String foodNationality="";
  //  String foodImage="";
  //  String foodAlcohol="";
   // String imageLabel="";

    List<ItemData> newItems;

    private long press;


    @Override
    public void onBackPressed() {


        if(press+3000>System.currentTimeMillis()){
            super.onBackPressed();
            return;}

        else
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_upload_page);




        newItems=new ArrayList<>();

        helper=new DatabaseHelper(this);


        price=findViewById(R.id.priceOfFood);
        name=findViewById(R.id.nameOfFoodItem);
        nationality=findViewById(R.id.nationalityOfItem);
        alcoholic=findViewById(R.id.alcoholic);
        upload=findViewById(R.id.selleruploadBtn);

        pictureLabel=findViewById(R.id.Imagelabel);
        vendorName=findViewById(R.id.vendorName);
        homeKey=findViewById(R.id.pageOneomekey);
        menuKey=findViewById(R.id.menuKeyS);


        homeKey2();
        menuKey2();


}


    public void homeKey2(){
        homeKey.setOnClickListener(v -> {
            Intent intent=new Intent(this, HomePage.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out);

        });

    }

    public void menuKey2(){
        menuKey.setOnClickListener(v -> {
            Intent intent2=new Intent(this, Menu.class);
            startActivity(intent2);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }

   /* public void populateOurDatabase(){
        upload.setOnClickListener(v -> {

            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);


            String foodImagelabel=pictureLabel.getText().toString();
           // String file= Environment.getExternalStorageDirectory().getPath() + "/Downloads/" + foodImagelabel + ".jpeg";
            String foodPrice=price.getText().toString();
            String foodName=name.getText().toString();
            String foodNationality=nationality.getText().toString();
            String foodAlcohol=alcoholic.getText().toString();

           // Bitmap toBitmap = BitmapFactory.decodeFile(file);
            ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
           // toBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteOutput);
            byte[] imageByte = byteOutput.toByteArray();


            // if (foodPrice.equals("") || foodName.equals("")|| foodNationality.equals(""))
            //  {

            //  Toast.makeText(this, "All fields must be complete", Toast.LENGTH_SHORT).show();}

            //     else{

            // newItems.add(new ItemData(foodPrice,
            //  foodName,foodNationality,uploadFoodImage(),imageLabel,foodAlcohol);


         /*   boolean populate=helper.uploadStatement(foodPrice,
                    foodName,foodNationality,foodAlcohol);


            if(populate==true){

                price.setText("");
                name.setText("");
                nationality.setText("");
                pictureLabel.setText("");
                alcoholic.setText("");

                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();}

            else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();


        });}*/





       /* public Bitmap converToBitmap(String txt){

                byte [] encodeByte = Base64.decode(txt,Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
                return bitmap;

            }*/
        }





