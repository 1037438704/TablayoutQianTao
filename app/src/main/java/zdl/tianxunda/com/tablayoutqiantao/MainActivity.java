package zdl.tianxunda.com.tablayoutqiantao;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import com.kongzue.baseokhttp.util.Parameter;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import zdl.tianxunda.com.tablayoutqiantao.adp.FgtAdapter;
import zdl.tianxunda.com.tablayoutqiantao.adp.MarketAllTickersAdp;
import zdl.tianxunda.com.tablayoutqiantao.adp.MarketAnnouncementAdp;
import zdl.tianxunda.com.tablayoutqiantao.aty.SearchAty;
import zdl.tianxunda.com.tablayoutqiantao.bean.MarketAllTickersBean;
import zdl.tianxunda.com.tablayoutqiantao.bean.MarketAnnouncementListBean;
import zdl.tianxunda.com.tablayoutqiantao.fgt.DEMVHomeNoticeFgt;
import zdl.tianxunda.com.tablayoutqiantao.fgt.DOMVMarketsFgt;
import zdl.tianxunda.com.tablayoutqiantao.fgt.IntroduceFgt;
import zdl.tianxunda.com.tablayoutqiantao.http.HttpUtlis;
import zdl.tianxunda.com.tablayoutqiantao.utlis.MessageEvent;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2018/11/10 10:00
 * 功能描述：
 * 联系方式：1037438704@qq.com
 *
 * @author dell-pc
 */

@Layout(R.layout.activity_main)
@DarkStatusBarTheme(true)  //开启顶部状态栏图标、false 白色 true 黑色
@NavigationBarBackgroundColor(a = 0, r = 0, g = 0, b = 0)
//透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的）
@DarkNavigationBarTheme(true) //开启底部导航栏按钮暗色
public class MainActivity extends BaseActivity {
    private TabLayout home_fgt_tab;
    private ViewPager home_viewPager;
    private List<Fragment> data;
    private List<String> lists;
    private FgtAdapter fgtAdapter;
    private ImageView image_back, home_iamge_search;
    private LinearLayout ll_title, ll_gone;
    private boolean aBoolean = false;
    private RecyclerView notice_rv_gril;
    private MarketAllTickersAdp marketAllTickersAdp;

    private List<String> listString;
    private int mimapint;
    private String name;
    private TextView text_name;
    private String market_id = "";
    private int sort = 0;
    private int page = 1;
    private String transaction_symbol = "全部";
    private List<MarketAllTickersBean.DataBean.TransactionSymbolListBean> transaction_symbol_list;
    private int count = 1;
    private int countnum = 1;
    private MarketAnnouncementAdp marketAnnouncementAdp;
    private List<MarketAnnouncementListBean.DataBean.AnnouncementTypeBean> announcement_type;
    private StringBuffer marketsSb;
    private int styleLeixin = 0;

    @Override
    public void initViews() {
        transaction_symbol_list = new ArrayList<>();
        listString = new ArrayList<>();
        data = new ArrayList<>();
        announcement_type = new ArrayList<>();
        lists = new ArrayList<>();
        text_name = findViewById(R.id.text_name);
        notice_rv_gril = findViewById(R.id.notice_rv_gril);
        ll_gone = findViewById(R.id.ll_gone);
        ll_title = findViewById(R.id.ll_title);
        home_iamge_search = findViewById(R.id.home_iamge_search);
        image_back = findViewById(R.id.image_back);
        home_fgt_tab = findViewById(R.id.home_fgt_tab);
        home_viewPager = findViewById(R.id.home_viewPager);
        mimapint = R.mipmap.icon_open_up;

    }

    @Override
    public void initDatas(JumpParameter jumpParameter) {
        data.add(new DOMVMarketsFgt("1"));//全部市场
        data.add(new DEMVHomeNoticeFgt("1"));//公告
        data.add(new IntroduceFgt("1"));//交易所介绍
        home_viewPager.setOffscreenPageLimit(4);
        lists.add("全部市场");
        lists.add("公告");
        lists.add("交易所介绍");
        fgtAdapter = new FgtAdapter(getSupportFragmentManager(), data, null);
        home_viewPager.setAdapter(fgtAdapter);

        home_fgt_tab.addTab(home_fgt_tab.newTab().setCustomView(tab_icon(lists.get(0), mimapint)));
        home_fgt_tab.addTab(home_fgt_tab.newTab().setCustomView(tab_icon(lists.get(1), mimapint)));
        home_fgt_tab.addTab(home_fgt_tab.newTab().setCustomView(tab_icon(lists.get(2), R.mipmap.icon_transparent)));

        home_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(home_fgt_tab));

