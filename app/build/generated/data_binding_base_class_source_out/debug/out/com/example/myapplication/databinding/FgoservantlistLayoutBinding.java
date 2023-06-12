// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FgoservantlistLayoutBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageRank;

  @NonNull
  public final TextView textviewId;

  @NonNull
  public final TextView textviewName;

  @NonNull
  public final TextView textviewTreasuretools;

  private FgoservantlistLayoutBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageRank, @NonNull TextView textviewId, @NonNull TextView textviewName,
      @NonNull TextView textviewTreasuretools) {
    this.rootView = rootView;
    this.imageRank = imageRank;
    this.textviewId = textviewId;
    this.textviewName = textviewName;
    this.textviewTreasuretools = textviewTreasuretools;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FgoservantlistLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FgoservantlistLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fgoservantlist_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FgoservantlistLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.image_rank;
      ImageView imageRank = ViewBindings.findChildViewById(rootView, id);
      if (imageRank == null) {
        break missingId;
      }

      id = R.id.textview_id;
      TextView textviewId = ViewBindings.findChildViewById(rootView, id);
      if (textviewId == null) {
        break missingId;
      }

      id = R.id.textview_name;
      TextView textviewName = ViewBindings.findChildViewById(rootView, id);
      if (textviewName == null) {
        break missingId;
      }

      id = R.id.textview_Treasuretools;
      TextView textviewTreasuretools = ViewBindings.findChildViewById(rootView, id);
      if (textviewTreasuretools == null) {
        break missingId;
      }

      return new FgoservantlistLayoutBinding((ConstraintLayout) rootView, imageRank, textviewId,
          textviewName, textviewTreasuretools);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}