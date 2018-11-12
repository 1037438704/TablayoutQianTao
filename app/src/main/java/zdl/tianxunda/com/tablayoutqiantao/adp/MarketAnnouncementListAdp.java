package zdl.tianxunda.com.tablayoutqiantao.adp;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import zdl.tianxunda.com.tablayoutqiantao.R;
import zdl.tianxunda.com.tablayoutqiantao.bean.MarketAnnouncementListBean;
import zdl.tianxunda.com.tablayoutqiantao.utlis.DataTimeView;


/**
 * Created by dell-pc on 2018/10/25.
 */

public class MarketAnnouncementListAdp extends BaseQuickAdapter<MarketAnnouncementListBean.DataBean.AnnouncementListBean, BaseViewHolder> {

    public MarketAnnouncementListAdp(int layoutResId, @Nullable List<MarketAnnouncementListBean.DataBean.AnnouncementListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MarketAnnouncementListBean.DataBean.AnnouncementListBean item) {
        helper.setText(R.id.create_time, DataTimeView.timeStamp2Date(item.getCreate_time(), "MM-dd HH:mm"))
                .setText(R.id.text_title, item.getTitle())
                .setText(R.id.text_content, item.getContent());
    }

}
