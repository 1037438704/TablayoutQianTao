package zdl.tianxunda.com.tablayoutqiantao.adp;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zdl.tianxunda.com.tablayoutqiantao.bean.MarketAnnouncementListBean;
import zdl.tianxunda.com.tablayoutqiantao.R;

/**
 * Created by dell-pc on 2018/10/25.
 */

public class MarketAnnouncementAdp extends BaseQuickAdapter<MarketAnnouncementListBean.DataBean.AnnouncementTypeBean, BaseViewHolder> {

    public MarketAnnouncementAdp(int layoutResId, @Nullable List<MarketAnnouncementListBean.DataBean.AnnouncementTypeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MarketAnnouncementListBean.DataBean.AnnouncementTypeBean item) {
        TextView text_item = helper.itemView.findViewById(R.id.text_item);
        text_item.setText(item.getType_name());
        text_item.setSelected(item.aBoolean);
    }
}
