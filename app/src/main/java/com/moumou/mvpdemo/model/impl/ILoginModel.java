package com.moumou.mvpdemo.model.impl;

import com.moumou.mvpdemo.listener.LoginViewListener;

/**
 * Created by ufsoft on2020-05-20
 * describle:
 */
public interface ILoginModel {
    public void login(String userName, String passWord, LoginViewListener listener);
}
