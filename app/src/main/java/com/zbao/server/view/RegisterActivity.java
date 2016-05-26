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
 * 用户注册界面
 * Created by zhangYB on 2016/5/24.
 */
public class RegisterActivity extends BaseActivity {

    @Bind(R.id.et_username)
    public EditText userName;
    @Bind(R.id.et_password)
    public EditText password;
    @Bind(R.id.et_nickname)
    public EditText nickname;
    @Bind(R.id.et_phone)
    public EditText phone;

    private String mUserName;
    private String mPassword;
    private String mNickName;
    private String mPhone;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayout() {
        return R.layout.activity_register;
    }


    @OnClick(R.id.btn_register)
    public void userRegister() {
        mUserName = userName.getText().toString();
        mPassword = password.getText().toString();
        mNickName = nickname.getText().toString();
        mPhone = phone.getText().toString();
        boolean isOk = verificateInfo(mUserName, mPassword, mNickName, mPhone);
        if (isOk) {
            Call<ResponseResult> register = RetrofitWapper.getInstance().create(ApiService.class).register(mUserName, mPassword, mNickName, mPhone);
            register.enqueue(new Callback<ResponseResult>() {
                @Override
                public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
                    ResponseResult result = response.body();
                    int code = result.getCode();
                    if (code == AppConstants.RESULT_SUCCESS) {
                        // 注册成功跳转到登录界面
                        startActivity(new Intent(mContext, LoginActivity.class));
                        finish();
                    } else if (code == AppConstants.USERNAME_ERROR) {
                        CommonUtil.showToast(mContext, "用户名已使用");
                    } else {
                        CommonUtil.showToast(mContext, "注册失败");
                    }
                    Logger.i("信息返回" + response.body());
                }

                @Override
                public void onFailure(Call<ResponseResult> call, Throwable t) {
                    Logger.i("信息返回" + t.getMessage());
                }
            });
        }
    }

    /**
     * 校验输入的信息是否合法
     *
     * @param username
     * @param password
     * @param nickname
     * @param phone
     * @return
     */
    private boolean verificateInfo(String username, String password, String nickname, String phone) {
        if (StringUtils.isEmpty(username)) {
            CommonUtil.showToast(mContext, "用户名不能为空");
            return false;
        }
        if (StringUtils.isEmpty(password)) {
            CommonUtil.showToast(mContext, "密码不能为空");
            return false;
        }
        if (StringUtils.isEmpty(nickname)) {
            CommonUtil.showToast(mContext, "昵称不能为空");
            return false;
        }
        if (StringUtils.isEmpty(phone)) {
            CommonUtil.showToast(mContext, "电话不能为空");
            return false;
        }
        if (!CommonUtil.isMobileNuber(phone)) {
            CommonUtil.showToast(mContext, "手机号格式错误");
            return false;
        }
        return true;
    }

    @OnClick(R.id.btn_login)
    public void login() {
        startActivity(new Intent(mContext, LoginActivity.class));
        finish();
    }
}
