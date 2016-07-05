package com.arialyy.absadapterdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.Constance;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.base.BaseActivity;
import com.arialyy.absadapterdemo.databinding.ActivityListViewBinding;
import com.arialyy.absadapterdemo.entity.TextEntity;
import com.arialyy.absadapterdemo.listview.LvAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class ListViewActivity extends BaseActivity<ActivityListViewBinding> {
    @InjectView(R.id.list)
    ListView mList;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_list_view;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        final List<AbsDEntity> data = setData();
        final LvAdapter adapter = new LvAdapter(this, data);
        mList.setAdapter(adapter);
        mList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                data.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    private List<AbsDEntity> setData() {
        List<AbsDEntity> list = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            if (rd.nextBoolean()) {
                TextEntity tEntity = new TextEntity();
                tEntity.setAbsType(Constance.ADAPTER_TYPE.TYPE_TEXT);
                tEntity.setText("text ==> " + i);
                list.add(tEntity);
            } else {
//                ImgEntity iEntity = new ImgEntity();
//                iEntity.setAbsType(Constance.ADAPTER_TYPE.TYPE_IMG);
//                iEntity.setText("img ==> " + i);
//                list.add(iEntity);
            }
        }
        return list;
    }
}
