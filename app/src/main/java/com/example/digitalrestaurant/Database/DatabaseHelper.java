package com.example.digitalrestaurant.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.digitalrestaurant.Details.ItemData;
import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.Details.UserDetails;
import com.example.digitalrestaurant.VendorDetails;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String MY_DATABASE_NAME="GodwinDatabase";
    public static final String MY_TABLE_NAME="GodwinItemsTable";
    public static final String MY_USER_AND_PASS_TABLE="GodwinUserInfoTable";
    public static final String FOODS_FOR_SALE="GodwinPopulateFoodIntoRestaurant";
    public static final String VENDOR_DETAILS="VendorStuff";
    public static final String COLUMNNAME1="ID";
    public static final String COLUMNNAME2="Food_Name";
    public static final String COLUMNNAME3="Total_Quantity";
    public static final String COLUMNNAME4="Total_Price";

    public static final String COLUMNUSER1="ID";
    public static final String COLUMNUSER2="nameOfUser";
    public static final String COLUMNUSER3="email";
    public static final String COLUMNUSER4="age";
    public static final String COLUMNUSER5="Passwords";

    public static final String COLUMNFOOD1="ID";
    public static final String COLUMNFOOD2="food_price";
    public static final String COLUMNFOOD3="food_name";
    public static final String COLUMNFOOD4="food_nationality";
    public static final String COLUMNFOOD5="";
    public static final String COLUMNFOOD6="alcoholic";

    public static final String COLUMNVEN1="ID";
    public static final String COLUMNVEN2="nameOfVendor";
    public static final String COLUMNVEN3="email";
    public static final String COLUMNVEN4="Passwords";





    ArrayList<OrderDetails> order;

    public DatabaseHelper(Context context) {
        super(context, MY_DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + MY_TABLE_NAME + "("
                + COLUMNNAME1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNNAME2 + " TEXT, "
                + COLUMNNAME3 + " INTEGER, "
                + COLUMNNAME4 + " INTEGER)");

        db.execSQL("CREATE TABLE " + MY_USER_AND_PASS_TABLE + "("
                + COLUMNUSER1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNUSER2 + " TEXT, "
                + COLUMNUSER3 + " TEXT, "
                + COLUMNUSER4 + " INTEGER, "
                + COLUMNUSER5 + " TEXT)");

        db.execSQL("CREATE TABLE " + FOODS_FOR_SALE + "("
                + COLUMNFOOD1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMNFOOD2 + " INTEGER, "
                + COLUMNFOOD3 + " TEXT, "
                + COLUMNFOOD4 + " TEXT, "
                + COLUMNFOOD5 + " INTEGER, "
                + COLUMNFOOD6 + " TEXT)");

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
            onCreate(db);
    }


    public boolean addData(String  foodName, String quantity, String totalPrice){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNNAME2,foodName);
        contentV.put(COLUMNNAME3,quantity);
        contentV.put(COLUMNNAME4,totalPrice);

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

    public boolean addCustomerUserAndPAss(String name, String  email, String age, String password){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNUSER2,name);
        contentV.put(COLUMNUSER3,email);
        contentV.put(COLUMNUSER4,age);
        contentV.put(COLUMNUSER5,password);


        long output=myDatabase.insert(MY_USER_AND_PASS_TABLE,null,contentV);

        if(output==-1) return false;
        else return  true;


    }

    public boolean populateFoodData(String foodPrice, String  foodName, String nationality, String image,String alcoholic){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMNFOOD2,foodPrice);
        contentV.put(COLUMNFOOD3,foodName);
        contentV.put(COLUMNFOOD4,nationality);
        contentV.put(COLUMNFOOD5,image);
        contentV.put(COLUMNFOOD6,alcoholic);


        long output=myDatabase.insert(FOODS_FOR_SALE,null,contentV);

        if(output==-1) return false;
        else return  true;


    }

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

    public ArrayList<ItemData> getNoneAlcoholicFood(){

        SQLiteDatabase myDatabase1=this.getReadableDatabase();

        ArrayList<ItemData> myAlcoholicFoodItems=new ArrayList<>();

        Cursor cur1=myDatabase1.rawQuery("select * from "+MY_TABLE_NAME+" where "+COLUMNFOOD6+" is null",null);

        if(cur1.moveToFirst()){
        do {

            myAlcoholicFoodItems.add(new ItemData(cur1.getInt(cur1.getColumnIndexOrThrow(COLUMNFOOD2)),
                    cur1.getString(cur1.getColumnIndexOrThrow(COLUMNFOOD3)),
                    cur1.getString(cur1.getColumnIndexOrThrow(COLUMNFOOD4)),
                    cur1.getInt(cur1.getColumnIndexOrThrow(COLUMNFOOD5)),
                    cur1.getString(cur1.getColumnIndexOrThrow(COLUMNFOOD6))));
        }while(cur1.moveToNext());

        cur1.close();
        myDatabase1.close();


    }   return  myAlcoholicFoodItems;


    }


    public ArrayList<ItemData> getAllFood(){

        SQLiteDatabase myDatabase2=this.getReadableDatabase();

        ArrayList<ItemData> myfoodItems=new ArrayList<>();

        Cursor cur2=myDatabase2.rawQuery("select * from "+MY_TABLE_NAME,null);

        if(cur2.moveToFirst()){
        do {

            myfoodItems.add(new ItemData(cur2.getInt(cur2.getColumnIndexOrThrow(COLUMNFOOD2)),
                    cur2.getString(cur2.getColumnIndexOrThrow(COLUMNFOOD3)),
                    cur2.getString(cur2.getColumnIndexOrThrow(COLUMNFOOD4)),
                    cur2.getInt(cur2.getColumnIndexOrThrow(COLUMNFOOD5)),
                    cur2.getString(cur2.getColumnIndexOrThrow(COLUMNFOOD6))));
        }while(cur2.moveToNext());

        cur2.close();
        myDatabase2.close();

    }   return  myfoodItems;


    }


    public ArrayList<OrderDetails> viewCartItems(){

        SQLiteDatabase myDatabase3=this.getReadableDatabase();

        ArrayList<OrderDetails> myCartItems=new ArrayList<>();

        Cursor cur3=myDatabase3.rawQuery("select * from "+MY_TABLE_NAME,null);

        if(cur3.moveToFirst()){
        do {

            myCartItems.add(new OrderDetails(cur3.getString(cur3.getColumnIndexOrThrow(COLUMNNAME2)),
                     cur3.getInt(cur3.getColumnIndexOrThrow(COLUMNNAME3)),
                            cur3.getInt(cur3.getColumnIndexOrThrow(COLUMNNAME4))));
        }while(cur3.moveToNext());

        cur3.close();
        myDatabase3.close();




    }return  myCartItems;

    }

    public ArrayList<UserDetails> getCustomerLoginDetails(){

        SQLiteDatabase  myDatabase4=this.getReadableDatabase();

        ArrayList<UserDetails> user=new ArrayList<>();

        Cursor cur4=myDatabase4.rawQuery("select * from "+MY_USER_AND_PASS_TABLE ,null);


        if(cur4.moveToFirst()){
        do {

            user.add(new UserDetails(cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER2)),
                    cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER3)),
                    Integer.parseInt(cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER4))),
                   cur4.getString(cur4.getColumnIndexOrThrow(COLUMNUSER5))));

        }while(cur4.moveToNext());

        cur4.close();
        myDatabase4.close();




    } return  user;
        }



    public ArrayList<VendorDetails> getVendorLoginDetails(){

        SQLiteDatabase myDatabase5=this.getWritableDatabase();

        ArrayList<VendorDetails> user=new ArrayList<>();
        Cursor cur5=myDatabase5.rawQuery("select * from "+VENDOR_DETAILS ,null);


        if(cur5.moveToFirst()){
        do {

            user.add(new VendorDetails(cur5.getString(cur5.getColumnIndexOrThrow(COLUMNUSER2)),
                    cur5.getString(cur5.getColumnIndexOrThrow(COLUMNUSER3)),
                    cur5.getString(cur5.getColumnIndexOrThrow(COLUMNUSER5))));

        }while(cur5.moveToNext());

        cur5.close();
        myDatabase5.close();




    }return  user;
    }}






