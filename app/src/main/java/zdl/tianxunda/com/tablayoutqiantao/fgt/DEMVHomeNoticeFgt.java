package zdl.tianxunda.com.tablayoutqiantao.fgt;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
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
import zdl.tianxunda.com.tablayoutqiantao.adp.MarketAnnouncementListAdp;
import zdl.tianxunda.com.tablayoutqiantao.bean.MarketAnnouncementListBean;
import zdl.tianxunda.com.tablayoutqiantao.http.HttpUtlis;
import zdl.tianxunda.com.tablayoutqiantao.utlis.MessageEvent;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
@Layout(R.layout.fragment_blank)
public class DEMVHomeNoticeFgt extends BaseFragment {
    private RecyclerView demv_home_rv;
    private MarketAnnouncementListAdp marketAnnouncementListAdp;
    private List<String> list;
    private String market_id = "";
    private String announcement_type_id = "";
    private int page = 1;
    private SmartRefreshLayout refreshLayout;
    private RelativeLayout rl_null;
    private List<MarketAnnouncementListBean.DataBean.AnnouncementListBean> announcement_list;

    public DEMVHomeNoticeFgt(String market_id) {
        this.market_id = market_id;
    }

    @Override
    public void initViews() {
        refreshLayout = findViewById(R.id.refreshLayout);
        rl_null = findViewById(R.id.rl_null);
        demv_home_rv = findViewById(R.id.demv_home_rv);
        demv_home_rv.setLayoutManager(new LinearLayoutManager(me));
        list = new ArrayList<>();
        announcement_list = new ArrayList<>();
    }

    @Override
    public void initDatas() {
//        WaitDialog.show(me, "数据加载中");
        marketAnnouncementList();
        for (int i = 0; i < 10; i++) {
            list.add("第" + i);
        }
    }

    @Override
    public void setEvents() {
        //刷新
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                marketAnnouncementList();
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                marketAnnouncementList();
            }
        });
    }

    private void marketAnnouncementList() {
        HttpRequest.getInstance(me).setHeaders(new Parameter().add("token", "1")).postRequest(HttpUtlis.BULLETIN_LIST,
                new Parameter()
                        .add("markets_id", market_id)
                        .add("p", String.valueOf(page))
                        .add("announcement_type_id", announcement_type_id),
                new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        if (error == null) {
                            log("=======BULLETIN_LIST======" + response);
                            refreshLayout.finishRefresh();
                            refreshLayout.finishLoadmore();
//                            WaitDialog.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String code = jsonObject.getString("code");
                                if (code.equals("1")) {
                                    Gson gson = new Gson();
                                    MarketAnnouncementListBean marketAnnouncementListBean = gson.fromJson(response, MarketAnnouncementListBean.class);
                                    MarketAnnouncementListBean.DataBean data = marketAnnouncementListBean.getData();
                                    if (page == 1) {
                                        announcement_list.clear();
                                        if (data.getAnnouncement_list().size() == 0) {
                                            rl_null.setVisibility(View.VISIBLE);
                                            demv_home_rv.setVisibility(View.GONE);
                                        } else {
                                            rl_null.setVisibility(View.GONE);
                                            demv_home_rv.setVisibility(View.VISIBLE);
                                            announcement_list.addAll(data.getAnnouncement_list());
                                            if (marketAnnouncementListAdp == null) {
                                                marketAnnouncementListAdp = new MarketAnnouncementListAdp(R.layout.item_home_notice, announcement_list);
                                                demv_home_rv.setAdapter(marketAnnouncementListAdp);
                                            } else {
                                                marketAnnouncementListAdp.notifyDataSetChanged();
                                            }
                                            //适配器点击事件
                                            adapterOnClick();
                                        }
                                    } else {
                                        List list = data.getAnnouncement_list();
                                        if (list.size() == 0) {
                                            toast("没有更多数据了");
                                            return;
                                        }
                                        announcement_list.addAll(list);
                                        marketAnnouncementListAdp.notifyDataSetChanged();
                                        //适配器点击事件
                                        adapterOnClick();
                                    }
                                    return;
                                }
                                String message = jsonObject.getString("message");
                                toast(message);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    private void adapterOnClick() {
//        marketAnnouncementListAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                jump(DetailsOfTheAnnouncementAty.class, new JumpParameter()
//                        .put("information_id", announcement_list.get(position).getInformation_id()));
//            }
//        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        if (messageEvent.getName() == 2) {
            announcement_type_id = messageEvent.getNameID();
            marketAnnouncementList();
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
