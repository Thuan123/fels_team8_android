package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.network.EConnect;
import group8.com.e_learning.network.GetUsetInfo;
import group8.com.e_learning.network.PostInfo;

/**
 * Created by tranngoclinh on 11/14/15.
 */
public class Login_Activity extends Activity
        implements PostInfo.OnConnected, View.OnClickListener {

    private JSONObject jsonObject;
    private TextView tvNoti;
    private EditText etEmailLogin, etPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        tvNoti = (TextView) findViewById(R.id.tv_noti);
        etEmailLogin = (EditText) findViewById(R.id.et_email_login);
        etPasswordLogin = (EditText) findViewById(R.id.et_password_login);
    }

    @Override
    public void getJson(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        if (jsonObject == null)
            Toast.makeText(this, "Cannot login",Toast.LENGTH_LONG).show();//cho nay thay toast = dong chu do bao rang khogn dang nhap dk
        else {
            //code vao day nhe de lam chuc nang sau khi login
            Intent intent = new Intent(this, Profile_Activity.class);
            startActivity(intent);
        }


    }

    private String getUserName() throws JSONException {

        return jsonObject.getString("username"); // cho nay cau co the thay username = 1 cai tag khac tuy theo api cua luan nhe


    }

    private String getPassword() throws JSONException {
        return jsonObject.getString("password");
    }

    private void login()
    {
        /*PostInfo eConnect = new PostInfo(this);

        String[] paras = {
                Constant.API_LOGIN,
                email.getText().toString(),
                password.getText().toString()
        };
        eConnect.execute(Constant.API_LOGIN,email.getText().toString(), password.getText().toString());
        Toast.makeText(this,jsonObject.toString(),Toast.LENGTH_LONG).show();*/
        //User user = new User();
       // GetUsetInfo getUsetInfo = new GetUsetInfo();
       // user = getUsetInfo.getUserInfo(null);
        PostInfo postInfo = new PostInfo(this);
        try {
            postInfo.execute(Constant.API_LOGIN, etEmailLogin.getText().toString(), etPasswordLogin.getText().toString(), Constant.LOGIN_SESSION);
        }
        catch(Exception e)
        {
            //chu do la khong dang nhap dk

        }

        //dung user de hien thi
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                //Intent intent = new Intent(Login_Activity.this, Profile_Activity.class);
                //startActivity(intent);
                if (checkLogin())
                    login();
                else tvNoti.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_create:
                Intent intentRegister = new Intent(Login_Activity.this, Register_Activity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private boolean checkLogin() {
        if (etEmailLogin.getText().toString().isEmpty()) {
            etEmailLogin.requestFocus();
            return false;
        }
        if (etPasswordLogin.getText().toString().isEmpty()) {
            etPasswordLogin.requestFocus();
            return false;
        }
        return true;
    }
}
