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
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CartContainerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ConstraintLayout cartConstraint;

  @NonNull
  public final TextView itemName;

  @NonNull
  public final TextView itemPrice;

  @NonNull
  public final TextView itemQuantity;

  @NonNull
  public final TextView textView9;

  private CartContainerBinding(@NonNull LinearLayout rootView,
      @NonNull ConstraintLayout cartConstraint, @NonNull TextView itemName,
      @NonNull TextView itemPrice, @NonNull TextView itemQuantity, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.cartConstraint = cartConstraint;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemQuantity = itemQuantity;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CartContainerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CartContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.cart_container, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CartContainerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cartConstraint;
      ConstraintLayout cartConstraint = ViewBindings.findChildViewById(rootView, id);
      if (cartConstraint == null) {
        break missingId;
      }

      id = R.id.itemName;
      TextView itemName = ViewBindings.findChildViewById(rootView, id);
      if (itemName == null) {
        break missingId;
      }

      id = R.id.itemPrice;
      TextView itemPrice = ViewBindings.findChildViewById(rootView, id);
      if (itemPrice == null) {
        break missingId;
      }

      id = R.id.itemQuantity;
      TextView itemQuantity = ViewBindings.findChildViewById(rootView, id);
      if (itemQuantity == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = ViewBindings.findChildViewById(rootView, id);
      if (textView9 == null) {
        break missingId;
      }

      return new CartContainerBinding((LinearLayout) rootView, cartConstraint, itemName, itemPrice,
          itemQuantity, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}