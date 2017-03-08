package com.nanddgroup.itea_project;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
  @BindView(R.id.fabSend) FloatingActionButton fabSend;
  @BindView(R.id.rvTestString) RecyclerView rvTestString;
  @BindView(R.id.toolbar) Toolbar mToolbar;
  private TestStringAdapter mTestStringAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setSupportActionBar(mToolbar);

    mTestStringAdapter = new TestStringAdapter(this);
    rvTestString.setLayoutManager(new LinearLayoutManager(this));
    rvTestString.setItemAnimator(new DefaultItemAnimator());
    rvTestString.setAdapter(mTestStringAdapter);
    for (int i = 0; i<100; i++){
      mTestStringAdapter.addCurrencyEntity("lorem");
    }
  }
}
