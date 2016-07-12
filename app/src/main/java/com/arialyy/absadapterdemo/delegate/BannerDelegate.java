package com.arialyy.absadapterdemo.delegate;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.arialyy.absadapter.delegate.AbsDelegation;
import com.arialyy.absadapter.common.AbsHolder;
import com.arialyy.absadapter.delegate.AbsIAdapter;
import com.arialyy.absadapter.viewpager.SimpleViewPagerAdapter;
import com.arialyy.absadapterdemo.BannerFragment;
import com.arialyy.absadapterdemo.R;
import com.arialyy.absadapterdemo.entity.BannerEntity;
import com.arialyy.absadapterdemo.entity.DBannerEntity;
import com.arialyy.absadapterdemo.widget.CircleIndicator;
import com.arialyy.frame.core.AbsActivity;

import java.util.List;

import butterknife.InjectView;

/**
 * Created by lyy on 2016/6/21.
 */
public class BannerDelegate extends AbsDelegation<DBannerEntity, BannerDelegate.BannerHolder> {
    FragmentManager mFm;

    public BannerDelegate(Context context, AbsIAdapter adapter, FragmentManager fm) {
        super(context, adapter);
        mFm = fm;
    }

    @Override
    public BannerHolder createHolder(View convertView) {
        return new BannerHolder(convertView);
    }

    @Override
    public void bindData(int position, BannerHolder holder, DBannerEntity item) {
        SimpleViewPagerAdapter adapter = (SimpleViewPagerAdapter) holder.vp.getTag(holder.vp.getId());
        if (adapter == null) {
            adapter = new SimpleViewPagerAdapter(mFm);
            holder.vp.setTag(holder.vp.getId(), adapter);
            List<BannerEntity> banners = item.getBanners();
            int                i       = 0;
            for (BannerEntity entity : banners) {
                BannerFragment fragment = BannerFragment.newInstance(entity);
                adapter.addFrag(fragment, i + "banner");
                i++;
            }
            holder.vp.setAdapter(adapter);
            holder.indicator.setViewPager(holder.vp);
        }
    }

    @Override
    public int setLayoutId() {
        return R.layout.item_banner;
    }

    class BannerHolder extends AbsHolder {
        @InjectView(R.id.vp)
        ViewPager       vp;
        @InjectView(R.id.indicator)
        CircleIndicator indicator;

        public BannerHolder(View itemView) {
            super(itemView);
        }
    }
}
