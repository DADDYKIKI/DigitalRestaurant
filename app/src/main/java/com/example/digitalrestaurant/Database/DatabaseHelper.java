package com.example.digitalrestaurant.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.digitalrestaurant.Details.ItemData;
import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.Details.RestaurantsData.RestaurantLogDetails;
import com.example.digitalrestaurant.Details.RestaurantsData.RestaurantsDetails;
import com.example.digitalrestaurant.Details.UserDetails;
import com.example.digitalrestaurant.R;
import com.example.digitalrestaurant.VendorDetails;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DatabaseHelper extends SQLiteOpenHelper {


    //Database
    public static final String MY_DATABASE_NAME="GodwinDatabase";

    //Tables
    public static final String MY_TABLE_NAME="GodwinItemsTable";
    public static final String MY_USER_AND_PASS_TABLE="GodwinUserInfoTable";
    public static final String FOODS_FOR_SALE="GodwinPopulateFoodIntoRestaurant";
    public static final String VENDOR_DETAILS="VendorStuff";
    //public static final String ADATABLE="AdaRestaurantTable";


    //Cart details
    public static final String COLUMNNAME1="CartID";
    public static final String COLUMNNAME2="Cart_ood_Name";
    public static final String COLUMNNAME3="Total_Quantity";
    public static final String COLUMNNAME4="Total_Price";
    public static final String COLUMNNAME5="RestaurantName";


    //Customer details
    public static final String COLUMNUSER1="CustomerID";
    public static final String COLUMNUSER2="nameOfUser";
    public static final String COLUMNUSER3="Customer_email";
    public static final String COLUMNUSER4="age";
    public static final String COLUMNUSER5="phone";
    public static final String COLUMNUSER6="maidenName";
    public static final String COLUMNUSER7="country";
    public static final String COLUMNUSER8="Customer_Passwords";


   /* //Items details
    public static final String COLUMNFOOD1="ItemID";
    public static final String COLUMNFOOD2="Item_food_price";
    public static final String COLUMNFOOD3="Item_food_name";
    public static final String COLUMNFOOD4="food_nationality";
    public static final String COLUMNFOOD5="RestaurantName";
    public static final String COLUMNFOOD6="alcoholic";*/

    //Vendor details
    public static final String COLUMNVEN1="VendorID";
    public static final String COLUMNVEN2="nameOfVendor";
    public static final String COLUMNVEN3="Vendor_email";
    public static final String COLUMNVEN4="Vendor_Passwords";

   /* public static final String COLUMNADA1="AdaItemID";
    public static final String COLUMNADA2="AdaFoodPrice";
    public static final String COLUMNADA3="AdaFoodName";
    public static final String COLUMNADA4="AdaFoodNAtionality";
    public static final String COLUMNADA5="AdaFoodImage";
    public static final String COLUMNADA6="AdaFoodLabel";
    public static final String COLUMNADA7="alcoholic";*/





    private static ArrayList<OrderDetails> order=new ArrayList<>();
    ArrayList<ItemData> items=new ArrayList<>();
    ArrayList<UserDetails> customer=new ArrayList<>();
    ArrayList<VendorDetails> vendor=new ArrayList<>();



    public DatabaseHelper(Context context) {
        super(context, MY_DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {



           //Cart table
           db.execSQL("CREATE TABLE " + MY_TABLE_NAME + "("
                   + COLUMNNAME1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + COLUMNNAME2 + " TEXT, "
                   + COLUMNNAME3 + " INTEGER, "
                   + COLUMNNAME4 + " INTEGER, "
                   + COLUMNNAME5 + " TEXT)");

           //Customer table
           db.execSQL("CREATE TABLE " + MY_USER_AND_PASS_TABLE + "("
                   + COLUMNUSER1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + COLUMNUSER2 + " TEXT, "
                   + COLUMNUSER3 + " TEXT, "
                   + COLUMNUSER4 + " INTEGER, "
                   + COLUMNUSER5 + " INTEGER, "
                   + COLUMNUSER6 + " TEXT, "
                   + COLUMNUSER7 + " TEXT, "
                   + COLUMNUSER8 + " TEXT)");

           //Items details
       /*   db.execSQL("CREATE TABLE " + FOODS_FOR_SALE + "("
                   + COLUMNFOOD1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + COLUMNFOOD2 + " INTEGER, "
                   + COLUMNFOOD3 + " TEXT, "
                   + COLUMNFOOD4 + " TEXT, "
                   + COLUMNFOOD4 + " TEXT, "
                   + COLUMNFOOD5 + " TEXT)");*/

          //Vendor tables
           db.execSQL("CREATE TABLE " + VENDOR_DETAILS + "("
                   + COLUMNVEN1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + COLUMNVEN2 + " TEXT, "
                   + COLUMNVEN3 + " TEXT, "
                   + COLUMNVEN4 + " TEXT)");

      /*  db.execSQL("CREATE TABLE " + ADATABLE + "("
                + COLUMNADA1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNADA2 + " TEXT, "
                + COLUMNADA3 + " TEXT, "
                + COLUMNADA4 + " TEXT, "
                + COLUMNADA5 + " BLOB, "
                + COLUMNADA6 + " TEXT, "
                + COLUMNADA7 + " TEXT)");*/




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+MY_TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS "+MY_USER_AND_PASS_TABLE );
            db.execSQL("DROP TABLE IF EXISTS "+FOODS_FOR_SALE);
            db.execSQL("DROP TABLE IF EXISTS "+VENDOR_DETAILS);
           // db.execSQL("DROP TABLE IF EXISTS "+ADATABLE);
            onCreate(db);
    }





    public boolean addData(String  foodName, String quantity, String totalPrice,String restaurantName){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNNAME2,foodName);
        contentV.put(COLUMNNAME3,quantity);
        contentV.put(COLUMNNAME4,totalPrice);
        contentV.put(COLUMNNAME5,restaurantName);

        long output=myDatabase.insert(MY_TABLE_NAME,null,contentV);
        myDatabase.close();

        if(output==-1) return false;
        else return  true;
    }





    public boolean addVendorData(String  Name, String email, String password){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNVEN2,Name);
        contentV.put(COLUMNVEN3,email);
        contentV.put(COLUMNVEN4,password);

        long output=myDatabase.insert(VENDOR_DETAILS,null,contentV);
        myDatabase.close();

        if(output==-1) return false;
        else return  true;


    }



    public boolean addCustomerUserAndPAss(String name, String  email, String age, String phone,
                                          String maidenName,String country,String password){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNUSER2,name);
        contentV.put(COLUMNUSER3,email);
        contentV.put(COLUMNUSER4,age);
        contentV.put(COLUMNUSER5,phone);
        contentV.put(COLUMNUSER6,maidenName);
        contentV.put(COLUMNUSER7,country);
        contentV.put(COLUMNUSER8,password);


        long output=myDatabase.insert(MY_USER_AND_PASS_TABLE,null,contentV);

        myDatabase.close();

        if(output==-1) return false;
        else return  true;


    }

    public boolean updateUserPassword(String email,String password){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();

        contentV.put(COLUMNUSER8,password);


        long output=myDatabase.update(MY_USER_AND_PASS_TABLE,contentV,COLUMNUSER3+"=?",
                new String[]{email});

        myDatabase.close();

        if(output==-1) return false;
        else return  true;


    }

   /* public boolean uploadStatement(String price, String name, String nationality, String alcoholic) {//................Add to Database...................


        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentV = new ContentValues();

            contentV.put(COLUMNFOOD2, price);
            contentV.put(COLUMNFOOD3, name);
            contentV.put(COLUMNFOOD4, nationality);
            //contentV.put(COLUMNFOOD5, image);
          //  contentV.put(COLUMNFOOD6, image_label);
            contentV.put(COLUMNFOOD7, alcoholic);



        long output = db.insert(DatabaseHelper.FOODS_FOR_SALE, null, contentV);

        if (output == -1) return false;
        else return true;

    }*/




   /* public Cursor getNoneAlcoholicFood(){

       SQLiteDatabase myDatabase=this.getReadableDatabase();

        //ArrayList<ItemData> myAlcoholicFoodItems=new ArrayList<>();

        Cursor cur=myDatabase.rawQuery("select * from "+MY_TABLE_NAME+" where "+COLUMNFOOD6+" is null",null);

     /*   while(cur1.moveToNext()){

                    Bitmap InBitmapBitmap= BitmapFactory.decodeByteArray(cur1.getBlob(5),0,
                            cur1.getBlob(5).length);

                    myAlcoholicFoodItems.add(new ItemData(cur1.getString(cur1.getColumnIndexOrThrow(COLUMNFOOD2)),
                    cur1.getString(cur1.getColumnIndexOrThrow(COLUMNFOOD3)), cur1.getString(cur1.getColumnIndexOrThrow(COLUMNFOOD4)),
                            InBitmapBitmap, cur1.getString(cur1.getColumnIndexOrThrow(COLUMNFOOD6)),
                    cur1.getString(cur1.getColumnIndexOrThrow(COLUMNFOOD7))));

    }
        cur1.close();
        myDatabase1.close();

        return  cur;


    }*/




    public Cursor getOrders(){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        Cursor cur=myDatabase.rawQuery("select * from "+MY_TABLE_NAME,null);

        //Cursor cur=myDatabase.query(MY_TABLE_NAME,null,null,null,null,null,null);

      /*  if(cur2.moveToFirst()){
        do{
            Bitmap InBitmapBitmap= BitmapFactory.decodeByteArray(cur2.getBlob(5),0,
                    cur2.getBlob(5).length);

           items.add(new ItemData(cur2.getString(cur2.getColumnIndexOrThrow(COLUMNFOOD2)),
                    cur2.getString(cur2.getColumnIndexOrThrow(COLUMNFOOD3)),
                    cur2.getString(cur2.getColumnIndexOrThrow(COLUMNFOOD4)),

                    cur2.getString(cur2.getColumnIndexOrThrow(COLUMNFOOD6)),
                    cur2.getString(cur2.getColumnIndexOrThrow(COLUMNFOOD7))));
    }while (cur2.moveToNext());

        }*/

        //myDatabase2.close();
        cur.close();
        return cur;
    }






    @SuppressLint("Range")
    public ArrayList<OrderDetails> viewCartItems() {

        SQLiteDatabase myDatabase3 = this.getReadableDatabase();
        ArrayList<OrderDetails> mylist = new ArrayList<>();

        Cursor cur = myDatabase3.rawQuery("select * from " + MY_TABLE_NAME, null);

        if (cur.getCount()>0) {
            if (cur.moveToFirst())

                do {

                    String name = cur.getString(cur.getColumnIndex(COLUMNNAME2));
                    String quantity = cur.getString(cur.getColumnIndex(COLUMNNAME3));
                    String totalPrice = cur.getString(cur.getColumnIndex(COLUMNNAME4));
                    String restaurant = cur.getString(cur.getColumnIndex(COLUMNNAME5));


                    OrderDetails myoder = new OrderDetails(name, quantity, totalPrice, restaurant);

                    mylist.add(myoder);


                } while (cur.moveToNext());

            cur.close();
            myDatabase3.close();




        }return mylist;
    }




    @SuppressLint("Range")
    public boolean getCustomerLoginDetails(String email, String password) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select * from " + MY_USER_AND_PASS_TABLE,

                null);

            if(cur.getCount()>0) {
                while (cur.moveToNext()) {

                    if (cur.getString(cur.getColumnIndex(COLUMNUSER3)).equals(email) &&
                            cur.getString(cur.getColumnIndex(COLUMNUSER8)).equals(password))

                        return true;

                    myDatabase.close();
                }


            }return false;
    }



        @SuppressLint("Range")
        public boolean getVendorLoginDetails(String restaurantName, String Password) {

            SQLiteDatabase myDatabase = this.getReadableDatabase();

            Cursor cur = myDatabase.rawQuery("select * from " + VENDOR_DETAILS,

                    null);

            if(cur.getCount()>0) {
                while (cur.moveToNext()) {

                    if (cur.getString(cur.getColumnIndex(COLUMNVEN2)).equals(restaurantName) &&
                            cur.getString(cur.getColumnIndex(COLUMNVEN4)).equals(Password))

                        return true;

                    myDatabase.close();
                }


            }return false;

    }

    @SuppressLint("Range")
    public String setCustomerWelcomeName(String email) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select * from " +MY_USER_AND_PASS_TABLE,
                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if(cur.getString(cur.getColumnIndex(COLUMNUSER3)).equals(email))

                  return cur.getString(cur.getColumnIndex(COLUMNUSER2));
                myDatabase.close();

            }


        }return null;

    }

    @SuppressLint("Range")
    public boolean checkforUniqueEmailAddress(String email) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select " +COLUMNUSER3+" from " + MY_USER_AND_PASS_TABLE,
                 // " where "+COLUMNUSER3+" = "+email,

                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if(cur.getString(cur.getColumnIndex(COLUMNUSER3)).equals(email))

                    return true;
              myDatabase.close();

            }

        }return false;

    }

    @SuppressLint("Range")
    public boolean forgotPassordChecker(String email,String maidenName) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select " +COLUMNUSER3+","+COLUMNUSER6+" from " + MY_USER_AND_PASS_TABLE,
                // " where "+COLUMNUSER3+" = "+email,

                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if(cur.getString(cur.getColumnIndex(COLUMNUSER3)).equals(email)&&
                        cur.getString(cur.getColumnIndex(COLUMNUSER6)).equals(maidenName))

                    return true;
                myDatabase.close();

            }

        }return false;

    }

    @SuppressLint("Range")
    public boolean updatePassword(String email, String password) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select " +COLUMNUSER3+" from " + MY_USER_AND_PASS_TABLE,
                // " where "+COLUMNUSER3+" = "+email,

                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if(cur.getString(cur.getColumnIndex(COLUMNUSER3)).equals(email))

                    return true;
                myDatabase.close();

            }

        }return false;

    }

    @SuppressLint("Range")
    public boolean checkforAge(String email) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select * from " +MY_USER_AND_PASS_TABLE,

                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if(cur.getString(cur.getColumnIndex(COLUMNUSER3)).equals(email) &&
                        Integer.parseInt(cur.getString(cur.getColumnIndex(COLUMNUSER4)))<18)



                    return true;
                myDatabase.close();

            }

        }return false;

    }

    @SuppressLint("Range")
    public boolean checkCountry(String email) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select * from " +MY_USER_AND_PASS_TABLE,

                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if(cur.getString(cur.getColumnIndex(COLUMNUSER3)).equals(email) &&
                        cur.getString(cur.getColumnIndex(COLUMNUSER7)).equalsIgnoreCase("nigeria"))



                    return true;
                myDatabase.close();

            }

        }return false;

    }





}










  /*  public boolean uploadToAdaRestaurant(String price, String name, String nationality, byte[] image, String image_label,String alcoholic) {//................Add to Database...................


        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentV = new ContentValues();

        contentV.put(COLUMNADA2, price);
        contentV.put(COLUMNADA3, name);
        contentV.put(COLUMNADA4, nationality);
        contentV.put(COLUMNADA5, image);
        contentV.put(COLUMNADA6, image_label);
        contentV.put(COLUMNADA7, alcoholic);



        long output = db.insert(DatabaseHelper.ADATABLE, null, contentV);

        if (output == -1) return false;
        else return true;

    }


    @SuppressLint("Range")
    public List<RestaurantLogDetails> getAprokoRestaurantDetails(){

        myRestaurantDetails=this.getWritableDatabase();

        Cursor cur2=myRestaurantDetails.rawQuery("select * from "+ADATABLE,null);

        if(cur2.moveToFirst()){
            do{
                Bitmap InBitmapBitmap= BitmapFactory.decodeByteArray(cur2.getBlob(5),0,
                        cur2.getBlob(5).length);

                items.add(new ItemData(cur2.getString(cur2.getColumnIndex(COLUMNADA2)),
                        cur2.getString(cur2.getColumnIndex(COLUMNADA3)),
                        cur2.getString(cur2.getColumnIndex(COLUMNADA4)),
                        InBitmapBitmap,
                        cur2.getString(cur2.getColumnIndex(COLUMNADA5)),
                        cur2.getString(cur2.getColumnIndex(COLUMNADA6))));
            }while (cur2.moveToNext());

        }
        cur2.close();
        myDatabase2.close();

        return  items;
    }*/
