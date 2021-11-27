package com.example.digitalrestaurant.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.digitalrestaurant.Details.OrderDetails;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String MY_DATABASE_NAME="GodwinCart";
    public static final String MY_TABLE_NAME="GodwinTable";
    public static final String COLUMN1="ID";
    public static final String COLUMN2="Food_Name";
    public static final String COLUMN3="Total_Quantity";
    public static final String COLUMN4="Total_Price";

    ArrayList<OrderDetails> order;

    public DatabaseHelper(Context context) {
        super(context, MY_DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + MY_TABLE_NAME + "("
                + COLUMN1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN2 + " TEXT, "
                + COLUMN3 + " INTEGER, "
                + COLUMN4 + " INTEGER)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+MY_TABLE_NAME);
            onCreate(db);
    }


    public boolean addData(String foodName,String quantity,String totalPrice){

        SQLiteDatabase myDatabase=this.getWritableDatabase();

        ContentValues contentV=new ContentValues();
        contentV.put(COLUMN2,foodName);
        contentV.put(COLUMN3,quantity);
        contentV.put(COLUMN4,totalPrice);

        long output=myDatabase.insert(MY_TABLE_NAME,null,contentV);

        if(output==-1) return false;
        else return  true;


    }

    public Cursor viewMyData(){

        SQLiteDatabase myDatabase=this.getReadableDatabase();
        Cursor cur=myDatabase.rawQuery("select * from "+MY_TABLE_NAME+" order by id desc ",null);
     /*   if (cur.moveToFirst()){

            do{
                int foodID=cur.getInt(0);
                String foodName=cur.getString(1);
                int foodQuantity=cur.getInt(2);
                int  foodTotal=cur.getInt(3);

                order.add(new OrderDetails(foodTotal,foodQuantity,foodName));


        }while(cur.moveToNext());



}*/
        cur.close();
        myDatabase.close();
        return  cur;
    }





}
