package com.example.digitalrestaurant;

import java.io.Serializable;

public class OrderState implements Serializable {

   private static int totalPrice;
    private static int quantity=1;



    public int incrementQuantity(){
        return quantity++;

    }

    public int decrementQuantity(){
        return quantity--;
    }


    public int getQuantity() {
        return quantity;
    }


}
