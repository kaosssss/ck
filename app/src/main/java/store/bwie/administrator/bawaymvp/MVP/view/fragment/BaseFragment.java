package store.bwie.administrator.bawaymvp.MVP.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import store.bwie.administrator.bawaymvp.MVP.app.MyApplication;
import store.bwie.administrator.bawaymvp.MVP.utils.OkhttpUtils;

/**
 * Created by Administrator on 2016/12/27.
 */

public abstract class BaseFragment extends Fragment {
    protected abstract View setView();
    protected OkhttpUtils okUtils=MyApplication.getOkhttp();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return setView();
    }
}
