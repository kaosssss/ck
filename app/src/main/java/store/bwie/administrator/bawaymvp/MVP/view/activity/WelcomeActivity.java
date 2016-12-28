package store.bwie.administrator.bawaymvp.MVP.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import store.bwie.administrator.bawaymvp.MVP.utils.GetSpUtil;
import store.bwie.administrator.bawaymvp.MVP.view.adapter.WelcomeAdapter;
import store.bwie.administrator.bawaymvp.R;

/**
 * @作者 : 石振伟
 * @日期 : 2016/12/27 19:40
 *引导页
 */

public class WelcomeActivity extends Activity {
    private ViewPager pager;
    private List<ImageView> list;
    private LinearLayout layout;
    private List<ImageView> shapo;
    private Button logActivity;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        //初始化控件
        initView();
        //初始化数据
        initData();
        //绑定适配器
        pager.setAdapter(new WelcomeAdapter(list));
        //viewpager滑动监听
        pagerListener();
        //跳转页面监听
        buttListener();
        //得到SP对象
        sp = GetSpUtil.GetSp("yd", WelcomeActivity.this);
        //判断是否第一次登陆
       if(sp.getBoolean("flag",false)){
           startHome();
       }
    }
    private void startHome(){
        startActivity(new Intent(WelcomeActivity.this,DelayedskipActivity.class));
        finish();
    }
    private void buttListener() {
        logActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOneLogin();
                startHome();
            }
        });
    }

    private void pagerListener() {
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==(list.size()-1)){
                    logActivity.setVisibility(View.VISIBLE);

                }else{
                    logActivity.setVisibility(View.GONE);
                }
                for (int i = 0; i < list.size(); i++) {
                    if(i==position){
                        shapo.get(i).setSelected(true);
                    }
                    else{
                        shapo.get(i).setSelected(false);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initData() {
        list=new ArrayList<ImageView>();
        shapo=new ArrayList<ImageView>();
        for (int i = 0; i < 4; i++) {
            ImageView pic=new ImageView(WelcomeActivity.this);
            pic.setImageResource(R.mipmap.ic_launcher);
            list.add(pic);
            ImageView shape=new ImageView(WelcomeActivity.this);
            shape.setImageResource(R.drawable.welcome_select);
            if(i==0){
                shape.setSelected(true);
            }
            else{
                shape.setSelected(false);
            }
            shapo.add(shape);
            shape.setPadding(10,0,0,0);
            layout.addView(shape);
        }
    }

    private void initView() {
        pager=(ViewPager) findViewById(R.id.welcome_pager);
        layout=(LinearLayout) findViewById(R.id.welcome_linear);
        logActivity=(Button) findViewById(R.id.log_home);
    }

    public void isOneLogin() {

        SharedPreferences.Editor edi=sp.edit();
        edi.putBoolean("flag",true);
        edi.commit();
    }
}
