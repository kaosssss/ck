package store.bwie.administrator.bawaymvp.MVP.utils;

/**
 * Created by Administrator on 2016/12/28.
 */

public interface RequestInterface {
    void fail(String request);
    <T>void succeed(T request);
}
