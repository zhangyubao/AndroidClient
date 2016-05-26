package com.zbao.server.view;

import android.content.Intent;
import android.os.Bundle;

import com.zbao.server.R;
import com.zbao.server.base.BaseActivity;

/**
 * Created by zhangYB on 2016/4/20.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(10);
            gotoLogin();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转到登录界面
     */
    private void gotoLogin() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }


    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }
}


