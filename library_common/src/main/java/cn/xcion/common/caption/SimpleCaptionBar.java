package cn.xcion.common.caption;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.xcion.common.R;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/3/25  22:14
 * Intro:
 */
public class SimpleCaptionBar extends CaptionBar {

    private int titleTextColor;
    private int titleSize;
    private String titleText;

    private int leftTextColor;
    private int leftTextSize;
    private String leftText;
    private int leftIcon;
    private View.OnClickListener leftClickListener;

    private int rightTextColor;
    private int rightTextSize;
    private String rightText;
    private int rightIcon;
    private View.OnClickListener rightClickListener;


    public SimpleCaptionBar(Builder builder) {

        this.context = builder.getContext();
        this.titleTextColor = builder.getTitleTextColor();
        this.titleSize = builder.getTitleSize();
        this.titleText = builder.getTitleText();
        this.leftTextColor = builder.getLeftTextColor();
        this.leftTextSize = builder.getLeftTextSize();
        this.leftText = builder.getLeftText();
        this.leftIcon = builder.getLeftIcon();
        this.leftClickListener = builder.getLeftClickListener();
        this.rightTextColor = builder.getRightTextColor();
        this.rightTextSize = builder.getRightTextSize();
        this.rightText = builder.getRightText();
        this.rightIcon = builder.getRightIcon();
        this.rightClickListener = builder.getRightClickListener();

        init();
    }

    @Override
    int layoutResId() {
        return R.layout.captionbar_simple;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    void initView(View view) {

        ImageView mLeftImage = view.findViewById(R.id.simple_left_image);
        TextView mLeftView = view.findViewById(R.id.simple_left_text);
        ImageView mRightImage = view.findViewById(R.id.simple_right_image);
        TextView mRightView = view.findViewById(R.id.simple_right_text);
        TextView mTitleView = view.findViewById(R.id.simple_title);

        Log.e("sos", "initView==" + titleText);
        //标题
        if (TextUtils.isEmpty(titleText)) {
            mTitleView.setVisibility(View.GONE);
        } else {
            mTitleView.setVisibility(View.VISIBLE);
            mTitleView.setText(titleText);
            if (titleSize != 0)
                mTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, context.getResources().getDimensionPixelSize(titleSize));
            if (titleTextColor != 0)
                mTitleView.setTextColor(context.getResources().getColor(titleTextColor));
        }

        //左侧按钮
        Log.e("sos", "initView=leftIcon=" + leftIcon);
        if (!TextUtils.isEmpty(leftText)) {
            mLeftView.setVisibility(View.VISIBLE);
            mLeftView.setText(leftText);
            if (leftTextSize != 0)
                mLeftView.setTextSize(TypedValue.COMPLEX_UNIT_PX, leftTextSize);
            if (leftTextColor != 0)
                mLeftView.setTextColor(context.getResources().getColor(leftTextColor));
            if (leftClickListener != null)
                mLeftView.setOnClickListener(leftClickListener);
        } else if (leftIcon != 0) {
            mLeftImage.setVisibility(View.VISIBLE);
            Drawable drawable = context.getDrawable(leftIcon);
            mLeftImage.setImageDrawable(drawable);
            if (leftClickListener != null)
                mLeftImage.setOnClickListener(leftClickListener);
        } else {
            mLeftView.setVisibility(View.GONE);
            mLeftImage.setVisibility(View.GONE);
        }

        //右侧按钮
        if (!TextUtils.isEmpty(rightText)) {
            mRightView.setVisibility(View.VISIBLE);
            mRightView.setText(rightText);
            if (rightTextSize != 0)
                mRightView.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightTextSize);
            if (rightTextColor != 0)
                mRightView.setTextColor(context.getResources().getColor(rightTextColor));
            if (rightClickListener != null)
                mRightView.setOnClickListener(rightClickListener);
        } else if (rightIcon != 0) {
            mRightImage.setVisibility(View.VISIBLE);
            Drawable drawable = context.getDrawable(rightIcon);
            mRightImage.setImageDrawable(drawable);
            if (rightClickListener != null)
                mRightView.setOnClickListener(rightClickListener);
        } else {
            mRightView.setVisibility(View.GONE);
            mRightImage.setVisibility(View.GONE);
        }

        this.captionbar = view;
    }

    @Override
    public View create() {
        return captionbar;
    }

    public static class Builder {

        private Context context;
        private int titleTextColor;
        private int titleSize;
        private String titleText;

        private int leftTextColor;
        private int leftTextSize;
        private String leftText;
        private int leftIcon;
        private View.OnClickListener leftClickListener;

        private int rightTextColor;
        private int rightTextSize;
        private String rightText;
        private int rightIcon;
        private View.OnClickListener rightClickListener;

        public Context getContext() {
            return context;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public int getTitleTextColor() {
            return titleTextColor;
        }

        public Builder setTitleTextColor(int titleTextColor) {
            this.titleTextColor = titleTextColor;
            return this;
        }

        public int getTitleSize() {
            return titleSize;
        }

        public Builder setTitleSize(int titleSize) {
            this.titleSize = titleSize;
            return this;
        }

        public String getTitleText() {
            return titleText;
        }

        public Builder setTitleText(String titleText) {
            this.titleText = titleText;
            return this;
        }

        public int getLeftTextColor() {
            return leftTextColor;
        }

        public Builder setLeftTextColor(int leftTextColor) {
            this.leftTextColor = leftTextColor;
            return this;
        }

        public int getLeftTextSize() {
            return leftTextSize;
        }

        public Builder setLeftTextSize(int leftTextSize) {
            this.leftTextSize = leftTextSize;
            return this;
        }

        public String getLeftText() {
            return leftText;
        }

        public Builder setLeftText(String leftText) {
            this.leftText = leftText;
            return this;
        }

        public int getLeftIcon() {
            return leftIcon;
        }

        public Builder setLeftIcon(int leftIcon) {
            this.leftIcon = leftIcon;
            return this;
        }

        public View.OnClickListener getLeftClickListener() {
            return leftClickListener;
        }

        public Builder setLeftClickListener(View.OnClickListener leftClickListener) {
            this.leftClickListener = leftClickListener;
            return this;
        }

        public int getRightTextColor() {
            return rightTextColor;
        }

        public Builder setRightTextColor(int rightTextColor) {
            this.rightTextColor = rightTextColor;
            return this;
        }

        public int getRightTextSize() {
            return rightTextSize;
        }

        public Builder setRightTextSize(int rightTextSize) {
            this.rightTextSize = rightTextSize;
            return this;
        }

        public String getRightText() {
            return rightText;
        }

        public Builder setRightText(String rightText) {
            this.rightText = rightText;
            return this;
        }

        public int getRightIcon() {
            return rightIcon;
        }

        public Builder setRightIcon(int rightIcon) {
            this.rightIcon = rightIcon;
            return this;
        }

        public View.OnClickListener getRightClickListener() {
            return rightClickListener;
        }

        public Builder setRightClickListener(View.OnClickListener rightClickListener) {
            this.rightClickListener = rightClickListener;
            return this;
        }

        public SimpleCaptionBar build() {
            return new SimpleCaptionBar(this);
        }
    }


}
