package com.moumou.mvpdemo.presenter;

import com.moumou.mvpdemo.listener.LoginViewListener;
import com.moumou.mvpdemo.model.LoginModel;
import com.moumou.mvpdemo.model.impl.ILoginModel;
import com.moumou.mvpdemo.presenter.impl.ILoginPresenter;
import com.moumou.mvpdemo.view.impl.ILoginView;

import java.lang.ref.WeakReference;

/**
 * Created by ufsoft on2020-05-20
 * describle:
 */
public class LoginPresenter implements ILoginPresenter {
    //持有view和model的引用，这里view的引用用弱引用避免内存溢出
    private WeakReference<ILoginView>weakReference;
    private ILoginModel loginModel;
    public LoginPresenter(ILoginView loginView){
        this.weakReference = new WeakReference<>(loginView);
        loginModel = new LoginModel();
    }
    //调用Model进行数据处理后，然后回调view的方法进行回显
    @Override
    public void login(String userName, String passWord) {
        if(loginModel != null && weakReference != null && weakReference.get() != null){
            final ILoginView loginView = weakReference.get();
            loginView.showProgress();
            loginModel.login(userName, passWord, new LoginViewListener() {
                @Override
                public void onLoginSucess() {
                    loginView.hideProgress();
                    loginView.loginSuccess();
                }

                @Override
                public void onLoginFail() {
                    loginView.hideProgress();
                    loginView.loginFail();
                }
            });
        }

    }


}
