// Generated by view binder compiler. Do not edit!
package com.example.digitalrestaurant.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.digitalrestaurant.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCustomerPageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText enterLoginEmail;

  @NonNull
  public final EditText enterLoginPaswd;

  @NonNull
  public final Button loginSubBtn;

  @NonNull
  public final EditText loginWarningText;

  @NonNull
  public final EditText signInLabelText;

  private ActivityCustomerPageBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText enterLoginEmail, @NonNull EditText enterLoginPaswd,
      @NonNull Button loginSubBtn, @NonNull EditText loginWarningText,
      @NonNull EditText signInLabelText) {
    this.rootView = rootView;
    this.enterLoginEmail = enterLoginEmail;
    this.enterLoginPaswd = enterLoginPaswd;
    this.loginSubBtn = loginSubBtn;
    this.loginWarningText = loginWarningText;
    this.signInLabelText = signInLabelText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCustomerPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCustomerPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_customer_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCustomerPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.enterLoginEmail;
      EditText enterLoginEmail = ViewBindings.findChildViewById(rootView, id);
      if (enterLoginEmail == null) {
        break missingId;
      }

      id = R.id.enterLoginPaswd;
      EditText enterLoginPaswd = ViewBindings.findChildViewById(rootView, id);
      if (enterLoginPaswd == null) {
        break missingId;
      }

      id = R.id.loginSubBtn;
      Button loginSubBtn = ViewBindings.findChildViewById(rootView, id);
      if (loginSubBtn == null) {
        break missingId;
      }

      id = R.id.loginWarningText;
      EditText loginWarningText = ViewBindings.findChildViewById(rootView, id);
      if (loginWarningText == null) {
        break missingId;
      }

      id = R.id.signInLabelText;
      EditText signInLabelText = ViewBindings.findChildViewById(rootView, id);
      if (signInLabelText == null) {
        break missingId;
      }

      return new ActivityCustomerPageBinding((ConstraintLayout) rootView, enterLoginEmail,
          enterLoginPaswd, loginSubBtn, loginWarningText, signInLabelText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}