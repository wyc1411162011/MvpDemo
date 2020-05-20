package com.moumou.mvpdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moumou.mvpdemo.R;
import com.moumou.mvpdemo.presenter.LoginPresenter;
import com.moumou.mvpdemo.presenter.impl.ILoginPresenter;
import com.moumou.mvpdemo.view.impl.ILoginView;

public class LoginActivity extends Activity implements ILoginView {
    private EditText et_username;
    private EditText et_password;
    private Button bt_login;
    private ProgressDialog progressDialog;
    //view持有Presenter 的引用可以调用他的方法
    private  ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        initDatas();
        bindListeners();
    }
    private void initDatas(){
        progressDialog = new ProgressDialog(this);
        loginPresenter = new LoginPresenter(this);
    }
    private void bindViews() {

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_login = (Button) findViewById(R.id.bt_login);
    }
    private void bindListeners(){
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login(et_username.getText().toString(),et_password.getText().toString());
            }
        });
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
       progressDialog.dismiss();
    }
}
