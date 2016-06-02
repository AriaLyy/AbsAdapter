package com.arialyy.absadapterdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.entity.ImgEntity;
import com.arialyy.absadapterdemo.entity.TextEntity;
import com.arialyy.absadapterdemo.listview.LvAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by lyy on 2016/5/30.
 */
public class ListViewActivity extends AppCompatActivity {

    ListView mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_list_view);
        mList = (ListView) findViewById(R.id.list);
        init();
    }

    private void init() {
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
                ImgEntity iEntity = new ImgEntity();
                iEntity.setAbsType(Constance.ADAPTER_TYPE.TYPE_IMG);
                iEntity.setText("img ==> " + i);
                list.add(iEntity);
            }
        }
        return list;
    }

}
