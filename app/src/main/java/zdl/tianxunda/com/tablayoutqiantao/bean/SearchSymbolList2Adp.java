package zdl.tianxunda.com.tablayoutqiantao.bean;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import zdl.tianxunda.com.tablayoutqiantao.R;


/**
 * Created by dell-pc on 2018/10/19.
 */

public class SearchSymbolList2Adp extends BaseQuickAdapter<SearchXQBean.DataBean.MarketsListBean, BaseViewHolder> {

    public SearchSymbolList2Adp(int layoutResId, @Nullable List<SearchXQBean.DataBean.MarketsListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchXQBean.DataBean.MarketsListBean item) {
        ImageView image_icon = helper.itemView.findViewById(R.id.image_icon);

        Glide.with(mContext).load(item.getIcon()).into(image_icon);

        helper.setText(R.id.symbol_name,item.getDisplay_name());
    }
}
