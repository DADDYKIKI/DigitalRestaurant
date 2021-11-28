// Generated by view binder compiler. Do not edit!
package com.example.digitalrestaurant.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView areYouNewSell;

  @NonNull
  public final TextView customerloginBut;

  @NonNull
  public final TextView customersignupBut;

  @NonNull
  public final TextView textView;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull TextView areYouNewSell,
      @NonNull TextView customerloginBut, @NonNull TextView customersignupBut,
      @NonNull TextView textView) {
    this.rootView = rootView;
    this.areYouNewSell = areYouNewSell;
    this.customerloginBut = customerloginBut;
    this.customersignupBut = customersignupBut;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.areYouNewSell;
      TextView areYouNewSell = ViewBindings.findChildViewById(rootView, id);
      if (areYouNewSell == null) {
        break missingId;
      }

      id = R.id.customerloginBut;
      TextView customerloginBut = ViewBindings.findChildViewById(rootView, id);
      if (customerloginBut == null) {
        break missingId;
      }

      id = R.id.customersignupBut;
      TextView customersignupBut = ViewBindings.findChildViewById(rootView, id);
      if (customersignupBut == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, areYouNewSell, customerloginBut,
          customersignupBut, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
