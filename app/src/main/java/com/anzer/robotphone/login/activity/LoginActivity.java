package com.anzer.robotphone.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.anzer.robotphone.MainActivity;
import com.anzer.robotphone.R;
import com.anzer.robotphone.base.BaseActivity;
import com.anzer.robotphone.login.presenter.ILoginPresenter;
import com.anzer.robotphone.login.presenterimpl.LoginPresenterImpl;
import com.anzer.robotphone.login.view.ILoginView;
import com.anzer.robotphone.service.CommunicateService;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by Lenovo on 17/4/10.
 */

public class LoginActivity extends BaseActivity implements ILoginView {
    private static final String TAG = "LoginActivity";

    private RadioGroup mRadioGroup;

    @BindView(R.id.et_ip_direct)
    EditText mIpDirect;
    @BindView(R.id.et_user_lan)
    EditText mUserLAN;
    @BindView(R.id.et_ip_remote)
    EditText mIpRemote;
    @BindView(R.id.et_pwd_remote)
    EditText mPwdRemote;
    @BindView(R.id.et_user_remote)
    EditText mUserRemote;

    @BindView(R.id.rbtn_direct)
    RadioButton mDirect;
    @BindView(R.id.rbtn_lan)
    RadioButton mLAN;
    @BindView(R.id.rbtn_remote)
    RadioButton mRemote;

    @BindView(R.id.llyt_direct)
    LinearLayout mLlytDirect;
    @BindView(R.id.llyt_lan)
    LinearLayout mLlytLAN;
    @BindView(R.id.llyt_remote)
    LinearLayout mLlytRemote;

    ILoginPresenter mILoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

//        Log.e(TAG, "onCreate: " + Process.myPid());

    }

    private void initView() {
        // bind
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_chose_pattern);
        ButterKnife.bind(this);

        // init
        mILoginPresenter = new LoginPresenterImpl(this);

        // 填充、移除布局  mLinearLayoutDirect、mLinearLayoutLAN、mLinearLayoutRemote
        showLayout(true, false, false);
    }

    @OnCheckedChanged(R.id.rbtn_direct)
    public void onDirect() {
        showLayout(true, false, false);
    }

    @OnCheckedChanged(R.id.rbtn_lan)
    public void onLAN() {
        showLayout(false, true, false);
    }

    @OnCheckedChanged(R.id.rbtn_remote)
    public void onRemote() {
        showLayout(false, false, true);
    }

    private void showLayout(boolean direct, boolean lan, boolean remote) {

        mDirect.setChecked(direct);
        mLAN.setChecked(lan);
        mRemote.setChecked(remote);

        mLlytDirect.setVisibility(direct ? View.VISIBLE : View.GONE);
        mLlytLAN.setVisibility(lan ? View.VISIBLE : View.GONE);
        mLlytRemote.setVisibility(remote ? View.VISIBLE : View.GONE);
    }

    @OnClick(R.id.btn_login_direct)
    public void onLoginDirect() {

        Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();

        CommunicateService.getInstance().showTips();
    }

    @OnClick(R.id.btn_login_lan)
    public void onLoginLAN() {
        Toast.makeText(this, "222", Toast.LENGTH_SHORT).show();
    }

    private Gson mGson = new Gson();

    @OnClick(R.id.btn_login_remote)
    public void onLoginRemote() {

        Toast.makeText(this, "333", Toast.LENGTH_SHORT).show();

        String name = mUserRemote.getText().toString().trim();
        String password = mPwdRemote.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            return;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("cmd", 0x0001);
        map.put("sn", hashCode());
        map.put("user", name);
        map.put("pass", password);
        map.put("softType", "android");

        CommunicateService.getInstance().sendJsonToWebSocket(mGson.toJson(map));    // Gson.toJson(),serializes the specified object into its equivalent Json representation.

        startActivity(new Intent(this, MainActivity.class));
    }


    @Override
    public void onLoginResult(Boolean result, int code) {

        if (result) {
            Toast.makeText(this, "Login Success.", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "Login Failed, code = " + code, Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
