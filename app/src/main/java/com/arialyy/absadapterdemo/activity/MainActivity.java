package com.arialyy.absadapterdemo.activity;

import android.content.Intent;
import android.view.View;

import com.arialyy.absadapter.core.AbsHelp;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.base.BaseActivity;
import com.arialyy.absadapterdemo.databinding.ActivityMainBinding;
import com.arialyy.frame.util.show.L;

import java.util.Map;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.recycle_view:
                intent = new Intent(this, RecycleViewActivity.class);
                break;
            case R.id.list_view:
                intent = new Intent(this, ListViewActivity.class);
                break;
            case R.id.test:
                Map map = AbsHelp.getINSTANCE().getData();
                L.m(map);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
