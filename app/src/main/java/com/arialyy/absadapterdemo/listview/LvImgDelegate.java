package com.arialyy.absadapterdemo.listview;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arialyy.absadapter.delegate.listview.AbsLvDHolder;
import com.arialyy.absadapter.delegate.listview.AbsLvDelegation;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.ImgEntity;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class LvImgDelegate extends AbsLvDelegation<ImgEntity, LvImgDelegate.LVImgHolder> {


    protected LvImgDelegate(Context context, int itemType) {
        super(context, itemType);
    }

    @Override
    public LVImgHolder createHolder(View convertView) {
        return new LVImgHolder(convertView);
    }

    @Override
    public void bindData(int position, LVImgHolder helper, ImgEntity item) {
        helper.text.setText(item.getText());
    }

    @Override
    public int setLayoutId() {
        return R.layout.layout_item_img;
    }

    public class LVImgHolder extends AbsLvDHolder {
        @InjectView(R.id.img)
        ImageView img;
        @InjectView(R.id.text)
        TextView text;

        public LVImgHolder(View itemView) {
            super(itemView);
        }
    }
}
