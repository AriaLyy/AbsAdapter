package com.arialyy.absadapterdemo;

import android.content.Intent;
import android.view.View;

import com.arialyy.absadapterdemo.databinding.ActivityMainBinding;
import com.arialyy.frame.core.AbsActivity;

public class MainActivity extends AbsActivity<ActivityMainBinding> {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void dataCallback(int result, Object data) {

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
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
