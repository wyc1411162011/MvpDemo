package com.moumou.mvpdemo.model;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.moumou.mvpdemo.listener.LoginViewListener;
import com.moumou.mvpdemo.model.impl.ILoginModel;

import androidx.annotation.NonNull;

/**
 * Created by ufsoft on2020-05-20
 * describle:
 */
public class LoginModel implements ILoginModel {
    @Override
    public void login(final String userName, final String passWord, final LoginViewListener listener) {
        //这里弄一个延迟等待三秒模仿网络加载的过程
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                //这里进行简单的判断，不做网络请求了
                if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)){
                    listener.onLoginFail();
                }else{
                    listener.onLoginSucess();
                }
            }
        }.execute();

    }
}
