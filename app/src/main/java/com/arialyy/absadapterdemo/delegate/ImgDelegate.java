package com.arialyy.absadapterdemo.delegate;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arialyy.absadapter.delegate.AbsDelegation;
import com.arialyy.absadapter.common.AbsHolder;
import com.arialyy.absadapter.delegate.AbsIAdapter;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.ImgEntity;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class ImgDelegate extends AbsDelegation<ImgEntity, ImgDelegate.LVImgHolder> {

    public ImgDelegate(Context context, AbsIAdapter adapter, int itemType) {
        super(context, adapter, itemType);
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
        return R.layout.item_img;
    }

    public class LVImgHolder extends AbsHolder {
        @InjectView(R.id.img)
        ImageView img;
        @InjectView(R.id.text)
        TextView text;

        public LVImgHolder(View itemView) {
            super(itemView);
        }
    }
}
