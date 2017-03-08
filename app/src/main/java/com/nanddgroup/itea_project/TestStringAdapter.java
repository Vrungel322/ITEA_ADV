package com.nanddgroup.itea_project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.ArrayList;

/**
 * Created by Vrungel on 16.02.2017.
 */

public class TestStringAdapter extends RecyclerView.Adapter<TestStringAdapter.TestStringViewHolder> {
  private ArrayList<String> mExchangeEntityArrayList = new ArrayList<>();
  private LayoutInflater inflater;
  private Context mContext;
  private int lastPosition;

  public TestStringAdapter(Context context) {
    this.inflater = LayoutInflater.from(context);
    this.mContext = context;
  }

  @Override
  public TestStringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = inflater.inflate(R.layout.currency_list_item, parent, false);
    return new TestStringViewHolder(v);
  }

  @Override public void onBindViewHolder(TestStringViewHolder holder, int position) {
    holder.tvText.setText(String.valueOf(mExchangeEntityArrayList.get(position)));
    addAnimation(holder, position);
  }

  @Override public int getItemCount() {
    return mExchangeEntityArrayList.size();
  }

  @Override public void onViewDetachedFromWindow(TestStringViewHolder holder) {
    super.onViewDetachedFromWindow(holder);
    holder.itemView.clearAnimation();
  }

  private void addAnimation(TestStringViewHolder holder, int position) {
    Animation animation = AnimationUtils.loadAnimation(mContext,
        (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
    holder.itemView.startAnimation(animation);
    lastPosition = position;
  }

  public void addCurrencyEntity(String entity) {
    mExchangeEntityArrayList.add(entity);
    notifyItemInserted(getItemCount());
  }

  static class TestStringViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvText) TextView tvText;

    TestStringViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
