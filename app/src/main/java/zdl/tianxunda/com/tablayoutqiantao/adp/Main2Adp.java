package zdl.tianxunda.com.tablayoutqiantao.adp;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zdl.tianxunda.com.tablayoutqiantao.R;

/**
 * Created by dell-pc on 2018/11/12.
 */

public class Main2Adp extends BaseQuickAdapter<String, BaseViewHolder> {
    public Main2Adp(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text, item);
    }
}
