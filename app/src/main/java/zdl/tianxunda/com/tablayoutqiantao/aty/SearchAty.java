package zdl.tianxunda.com.tablayoutqiantao.aty;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kongzue.baseframework.BaseActivity;
import com.kongzue.baseframework.interfaces.DarkNavigationBarTheme;
import com.kongzue.baseframework.interfaces.DarkStatusBarTheme;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseframework.interfaces.NavigationBarBackgroundColor;
import com.kongzue.baseframework.util.JumpParameter;
import com.kongzue.baseframework.util.Preferences;
import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import com.kongzue.baseokhttp.util.Parameter;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import zdl.tianxunda.com.tablayoutqiantao.R;
import zdl.tianxunda.com.tablayoutqiantao.adp.HistoryAdp;
import zdl.tianxunda.com.tablayoutqiantao.adp.SearchAdp;
import zdl.tianxunda.com.tablayoutqiantao.bean.SearchBean;
import zdl.tianxunda.com.tablayoutqiantao.bean.SearchSymbolAdp;
import zdl.tianxunda.com.tablayoutqiantao.bean.SearchSymbolList2Adp;
import zdl.tianxunda.com.tablayoutqiantao.bean.SearchSymbolListAdp;
import zdl.tianxunda.com.tablayoutqiantao.bean.SearchXQBean;
import zdl.tianxunda.com.tablayoutqiantao.http.HttpUtlis;

/**
 * 创建人： Nine tails fox
 * 创建时间： 2018/9/10 9:00
 * 功能描述： 搜索界面
 * 联系方式：1037438704@qq.com
 *
 * @author dell-pc
 */
@Layout(R.layout.aty_search) //布局
@DarkStatusBarTheme(true) //开启顶部状态栏图标、文字暗色模式
@NavigationBarBackgroundColor(a = 0, r = 0, g = 0, b = 0)
//透明颜色   设置底部导航栏背景颜色（a = 255,r = 255,g = 255,b = 255 黑色的）
@DarkNavigationBarTheme(true) //开启底部导航栏按钮暗色模式
public class SearchAty extends BaseActivity {

    private RecyclerView search_rv, rv_currency, rv_exchange;
    private TextView text_right_more, text_gengduo, text_gengduo_2;
    private ImageView image_search, text_delete;
    private RecyclerView rv_history, search_rv_2;
    private LinearLayout ll_history;
    private EditText edit_search;
    private NestedScrollView nsv;
    private String search_int;
    private SearchAdp searchAdp;
    private SearchSymbolAdp searchSymbolAdp;
    private List<SearchXQBean.DataBean.MarketsListBean> searchMarkets_list;
    private List<SearchXQBean.DataBean.SymbolListBean> searchSymbol_list;
    private SearchSymbolListAdp searchSymbolListAdp;
    private SearchSymbolList2Adp searchSymbolList2Adp;
    private int p_symbol = 1;
    private int p_markets = 1;
    private NestedScrollView ll_bujuyi;
    private String keywords;
    private List<String> list;
    private String history;
    private HistoryAdp historyAdp;

    @Override
    public void initViews() {
        nsv = findViewById(R.id.nsv);
        text_gengduo_2 = findViewById(R.id.text_gengduo_2);
        text_gengduo = findViewById(R.id.text_gengduo);
        ll_bujuyi = findViewById(R.id.ll_bujuyi);
        rv_exchange = findViewById(R.id.rv_exchange);
        rv_exchange.setLayoutManager(new GridLayoutManager(me, 4));
        rv_currency = findViewById(R.id.rv_currency);
        rv_currency.setLayoutManager(new GridLayoutManager(me, 4));
        edit_search = findViewById(R.id.edit_search);
        ll_history = findViewById(R.id.ll_history);
        text_delete = findViewById(R.id.text_delete);
        rv_history = findViewById(R.id.rv_history);
        rv_history.setLayoutManager(new GridLayoutManager(me, 4));
        list = new ArrayList<>();
        image_search = findViewById(R.id.image_search);
        search_rv = findViewById(R.id.search_rv);
        text_right_more = findViewById(R.id.text_right_more);
        search_rv.setLayoutManager(new LinearLayoutManager(me));
        image_search.setFocusable(true);
        image_search.requestFocus();
        image_search.setFocusableInTouchMode(true);
        image_search.requestFocusFromTouch();
        edit_search.addTextChangedListener(watcher);
        searchSymbol_list = new ArrayList<>();
        searchMarkets_list = new ArrayList<>();
        search_rv_2 = findViewById(R.id.search_rv_2);
        search_rv_2.setLayoutManager(new LinearLayoutManager(me));
        history = Preferences.getInstance().getString(me, "hiler", "text_right_more");

        if (!history.equals("")) {
            ll_history.setVisibility(View.VISIBLE);
            log("=====Preferences2=====" + history);
            Gson gson = new Gson();
            Type type = new TypeToken<List<String>>() {
            }.getType();
            List<String> data = gson.fromJson(history, type);
            list.addAll(data);
        }else {
            ll_history.setVisibility(View.GONE);
        }
    }

