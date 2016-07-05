package com.arialyy.absadapterdemo.recycle_view.delegate;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.arialyy.absadapter.delegate.recycler_view.AbsRvDAdapter;
import com.arialyy.absadapter.delegate.recycler_view.AbsRvDelegation;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.TextEntity;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/5/30.
 */
public class RvTextDelegate extends AbsRvDelegation<TextEntity, RvTextDelegate.RvDelegate> {


    public RvTextDelegate(Context context, AbsRvDAdapter adapter, int itemType) {
        super(context, adapter, itemType);
    }

    @Override
    public RvDelegate createHolder(View convertView) {
        return new RvDelegate(convertView);
    }

    @Override
    public void bindData(int position, RvDelegate helper, TextEntity item) {
        helper.mText.setText(item.getText());
    }


    @Override
    public int setLayoutId() {
        return R.layout.layout_item_text;
    }

    public class RvDelegate extends AbsRVHolder {
        @InjectView(R.id.text)
        TextView mText;

        public RvDelegate(View itemView) {
            super(itemView);
        }
    }
}
