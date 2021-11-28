// Generated by view binder compiler. Do not edit!
package com.example.digitalrestaurant.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.digitalrestaurant.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class OrderBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ConstraintLayout adarestaurantcard;

  @NonNull
  public final TextView addToCartbtn;

  @NonNull
  public final ConstraintLayout constraintLayout2;

  @NonNull
  public final FloatingActionButton floatingActionButton;

  @NonNull
  public final TextView minusBtn;

  @NonNull
  public final TextView orderFoodName;

  @NonNull
  public final TextView orderNationality;

  @NonNull
  public final TextView orderPrice;

  @NonNull
  public final ConstraintLayout orderingContainer;

  @NonNull
  public final TextView plusBtn;

  @NonNull
  public final TextView poundSign;

  @NonNull
  public final TextView poundSign2;

  @NonNull
  public final TextView priceOfItem;

  @NonNull
  public final TextView quantityTxt;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView totalOrderPrice;

  @NonNull
  public final TextView totalPrice;

  private OrderBinding(@NonNull LinearLayout rootView, @NonNull ConstraintLayout adarestaurantcard,
      @NonNull TextView addToCartbtn, @NonNull ConstraintLayout constraintLayout2,
      @NonNull FloatingActionButton floatingActionButton, @NonNull TextView minusBtn,
      @NonNull TextView orderFoodName, @NonNull TextView orderNationality,
      @NonNull TextView orderPrice, @NonNull ConstraintLayout orderingContainer,
      @NonNull TextView plusBtn, @NonNull TextView poundSign, @NonNull TextView poundSign2,
      @NonNull TextView priceOfItem, @NonNull TextView quantityTxt, @NonNull TextView textView2,
      @NonNull TextView totalOrderPrice, @NonNull TextView totalPrice) {
    this.rootView = rootView;
    this.adarestaurantcard = adarestaurantcard;
    this.addToCartbtn = addToCartbtn;
    this.constraintLayout2 = constraintLayout2;
    this.floatingActionButton = floatingActionButton;
    this.minusBtn = minusBtn;
    this.orderFoodName = orderFoodName;
    this.orderNationality = orderNationality;
    this.orderPrice = orderPrice;
    this.orderingContainer = orderingContainer;
    this.plusBtn = plusBtn;
    this.poundSign = poundSign;
    this.poundSign2 = poundSign2;
    this.priceOfItem = priceOfItem;
    this.quantityTxt = quantityTxt;
    this.textView2 = textView2;
    this.totalOrderPrice = totalOrderPrice;
    this.totalPrice = totalPrice;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static OrderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static OrderBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.order, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static OrderBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adarestaurantcard;
      ConstraintLayout adarestaurantcard = ViewBindings.findChildViewById(rootView, id);
      if (adarestaurantcard == null) {
        break missingId;
      }

      id = R.id.addToCartbtn;
      TextView addToCartbtn = ViewBindings.findChildViewById(rootView, id);
      if (addToCartbtn == null) {
        break missingId;
      }

      id = R.id.constraintLayout2;
      ConstraintLayout constraintLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout2 == null) {
        break missingId;
      }

      id = R.id.floatingActionButton;
      FloatingActionButton floatingActionButton = ViewBindings.findChildViewById(rootView, id);
      if (floatingActionButton == null) {
        break missingId;
      }

      id = R.id.minusBtn;
      TextView minusBtn = ViewBindings.findChildViewById(rootView, id);
      if (minusBtn == null) {
        break missingId;
      }

      id = R.id.orderFoodName;
      TextView orderFoodName = ViewBindings.findChildViewById(rootView, id);
      if (orderFoodName == null) {
        break missingId;
      }

      id = R.id.orderNationality;
      TextView orderNationality = ViewBindings.findChildViewById(rootView, id);
      if (orderNationality == null) {
        break missingId;
      }

      id = R.id.orderPrice;
      TextView orderPrice = ViewBindings.findChildViewById(rootView, id);
      if (orderPrice == null) {
        break missingId;
      }

      id = R.id.ordering_container;
      ConstraintLayout orderingContainer = ViewBindings.findChildViewById(rootView, id);
      if (orderingContainer == null) {
        break missingId;
      }

      id = R.id.plusBtn;
      TextView plusBtn = ViewBindings.findChildViewById(rootView, id);
      if (plusBtn == null) {
        break missingId;
      }

      id = R.id.poundSign;
      TextView poundSign = ViewBindings.findChildViewById(rootView, id);
      if (poundSign == null) {
        break missingId;
      }

      id = R.id.poundSign2;
      TextView poundSign2 = ViewBindings.findChildViewById(rootView, id);
      if (poundSign2 == null) {
        break missingId;
      }

      id = R.id.priceOfItem;
      TextView priceOfItem = ViewBindings.findChildViewById(rootView, id);
      if (priceOfItem == null) {
        break missingId;
      }

      id = R.id.quantityTxt;
      TextView quantityTxt = ViewBindings.findChildViewById(rootView, id);
      if (quantityTxt == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.totalOrderPrice;
      TextView totalOrderPrice = ViewBindings.findChildViewById(rootView, id);
      if (totalOrderPrice == null) {
        break missingId;
      }

      id = R.id.totalPrice;
      TextView totalPrice = ViewBindings.findChildViewById(rootView, id);
      if (totalPrice == null) {
        break missingId;
      }

      return new OrderBinding((LinearLayout) rootView, adarestaurantcard, addToCartbtn,
          constraintLayout2, floatingActionButton, minusBtn, orderFoodName, orderNationality,
          orderPrice, orderingContainer, plusBtn, poundSign, poundSign2, priceOfItem, quantityTxt,
          textView2, totalOrderPrice, totalPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
