package group8.com.e_learning;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieHandler;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.common.SharedPreferencesHelper;
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
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Constant.context = this;

        CookieHandler.setDefault(Constant.cookiesManager) ;

        initView();
        ifRegisterDone();


    }

    private void ifRegisterDone() {

        SharedPreferencesHelper helper = SharedPreferencesHelper.getInstance();
        if (!Constant.registerDone) return;
        Constant.registerDone = false;
        Log.d("vo here", "vo here");
        etEmailLogin.setText(helper.getUser1Email());
        etPasswordLogin.setText(helper.getUser1Pass());
        btn_login.requestFocus();

    }

    private void initView() {
        tvNoti = (TextView) findViewById(R.id.tv_noti);
        tvNoti.setVisibility(View.GONE);

        etEmailLogin = (EditText) findViewById(R.id.et_email_login);
        etPasswordLogin = (EditText) findViewById(R.id.et_password_login);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    private Intent makeNewIntent(String name) throws JSONException {
        Intent intent = new Intent(this, Profile_Activity.class);
        String
                email = etEmailLogin.getText().toString(),
                pass = etPasswordLogin.getText().toString();
        intent.putExtra("email", email);
        intent.putExtra("password", pass);
        intent.putExtra("name", name);

        return intent;
    }

    private void saveDb() throws JSONException {
        String name = jsonObject.getString("name"),
                email = etEmailLogin.getText().toString(),
                pass = etPasswordLogin.getText().toString();
        SharedPreferencesHelper helper = SharedPreferencesHelper.getInstance();
        helper.setUser1Name(name);
        helper.setUser1Email(email);
        helper.setUser1Password(pass);
    }

    private boolean isNetworkConnect() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    @Override
    public void getJson(JSONObject JsonObject) {
        try {

            if (JsonObject == null) {
                //Toast.makeText(this, "Cannot login",Toast.LENGTH_LONG).show();//cho nay thay toast = dong chu do bao rang khogn dang nhap dk
                makeNoti();
            } else {
                //code vao day nhe de lam chuc nang sau khi login
                this.jsonObject = JsonObject.getJSONObject(Constant.PARA_USER);
                //this.jsonObject = JsonObject.getJSONObject("user");
                String name = jsonObject.getString("name");
                saveDb();
                startActivity(makeNewIntent(name));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private void makeNoti() {
        tvNoti.setText("Email or password is incorrected");
        tvNoti.setVisibility(View.VISIBLE);
    }

    private String getUserName() throws JSONException {

        return jsonObject.getString("username"); // cho nay cau co the thay username = 1 cai tag khac tuy theo api cua luan nhe


    }

    private String getPassword() throws JSONException {
        return jsonObject.getString("password");
    }

    private boolean checkAuthenicationOffline(String email, String pass) {
        return email.equals(etEmailLogin.getText().toString())
                && pass.equals(etPasswordLogin.getText().toString());
    }

    private void login() {
        try {
            if (isNetworkConnect()) {
                PostInfo postInfo = new PostInfo(this);

                postInfo.execute(Constant.API_LOGIN, etEmailLogin.getText().toString(), etPasswordLogin.getText().toString(), Constant.LOGIN_SESSION);


            } else {
                SharedPreferencesHelper helper = SharedPreferencesHelper.getInstance().getInstance();
                String email = helper.getUser1Email(),
                        pass = helper.getUser1Pass();

                if (checkAuthenicationOffline(email, pass)) {
                    startActivity(makeNewIntent(helper.getUser1Name()));
                } else
                    makeNoti();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
//                Intent intent = new Intent(Login_Activity.this, Profile_Activity.class);
//                startActivity(intent);
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
