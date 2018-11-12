package zdl.tianxunda.com.tablayoutqiantao.adp;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zdl.tianxunda.com.tablayoutqiantao.bean.MarketAllTickersBean;
import zdl.tianxunda.com.tablayoutqiantao.R;

/**
 * Created by dell-pc on 2018/10/25.
 */

    public class MarketAllTickersAdp extends BaseQuickAdapter<MarketAllTickersBean.DataBean.TransactionSymbolListBean, BaseViewHolder> {

    public MarketAllTickersAdp(int layoutResId, @Nullable List<MarketAllTickersBean.DataBean.TransactionSymbolListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MarketAllTickersBean.DataBean.TransactionSymbolListBean item) {
        helper.setText(R.id.text_name, item.getTransaction_symbol());
        ImageView imageView = helper.itemView.findViewById(R.id.imageView);
        if (item.aBoolean == true) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

    }
}
