package zdl.tianxunda.com.tablayoutqiantao.aty;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.HorizontalScrollView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jarvislau.destureviewbinder.GestureViewBinder;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;

import java.util.ArrayList;
import java.util.List;

import zdl.tianxunda.com.tablayoutqiantao.R;
import zdl.tianxunda.com.tablayoutqiantao.adp.Main2Adp;

@Layout(R.layout.activity_main2)
@DarkStatusBarTheme(true)  //开启顶部状态栏图标、false 白色 true 黑色
@NavigationBarBackgroundColor(a = 0, r = 0, g = 0, b = 0)
//透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的）
@DarkNavigationBarTheme(true) //开启底部导航栏按钮暗色
public class Main2Activity extends BaseActivity {

    public RecyclerView recyclerView;
    private List<String> list;
    private Main2Adp main2Adp;
    private HorizontalScrollView horizontalScrollView;
    private NestedScrollView sor;

    @Override
    public void initViews() {
        sor = findViewById(R.id.sor);
        horizontalScrollView = findViewById(R.id.horizontalScrollView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(me, 50));
        list = new ArrayList<>();

    }

    @Override
    public void initDatas(JumpParameter paramer) {
        for (int i = 0; i < 500; i++) {
            list.add("" + i);
        }
//        item_layout_yiqian
        main2Adp = new Main2Adp(R.layout.item_layout_yiqian, list);
        recyclerView.setAdapter(main2Adp);
        GestureViewBinder.bind(this, horizontalScrollView, recyclerView);
    }

    @Override
    public void setEvents() {
        main2Adp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toast(list.get(position));
            }
        });
    }

}
