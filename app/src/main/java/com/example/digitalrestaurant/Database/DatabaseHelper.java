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
    public static final String COLUMNUSER6="address";
    public static final String COLUMNUSER7="Customer_Passwords";


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





    ArrayList<OrderDetails> order=new ArrayList<>();
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
                   + COLUMNUSER7 + " TEXT)");

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

        if(output==-1) return false;
        else return  true;


    }



    public boolean addCustomerUserAndPAss(String name, String  email, String age, String phone,String address,String password){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNUSER2,name);
        contentV.put(COLUMNUSER3,email);
        contentV.put(COLUMNUSER4,age);
        contentV.put(COLUMNUSER5,phone);
        contentV.put(COLUMNUSER6,address);
        contentV.put(COLUMNUSER7,password);


        long output=myDatabase.insert(MY_USER_AND_PASS_TABLE,null,contentV);

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



    public boolean checkUserName(String email){
        SQLiteDatabase myDatabase20=this.getWritableDatabase();
        Cursor cur20=myDatabase20.rawQuery("select * from "+MY_TABLE_NAME+" where email=?", new String[]{email});

        if(cur20.getCount()>0)return true;
        else return false;
    }




    public boolean checkUserNameAndPassword(String email,String password){
        SQLiteDatabase myDatabase21=this.getWritableDatabase();

        Cursor cur21=myDatabase21.rawQuery("select * from "+MY_TABLE_NAME+" where email=? and password=?",
                new String[]{email,password});

        if(cur21.getCount()>0)return true;
        else return false;
    }



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

        SQLiteDatabase myDatabase=this.getReadableDatabase();

        Cursor cur=myDatabase.rawQuery("select * from "+MY_TABLE_NAME,null);

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

        }
        cur2.close();
        myDatabase2.close();*/

        return cur;
    }






    public Cursor viewCartItems(){

        SQLiteDatabase myDatabase3=this.getReadableDatabase();



        Cursor cur=myDatabase3.rawQuery("select * from "+MY_TABLE_NAME,null);


      /*    while (cur3.moveToNext()){

                  order.add(new OrderDetails(cur3.getString(cur3.getColumnIndexOrThrow(COLUMNNAME2)),
                           cur3.getInt(cur3.getColumnIndexOrThrow(COLUMNNAME3)),
                           cur3.getInt(cur3.getColumnIndexOrThrow(COLUMNNAME4))));
           }
               cur3.close();
               myDatabase3.close();*/

       return  cur;

    }




   // public Cursor getCustomerLoginDetails() {

      /*  String[] columns={COLUMNUSER1,COLUMNUSER2,COLUMNUSER3,COLUMNUSER4,COLUMNUSER5};

        String sort=COLUMNUSER1+"ASC";

        List<UserDetails> myuser=new ArrayList<>();

        SQLiteDatabase myDatabase4 = this.getReadableDatabase();

        Cursor cur = myDatabase4.rawQuery(MY_USER_AND_PASS_TABLE, null);

        if(cur4.moveToFirst()) {

            do{
                UserDetails user=new UserDetails(0,"","",0,"");
                user.setId(Integer.parseInt(cur4.getString(cur4.getColumnIndex(COLUMNUSER1))));
                user.setNameOfUser(cur4.getString(cur4.getColumnIndex(COLUMNUSER2)));
                        user.setEmail(  cur4.getString(cur4.getColumnIndex(COLUMNUSER3)));
                        user.setAge(Integer.parseInt(cur4.getString(cur4.getColumnIndex(COLUMNUSER4))));
                        user.setPassword( cur4.getString(cur4.getColumnIndex(COLUMNUSER5)));

                        customer.add(user);

        }while (cur4.moveToNext());

        }
        cur4.close();
        myDatabase4.close();
        return cur;

    }*/


   public Cursor getCustomerLoginDetails() {

        SQLiteDatabase myDatabase4 = this.getReadableDatabase();

        Cursor cur = myDatabase4.rawQuery("select * from " + MY_USER_AND_PASS_TABLE, null);


      /*  while (cur4.moveToNext()) {


            customer.add(new UserDetails(cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER2)),
                    cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER3)),
                    (cur4.getInt(cur4.getColumnIndexOrThrow(COLUMNUSER4))),
                    cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER5))));

        }*/
        return cur;


    }

    public Cursor getCustomerContactDetails(int phone,String address) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select * from " + MY_USER_AND_PASS_TABLE+
                        " where "+COLUMNUSER5+"="+phone+" and "+COLUMNUSER6+"="+address,
                null);


      /*  while (cur4.moveToNext()) {


            customer.add(new UserDetails(cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER2)),
                    cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER3)),
                    (cur4.getInt(cur4.getColumnIndexOrThrow(COLUMNUSER4))),
                    cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER5))));

        }*/
        return cur;


    }



        public Cursor getVendorLoginDetails() {

        SQLiteDatabase myDatabase5 = this.getWritableDatabase();

        Cursor cur = myDatabase5.rawQuery("select * from " + VENDOR_DETAILS, null);


      /*  while (cur5.moveToNext()) {

            vendor.add(new VendorDetails(cur5.getString(cur5.getColumnIndexOrThrow(COLUMNVEN2)),
                    cur5.getString(cur5.getColumnIndexOrThrow(COLUMNVEN3)),
                    cur5.getString(cur5.getColumnIndexOrThrow(COLUMNVEN4))));

        }
        cur5.close();
        myDatabase5.close();*/

        return cur;


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

}








