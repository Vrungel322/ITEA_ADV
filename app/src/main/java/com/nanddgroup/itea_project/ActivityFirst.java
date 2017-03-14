package com.nanddgroup.itea_project;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityFirst extends AppCompatActivity {
  @BindView(R.id.ivFirst) ImageView ivFirst;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_first);
    ButterKnife.bind(this);

    ivFirst.setOnClickListener(v -> {
      ActivityOptions transitionActivityOptions = null;
      if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
        transitionActivityOptions =
            ActivityOptions.makeSceneTransitionAnimation(ActivityFirst.this, ivFirst,
                "transitionName");
        startActivity(new Intent(ActivityFirst.this, ActivitySecond.class),
            transitionActivityOptions.toBundle());
      }
    });
  }
}
