package zdl.tianxunda.com.tablayoutqiantao.bean;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import zdl.tianxunda.com.tablayoutqiantao.R;

/**
 * Created by dell-pc on 2018/10/17.
 */

public class SearchSymbolAdp extends BaseQuickAdapter<SearchBean.DataBean.SymbolListBean, BaseViewHolder> {

    public SearchSymbolAdp(int layoutResId, @Nullable List<SearchBean.DataBean.SymbolListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchBean.DataBean.SymbolListBean item) {
        helper.setText(R.id.text_bitcoin, item.getName());
    }
}
