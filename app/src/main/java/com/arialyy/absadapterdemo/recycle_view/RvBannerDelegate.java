package com.arialyy.absadapterdemo.recycle_view;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.arialyy.absadapter.delegate.recycler_view.AbsRvDAdapter;
import com.arialyy.absadapter.delegate.recycler_view.AbsRvDelegation;
import com.arialyy.absadapter.recycler_view.AbsRVHolder;
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
public class RvBannerDelegate extends AbsRvDelegation<DBannerEntity, RvBannerDelegate.BannerHolder> {

    public RvBannerDelegate(Context context, AbsRvDAdapter adapter, int itemType) {
        super(context, adapter, itemType);
    }

    @Override
    public BannerHolder createHolder(View convertView) {
        return new BannerHolder(convertView);
    }

    @Override
    public void bindData(int position, BannerHolder holder, DBannerEntity item) {
        SimpleViewPagerAdapter adapter = (SimpleViewPagerAdapter) holder.vp.getTag(holder.vp.getId());
        if (adapter == null) {
            FragmentManager fm = getFm();
            if (fm != null) {
                adapter = new SimpleViewPagerAdapter(fm);
                holder.vp.setTag(holder.vp.getId(), adapter);
                List<BannerEntity> banners = item.getBanners();
                int                i       = 0;
                for (BannerEntity entity : banners) {
                    BannerFragment fragment = BannerFragment.newInstance(entity);
                    fragment.setDrawable(R.mipmap.ic_launcher);
                    fragment.setCanClick(true);
                    adapter.addFrag(fragment, i + "banner");
                    i++;
                }
                holder.vp.setAdapter(adapter);
                holder.indicator.setViewPager(holder.vp);
            }
        }
    }

    private FragmentManager getFm() {
        Context context = getContext();
        if (context instanceof AbsActivity) {
            return ((AbsActivity) context).getSupportFragmentManager();
        }
        return null;
    }

    @Override
    public int setLayoutId() {
        return R.layout.item_banner;
    }

    class BannerHolder extends AbsRVHolder {
        @InjectView(R.id.vp)
        ViewPager       vp;
        @InjectView(R.id.indicator)
        CircleIndicator indicator;

        public BannerHolder(View itemView) {
            super(itemView);
        }
    }
}
