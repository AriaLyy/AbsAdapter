package com.arialyy.absadapterdemo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

import com.arialyy.absadapterdemo.databinding.FragmentBannerBinding;
import com.arialyy.absadapterdemo.entity.BannerEntity;
import com.arialyy.frame.core.AbsFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.InjectView;

/**
 * Created by lyy on 2015/11/18.
 * Banner
 */
@SuppressLint("ValidFragment")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class BannerFragment extends AbsFragment<FragmentBannerBinding> {
    @InjectView(R.id.img_banner)
    ImageView mBannerImg;
    private BannerEntity mEntity;
    private boolean isCanClick = false;

    private BannerFragment() {

    }

    public static BannerFragment newInstance(BannerEntity entity) {
        BannerFragment fragment = new BannerFragment();
        Bundle         b        = new Bundle();
        b.putParcelable("entity", entity);
        fragment.setArguments(b);
        return fragment;
    }

        @Override
    protected void init(Bundle savedInstanceState) {
        mEntity = getArguments().getParcelable("entity");
//        mBannerImg.setScaleType(mScaleType);
        setUpData(mEntity);
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isCanClick) {
                    return;
                }
//                TurnHelp.turn(getContext(), mEntity);
            }
        });
    }

    @Override
    protected void onDelayLoad() {

    }

    /**
     * 获取ImageView
     */
    public ImageView getBannerImg() {
        return mBannerImg;
    }

    /**
     * 设置能否点击
     */
    public void setCanClick(boolean isCanClick) {
        this.isCanClick = isCanClick;
    }

    /**
     * 设置数据
     *
     * @param entity
     */
    private void setUpData(BannerEntity entity) {
        //databind会自动给控件设置tag的
        mBannerImg.setTag(null);
        mBannerImg.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(getContext()).load(entity.getImgUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mBannerImg);
    }

    /**
     * 设置图片
     */
    public void setDrawable(@DrawableRes int drawable) {
        if (mBannerImg != null) {
            mBannerImg.setImageResource(drawable);
        }
    }

    /**
     * 更新数据
     */
    public void update(BannerEntity entity) {
        mEntity = entity;
        setUpData(entity);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_banner;
    }

    @Override
    protected void dataCallback(int result, Object obj) {

    }
}
