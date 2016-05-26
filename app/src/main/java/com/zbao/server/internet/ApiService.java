package com.zbao.server.internet;

import com.zbao.server.bean.ResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangYB on 2016/4/20.
 */
public interface ApiService {
    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @param nickname
     * @param phone
     * @return
     */
    @GET("register.json")
    Call<ResponseResult> register(@Query("username") String username, @Query("password") String password, @Query("nickname") String nickname, @Query("phone") String phone);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @GET("login.json")
    Call<ResponseResult> login(@Query("username") String username, @Query("password") String password);
}
