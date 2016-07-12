package com.arialyy.absadapterdemo.delegate;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.arialyy.absadapter.delegate.AbsDelegation;
import com.arialyy.absadapter.common.AbsHolder;
import com.arialyy.absadapter.delegate.AbsIAdapter;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.TextEntity;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class TextDelegate extends AbsDelegation<TextEntity, TextDelegate.LvTextHolder> {

    public TextDelegate(Context context, AbsIAdapter adapter) {
        super(context, adapter);
    }

    @Override
    public LvTextHolder createHolder(View convertView) {
        return new LvTextHolder(convertView);
    }

    @Override
    public void bindData(int position, TextDelegate.LvTextHolder helper, TextEntity item) {
        helper.mText.setText(item.getText());
    }


    @Override
    public int setLayoutId() {
        return R.layout.item_text;
    }

    public class LvTextHolder extends AbsHolder {
        @InjectView(R.id.text)
        TextView mText;

        public LvTextHolder(View itemView) {
            super(itemView);
        }
    }
}
