// Generated by view binder compiler. Do not edit!
package com.example.taipeitour.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.taipeitour.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TaipeiTourListDetailFragmentBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final ImageView ivDeetail;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final AppBarDetailToolbarBinding toolBar;

  @NonNull
  public final TextView tvDetailDesc;

  @NonNull
  public final TextView tvDetailTitle;

  @NonNull
  public final TextView tvUrl;

  @NonNull
  public final CoordinatorLayout tvWebUrl;

  @NonNull
  public final View viewDivider;

  @NonNull
  public final WebView webView;

  private TaipeiTourListDetailFragmentBinding(@NonNull CoordinatorLayout rootView,
      @NonNull ImageView ivDeetail, @NonNull ProgressBar progressBar,
      @NonNull ScrollView scrollView, @NonNull AppBarDetailToolbarBinding toolBar,
      @NonNull TextView tvDetailDesc, @NonNull TextView tvDetailTitle, @NonNull TextView tvUrl,
      @NonNull CoordinatorLayout tvWebUrl, @NonNull View viewDivider, @NonNull WebView webView) {
    this.rootView = rootView;
    this.ivDeetail = ivDeetail;
    this.progressBar = progressBar;
    this.scrollView = scrollView;
    this.toolBar = toolBar;
    this.tvDetailDesc = tvDetailDesc;
    this.tvDetailTitle = tvDetailTitle;
    this.tvUrl = tvUrl;
    this.tvWebUrl = tvWebUrl;
    this.viewDivider = viewDivider;
    this.webView = webView;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TaipeiTourListDetailFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TaipeiTourListDetailFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.taipei_tour_list_detail_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TaipeiTourListDetailFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_deetail;
      ImageView ivDeetail = ViewBindings.findChildViewById(rootView, id);
      if (ivDeetail == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.scrollView;
      ScrollView scrollView = ViewBindings.findChildViewById(rootView, id);
      if (scrollView == null) {
        break missingId;
      }

      id = R.id.tool_bar;
      View toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }
      AppBarDetailToolbarBinding binding_toolBar = AppBarDetailToolbarBinding.bind(toolBar);

      id = R.id.tv_detail_desc;
      TextView tvDetailDesc = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailDesc == null) {
        break missingId;
      }

      id = R.id.tv_detail_title;
      TextView tvDetailTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvDetailTitle == null) {
        break missingId;
      }

      id = R.id.tv_url;
      TextView tvUrl = ViewBindings.findChildViewById(rootView, id);
      if (tvUrl == null) {
        break missingId;
      }

      CoordinatorLayout tvWebUrl = (CoordinatorLayout) rootView;

      id = R.id.view_divider;
      View viewDivider = ViewBindings.findChildViewById(rootView, id);
      if (viewDivider == null) {
        break missingId;
      }

      id = R.id.webView;
      WebView webView = ViewBindings.findChildViewById(rootView, id);
      if (webView == null) {
        break missingId;
      }

      return new TaipeiTourListDetailFragmentBinding((CoordinatorLayout) rootView, ivDeetail,
          progressBar, scrollView, binding_toolBar, tvDetailDesc, tvDetailTitle, tvUrl, tvWebUrl,
          viewDivider, webView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
