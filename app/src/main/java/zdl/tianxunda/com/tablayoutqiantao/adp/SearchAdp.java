package zdl.tianxunda.com.tablayoutqiantao.adp;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import zdl.tianxunda.com.tablayoutqiantao.R;
import zdl.tianxunda.com.tablayoutqiantao.bean.SearchBean;


/**
 * Created by dell-pc on 2018/10/17.
 */

public class SearchAdp extends BaseQuickAdapter<SearchBean.DataBean.MarketsListBean,BaseViewHolder> {

    public SearchAdp(int layoutResId, @Nullable List<SearchBean.DataBean.MarketsListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean.DataBean.MarketsListBean item) {
        helper.setText(R.id.text_bitcoin,item.getDisplay_name());
    }
}
