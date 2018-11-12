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

public class SearchSymbolListAdp extends BaseQuickAdapter<SearchXQBean.DataBean.SymbolListBean, BaseViewHolder> {

    public SearchSymbolListAdp(int layoutResId, @Nullable List<SearchXQBean.DataBean.SymbolListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchXQBean.DataBean.SymbolListBean item) {
        ImageView image_icon = helper.itemView.findViewById(R.id.image_icon);
        ImageView imageView_gone = helper.itemView.findViewById(R.id.imageView_gone);
        Glide.with(mContext).load(item.getIcon()).into(image_icon);
        helper.setText(R.id.symbol_name,item.getSymbol()+"("+item.getName()+")");
        if (item.getIs_choose().equals("0")){
            imageView_gone.setSelected(false);
        }else {
            imageView_gone.setSelected(true);
        }

    }
}
