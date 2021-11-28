package com.example.digitalrestaurant.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.digitalrestaurant.Details.OrderDetails;
import com.example.digitalrestaurant.Details.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String MY_DATABASE_NAME="Godwin";
    public static final String MY_TABLE_NAME="GodwinTable";
    public static final String MY_USER_AND_PASS_TABLE="GodwinUserTable";
    public static final String COLUMNNAME1="ID";
    public static final String COLUMNNAME2="Food_Name";
    public static final String COLUMNNAME3="Total_Quantity";
    public static final String COLUMNNAME4="Total_Price";

    public static final String COLUMNUSER1="ID";
    public static final String COLUMNUSER2="nameOfUser";
    public static final String COLUMNUSER3="email";
    public static final String COLUMNUSER4="Passwords";
    public static final String COLUMNUSER5="age";




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



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+MY_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+MY_USER_AND_PASS_TABLE );
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

    public boolean addDataUserAndPAss(String name, String  email, String age, String password){

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

    public boolean checkUserName(String email){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        Cursor cur2=myDatabase.rawQuery("select * from "+MY_TABLE_NAME+" where email=?", new String[]{email});

        if(cur2.getCount()>0)return true;
        else return false;


    }

    public boolean checkUserNameAndPassword(String email,String password){
        SQLiteDatabase myDatabase=this.getWritableDatabase();
        Cursor cur3=myDatabase.rawQuery("select * from "+MY_TABLE_NAME+" where email=? and password=?",
                new String[]{email});

        if(cur3.getCount()>0)return true;
        else return false;


    }

    public ArrayList viewMyItemsData(){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ArrayList<OrderDetails> myItems=new ArrayList<>();
        Cursor cur=myDatabase.rawQuery("select * from "+MY_TABLE_NAME,null);
      /* if (cur.moveToFirst()){

            do{
                int foodID=cur.getInt(0);
                String foodName=cur.getString(1);
                int foodQuantity=cur.getInt(2);
                int  foodTotal=cur.getInt(3);

                order.add(new OrderDetails(foodTotal,foodQuantity,foodName));


        }*/
        while(!cur.isAfterLast()) {

            myItems.add(new OrderDetails(cur.getString(cur.getColumnIndexOrThrow(COLUMNNAME2)),
                    Integer.parseInt( cur.getString(cur.getColumnIndexOrThrow(COLUMNNAME3))),
                            Integer.parseInt(cur.getString(cur.getColumnIndexOrThrow(COLUMNNAME3)))));
            cur.moveToNext();
        }



           return  myItems;


    }

    public ArrayList viewMyLoginDetails(){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ArrayList<UserDetails> user=new ArrayList<>();
        Cursor cur=myDatabase.rawQuery("select * from "+MY_USER_AND_PASS_TABLE ,null);

        while(!cur.isAfterLast()) {

            user.add(new UserDetails(cur.getString(cur.getColumnIndexOrThrow(COLUMNUSER2)),
                    cur.getString(cur.getColumnIndexOrThrow(COLUMNUSER3)),
                    Integer.parseInt(cur.getString(cur.getColumnIndexOrThrow(COLUMNUSER4))),
                   cur.getString(cur.getColumnIndexOrThrow(COLUMNUSER5))));
            cur.moveToNext();
        }



        return  user;


    }





}
