package com.example.digitalrestaurant.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.digitalrestaurant.Details.VendorOrderDetails;
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
    public static final String ADA_TABLE="AdaStuff";
    public static final String APPROKO_TABLE="ApprokoStuff";
    public static final String OBANDE_TABLE="ObandeStuff";
    public static final String STAINLESS="StainlessStuff";


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

    //Ada tabel
    public static final String COLUMNADA1="CartID";
    public static final String COLUMNADA2="Cart_ood_Name";
    public static final String COLUMNADA3="CustomerName";
    public static final String COLUMNADA4="Total_Price";
    public static final String COLUMNADA5="Total_Quantity";
    public static final String COLUMNADA6="CustomerPhone";


    //Approko Table
    public static final String COLUMNAPRO1="CartID";
    public static final String COLUMNAPRO2="Cart_ood_Name";
    public static final String COLUMNAPRO3="CustomertName";
    public static final String COLUMNAPRO4="Total_Price";
    public static final String COLUMNAPRO5="Total_Quantity";
    public static final String COLUMNAPRO6="CustomertPhone";


    //Obande Table
    public static final String COLUMNOABA1="CartID";
    public static final String COLUMNOABA2="Cart_ood_Name";
    public static final String COLUMNOABA3="CustomerName";
    public static final String COLUMNOABA4="Total_Price";
    public static final String COLUMNOABA5="Total_Quantity";
    public static final String COLUMNOABA6="CustomerPhone";


    //Stainless Table
    public static final String COLUMNST1="CartID";
    public static final String COLUMNST2="Cart_ood_Name";
    public static final String COLUMNST3="CustomerName";
    public static final String COLUMNST4="Total_Price";
    public static final String COLUMNST5="Total_Quantity";
    public static final String COLUMNST6="CustomerPhone";




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

        db.execSQL("CREATE TABLE " + ADA_TABLE + "("
                + COLUMNADA1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNADA2 + " TEXT, "
                + COLUMNADA3 + " TEXT, "
                + COLUMNADA4 + " INTEGER, "
                + COLUMNADA5 + " INTEGER, "
                + COLUMNADA6 + " INTEGER)");

        db.execSQL("CREATE TABLE " + APPROKO_TABLE+ "("
                + COLUMNAPRO1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNAPRO2 + " TEXT, "
                + COLUMNAPRO3 + " TEXT, "
                + COLUMNAPRO4 + " INTEGER, "
                + COLUMNAPRO5 + " INTEGER, "
                + COLUMNAPRO6 + " INTEGER)");

        db.execSQL("CREATE TABLE " + OBANDE_TABLE + "("
                + COLUMNOABA1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNOABA2 + " TEXT, "
                + COLUMNOABA3 + " TEXT, "
                + COLUMNOABA4 + " INTEGER, "
                + COLUMNOABA5 + " INTEGER, "
                + COLUMNOABA6 + " INTEGER)");

        db.execSQL("CREATE TABLE " + STAINLESS + "("
                + COLUMNST1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNST2 + " TEXT, "
                + COLUMNST3 + " TEXT, "
                + COLUMNST4 + " INTEGER, "
                + COLUMNST5 + " INTEGER, "
                + COLUMNST6 + " INTEGER)");

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
                db.execSQL("DROP TABLE IF EXISTS "+ADA_TABLE);
                db.execSQL("DROP TABLE IF EXISTS "+APPROKO_TABLE);
                db.execSQL("DROP TABLE IF EXISTS "+OBANDE_TABLE);
                db.execSQL("DROP TABLE IF EXISTS "+STAINLESS);

                onCreate(db);
    }



    public boolean addData(OrderDetails order){// Add data to Order table

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

    public boolean addAdaData(VendorOrderDetails order){//Add data to Ada table

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNADA2,order.getFoodName());
        contentV.put(COLUMNADA3,order.getCusName());
        contentV.put(COLUMNADA4,order.getTotalFoodPrice());
        contentV.put(COLUMNADA5,order.getQuantity());
        contentV.put(COLUMNADA6,order.getPhone());

        long output=myDatabase.insert(ADA_TABLE,null,contentV);
        myDatabase.close();

        if(output==-1) return false;
        else return  true;
    }

    public boolean addApprokoData(VendorOrderDetails order){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNAPRO2,order.getFoodName());
        contentV.put(COLUMNAPRO3,order.getCusName());
        contentV.put(COLUMNAPRO4,order.getTotalFoodPrice());
        contentV.put(COLUMNAPRO5,order.getQuantity());
        contentV.put(COLUMNAPRO6,order.getPhone());

        long output=myDatabase.insert(APPROKO_TABLE,null,contentV);
        myDatabase.close();

        if(output==-1) return false;
        else return  true;
    }

    public boolean addObandeData(VendorOrderDetails order){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNOABA2,order.getFoodName());
        contentV.put(COLUMNOABA3,order.getCusName());
        contentV.put(COLUMNOABA4,order.getTotalFoodPrice());
        contentV.put(COLUMNOABA5,order.getQuantity());
        contentV.put(COLUMNOABA6,order.getPhone());

        long output=myDatabase.insert(OBANDE_TABLE,null,contentV);
        myDatabase.close();

        if(output==-1) return false;
        else return  true;
    }


    public boolean addStainlessData(VendorOrderDetails order){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNST2,order.getFoodName());
        contentV.put(COLUMNST3,order.getCusName());
        contentV.put(COLUMNST4,order.getTotalFoodPrice());
        contentV.put(COLUMNST5,order.getQuantity());
        contentV.put(COLUMNST6,order.getPhone());

        long output=myDatabase.insert(STAINLESS,null,contentV);
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



    public boolean addCustomerUserAndPAss(UserDetails user){//For registering a new user

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
    public List<OrderDetails> getCartItems() {//For getting order items from database and dipley the in customers basket

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
    public List<VendorOrderDetails> getAdaCartItems() {

        SQLiteDatabase myDatabase3 = this.getWritableDatabase();
        List<VendorOrderDetails> mylist = new ArrayList<>();



        Cursor cur = myDatabase3.rawQuery("select * from " + ADA_TABLE, null);

        if (cur.getCount()>0) {
            if (cur.moveToFirst())

                do {

                    String name = cur.getString(cur.getColumnIndex(COLUMNADA2));
                    String cusName = cur.getString(cur.getColumnIndex(COLUMNADA3));
                    String totalPrice = cur.getString(cur.getColumnIndex(COLUMNADA4));
                    String quantity = cur.getString(cur.getColumnIndex(COLUMNADA5));
                    String phone = cur.getString(cur.getColumnIndex(COLUMNADA6));


                    VendorOrderDetails myoder = new VendorOrderDetails(name, cusName,totalPrice,quantity,phone);

                    mylist.add(myoder);


                } while (cur.moveToNext());

            cur.close();
            myDatabase3.close();




        }return mylist;
    }

    @SuppressLint("Range")
    public List<VendorOrderDetails> getApprokoCartItems() {

        SQLiteDatabase myDatabase3 = this.getWritableDatabase();
        List<VendorOrderDetails> mylist = new ArrayList<>();



        Cursor cur = myDatabase3.rawQuery("select * from " + APPROKO_TABLE, null);

        if (cur.getCount()>0) {
            if (cur.moveToFirst())

                do {

                    String name = cur.getString(cur.getColumnIndex(COLUMNAPRO2));
                    String cusName = cur.getString(cur.getColumnIndex(COLUMNAPRO3));
                    String totalPrice = cur.getString(cur.getColumnIndex(COLUMNAPRO4));
                    String quantity = cur.getString(cur.getColumnIndex(COLUMNAPRO5));
                    String phone = cur.getString(cur.getColumnIndex(COLUMNAPRO6));


                    VendorOrderDetails myoder = new VendorOrderDetails(name, cusName,totalPrice,quantity, phone);

                    mylist.add(myoder);


                } while (cur.moveToNext());

            cur.close();
            myDatabase3.close();




        }return mylist;
    }

    @SuppressLint("Range")
    public List<VendorOrderDetails> getObandeCartItems() {

        SQLiteDatabase myDatabase3 = this.getWritableDatabase();
        List<VendorOrderDetails> mylist = new ArrayList<>();



        Cursor cur = myDatabase3.rawQuery("select * from " + OBANDE_TABLE, null);

        if (cur.getCount()>0) {
            if (cur.moveToFirst())

                do {

                    String name = cur.getString(cur.getColumnIndex(COLUMNOABA2));
                    String cusName = cur.getString(cur.getColumnIndex(COLUMNOABA3));
                    String totalPrice = cur.getString(cur.getColumnIndex(COLUMNOABA4));
                    String quantity = cur.getString(cur.getColumnIndex(COLUMNOABA5));
                    String phone = cur.getString(cur.getColumnIndex(COLUMNOABA6));


                    VendorOrderDetails myoder = new VendorOrderDetails(name, quantity, totalPrice, cusName,phone);

                    mylist.add(myoder);


                } while (cur.moveToNext());

            cur.close();
            myDatabase3.close();




        }return mylist;
    }


    @SuppressLint("Range")
    public List<VendorOrderDetails> getStainlessCartItems() {

        SQLiteDatabase myDatabase3 = this.getWritableDatabase();
        List<VendorOrderDetails> mylist = new ArrayList<>();



        Cursor cur = myDatabase3.rawQuery("select * from " + STAINLESS, null);

        if (cur.getCount()>0) {
            if (cur.moveToFirst())

                do {

                    String name = cur.getString(cur.getColumnIndex(COLUMNST2));
                    String cusName = cur.getString(cur.getColumnIndex(COLUMNST3));
                    String totalPrice = cur.getString(cur.getColumnIndex(COLUMNST4));
                    String quantity = cur.getString(cur.getColumnIndex(COLUMNST5));
                    String phone = cur.getString(cur.getColumnIndex(COLUMNST6));


                    VendorOrderDetails myoder = new VendorOrderDetails(name , cusName,totalPrice,quantity,phone);

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
    public void clearItemsFromStainless() {

        SQLiteDatabase myDatabase = this.getReadableDatabase();
        myDatabase.execSQL("delete from "+ STAINLESS);

    }

    @SuppressLint("Range")
    public void clearItemsFromObande() {

        SQLiteDatabase myDatabase = this.getReadableDatabase();
        myDatabase.execSQL("delete from "+ OBANDE_TABLE);

    }


    @SuppressLint("Range")
    public void clearItemsFromCart() {

        SQLiteDatabase myDatabase = this.getReadableDatabase();
        myDatabase.execSQL("delete from "+ MY_TABLE_NAME);

    }

    @SuppressLint("Range")
    public void clearItemsFromAdaTabel() {

        SQLiteDatabase myDatabase = this.getReadableDatabase();
        myDatabase.execSQL("delete from "+ ADA_TABLE);

    }

    @SuppressLint("Range")
    public void clearItemsFromAPProkoTabel() {

        SQLiteDatabase myDatabase = this.getReadableDatabase();
        myDatabase.execSQL("delete from "+ APPROKO_TABLE);

    }





    @SuppressLint("Range")
        public boolean getVendorLoginDetails(String email, String Password) {

                    SQLiteDatabase myDatabase = this.getReadableDatabase();

                    Cursor cur = myDatabase.rawQuery("select * from " + VENDOR_DETAILS,

                            null);

                    if(cur.getCount()>0) {
                        while (cur.moveToNext()) {

                            if (cur.getString(cur.getColumnIndex(COLUMNVEN3)).equals(email) &&
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
    public boolean checkforVendorsUniqueEmailAddress(String email) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select " +COLUMNVEN3+" from " + VENDOR_DETAILS,

                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if(cur.getString(cur.getColumnIndex(COLUMNVEN3)).equals(email))

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
    public int getCustomerPhone(String email) {

        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select * from " +MY_USER_AND_PASS_TABLE,

                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if (cur.getString(cur.getColumnIndex(COLUMNUSER3)).equals(email))

                    return Integer.parseInt(cur.getString(cur.getColumnIndex(COLUMNUSER5)));

                myDatabase.close();

            }

        }return 0;

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


    @SuppressLint("Range")
    public String checkRestaurant(String email) {


        SQLiteDatabase myDatabase = this.getReadableDatabase();

        Cursor cur = myDatabase.rawQuery("select * from " +VENDOR_DETAILS,

                null);

        if(cur.getCount()>0) {
            while (cur.moveToNext()) {

                if(cur.getString(cur.getColumnIndex(COLUMNVEN3)).equals(email) &&
                        cur.getString(cur.getColumnIndex(COLUMNVEN2)).equalsIgnoreCase("adakitchen"))
                    return "adakitchen";
                 if(cur.getString(cur.getColumnIndex(COLUMNVEN3)).equals(email) &&
                        cur.getString(cur.getColumnIndex(COLUMNVEN2)).equalsIgnoreCase("obandekitchen"))
                    return "obandekitchen";
                 if(cur.getString(cur.getColumnIndex(COLUMNVEN3)).equals(email) &&
                        cur.getString(cur.getColumnIndex(COLUMNVEN2)).equalsIgnoreCase("approkokitchen"))
                    return "approkokitchen";
                 if(cur.getString(cur.getColumnIndex(COLUMNVEN3)).equals(email) &&
                        cur.getString(cur.getColumnIndex(COLUMNVEN2)).equalsIgnoreCase("stainless"))
                    return "stainless";




                myDatabase.close();

            }

        }return null;

    }





}


