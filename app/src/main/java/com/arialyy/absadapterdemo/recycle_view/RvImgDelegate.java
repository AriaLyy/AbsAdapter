package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arialyy.absadapter.delegate.recycler_view.AbsRvDAdapter;
import com.arialyy.absadapter.delegate.recycler_view.AbsRvDelegation;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.ImgEntity;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class RvImgDelegate extends AbsRvDelegation<ImgEntity, RvImgDelegate.RVImgHolder> {

    public RvImgDelegate(Context context, AbsRvDAdapter adapter, int itemType) {
        super(context, adapter, itemType);
    }

    @Override
    public RVImgHolder createHolder(View convertView) {
        return new RVImgHolder(convertView);
    }

    @Override
    public void bindData(int position, RVImgHolder helper, ImgEntity item) {
        helper.text.setText(item.getText());
    }


    @Override
    public int setLayoutId() {
        return R.layout.layout_item_img;
    }

    public class RVImgHolder extends AbsRVHolder {
        @InjectView(R.id.img)
        ImageView img;
        @InjectView(R.id.text)
        TextView text;

        public RVImgHolder(View itemView) {
            super(itemView);
        }
    }
}
