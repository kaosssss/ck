package store.bwie.administrator.bawaymvp.MVP.view.viewinterrfase;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * @作者 : 石振伟
 * @日期 : 2016/12/28 8:51
 *主页面的回调
 */

public interface HomeView extends BaseView {
    //添加第一个fragment
    void addViews(Fragment fragment);
    //替换fragment
    void    show(Fragment fragment1,Fragment fragment2);
}
