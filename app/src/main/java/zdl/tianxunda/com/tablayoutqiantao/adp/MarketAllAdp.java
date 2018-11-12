package zdl.tianxunda.com.tablayoutqiantao.adp;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zdl.tianxunda.com.tablayoutqiantao.R;
import zdl.tianxunda.com.tablayoutqiantao.bean.MarketAllTickersBean;

/**
 * Created by dell-pc on 2018/10/25.
 */

public class MarketAllAdp extends BaseQuickAdapter<MarketAllTickersBean.DataBean.ListBean, BaseViewHolder> {
    public MarketAllAdp(int layoutResId, @Nullable List<MarketAllTickersBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MarketAllTickersBean.DataBean.ListBean item) {
        ImageView image_icon = helper.itemView.findViewById(R.id.image_icon);
        Glide.with(mContext).load(item.getIcon()).into(image_icon);
        helper.setText(R.id.text_ticker, item.getTicker())
                .setText(R.id.text_bid_ask, item.getBid() + item.getBase_symbol() + "/" + item.getAsk() + item.getTransaction_symbol())
                .setText(R.id.text_last_price, item.getLast_price())
                .setText(R.id.text_base_volume, item.getBase_volume())
                .setText(R.id.text_change_daily, item.getChange_daily());


    }
}
