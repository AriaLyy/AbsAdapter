package com.arialyy.absadapterdemo.listview;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.arialyy.absadapter.delegate.listview.AbsLvDHolder;
import com.arialyy.absadapter.delegate.listview.AbsLvDelegation;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.TextEntity;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class LvTextDelegate extends AbsLvDelegation<TextEntity, LvTextDelegate.LvTextHolder> {


    protected LvTextDelegate(Context context, int itemType) {
        super(context, itemType);
    }

    @Override
    public LvTextHolder createHolder(View convertView) {
        return new LvTextHolder(convertView);
    }

    @Override
    public void bindData(int position, LvTextDelegate.LvTextHolder helper, TextEntity item) {
        helper.mText.setText(item.getText());
    }


    @Override
    public int setLayoutId() {
        return R.layout.layout_item_text;
    }

    public class LvTextHolder extends AbsLvDHolder {
        @InjectView(R.id.text)
        TextView mText;

        public LvTextHolder(View itemView) {
            super(itemView);
        }
    }
}
