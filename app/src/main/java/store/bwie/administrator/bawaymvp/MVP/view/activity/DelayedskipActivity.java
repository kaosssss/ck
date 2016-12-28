package store.bwie.administrator.bawaymvp.MVP.view.activity;

import android.content.Intent;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import store.bwie.administrator.bawaymvp.R;

/**
 * @作者 : 石振伟
 * @日期 : 2016/12/28 9:48
 *延时跳转页面
 */

    public class DelayedskipActivity extends BaseActivity {
    private TextView textview;
    private Timer timer;
    private int i=3;
    @Override
    int createView() {
        return R.layout.delayedskip_activity;
    }
    @Override
    void initView() {
        textview= (TextView) findViewById(R.id.timeText);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(timer==null){
            timer=new Timer();
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            i--;
                            textview.setText(i+"秒后跳转");
                            if(i==0){
                                startActivity(new Intent(DelayedskipActivity.this,MainActivity.class));
                                finish();
                            }
                        }
                    });
                }
            },0,1000);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer=null;
    }

    @Override
    void initData() {

    }

}
