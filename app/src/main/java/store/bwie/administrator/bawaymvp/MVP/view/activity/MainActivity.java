package store.bwie.administrator.bawaymvp.MVP.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import store.bwie.administrator.bawaymvp.MVP.presenter.HomePresenter;
import store.bwie.administrator.bawaymvp.MVP.view.viewinterrfase.HomeView;
import store.bwie.administrator.bawaymvp.R;

public class MainActivity extends BaseActivity implements HomeView {
    private RadioGroup group;
    private final int HOME = 0, CATEGORY = 1, SHOPPINGCART = 2, MUTE = 3;
    HomePresenter home = new HomePresenter(this);
    private FragmentManager fm;

    //返回要加载的layout
    @Override
    int createView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();

        //显示第一个页面
        home.addFragment();
        //Radiogroup监听
        groupClick();
    }

    private void groupClick() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.GroupHome:
                        home.replace(HOME);
                        break;
                    case R.id.Groupcategory:
                        home.replace(CATEGORY);
                        break;
                    case R.id.Groupshoppingcart:
                        home.replace(SHOPPINGCART);
                        break;
                    case R.id.GroupMute:
                        home.replace(MUTE);
                        break;
                }
            }
        });
    }

    @Override
    void initView() {
        group = (RadioGroup) findViewById(R.id.Home_group);
    }

    @Override
    void initData() {
        fm = getSupportFragmentManager();
    }

    //第一次显示的页面
    @Override
    public void addViews(Fragment fragment) {
        //获得Fragment事物管理器添加fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.Home_Frame, fragment).commit();
    }

    //替换页面
    @Override
    public void show(Fragment fragment1, Fragment fragment2) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        //判断要显示的fragment是否添加过
        if (fragment2.isAdded()) {
            fragmentTransaction.hide(fragment1).show(fragment2).commit();
        } else {
            fragmentTransaction.hide(fragment1).add(R.id.Home_Frame, fragment2).commit();
        }
    }

}
