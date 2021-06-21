package cn.xcion.common.caption;

import android.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/3/24  21:12
 * Intro:
 */
public class CaptionActivity extends AppCompatActivity {

    private View mContentView;

    public int dip2px(float dpValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public int px2dip(float pxValue) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);

    }

    public Config getConfig() {
        return new Config();
    }

    public class Config {

        private int layoutResID;
        private int statusBarBackgroundColor;
        private int captionBackgroundColor;
        private int captionBarHeight;
        private View captionBar;
        private boolean autoHideKeyboard;
        private boolean immersiveStatus;

        public int getLayoutResID() {
            return layoutResID;
        }

        public Config setLayoutResID(int layoutResID) {
            this.layoutResID = layoutResID;
            return this;
        }

        public int getStatusBarBackgroundColor() {
            return statusBarBackgroundColor;
        }

        public Config setStatusBarBackgroundColor(int statusBarBackgroundColor) {
            this.statusBarBackgroundColor = statusBarBackgroundColor;
            return this;
        }

        public int getCaptionBackgroundColor() {
            return captionBackgroundColor;
        }

        public Config setCaptionBackgroundColor(int captionBackgroundColor) {
            this.captionBackgroundColor = captionBackgroundColor;
            return this;
        }

        public int getCaptionBarHeight() {
            return captionBarHeight;
        }

        public Config setCaptionBarHeight(int captionBarHeight) {
            this.captionBarHeight = captionBarHeight;
            return this;
        }

        public View getCaptionBar() {
            return captionBar;
        }

        public Config setCaptionBar(View captionBar) {
            this.captionBar = captionBar;
            return this;
        }

        public boolean isAutoHideKeyboard() {
            return autoHideKeyboard;
        }

        public Config setAutoHideKeyboard(boolean autoHideKeyboard) {
            this.autoHideKeyboard = autoHideKeyboard;
            return this;
        }

        public boolean isImmersiveStatus() {
            return immersiveStatus;
        }

        public Config setImmersiveStatus(boolean immersiveStatus) {
            this.immersiveStatus = immersiveStatus;
            return this;
        }

        public void build() {
            setCaptionView(this);
        }
    }

    private void setCaptionView(Config config) {

        ActionBar bar = getActionBar();
        if (bar != null) bar.hide();

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mContentView = LayoutInflater.from(this).inflate( config.getLayoutResID(),null,false);
        setContentView(mContentView, params);

        if (config.getCaptionBar() != null) {
            //Caption Bar background color
            if (config.getCaptionBackgroundColor() != 0)
                config.getCaptionBar().setBackgroundColor(getResources().getColor(config.getCaptionBackgroundColor()));
            //Caption Bar height
            int mCaptionBarHeight = getResources().getDimensionPixelSize(config.getCaptionBarHeight());
            ViewGroup.LayoutParams mCaptionBarLP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mCaptionBarHeight);
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            parent.addView(config.getCaptionBar(), mCaptionBarLP);
            //Caption Bar height
            FrameLayout.LayoutParams mContentLP = (FrameLayout.LayoutParams) mContentView.getLayoutParams();
            mContentLP.topMargin = mCaptionBarHeight;
            mContentView.setLayoutParams(mContentLP);
        }

        /*** 状态栏一体化 ***/
        if (config.isImmersiveStatus())
            ImmersiveUtils.getInstance().initImmersive(this);
        /*** 自动隐藏软键盘 ***/
        if (config.isAutoHideKeyboard())
            AutoHideKeyboard.getInstance(this).setRootView(mContentView).build();

    }
}
