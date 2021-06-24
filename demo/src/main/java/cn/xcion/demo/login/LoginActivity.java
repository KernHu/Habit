package cn.xcion.demo.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.lifecycle.ViewModelProviders;
import cn.xcion.demo.MainActivity;
import cn.xcion.demo.R;
import cn.xcion.demo.databinding.ActivityLoginBinding;
import cn.xcion.mvvmhttp.base.BaseViewModelActivity;


/**
 * ****************************************************************
 * 文件名称: LoginActivity
 * 作    者: Created by gyd
 * 创建时间: 2019/6/3 10:26
 * 文件描述:
 * 注意事项:
 * 版权声明:
 * ****************************************************************
 */
public class LoginActivity extends BaseViewModelActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    @Override
    public void initView() {
        binding.btnLogin.setOnClickListener(v -> {
            boolean valid = true;
            if (TextUtils.isEmpty(viewModel.userName.getValue())) {
                valid = false;
                binding.userNameLayout.setError("user is avoid");
            } else {
                binding.userNameLayout.setErrorEnabled(false);
            }
            if (TextUtils.isEmpty(viewModel.password.getValue())) {
                valid = false;
                binding.passwordLayout.setError("password is avoid");
            } else {
                binding.passwordLayout.setErrorEnabled(false);
            }
            if (valid) {
                binding.btnLogin.setEnabled(false);
                viewModel.login();
            }
        });
    }

    public void initData() {
        binding.setViewModel(viewModel);
    }

    public void initViewObservable() {
        viewModel.isLogin().observe(this, b -> {
            if (b) {
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            } else {
                binding.btnLogin.setEnabled(true);
            }
        });

        viewModel.isLoading.observe(this, b -> {
            if (b) {
                showProgressDialog();
            } else {
                dismissProgressDialog();
            }
        });
    }
}
