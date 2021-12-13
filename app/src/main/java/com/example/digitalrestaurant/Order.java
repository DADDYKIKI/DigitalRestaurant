package com.example.digitalrestaurant;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
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
import com.example.digitalrestaurant.Authentications.LoginPage;
import com.example.digitalrestaurant.Database.DatabaseHelper;
import com.example.digitalrestaurant.Details.VendorOrderDetails;
import com.example.digitalrestaurant.Details.OrderDetails;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {


    private RecyclerView.Adapter orderAdaptor;

    private DatabaseHelper myCart;

    private RecyclerView cartRecycler;

    private  List<OrderDetails> myOrder;

    private  static List<OrderDetails> myOrder2=new ArrayList<>();

    FloatingActionButton basket;

    TextView homeKey,menuKey;

    Button clear,order;


    @SuppressLint("StaticFieldLeak")
    private  static TextView totalOrderPrice,orderPrice;

    private  TextView plusBtn,minusBtn,addToCartBtn,quantityText,orderFoodName,
            orderNationality,restaurantNameA;
    private ConstraintLayout adaFoodImages;
    private  int quantityNumber=1;
    private static int foodPrice=0;
    private static String foodName = "";
    private static String NameOfRestaurant="";
    private static String foodNationality = "";
    private static int foodImage=0;
    private int phone=0;


    DatabaseHelper myCartDataUpload,myCartUpdated,myCartGet;

    List<OrderDetails> orderList,orders,myCartx;


    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, HomePage.class);

        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart);


        orderPrice=findViewById(R.id.orderPrice);
        adaFoodImages=findViewById(R.id.adarestaurantcard);
        quantityText=findViewById(R.id.quantityTxt);
        addToCartBtn=findViewById(R.id.addToCartbtn);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        totalOrderPrice=findViewById(R.id.totalOrderPrice);
        basket=findViewById(R.id.floatingActionButton);
       clear=findViewById(R.id.clear);
       order=findViewById(R.id.order);

        myCart=new DatabaseHelper(this);

        myOrder=new ArrayList<>();
        myCartx=new ArrayList<>();

        homeKey=findViewById(R.id.homeKey);
        menuKey=findViewById(R.id.menuKeyS);



        myCartDataUpload=new DatabaseHelper(this);
        myCartUpdated=new DatabaseHelper(this);
        myCartGet=new DatabaseHelper(this);



        orderList=new ArrayList<>();
        orders=new ArrayList<>();


        Bundle extras=getIntent().getExtras();

        if(extras!=null){

            //Bundle elements from all restaurants
            setFoodName(extras.getString("name"));
            setFoodPrice(extras.getInt("price"));
            setFoodNationality(extras.getString("nationality"));
            setFoodImage(extras.getInt("imageUrl"));
            setNameOfRestaurant(extras.getString("restaurant"));

        }
            orderFoodName.setText(getFoodName());
            orderPrice.setText(String.valueOf(getFoodPrice()));
            orderNationality.setText(getFoodNationality());
            adaFoodImages.setBackgroundResource(getFoodImage());
            totalOrderPrice.setText(String.valueOf(getFoodPrice()));
            restaurantNameA.setText(getNameOfRestaurant());


            homeKey();
            menuKey();
            clearCart();
            AddToCart();
            openMyBasket();
            placeOrder();
    }




    //Static elements for holding memory of order elements when the order page is returned to infrom of last attempts
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






    public void clearCart() {//............Clear items from basket

        clear.setOnClickListener(v -> {

          myCartUpdated.clearItemsFromCart();

            Intent intent5 =new Intent(getApplicationContext(), Order.class);
            startActivity(intent5);


    });

    }

    public void placeOrder() {//............used for placing orders to different restaurants

        order.setOnClickListener(v -> {

            myCartx=myCartGet.getCartItems();


            //Used to recognise a restaurant using email address as the signature
            for(OrderDetails x:myCartx) {


                if (x.getRestaurantName().equals("adakitchen")) {

                    VendorOrderDetails ada = new VendorOrderDetails(x.getFoodName(), LoginPage.getCusName(),x.getTotalFoodPrice(),x.getQuantity(),

                            String.valueOf(LoginPage.getCUSTOMERPHONE()));

                    Boolean addAda=myCartGet.addAdaData(ada);

                    if (addAda == true) {

                        Toast.makeText(this, "Orders sent to Ada Kitchen", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(this, Order.class);

                        startActivity(intent);
                    }

                    else Toast.makeText(this, "Orders not sent to Ada Kitchen", Toast.LENGTH_SHORT).show();

                }





                if (x.getRestaurantName().equals("approkokitchen")) {

                    VendorOrderDetails approko = new VendorOrderDetails(x.getFoodName(), LoginPage.getCusName(),x.getTotalFoodPrice(),x.getQuantity(),

                    String.valueOf(LoginPage.getCUSTOMERPHONE()));

                    Boolean addApro=myCartGet.addApprokoData(approko);

                    if (addApro == true) {

                        Toast.makeText(this, "Orders sent to Approko Restaurant", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(this, Order.class);

                        startActivity(intent);
                    }

                    else Toast.makeText(this, "Orders not sent to Approko Restaurant", Toast.LENGTH_SHORT).show();
                }




                if (x.getRestaurantName().equals("obandekitchen")) {

                    VendorOrderDetails obans = new VendorOrderDetails(x.getFoodName(), LoginPage.getCusName(),x.getTotalFoodPrice(),x.getQuantity(),

                            String.valueOf(LoginPage.getCUSTOMERPHONE()));

                    Boolean addOba=myCartGet.addObandeData(obans);

                    if (addOba == true) {

                        Toast.makeText(this, "Orders sent to Obande Kitchen", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(this, Order.class);

                        startActivity(intent);
                    }

                    else Toast.makeText(this, "Orders not sent to Obande Restaurant", Toast.LENGTH_SHORT).show();
                }



                if (x.getRestaurantName().equals("stainless")) {

                    VendorOrderDetails stainless = new VendorOrderDetails(x.getFoodName(), LoginPage.getCusName(),x.getTotalFoodPrice(),x.getQuantity(),

                    String.valueOf(LoginPage.getCUSTOMERPHONE()));

                    Boolean addStainless=myCartGet.addStainlessData(stainless);

                    if (addStainless == true) {

                        Toast.makeText(this, "Orders sent to Stainless Bar", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(this, Order.class);

                        startActivity(intent);
                    }

                    else Toast.makeText(this, "Orders not sent to Stainless", Toast.LENGTH_SHORT).show();

                }


            }


        });

    }




    public void AddToCart(){//............Change quantity, total price and add items tp my basket.........

        plusBtn.setOnClickListener(v -> {//  Increases  the quantity of items

            quantityNumber++;
            quantityText.setText(String.valueOf(quantityNumber));
            totalOrderPrice.setText(String.valueOf(getFoodPrice()*quantityNumber));

        });

        minusBtn.setOnClickListener(v -> {//decreases the quantity of items


            if(quantityNumber>1) {

                quantityNumber--;
                quantityText.setText(String.valueOf(quantityNumber));
                totalOrderPrice.setText(String.valueOf(getFoodPrice()*quantityNumber));


            }

        });

        addToCartBtn.setOnClickListener(v -> {

           String res=getNameOfRestaurant().replaceAll("\\s+","").toLowerCase();

            OrderDetails orders=new OrderDetails(getFoodName(), String.valueOf(quantityNumber),

            String.valueOf(getFoodPrice() * quantityNumber), res);

            boolean addToCart =

                    myCartDataUpload.addData(orders);

            if (addToCart == true) {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, Order.class);

                startActivity(intent);
            }

            else Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();

        });

    }


           //      Used for viewing all the order made and display it in the basket
    public void openMyBasket(){

        myOrder=myCart.getCartItems();

        cartRecycler=findViewById(R.id.myRecycler);

        cartRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        // Delete Items when swiped in the recyclerview

        ItemTouchHelper.SimpleCallback itemtouch=new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                myOrder.remove(viewHolder.getAdapterPosition());

                orderAdaptor.notifyDataSetChanged();


                setMyOrder2(myOrder);

                myCartUpdated.clearItemsFromCart();

                for (OrderDetails x : getMyOrder2()) {

                    OrderDetails oders2 = new OrderDetails(x.getFoodName(), x.getQuantity(), x.getTotalFoodPrice()
                            , x.getRestaurantName());


                    myCartUpdated.addData(oders2);


                }
            }


        };

        orderAdaptor=new OrderAdaptor(myOrder);

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







