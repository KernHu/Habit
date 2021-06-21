package cn.xcion.common.caption;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/3/25  22:29
 * Intro:
 */
public abstract class CaptionBar {

    protected Context context;
    protected View captionbar;

    abstract int layoutResId();

    protected void init() {
        View view = LayoutInflater.from(context).inflate(layoutResId(), null, false);
        initView(view);
    }

    abstract void initView(View view);

    abstract View create();

    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


}
