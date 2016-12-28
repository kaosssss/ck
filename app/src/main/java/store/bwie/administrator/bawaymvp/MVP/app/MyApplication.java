package store.bwie.administrator.bawaymvp.MVP.app;

import android.app.Application;
import android.content.Context;

import store.bwie.administrator.bawaymvp.MVP.utils.OkhttpUtils;

/**
 * Created by Administrator on 2016/12/28.
 */

public class MyApplication extends Application {
    public static OkhttpUtils okUtils;
    public static Context con;
    @Override
    public void onCreate() {
        super.onCreate();
    con=getApplicationContext();
    }
    public static OkhttpUtils getOkhttp(){
        okUtils=OkhttpUtils.instance(con);
        return okUtils;
    }
}
