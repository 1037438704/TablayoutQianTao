package zdl.tianxunda.com.tablayoutqiantao.fgt;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import com.kongzue.baseokhttp.util.Parameter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import zdl.tianxunda.com.tablayoutqiantao.R;
import zdl.tianxunda.com.tablayoutqiantao.adp.MarketAllAdp;
import zdl.tianxunda.com.tablayoutqiantao.bean.MarketAllTickersBean;
import zdl.tianxunda.com.tablayoutqiantao.http.HttpUtlis;
import zdl.tianxunda.com.tablayoutqiantao.utlis.MessageEvent;

@SuppressLint("ValidFragment")
@Layout(R.layout.fgt_domvmarkets)
public class DOMVMarketsFgt extends BaseFragment {

    private RecyclerView recyclerView;
    private String market_id = "";
    private int sort = 0;
    private int page = 1;
    private String transaction_symbol = "";
    private List<MarketAllTickersBean.DataBean.ListBean> marketAllList;
    private TextView text_latest_price, text_gonggao;
    private SmartRefreshLayout refreshLayout;
    private RelativeLayout rl_null;
    private MarketAllAdp marketAllAdp;
    private int latest_price = 1;
    private int latest_price2 = 1;
    private int image;
    private Drawable drawable;

    public DOMVMarketsFgt(String market_id) {
        this.market_id = market_id;
    }

    @Override
    public void initViews() {
        text_gonggao = findViewById(R.id.text_gonggao);
        text_latest_price = findViewById(R.id.text_latest_price);
        refreshLayout = findViewById(R.id.refreshLayout);
        rl_null = findViewById(R.id.rl_null);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(me));
        marketAllList = new ArrayList<>();
        EventBus.getDefault().register(this);
    }

    @Override
    public void initDatas() {
        marketAllTickers();
    }

    @Override
    public void setEvents() {
        //最新价
        text_latest_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                latest_price++;
                Drawable drawable2 = getResources().getDrawable(R.mipmap.icon_home_sort_default);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                text_gonggao.setCompoundDrawables(null, null, drawable2, null);
                latest_price2 = 1;
                if (latest_price == 4) {
                    latest_price = 1;
                }
                if (latest_price == 1) {
                    sort = 0;
                    image = R.mipmap.icon_home_sort_default;
                } else if (latest_price == 2) {
                    sort = 2;
                    image = R.mipmap.icon_home_upper_select;
                } else if (latest_price == 3) {
                    sort = 1;
                    image = R.mipmap.icon_home_lower_select;
                }
                drawable = getResources().getDrawable(image);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                text_latest_price.setCompoundDrawables(null, null, drawable, null);

                marketAllTickers();
            }
        });
        //公告
        text_gonggao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                latest_price2++;
                Drawable drawable2 = getResources().getDrawable(R.mipmap.icon_home_sort_default);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                text_latest_price.setCompoundDrawables(null, null, drawable2, null);
                latest_price = 1;
                if (latest_price2 == 4) {
                    latest_price2 = 1;
                }
                if (latest_price2 == 1) {
                    image = R.mipmap.icon_home_sort_default;
                    sort = 0;
                } else if (latest_price2 == 2) {
                    image = R.mipmap.icon_home_upper_select;
                    sort = 3;
                } else if (latest_price2 == 3) {
                    image = R.mipmap.icon_home_lower_select;
                    sort = 4;
                }

                drawable = getResources().getDrawable(image);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                text_gonggao.setCompoundDrawables(null, null, drawable, null);

                marketAllTickers();
            }
        });

//刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                marketAllTickers();
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                marketAllTickers();
            }
        });
    }


    private void marketAllTickers() {
        HttpRequest.getInstance(me).setHeaders(new Parameter().add("token", "1")).postRequest(HttpUtlis.ALL_MARKETS,
                new Parameter()
                        .add("market_id", market_id)
                        .add("sort", String.valueOf(sort))
                        .add("p", String.valueOf(page))
                        .add("transaction_symbol", transaction_symbol),
                new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        if (error == null) {
                            refreshLayout.finishRefresh();
                            refreshLayout.finishLoadmore();
                            log("========ALL_MARKETS========" + response);
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String code = jsonObject.getString("code");
                                if (code.equals("1")) {
                                    Gson gson = new Gson();
                                    MarketAllTickersBean marketAllTickersBean = gson.fromJson(response, MarketAllTickersBean.class);
                                    MarketAllTickersBean.DataBean data = marketAllTickersBean.getData();
                                    if (page == 1) {
                                        marketAllList.clear();
                                        if (data.getList().size() == 0) {
                                            rl_null.setVisibility(View.VISIBLE);
                                            recyclerView.setVisibility(View.GONE);
                                        } else {
                                            rl_null.setVisibility(View.GONE);
                                            recyclerView.setVisibility(View.VISIBLE);
                                            marketAllList.addAll(data.getList());
                                            if (marketAllAdp == null) {
                                                marketAllAdp = new MarketAllAdp(R.layout.item_domvmarkets_list, marketAllList);
                                                recyclerView.setAdapter(marketAllAdp);
                                            } else {
                                                marketAllAdp.notifyDataSetChanged();
                                            }
                                        }
                                    } else {
                                        List list = data.getList();
                                        if (list.size() == 0) {
                                            toast("没有更多数据了");
                                            return;
                                        }
                                        marketAllList.addAll(list);
                                        marketAllAdp.notifyDataSetChanged();
                                    }
                                    return;
                                }
                                if (jsonObject.getString("message").equals("暂无数据")) {
                                    return;
                                }
                                toast(jsonObject.getString("message"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent){
        if (messageEvent.getName() == 1){
            transaction_symbol = messageEvent.getNameID();
            marketAllTickers();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
