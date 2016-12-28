package store.bwie.administrator.bawaymvp.MVP.presenter;

import store.bwie.administrator.bawaymvp.MVP.view.viewinterrfase.BaseView;

/**
 * @作者 : 石振伟
 * @日期 : 2016/12/28 8:51
 *presenter基类
 */

public class BasePresenter<T extends BaseView> {
    private T view;
     public void addView(T view) {
        this.view = view;
    }
    public T getViews(){
        return view;
    }
}