    @Override
    public void initDatas(JumpParameter jumpParameter) {
        //请求数据
        searchPage();

        //历史记录
        historyAdp = new HistoryAdp(R.layout.item_search_adp, list);
        rv_history.setAdapter(historyAdp);
    }

    private void searchPage() {
//        WaitDialog.show(me, "数据加载中");
        HttpRequest.getInstance(me).setHeaders(new Parameter().add("token", "154174150854542")).postRequest(HttpUtlis.SEARCHINTERFACE,
                new Parameter(),
                new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        if (error == null) {
//                            WaitDialog.dismiss();
                            log("======SEARCHINTERFACE=====" + response);
                            Gson gson = new Gson();
                            SearchBean searchBean = gson.fromJson(response, SearchBean.class);
                            if (searchBean.getCode().equals("1")) {
                                SearchBean.DataBean data = searchBean.getData();
                                //交易所列表
                                if (data.getMarkets_list().size() != 0) {
                                    List<SearchBean.DataBean.MarketsListBean> markets_list = data.getMarkets_list();
                                    searchAdp = new SearchAdp(R.layout.item_search_adp, markets_list);
                                    rv_currency.setAdapter(searchAdp);
                                    adpOnClick1Markets(markets_list);
                                }
                                //币种列表
                                if (data.getSymbol_list().size() != 0) {
                                    List<SearchBean.DataBean.SymbolListBean> symbol_list = data.getSymbol_list();
                                    searchSymbolAdp = new SearchSymbolAdp(R.layout.item_search_adp, symbol_list);
                                    rv_exchange.setAdapter(searchSymbolAdp);
                                    adpOnClick1Symbol(symbol_list);
                                }
                            }
                        }
                    }
                });
    }

    private void adpOnClick1Symbol(final List<SearchBean.DataBean.SymbolListBean> symbol_list) {
        searchSymbolAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                edit_search.setText(symbol_list.get(position).getName());
            }
        });
    }

    private void adpOnClick1Markets(final List<SearchBean.DataBean.MarketsListBean> markets_list) {
        searchAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                edit_search.setText(markets_list.get(position).getDisplay_name());
            }
        });
    }

    @Override
    public void setEvents() {
        //更多
        text_gengduo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p_symbol++;
                search();
            }
        });
        text_gengduo_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p_markets++;
                search();
            }
        });
        //历史搜索删除
        text_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Preferences.getInstance().cleanAll(me, "hiler");
                ll_history.setVisibility(View.GONE);
            }
        });
        historyAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                edit_search.setText(list.get(position));
            }
        });
        //取消
        text_right_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edit_search.getText().toString().trim().equals("")) {
                    if (list.size() == 0) {
                        list.add(edit_search.getText().toString().trim());
                    } else {
                        if (!list.contains(edit_search.getText().toString().trim())) {
                            list.add(edit_search.getText().toString().trim());
                        }
                    }
                    Gson gson = new Gson();
                    String str = gson.toJson(list);
                    Preferences.getInstance().set(me, "hiler", "text_right_more", str);
                    log("-----Preferences1-----" + str);
                }
                finish();
            }
        });
    }

    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.length() >= 1) {
                nsv.setVisibility(View.GONE);
                ll_bujuyi.setVisibility(View.VISIBLE);
                log("======editable=====" + editable.toString());
                //加载数据
                keywords = editable.toString();
                p_symbol = 1;
                p_markets = 1;
                search();
            } else {
                nsv.setVisibility(View.VISIBLE);
                ll_bujuyi.setVisibility(View.GONE);
            }
        }
    };

    private void search() {
        HttpRequest.getInstance(me).setHeaders(new Parameter().add("token", "154174150854542")).postRequest(HttpUtlis.SEARCH,
                new Parameter().add("keywords", keywords)
                        .add("p_symbol", String.valueOf(p_symbol))
                        .add("p_markets", String.valueOf(p_markets)),
                new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        if (error == null) {
                            log("=====SEARCH====" + response);
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                if (jsonObject.getString("code").equals("1")) {
                                    Gson gson = new Gson();
                                    SearchXQBean searchXQBean = gson.fromJson(response, SearchXQBean.class);
                                    SearchXQBean.DataBean data = searchXQBean.getData();

                                    if (p_symbol == 1) {
                                        searchSymbol_list.clear();
                                        searchSymbol_list.addAll(data.getSymbol_list());//币种
                                        if (searchSymbolListAdp == null) {
                                            searchSymbolListAdp = new SearchSymbolListAdp(R.layout.item_search, searchSymbol_list);
                                            search_rv.setAdapter(searchSymbolListAdp);
                                        } else {
                                            searchSymbolListAdp.notifyDataSetChanged();
                                        }
                                    } else {
                                        List<SearchXQBean.DataBean.SymbolListBean> list = data.getSymbol_list();
                                        if (list.size() == 0) {
                                            toast("没有更多数据了");
                                            return;
                                        }
                                        searchSymbol_list.addAll(list);
                                        searchSymbolListAdp.notifyDataSetChanged();
                                    }
                                    onCreateAdp1();
                                    if (p_markets == 1) {
                                        searchMarkets_list.clear();
                                        searchMarkets_list.addAll(data.getMarkets_list());//交易所
                                        if (searchSymbolList2Adp == null) {
                                            searchSymbolList2Adp = new SearchSymbolList2Adp(R.layout.item_search_2, searchMarkets_list);
                                            search_rv_2.setAdapter(searchSymbolList2Adp);
                                        } else {
                                            searchSymbolList2Adp.notifyDataSetChanged();
                                        }
                                    } else {
                                        List list = data.getMarkets_list();
                                        if (list.size() == 0) {
                                            toast("没有更多数据了");
                                            return;
                                        }
                                        searchMarkets_list.addAll(list);
                                        searchSymbolList2Adp.notifyDataSetChanged();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    private void onCreateAdp1() {
        searchSymbolListAdp.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (searchSymbol_list.get(position).getIs_choose().equals("0")) {
                    searchSymbol_list.get(position).setIs_choose("1");
                    //添加币种
                    addMemberSymbol(searchSymbol_list.get(position).getSymbol_id());
                } else {
                    searchSymbol_list.get(position).setIs_choose("0");
                    //删除币种
                    deleteMemberSymbol(searchSymbol_list.get(position).getSymbol_id());
                }
                searchSymbolListAdp.notifyDataSetChanged();
            }
        });
    }

    /**
     * 添加数据
     *
     * @param symbol_id
     */
    private void addMemberSymbol(String symbol_id) {
        HttpRequest.getInstance(me).setHeaders(new Parameter().add("token", "154174150854542")).postRequest(HttpUtlis.ADDCURRENCY,
                new Parameter().add("symbol_id_str",symbol_id),
                new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        if (error == null) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String code = jsonObject.getString("code");
                                if (code.equals("1")) {
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

    /**
     * 删除
     *
     * @param symbol_id
     */
    private void deleteMemberSymbol(String symbol_id) {
        HttpRequest.getInstance(me).setHeaders(new Parameter().add("token", "1")).postRequest(HttpUtlis.DELETIONGCURRENCY,
                new Parameter().add("symbol_id", symbol_id),
                new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        if (error == null) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String code = jsonObject.getString("code");
                                if (code.equals("1")) {
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
}
