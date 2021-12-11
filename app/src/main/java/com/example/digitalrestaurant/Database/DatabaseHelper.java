package com.example.digitalrestaurant.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.digitalrestaurant.Details.ItemData;
import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.Details.UserDetails;
import com.example.digitalrestaurant.Details.VendorDetails;

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
    public static final String COLUMNUSER6="maidenName";
    public static final String COLUMNUSER7="country";
    public static final String COLUMNUSER8="Customer_Passwords";

    //Vendor details
    public static final String COLUMNVEN1="VendorID";
    public static final String COLUMNVEN2="nameOfVendor";
    public static final String COLUMNVEN3="Vendor_email";
    public static final String COLUMNVEN4="Vendor_Passwords";


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

          //Vendor tables
           db.execSQL("CREATE TABLE " + VENDOR_DETAILS + "("
                   + COLUMNVEN1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                   + COLUMNVEN2 + " TEXT, "
                   + COLUMNVEN3 + " TEXT, "
                   + COLUMNVEN4 + " TEXT)");

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



    public boolean addData(OrderDetails order){

                SQLiteDatabase myDatabase=this.getWritableDatabase();

                ContentValues contentV=new ContentValues();
                contentV.put(COLUMNNAME2,order.getFoodName());
                contentV.put(COLUMNNAME3,order.getQuantity());
                contentV.put(COLUMNNAME4,order.getTotalFoodPrice());
                contentV.put(COLUMNNAME5,order.getRestaurantName());

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



    public boolean addCustomerUserAndPAss(UserDetails user){

                SQLiteDatabase myDatabase=this.getWritableDatabase();

                ContentValues contentV=new ContentValues();
                contentV.put(COLUMNUSER2,user.getNameOfUser());
                contentV.put(COLUMNUSER3,user.getEmail());
                contentV.put(COLUMNUSER4,user.getAge());
                contentV.put(COLUMNUSER5,user.getPhone());
                contentV.put(COLUMNUSER6,user.getMaidenName());
                contentV.put(COLUMNUSER7,user.getCountry());
                contentV.put(COLUMNUSER8,user.getPassword());


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



    @SuppressLint("Range")
    public List<OrderDetails> getCartItems() {

                SQLiteDatabase myDatabase3 = this.getWritableDatabase();
                List<OrderDetails> mylist = new ArrayList<>();



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
    public void clearItemsFromCart() {

        SQLiteDatabase myDatabase = this.getReadableDatabase();
        myDatabase.execSQL("delete from "+ MY_TABLE_NAME);

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


