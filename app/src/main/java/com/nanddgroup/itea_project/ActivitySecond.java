package com.nanddgroup.itea_project;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivitySecond extends AppCompatActivity {
  @BindView(R.id.ivSecond) ImageView ivSecond;
  @BindView(R.id.toolbar) Toolbar mToolbar;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    ButterKnife.bind(this);
    setSupportActionBar(mToolbar);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      ivSecond.setTransitionName("transitionName");
    }
  }
}
