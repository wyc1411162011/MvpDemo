package com.moumou.mvpdemo.view.impl;

/**
 * Created by ufsoft on2020-05-20
 * describle:这个是处理View层回调的，也就是Presenter 要使用的封装方法都要在这里实现接口
 * presenter持有View的接口，他的业务逻辑的所有数据都要从View获取，所以他用到的view所有的数据都要以方法返回
 */
public interface ILoginView {
    public void loginSuccess();
    public void loginFail();
    public void showProgress();
    public void hideProgress();
}
