package com.example.digitalrestaurant;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.digitalrestaurant.Adaptors.CartAdaptor;
//import com.example.digitalrestaurant.Adaptors.OrderAdaptor;
import com.example.digitalrestaurant.Adaptors.OrderAdaptor;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.OrderDetails;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {

    private OrderAdaptor.myOrderListener orderListener;

    private RecyclerView.Adapter orderAdaptor;

    private OrderAdaptor oderAdaptor;

    private RecyclerView recycler;

    private DatabaseHelper myCart;

    private RecyclerView cartRecycler;

    private  List<OrderDetails> myOrder;

    private  static List<OrderDetails> myOrder2=new ArrayList<>();

    FloatingActionButton basket;

    TextView homeKey,menuKey;



    private TextView plusBtn,minusBtn,addToCartBtn,quantityText,orderFoodName,
            orderNationality,orderPrice,totalOrderPrice,restaurantNameA;
    private ConstraintLayout adaFoodImages;
    private static int quantityNumber=1;
    private static int foodPrice=0;
    private static String foodName = "";
    private static String NameOfRestaurant="";
    private static String foodNationality = "";
    private static int foodImage=0;
    private int phone=0;
    private String address;
    private String customerName;

    DatabaseHelper myCartDataUpload,myCartDataViewed;

    List<OrderDetails> orderList,orders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE},PackageManager.PERMISSION_GRANTED);


        orderPrice=findViewById(R.id.orderPrice);
        orderNationality=findViewById(R.id.orderNationality);
        orderFoodName=findViewById(R.id.orderFoodName);
        adaFoodImages=findViewById(R.id.adarestaurantcard);
        restaurantNameA=findViewById(R.id.orderRestaurant);
        quantityText=findViewById(R.id.quantityTxt);
        addToCartBtn=findViewById(R.id.addToCartbtn);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        totalOrderPrice=findViewById(R.id.totalOrderPrice);
        basket=findViewById(R.id.floatingActionButton);

        myCart=new DatabaseHelper(this);

        myOrder=new ArrayList<>();

        homeKey=findViewById(R.id.homeKey);
        menuKey=findViewById(R.id.menuKeyS);



        myCartDataUpload=new DatabaseHelper(this);
        myCartDataViewed=new DatabaseHelper(this);


        Toast.makeText(this, "Add quantity by\nclicking the + or -\nbutton", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Your total price,\nchanges as well", Toast.LENGTH_SHORT).show();


        orderList=new ArrayList<>();
        orders=new ArrayList<>();


        Bundle extras=getIntent().getExtras();

        if(extras!=null){

            //Orders from restaurants
            setFoodName(extras.getString("name"));
            setFoodPrice(extras.getInt("price"));
            setFoodNationality(extras.getString("nationality"));
            setFoodImage(extras.getInt("imageUrl"));
            setNameOfRestaurant(extras.getString("RestaurantName"));

            //Orders from
            //phone=extras.getInt("phone");
            // address=extras.getString("address");
            //customerName=extras.getString("customerName");


        }

        orderFoodName.setText(getFoodName());
        orderPrice.setText(String.valueOf(getFoodPrice()));
        orderNationality.setText(getFoodNationality());
        adaFoodImages.setBackgroundResource(getFoodImage());
        totalOrderPrice.setText(String.valueOf(getFoodPrice()));
        restaurantNameA.setText(getNameOfRestaurant());





        Toast.makeText(this, orders.toString(), Toast.LENGTH_SHORT).show();




        homeKey();
        menuKey();
        deleteCartItem();



        AddToCart();
        openMyBasket();


        // setMyAdaptor();


    }

    public static List<OrderDetails> getMyOrder2() {
        return myOrder2;
    }


    public static void setMyOrder2(List<OrderDetails> order) {

       myOrder2=order;
    }


    public static String getFoodName() {
        return foodName;
    }


    public static void setFoodName(String food) {

       foodName=food;
    }
    public static String getNameOfRestaurant() {
        return NameOfRestaurant;
    }


    public static void setNameOfRestaurant(String name) {

        NameOfRestaurant=name;
    }
    public static String getFoodNationality() {
        return foodNationality;
    }


    public static void setFoodNationality(String nationality) {

        foodNationality=nationality;
    }
    public static int getFoodPrice() {
        return foodPrice;
    }


    public static void setFoodPrice(int price) {

        foodPrice=price;
    }
    public static int getFoodImage() {
        return foodImage;
    }


    public static void setFoodImage(int image) {

        foodImage=image;
    }




    public void deleteCartItem() {
        orderListener = (v, position) -> {
            Intent intent5 =new Intent(getApplicationContext(), DeleteCartItem.class);

            intent5.putExtra("name",myOrder.get(position).getFoodName());

            intent5.putExtra("restaurantName",myOrder.get(position).getRestaurantName());

            startActivity(intent5);

        };

    }




    public void AddToCart(){//............Calculating total quantity and total price..........

        plusBtn.setOnClickListener(v -> {

            quantityNumber++;
            quantityText.setText(String.valueOf(quantityNumber));
            totalOrderPrice.setText(String.valueOf(foodPrice*quantityNumber));

        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(quantityNumber>1) {

                    quantityNumber--;
                    quantityText.setText(String.valueOf(quantityNumber));
                    totalOrderPrice.setText(String.valueOf(foodPrice*quantityNumber));


                }

            }});

        addToCartBtn.setOnClickListener(v -> {

            boolean addToCart =
                    myCartDataUpload.addData(foodName, String.valueOf(quantityNumber),
                            String.valueOf(foodPrice * quantityNumber), NameOfRestaurant);

            if (addToCart == true) {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, Order.class);


                startActivity(intent);
            }




            else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();


        });




    }

    public void openMyBasket(){

        cartRecycler=findViewById(R.id.myRecycler);
        cartRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        myOrder=myCart.getCartItems();


        ItemTouchHelper.SimpleCallback itemtouch=new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                myOrder.remove(viewHolder.getAdapterPosition());

                myOrder2=myOrder;

                orderAdaptor.notifyDataSetChanged();
            }
        };




        orderAdaptor=new OrderAdaptor(myOrder,orderListener);
        new ItemTouchHelper(itemtouch).attachToRecyclerView(cartRecycler);
        cartRecycler.setAdapter(orderAdaptor);





    }


    public void homeKey(){
        homeKey.setOnClickListener(v -> {
            Intent intent=new Intent(this, HomePage.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out);

        });

    }

    public void menuKey(){
        menuKey.setOnClickListener(v -> {
            Intent intent2=new Intent(this, Menu.class);
            startActivity(intent2);
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);


        });

    }

}







