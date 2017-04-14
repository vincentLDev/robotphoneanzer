package com.anzer.robotphone.login.activity;

import android.content.Intent;
import android.gesture.Prediction;
import android.os.Bundle;
import android.renderscript.Int2;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

/**
 * Created by Lenovo on 17/4/10.
 */

public class LoginActivity extends BaseActivity
        implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, LoginView {

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

    @BindView(R.id.btn_login_Direct)
    Button mBtnLoginDirect;
    @BindView(R.id.btn_login_LAN)
    Button mBtnLoginLAN;
    @BindView(R.id.btn_login_Remote)
    Button mBtnLoginRemote;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {

        // find view
        RadioGroup mRadioGroup = (RadioGroup) findViewById(R.id.rgChosePattern);
        ButterKnife.bind(this);

        // set listener
        mRadioGroup.setOnCheckedChangeListener(this);

        mBtnLoginDirect.setOnClickListener(this);
        mBtnLoginLAN.setOnClickListener(this);
        mBtnLoginRemote.setOnClickListener(this);

        // init
        mLoginPresenter = new LoginPresenterImpl(this);

        mRbtnDirect.setChecked(true);

        mBtnLoginDirect.setEnabled(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

        switch (checkedId) {
            case R.id.rdoDirect:

                mRbtnDirect.setChecked(true);
                mRbtnLAN.setChecked(false);
                mRbtnRemote.setChecked(false);
                break;
            case R.id.rdoLAN:

                mRbtnDirect.setChecked(false);
                mRbtnLAN.setChecked(true);
                mRbtnRemote.setChecked(false);
                break;
            case R.id.rdoRemote:

                mRbtnDirect.setChecked(false);
                mRbtnLAN.setChecked(false);
                mRbtnRemote.setChecked(true);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login_Direct:

                mBtnLoginDirect.setEnabled(true);
                mBtnLoginLAN.setEnabled(false);
                mBtnLoginRemote.setEnabled(false);

//                mLoginPresenter.login();

//                if (rdoDirect.isChecked() || rdoRemote.isChecked() || rdoLAN.isChecked()) {
//                }

                Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_login_LAN:

                mBtnLoginLAN.setEnabled(true);
                mBtnLoginDirect.setEnabled(false);
                mBtnLoginRemote.setEnabled(false);

                Toast.makeText(this, "222", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_login_Remote:

                mBtnLoginRemote.setEnabled(true);
                mBtnLoginDirect.setEnabled(false);
                mBtnLoginLAN.setEnabled(false);

                Toast.makeText(this, "333", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
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
