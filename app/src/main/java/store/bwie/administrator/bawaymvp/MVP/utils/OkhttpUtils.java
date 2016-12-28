package store.bwie.administrator.bawaymvp.MVP.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import store.bwie.administrator.bawaymvp.MVP.model.bean.PostMap;

/**
 * Created by Administrator on 2016/12/28.
 */

public class OkhttpUtils {
    private static OkhttpUtils mOkhttpUtils;
    private Gson mGson;
    private Handler mHandler;
    private OkHttpClient okhttp;
    private OkhttpUtils(Context con){
        okhttp=new OkHttpClient();
        mGson = new Gson();
        mHandler=new Handler(Looper.getMainLooper());
    }
    public static OkhttpUtils instance(Context con){
        if(mOkhttpUtils==null){
            synchronized (OkhttpUtils.class){
                if(mOkhttpUtils==null) {
                    mOkhttpUtils = new OkhttpUtils(con);
                }
            }
        }
        return mOkhttpUtils;
    }
    public <T> void getJson2Bean(String url, final Class<T> clazz, final RequestInterface requestInterface){
        final Request request=new Request.Builder().url(url).build();
        okhttp.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                requestInterface.fail("请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               T requst= mGson.fromJson(response.body().string(), clazz);
                requestInterface.succeed(requst);
            }
        });
}
    public<T> void postJson2Bean(String url,Class<T> clazz,RequestInterface requestInterface,PostMap... postMaps){

    }

}
