package group8.com.e_learning;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.common.SharedPreferencesHelper;
import group8.com.e_learning.network.GetUsetInfo;
import group8.com.e_learning.network.PostInfo;

/**
 * Created by tranngoclinh on 11/15/15.
 */
public class Register_Activity extends Activity implements View.OnClickListener, PostInfo.OnConnected {

    private JSONObject jsonObject;
    private EditText email,pass,fullName,passConfirmation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = (EditText)findViewById(R.id.et_email_login);
        pass = (EditText)findViewById(R.id.et_password_login);
        fullName=(EditText)findViewById(R.id.et_name_login);
        passConfirmation = (EditText)findViewById(R.id.et_password_confirmation_login);

    }

    private void tapDone()
    {
        User user = new User();
        GetUsetInfo getUsetInfo = new GetUsetInfo();
//        user = getUsetInfo.getUserInfo(null);
        //Toast.makeText(this, "Register done", Toast.LENGTH_SHORT).show();

        /*SharedPreferencesHelper preferencesHelper = SharedPreferencesHelper.getInstance();

        preferencesHelper.setUser1Email(email.getText().toString());
        preferencesHelper.setUser1Password(pass.getText().toString());
        preferencesHelper.setUser1Name(fullName.getText().toString());*/

        PostInfo postInfo = new PostInfo(this);
        postInfo.execute(Constant.API_SIGNUP, email.getText().toString(), pass.getText().toString(),Constant.SIGNUP_SESSION,
                            fullName.getText().toString()
                            , passConfirmation.getText().toString());
        this.finish();




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_done:
                tapDone();
                break;
        }
    }

    @Override
    public void getJson(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        if(jsonObject == null)
            Toast.makeText(this, "cannot registry",Toast.LENGTH_LONG).show();//cho nay cau thay bang hien dong chu do thong bao khong dang ky dk nhe
        else
        {
            //code vao day
        }

    }
}
