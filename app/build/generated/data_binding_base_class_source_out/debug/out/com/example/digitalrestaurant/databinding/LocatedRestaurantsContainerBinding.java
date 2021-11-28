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

public final class LocatedRestaurantsContainerBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ConstraintLayout locatedrestaurantback;

  @NonNull
  public final TextView locatedrestaurantname;

  private LocatedRestaurantsContainerBinding(@NonNull LinearLayout rootView,
      @NonNull ConstraintLayout locatedrestaurantback, @NonNull TextView locatedrestaurantname) {
    this.rootView = rootView;
    this.locatedrestaurantback = locatedrestaurantback;
    this.locatedrestaurantname = locatedrestaurantname;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LocatedRestaurantsContainerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LocatedRestaurantsContainerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.located_restaurants_container, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LocatedRestaurantsContainerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.locatedrestaurantback;
      ConstraintLayout locatedrestaurantback = ViewBindings.findChildViewById(rootView, id);
      if (locatedrestaurantback == null) {
        break missingId;
      }

      id = R.id.locatedrestaurantname;
      TextView locatedrestaurantname = ViewBindings.findChildViewById(rootView, id);
      if (locatedrestaurantname == null) {
        break missingId;
      }

      return new LocatedRestaurantsContainerBinding((LinearLayout) rootView, locatedrestaurantback,
          locatedrestaurantname);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}