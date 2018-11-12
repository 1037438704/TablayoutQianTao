package zdl.tianxunda.com.tablayoutqiantao.fgt;


import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.kongzue.baseframework.BaseFragment;
import com.kongzue.baseframework.interfaces.Layout;
import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;
import com.kongzue.baseokhttp.util.Parameter;

import org.json.JSONException;
import org.json.JSONObject;

import zdl.tianxunda.com.tablayoutqiantao.R;
import zdl.tianxunda.com.tablayoutqiantao.http.HttpUtlis;

/**
 * A simple {@link Fragment} subclass.
 * @author dell-pc
 */
@SuppressLint("ValidFragment")
@Layout(R.layout.fgt_introduce)
public class IntroduceFgt extends BaseFragment {
    private String market_id = "";

    private TextView text_market_desc, textz_address, text_official_website, text_handling_fee;

    public IntroduceFgt(String market_id) {
        this.market_id = market_id;
    }

    @Override
    public void initViews() {
        text_market_desc = findViewById(R.id.text_market_desc);
        textz_address = findViewById(R.id.textz_address);
        text_official_website = findViewById(R.id.text_official_website);
        text_handling_fee = findViewById(R.id.text_handling_fee);

    }

    @Override
    public void initDatas() {
//        EXCHANGE_DETAILS
//        WaitDialog.show(me, "数据加载中");
        marketInfo();
    }


    @Override
    public void setEvents() {

    }

    private void marketInfo() {
        HttpRequest.getInstance(me).setHeaders(new Parameter().add("token", "1")).postRequest(HttpUtlis.EXCHANGE_DETAILS,
                new Parameter()
                        .add("market_id", market_id),
                new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                        log("=====EXCHANGE_DETAILS======" + response);
                        if (error == null) {
//                            WaitDialog.dismiss();
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String code = jsonObject.getString("code");
                                if (code.equals("1")) {
                                    JSONObject data = jsonObject.getJSONObject("data");
                                    text_market_desc.setText(data.getString("market_desc"));
                                    textz_address.setText(data.getString("address"));
                                    text_official_website.setText(data.getString("official_website"));
                                    text_handling_fee.setText(data.getString("handling_fee"));
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
}
