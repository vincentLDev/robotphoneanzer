package com.anzer.robotphone.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.anzer.robotphone.MainActivity;
import com.anzer.robotphone.R;
import com.anzer.robotphone.base.BaseActivity;
import com.anzer.robotphone.login.presenter.LoginPresenter;
import com.anzer.robotphone.login.presenterimpl.LoginPresenterImpl;
import com.anzer.robotphone.login.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by Lenovo on 17/4/10.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    private RadioGroup mRadioGroup;

    @BindView(R.id.etIpDirect)
    EditText mEdtIpDirect;
    @BindView(R.id.etUserLAN)
    EditText mEdtUserLAN;
    @BindView(R.id.etIpRemote)
    EditText mEdtIpRemote;
    @BindView(R.id.etPwdRemote)
    EditText mEdtPwdRemote;
    @BindView(R.id.etUserRemote)
    EditText mEdtUserRemote;

    @BindView(R.id.rdoDirect)
    RadioButton mRbtnDirect;
    @BindView(R.id.rdoLAN)
    RadioButton mRbtnLAN;
    @BindView(R.id.rdoRemote)
    RadioButton mRbtnRemote;

    @BindView(R.id.linearLayoutDirect)
    LinearLayout mLinearLayoutDirect;
    @BindView(R.id.btn_login_LAN)
    LinearLayout mLinearLayoutLAN;
    @BindView(R.id.linearLayout_Remote)
    LinearLayout mLinearLayoutRemote;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        // find view
        mRadioGroup = (RadioGroup) findViewById(R.id.rgChosePattern);
        ButterKnife.bind(this);

        // init
        mLoginPresenter = new LoginPresenterImpl(this);

        // 填充、移除布局  mLinearLayoutDire、mLinearLayoutLAN、mLinearLayoutRemote
        showLayout(true, false, false);
    }

    @OnCheckedChanged(R.id.rdoDirect)
    public void onRdoDirect() {
        showLayout(true, false, false);
    }

    @OnCheckedChanged(R.id.rdoLAN)
    public void onRdoLAN() {
        showLayout(false, true, false);
    }

    @OnCheckedChanged(R.id.rdoRemote)
    public void onRdoRemote() {
        showLayout(false, false, true);
    }

    private void showLayout(boolean direct, boolean lan, boolean remote) {

        mRbtnDirect.setChecked(direct);
        mRbtnLAN.setChecked(lan);
        mRbtnRemote.setChecked(remote);

        mLinearLayoutDirect.setVisibility(direct ? View.VISIBLE : View.GONE);
        mLinearLayoutLAN.setVisibility(lan ? View.VISIBLE : View.GONE);
        mLinearLayoutRemote.setVisibility(remote ? View.VISIBLE : View.GONE);
    }

    @OnClick(R.id.btn_login_Direct)
    public void onbtn_login_Direct() {

        Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));

    }

    @OnClick(R.id.btn_login_LAN)
    public void onbtn_login_LAN() {

        Toast.makeText(this, "222", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login_Remote)
    public void onbtn_login_Remote() {

        Toast.makeText(this, "333", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onLoginResult(Boolean result, int code) {

        if (result) {
            Toast.makeText(this, "Login Success.", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this, MainActivity.class));

        } else {
            Toast.makeText(this, "Login Failed, code = " + code, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
