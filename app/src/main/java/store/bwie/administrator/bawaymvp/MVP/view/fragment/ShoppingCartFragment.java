package store.bwie.administrator.bawaymvp.MVP.view.fragment;

import android.view.View;

import store.bwie.administrator.bawaymvp.R;

/**
 * @作者 : 石振伟
 * @日期 : 2016/12/28 8:49
 *购物车页面
 */

public class ShoppingCartFragment extends BaseFragment {
    @Override
    protected View setView() {
        View view=View.inflate(getActivity(), R.layout.shoppingcart_fragment,null);
        return view;
    }
}
