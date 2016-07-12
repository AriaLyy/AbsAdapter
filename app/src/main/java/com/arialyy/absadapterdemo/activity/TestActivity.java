package com.arialyy.absadapterdemo.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.base.BaseActivity;
import com.arialyy.absadapterdemo.databinding.ActivityTestBinding;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/7/12.
 */
public class TestActivity extends BaseActivity<ActivityTestBinding> {
    @InjectView(R.id.list)
    RecyclerView mList;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);

    }

}