        home_fgt_tab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(home_viewPager));

        fgtAdapter.notifyDataSetChanged();
        marketAnnouncementList();
        marketAllTickers();

    }


    /**
     * 公告
     */
    private void marketAnnouncementList() {
        HttpRequest.getInstance(me)
                .setHeaders(new Parameter().add("token", "1"))
                .postRequest(HttpUtlis.BULLETIN_LIST,
                        new Parameter()
                                .add("markets_id", "1")
                                .add("p", "1")
                                .add("announcement_type_id", ""),
                        new ResponseListener() {
                            @Override
                            public void onResponse(String response, Exception error) {
                                if (error == null) {
                                    log("=======BULLETIN_LIST======" + response);
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        String code = jsonObject.getString("code");
                                        if (code.equals("1")) {
                                            if (countnum == 2) {
                                                return;
                                            }
                                            Gson gson = new Gson();
                                            MarketAnnouncementListBean marketAnnouncementListBean = gson.fromJson(response, MarketAnnouncementListBean.class);
                                            MarketAnnouncementListBean.DataBean data = marketAnnouncementListBean.getData();
                                            announcement_type.addAll(data.getAnnouncement_type());
                                            for (int i = 0; i < announcement_type.size(); i++) {
                                                announcement_type.get(i).aBoolean = false;
                                            }
                                            countnum = 2;
//                                            notice_rv_gril.setLayoutManager(new GridLayoutManager(me, 4));
//                                            marketAnnouncementAdp = new MarketAnnouncementAdp(R.layout.item_rv_flash, announcement_type);
//                                            notice_rv_gril.setAdapter(marketAnnouncementAdp);
//                                            onClickAmark();
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

    /**
     * 全部市场
     */
    private void marketAllTickers() {
        HttpRequest.getInstance(me).setHeaders(new Parameter().add("token", "1")).postRequest(HttpUtlis.ALL_MARKETS,
                new Parameter()
                        .add("market_id", "1")
                        .add("sort", "1")
                        .add("p", "1")
                        .add("transaction_symbol", "全部"),
                new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        if (error == null) {
                            log("========ALL_MARKETS========" + response);
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String code = jsonObject.getString("code");
                                if (code.equals("1")) {
                                    if (count == 2) {
                                        return;
                                    }
                                    Gson gson = new Gson();
                                    MarketAllTickersBean marketAllTickersBean = gson.fromJson(response, MarketAllTickersBean.class);
                                    MarketAllTickersBean.DataBean data = marketAllTickersBean.getData();
                                    transaction_symbol_list.addAll(data.getTransaction_symbol_list());
                                    for (int i = 0; i < transaction_symbol_list.size(); i++) {
                                        transaction_symbol_list.get(i).aBoolean = false;
                                    }
                                    log("========ALL_MARKETS========" + transaction_symbol_list.get(0).getTransaction_symbol());
                                    notice_rv_gril.setLayoutManager(new LinearLayoutManager(me));
                                    marketAllTickersAdp = new MarketAllTickersAdp(R.layout.item_qexchang_list, transaction_symbol_list);
                                    notice_rv_gril.setAdapter(marketAllTickersAdp);
                                    onClickAll();
                                    count = 2;
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


    /**
     * 多选点击事件
     */
    private void onClickAmark() {
        marketAnnouncementAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                styleLeixin = position;
                if (announcement_type.get(position).aBoolean == true) {
                    announcement_type.get(position).aBoolean = false;
                } else {
                    announcement_type.get(position).aBoolean = true;
                }
                marketsSb = new StringBuffer();
                marketsSb.setLength(0);
                for (int i = 0; i < announcement_type.size(); i++) {
                    if (announcement_type.get(i).aBoolean == true) {
                        marketsSb.append(announcement_type.get(i).getAnnouncement_type_id()).append(",");
                    }
                }
                if (marketsSb.length() > 0) {
                    System.out.println(marketsSb.deleteCharAt(marketsSb.length() - 1));
                }
                //在这里发送给碎片
                EventBus.getDefault().post(new MessageEvent(2, String.valueOf(marketsSb)));
                marketAnnouncementAdp.notifyDataSetChanged();
            }
        });
    }

    /**
     * 单选点击事件
     */
    private void onClickAll() {
        marketAllTickersAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                marketsSb = new StringBuffer();
                for (int i = 0; i < transaction_symbol_list.size(); i++) {
                    transaction_symbol_list.get(i).aBoolean = false;
                }
                transaction_symbol_list.get(position).aBoolean = true;
                transaction_symbol = transaction_symbol_list.get(position).getTransaction_symbol();
                //将消息传给碎片
                EventBus.getDefault().post(new MessageEvent(1, transaction_symbol_list.get(position).getTransaction_symbol()));
                marketAllTickersAdp.notifyDataSetChanged();
                ll_gone.setVisibility(View.GONE);
                aBoolean = false;

            }
        });
    }

    private View tab_icon(String name, int iconID) {
        View newtab = LayoutInflater.from(me).inflate(R.layout.item_tablayout, null);
        TextView tv = newtab.findViewById(R.id.tabtext);
        tv.setText(name);
        ImageView im = newtab.findViewById(R.id.tabicon);
        im.setImageResource(iconID);
        return newtab;
    }

    @Override
    public void setEvents() {
        //返回
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //搜索
        home_iamge_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump(SearchAty.class);
            }
        });
        //tablayout的点击事件
        home_fgt_tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 2) {
                    ll_gone.setVisibility(View.GONE);
                    aBoolean = false;
                    return;
                }

                if (tab.getPosition() == 0) {
                    notice_rv_gril.setLayoutManager(new LinearLayoutManager(me));
                    marketAllTickersAdp = new MarketAllTickersAdp(R.layout.item_qexchang_list, transaction_symbol_list);
                    notice_rv_gril.setAdapter(marketAllTickersAdp);
                    onClickAll();
                } else if (tab.getPosition() == 1) {
                    notice_rv_gril.setLayoutManager(new GridLayoutManager(me, 4));
                    marketAnnouncementAdp = new MarketAnnouncementAdp(R.layout.item_rv_flash, announcement_type);
                    notice_rv_gril.setAdapter(marketAnnouncementAdp);
                    onClickAmark();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 2) {
                    ll_gone.setVisibility(View.GONE);
                    aBoolean = false;
                    return;
                }

                if (aBoolean == false) {
                    ll_gone.setVisibility(View.VISIBLE);
                    aBoolean = true;

                } else {
                    ll_gone.setVisibility(View.GONE);
                    aBoolean = false;
                }
            }
        });
        ll_gone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_gone.setVisibility(View.GONE);
                aBoolean = false;
            }
        });
    }
}
