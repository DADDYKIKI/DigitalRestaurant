package com.example.digitalrestaurant.Authentications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
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
import com.example.digitalrestaurant.R;

import java.io.ByteArrayOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SellerUploadPage extends AppCompatActivity {

    private EditText price,name,nationality,alcoholic,image,pictureLabel;
    private TextView upload,vendorName;

    private DatabaseHelper helper;


   // String foodPrice="";
 //  // String foodName="";
   // String foodNationality="";
  //  String foodImage="";
  //  String foodAlcohol="";
   // String imageLabel="";

    List<ItemData> newItems;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_upload_page);




        newItems=new ArrayList<>();

        helper=new DatabaseHelper(this);

        //..........DataBase Stuff...........................................................





     /*   db.execSQL("CREATE TABLE " + DatabaseHelper.FOODS_FOR_SALE + "("
                + DatabaseHelper.COLUMNFOOD1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DatabaseHelper.COLUMNFOOD2 + " INTEGER, "
                + DatabaseHelper.COLUMNFOOD3 + " TEXT, "
                + DatabaseHelper.COLUMNFOOD4 + " TEXT, "
                + DatabaseHelper.COLUMNFOOD5 + " BLOB, "
                + DatabaseHelper.COLUMNFOOD6 + " TEXT, "
                + DatabaseHelper.COLUMNFOOD7 + " TEXT)");
        //..................................................................................

*/

        price=findViewById(R.id.priceOfFood);
        name=findViewById(R.id.nameOfFoodItem);
        nationality=findViewById(R.id.nationalityOfItem);
        alcoholic=findViewById(R.id.alcoholic);
        upload=findViewById(R.id.selleruploadBtn);

        pictureLabel=findViewById(R.id.Imagelabel);
        vendorName=findViewById(R.id.vendorName);






      //  populateOurDatabase();




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





