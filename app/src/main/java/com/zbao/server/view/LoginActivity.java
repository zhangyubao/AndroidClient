package com.zbao.server.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.orhanobut.logger.Logger;
import com.zbao.server.R;
import com.zbao.server.base.BaseActivity;
import com.zbao.server.bean.ResponseResult;
import com.zbao.server.internet.ApiService;
import com.zbao.server.utils.AppConstants;
import com.zbao.server.utils.CommonUtil;
import com.zbao.server.utils.RetrofitWapper;
import com.zbao.server.utils.StringUtils;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 用户登录界面
 * Created by zhangYB on 2016/5/24.
 */
public class LoginActivity extends BaseActivity {

    @Bind(R.id.et_username)
    public EditText userName;
    @Bind(R.id.et_password)
    public EditText password;

    private String mUserName;
    private String mPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }

    /**
     * 用户登录
     */
    @OnClick(R.id.btn_login)
    public void userLogin() {
        mUserName = userName.getText().toString();
        mPassword = password.getText().toString();
        if (StringUtils.isEmpty(mUserName) || StringUtils.isEmpty(mPassword)) {
            CommonUtil.showToast(mContext, "用户名或密码不能为空");
            return;
        }
        Call<ResponseResult> login = RetrofitWapper.getInstance().create(ApiService.class).login(mUserName, mPassword);
        login.enqueue(new Callback<ResponseResult>() {
            @Override
            public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
                ResponseResult result = response.body();
                if (result.getCode() == AppConstants.RESULT_SUCCESS) {
                    startMain();
                } else if (result.getCode() == AppConstants.NO_REGIST_ERROR) {
                    CommonUtil.showToast(mContext, "该用户未注册");
                } else {
                    CommonUtil.showToast(mContext, "用户名或密码错误");
                }
                Logger.i("login success server return code is:" + response.code());
            }

            @Override
            public void onFailure(Call<ResponseResult> call, Throwable t) {
                Logger.i("login error:" + t.getMessage());
            }
        });
    }

    /**
     * 进入主界面
     */
    private void startMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        this.finish();
    }

    /**
     * 进入注册页面
     */
    @OnClick(R.id.btn_register)
    public void goRegister() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}
