package com.arialyy.absadapterdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;
import com.arialyy.absadapterdemo.entity.ImgEntity;
import com.arialyy.absadapterdemo.entity.TextEntity;
import com.arialyy.absadapterdemo.recycle_view.RvAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lyy on 2016/5/30.
 */
public class RecycleViewActivity extends AppCompatActivity {
    RecyclerView mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recycle_view);
        mList = (RecyclerView) findViewById(R.id.list);
        init();
    }

    private void init() {
        final List<AbsDEntity> data = setData();
        final RvAdapter adapter = new RvAdapter(this, data);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setAdapter(adapter);
        adapter.setOnItemLongClickListener(new AbsRVHolder.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View parent, int position) {
                data.remove(position);
                adapter.notifyDataSetChanged();
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
                ImgEntity iEntity = new ImgEntity();
                iEntity.setAbsType(Constance.ADAPTER_TYPE.TYPE_IMG);
                iEntity.setText("img ==> " + i);
                list.add(iEntity);
            }
        }
        return list;
    }
}
