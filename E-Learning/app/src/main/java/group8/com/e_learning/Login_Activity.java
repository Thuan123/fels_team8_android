package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import group8.com.e_learning.network.EConnect;

/**
 * Created by tranngoclinh on 11/14/15.
 */
public class Login_Activity extends Activity
        implements EConnect.OnConnected, View.OnClickListener {

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
    }

    private String getUserName() throws JSONException {

        return jsonObject.getString("username"); // cho nay cau co the thay username = 1 cai tag khac tuy theo api cua luan nhe


    }

    private String getPassword() throws JSONException {
        return jsonObject.getString("password");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (checkLogin()) {
                    Intent intent = new Intent(Login_Activity.this, Profile_Activity.class);
                    startActivity(intent);
                } else {
                    tvNoti.setVisibility(View.VISIBLE);
                }
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
