package com.anzer.robotphone.login.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

    ILoginPresenter mILoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        // bind
        mRadioGroup = (RadioGroup) findViewById(R.id.rgChosePattern);
        ButterKnife.bind(this);

        // init
        mILoginPresenter = new LoginPresenterImpl(this);

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

    @OnClick(R.id.mBtnLoginDirect)
    public void onBtnLoginDirect() {

        Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();

        CommunicateService.getInstance().showTips();
    }

    @OnClick(R.id.mBtnLoginLAN)
    public void onBtnLoginLAN() {

        Toast.makeText(this, "222", Toast.LENGTH_SHORT).show(); // 无法显示
    }

    private Gson mGson = new Gson();

    @OnClick(R.id.mBtnLoginRemote)
    public void onBtnLoginRemote() {

        Toast.makeText(this, "333", Toast.LENGTH_SHORT).show();


        String name = mEdtUserRemote.getText().toString().trim();
        String password = mEdtPwdRemote.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            return;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("cmd", 0x0001);
        map.put("sn", hashCode());
        map.put("user", name);
        map.put("pass", password);
        map.put("softType", "android");
        CommunicateService.getInstance().sendJsonToWebSocket(mGson.toJson(map));
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
