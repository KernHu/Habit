package cn.xcion.frame;


import android.os.Bundle;

import cn.xcion.common.activity.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getConfig().
                setAutoHideKeyboard(true)
                .setImmersiveStatus(true)
                .setLayoutResID(R.layout.activity_main)
                .build();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void bindData() {

    }
}