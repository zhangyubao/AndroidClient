package com.zbao.server.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by zhangYB on 2016/4/21.
 */
public class ServerApplication extends Application {


    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * 获取应用程序的上下文环境
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }
}
