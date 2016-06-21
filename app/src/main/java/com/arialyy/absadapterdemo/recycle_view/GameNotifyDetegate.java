package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arialyy.absadapter.delegate.recycler_view.AbsRvDAdapter;
import com.arialyy.absadapter.delegate.recycler_view.AbsRvDelegation;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.GameNotifyEntity;
import com.bumptech.glide.Glide;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/6/21.
 */
public class GameNotifyDetegate extends AbsRvDelegation<GameNotifyEntity, GameNotifyDetegate.GameNotifyHolder> {

    public GameNotifyDetegate(Context context, AbsRvDAdapter adapter, int itemType) {
        super(context, adapter, itemType);
    }

    @Override
    public GameNotifyHolder createHolder(View convertView) {
        return new GameNotifyHolder(convertView);
    }

    @Override
    public void bindData(int position, GameNotifyHolder holder, GameNotifyEntity item) {
        Glide.with(getContext()).load(item.getImgUrl()).into(holder.img);
        Glide.with(getContext()).load(item.getGameIcon()).into(holder.gameIcon);
        holder.title.setText(item.getTitle());
        holder.detail.setText(item.getDetail());
    }

    @Override
    public int setLayoutId() {
        return R.layout.item_game_notify;
    }

    class GameNotifyHolder extends AbsRVHolder {
        @InjectView(R.id.img)
        ImageView img;
        @InjectView(R.id.game_img)
        ImageView gameIcon;
        @InjectView(R.id.title)
        TextView  title;
        @InjectView(R.id.detail)
        TextView  detail;

        public GameNotifyHolder(View itemView) {
            super(itemView);
        }
    }
}
