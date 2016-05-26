package com.zbao.server.utils;

import android.util.Log;

/**
 * Log信息输出工具类
 * <p/>
 * Created by zhangYB on 2016/4/19.
 */
public class Logger {
    /**
     * 正式发布后改为 false暂停Log输出
     */
    private static final boolean DEBUG = true;

    /**
     * 控制台输出信息
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg) {
        if (DEBUG)
            Log.w(tag, msg);
    }

    /**
     * 控制台输出信息
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        if (DEBUG)
            Log.v(tag, msg);
    }

    /**
     * 控制台输出信息
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        if (DEBUG)
            Log.i(tag, msg);
    }

    /**
     * 控制台输出信息
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (DEBUG)
            Log.d(tag, msg);
    }

    /**
     * 控制台输出信息
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (DEBUG)
            Log.e(tag, msg);
    }
}
