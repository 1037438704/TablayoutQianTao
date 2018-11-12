package zdl.tianxunda.com.tablayoutqiantao.adp;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import zdl.tianxunda.com.tablayoutqiantao.R;

/**
 * Created by dell-pc on 2018/10/17.
 */

public class HistoryAdp extends BaseQuickAdapter<String, BaseViewHolder> {

    public HistoryAdp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text_bitcoin, item.toString().trim());
    }
}
