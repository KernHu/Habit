package cn.xcion.common.caption;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.ref.WeakReference;

import androidx.fragment.app.Fragment;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/3/24  21:57
 * Intro:
 */
public class AutoHideKeyboard {

    private static String TAG = "AutoHideKeyboard";

    private WeakReference<Object> mWeakReference;
    private View mRootView;

    public static AutoHideKeyboard getInstance(Object object) {
        return new AutoHideKeyboard(object);
    }

    public AutoHideKeyboard(Object object) {
        this.mWeakReference = new WeakReference<>(object);
    }

    public AutoHideKeyboard setRootView(View rootView) {
        mRootView = rootView;
        return this;
    }

    public void build() {

        recursionTraverse(mRootView);

    }


    /**
     * the function is recursive until the ViewGroup don't have childView
     *
     * @param view the root view in your layout
     */
    public void recursionTraverse(View view) {

        if (view != null) {
            if (!(view instanceof EditText || view instanceof TextInputEditText)) {
                view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        hideSoftKeyboard(mWeakReference.get());
                        return false;
                    }
                });
            }

            if (view instanceof ViewGroup) {
                for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                    View inView = ((ViewGroup) view).getChildAt(i);
                    recursionTraverse(inView);
                }
            }
        } else {
            throw new NullPointerException("root view is null");
        }
    }

    /**
     * 隐藏软键盘(可用于Activity，Fragment)
     */
    public void hideSoftKeyboard(Object o) {
        if (o instanceof Activity) {
            Activity activity = (Activity) o;
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        } else if (o instanceof Fragment) {
            Fragment fragment = (Fragment) o;
            fragment.getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }
    }
}
