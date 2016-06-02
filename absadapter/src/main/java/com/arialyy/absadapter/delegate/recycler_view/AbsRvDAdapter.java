package com.arialyy.absadapter.delegate.recycler_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arialyy.absadapter.AbsUtil;
import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.delegate.AbsDManager;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyy on 2016/5/30.
 */
public abstract class AbsRvDAdapter<T extends AbsDEntity> extends RecyclerView.Adapter {
    protected String TAG;
    protected List<T> mData = new ArrayList<>();
    protected Context mContext;
    protected AbsRVHolder.OnItemClickListener mItemClickListener;
    protected AbsRVHolder.OnItemLongClickListener mItemLongClickListener;
    protected AbsDManager mManager = new AbsDManager();

    public AbsRvDAdapter(Context context, List<T> data) {
        mData = data;
        mContext = context;
        TAG = AbsUtil.getClassName(this);
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getAbsType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AbsRVHolder holder;
        AbsIRvDelegation delegation = (AbsIRvDelegation) mManager.getDelegate(viewType);
        if (delegation == null){
            throw new NullPointerException("没有type == " + viewType + "的Delegate");
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(delegation.setLayoutId(), parent, false);
        holder = delegation.createHolder(view);
        if (mItemClickListener != null) {
            holder.setItemClickListener(mItemClickListener);
        }
        if (mItemLongClickListener != null) {
            holder.setItemLongClickListener(mItemLongClickListener);
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        AbsIRvDelegation delegation = (AbsIRvDelegation) mManager.getDelegate(type);
        if (delegation == null){
            throw new NullPointerException("没有type == " + type + "的Delegate");
        }
        if (holder instanceof AbsRVHolder) {
            delegation.bindData(position, (AbsRVHolder) holder, mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public Context getContext() {
        return mContext;
    }

    public void setOnItemClickListener(AbsRVHolder.OnItemClickListener mClick) {
        mItemClickListener = mClick;
    }

    public void setOnItemLongClickListener(AbsRVHolder.OnItemLongClickListener mLongClick) {
        mItemLongClickListener = mLongClick;
    }

}
