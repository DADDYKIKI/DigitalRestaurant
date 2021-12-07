// Generated by view binder compiler. Do not edit!
package com.example.digitalrestaurant.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.digitalrestaurant.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CartBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView cartTitle;

  @NonNull
  public final TextView homeKey;

  @NonNull
  public final TextView menuKeyS;

  @NonNull
  public final RecyclerView orderRecyclerview;

  @NonNull
  public final TextView restN;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  private CartBinding(@NonNull LinearLayout rootView, @NonNull TextView cartTitle,
      @NonNull TextView homeKey, @NonNull TextView menuKeyS,
      @NonNull RecyclerView orderRecyclerview, @NonNull TextView restN,
      @NonNull TextView textView10, @NonNull TextView textView7, @NonNull TextView textView8) {
    this.rootView = rootView;
    this.cartTitle = cartTitle;
    this.homeKey = homeKey;
    this.menuKeyS = menuKeyS;
    this.orderRecyclerview = orderRecyclerview;
    this.restN = restN;
    this.textView10 = textView10;
    this.textView7 = textView7;
    this.textView8 = textView8;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CartBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CartBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.cart, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CartBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cartTitle;
      TextView cartTitle = ViewBindings.findChildViewById(rootView, id);
      if (cartTitle == null) {
        break missingId;
      }

      id = R.id.homeKey;
      TextView homeKey = ViewBindings.findChildViewById(rootView, id);
      if (homeKey == null) {
        break missingId;
      }

      id = R.id.menuKeyS;
      TextView menuKeyS = ViewBindings.findChildViewById(rootView, id);
      if (menuKeyS == null) {
        break missingId;
      }

      id = R.id.orderRecyclerview;
      RecyclerView orderRecyclerview = ViewBindings.findChildViewById(rootView, id);
      if (orderRecyclerview == null) {
        break missingId;
      }

      id = R.id.restN;
      TextView restN = ViewBindings.findChildViewById(rootView, id);
      if (restN == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = ViewBindings.findChildViewById(rootView, id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      return new CartBinding((LinearLayout) rootView, cartTitle, homeKey, menuKeyS,
          orderRecyclerview, restN, textView10, textView7, textView8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
