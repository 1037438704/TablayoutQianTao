package zdl.tianxunda.com.tablayoutqiantao;

import android.app.Application;

import com.kongzue.baseokhttp.HttpRequest;

/**
 * @author dell-pc
 * @date 2018/9/10
 */

public class MyApplication extends Application {
    public static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        HttpRequest.serviceUrl = "http://app.coinwind.io/index.php/Api/";
    }
    /**
     * 获取Application对象
     *
     * @return
     */
    public static Application getApplication() {
        return instance;
    }
}
