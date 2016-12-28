package store.bwie.administrator.bawaymvp.MVP.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/12/27.
 */

public class GetSpUtil {
    private static SharedPreferences sharedPreferences;
    public static SharedPreferences GetSp(String FileName,Context con){
        sharedPreferences=con.getSharedPreferences(FileName,con.MODE_PRIVATE);
        return sharedPreferences;
    }

}
