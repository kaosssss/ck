package store.bwie.administrator.bawaymvp.MVP.presenter;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import store.bwie.administrator.bawaymvp.MVP.view.fragment.HomeFragment;
import store.bwie.administrator.bawaymvp.MVP.view.fragment.MuteFragment;
import store.bwie.administrator.bawaymvp.MVP.view.fragment.PcategoryFragment;
import store.bwie.administrator.bawaymvp.MVP.view.fragment.ShoppingCartFragment;
import store.bwie.administrator.bawaymvp.MVP.view.viewinterrfase.HomeView;

/**
 * @作者 : 石振伟
 * @日期 : 2016/12/28 8:50
 *主页面
 */
    public class HomePresenter extends BasePresenter<HomeView>{
    private List<Fragment> list;
    private int flag=0;
    HomeView home;
    public HomePresenter(HomeView home) {
        this.home = home;
    }
    public void addFragment(){
        initData();
        addView(home);
        getViews().addViews(list.get(0));
    }
    private void initData(){
        list=new ArrayList<Fragment>();
        list.add(new HomeFragment());
        list.add(new PcategoryFragment());
        list.add(new ShoppingCartFragment());
        list.add(new MuteFragment());
    }
    public void replace(int id){
//        switch (id){
//            case 0:getViews().replace();break;
//            case 1:getViews().replace();break;
//            case 2:getViews().replace();break;
//            case 3:getViews().replace();break;
//        }
        if(id==-1){
            getViews().show(list.get(0),null);return;
        }
        getViews().show(list.get(flag),list.get(id));
        flag=id;
    }
}
