package com.arialyy.absadapterdemo.delegate;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arialyy.absadapter.delegate.AbsDelegation;
import com.arialyy.absadapter.common.AbsHolder;
import com.arialyy.absadapter.delegate.AbsIAdapter;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.GameDetailEntity;
import com.bumptech.glide.Glide;

import butterknife.Bind;

/**
 * Created by lyy on 2016/6/21.
 */
public class GameDetailDelegate extends AbsDelegation<GameDetailEntity, GameDetailDelegate.GameDetailHolder> {

    public GameDetailDelegate(Context context, AbsIAdapter adapter) {
        super(context, adapter);
    }

    @Override
    public GameDetailHolder createHolder(View convertView) {
        return new GameDetailHolder(convertView);
    }

    @Override
    public void bindData(int position, GameDetailHolder holder, GameDetailEntity item) {
        Glide.with(getContext()).load(item.getImgUrl()).into(holder.img);
        holder.title.setText(item.getTitle());
        holder.detail.setText(item.getDetail());
        BtListener listener = (BtListener) holder.bt.getTag(holder.bt.getId());
        if (listener == null) {
            listener = new BtListener();
            holder.bt.setTag(holder.bt.getId(), listener);
        }
        listener.setData(item);
        holder.bt.setOnClickListener(listener);
    }

    private class BtListener implements View.OnClickListener {
        GameDetailEntity entity;

        public void setData(GameDetailEntity entity) {
            this.entity = entity;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(), entity.getTitle() + "", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.item_game_detail;
    }

    class GameDetailHolder extends AbsHolder {
        @Bind(R.id.img)
        ImageView img;
        @Bind(R.id.title)
        TextView  title;
        @Bind(R.id.game_detail)
        TextView  detail;
        @Bind(R.id.bt)
        Button    bt;

        public GameDetailHolder(View itemView) {
            super(itemView);
        }
    }
}
