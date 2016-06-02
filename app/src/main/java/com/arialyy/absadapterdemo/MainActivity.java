package com.arialyy.absadapterdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapterdemo.entity.ImgEntity;
import com.arialyy.absadapterdemo.recycle_view.RvAdapter;
import com.arialyy.absadapterdemo.entity.TextEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
