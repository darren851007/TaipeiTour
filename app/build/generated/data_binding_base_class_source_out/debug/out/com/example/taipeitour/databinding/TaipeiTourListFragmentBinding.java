// Generated by view binder compiler. Do not edit!
package com.example.taipeitour.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.taipeitour.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TaipeiTourListFragmentBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final AppBarLayoutBinding toolBar;

  @NonNull
  public final View viewDivider;

  private TaipeiTourListFragmentBinding(@NonNull CoordinatorLayout rootView,
      @NonNull AppBarLayoutBinding toolBar, @NonNull View viewDivider) {
    this.rootView = rootView;
    this.toolBar = toolBar;
    this.viewDivider = viewDivider;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TaipeiTourListFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TaipeiTourListFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.taipei_tour_list_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TaipeiTourListFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tool_bar;
      View toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }
      AppBarLayoutBinding binding_toolBar = AppBarLayoutBinding.bind(toolBar);

      id = R.id.view_divider;
      View viewDivider = ViewBindings.findChildViewById(rootView, id);
      if (viewDivider == null) {
        break missingId;
      }

      return new TaipeiTourListFragmentBinding((CoordinatorLayout) rootView, binding_toolBar,
          viewDivider);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}