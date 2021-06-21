package cn.xcion.common.activity;

import android.view.View;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.xcion.common.caption.CaptionActivity;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/3/20  23:51
 * Intro:
 */
public abstract class BaseActivity extends CaptionActivity {

    protected Unbinder mUnbinder;

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mUnbinder = ButterKnife.bind(this);
        initView();
        bindEvent();
        bindData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) mUnbinder.unbind();
    }

    /**
     * 初始化组件
     */
    protected abstract void initView();

    /**
     * 设置数据等逻辑代码
     */
    protected abstract void bindEvent();

    /**
     * 设置数据等逻辑代码
     */
    protected abstract void bindData();
}
