package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.network.EditProfile;
import group8.com.e_learning.network.PostInfo;

/**
 * Created by tranngoclinh on 11/15/15.
 */
public class UpdateProfile_Activity extends Activity implements EditProfile.OnConnected{
    private EditText email,pass,fullName,passConfirmation;
    private JSONObject jsonObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        email = (EditText)findViewById(R.id.et_email_login);
        pass = (EditText)findViewById(R.id.et_password_login);
        fullName=(EditText)findViewById(R.id.et_name_login);
        passConfirmation = (EditText)findViewById(R.id.et_password_confirmation_login);

        email.setText(getIntent().getStringExtra("email"));

    }

    private void tapUpdate() {

        //Toast.makeText(this, "Update Register", Toast.LENGTH_LONG).show();
       EditProfile editProfile= new EditProfile(this);
       editProfile.execute(Constant.API_EDIT_PROFILE, email.getText().toString(), pass.getText().toString(),Constant.SIGNUP_SESSION,
                fullName.getText().toString()
                , passConfirmation.getText().toString());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_cancel:
                finish();
                break;
            case R.id.button_update:
                tapUpdate();
                break;
        }
    }

    @Override
    public void getJson(JSONObject JsonObject) {
        this.jsonObject = JsonObject;
        if(jsonObject != null)
        {
            Toast.makeText(this, "Update successful",Toast.LENGTH_LONG).show();
            Constant.updateDone = true;
            this.finish();
        }
    }
}
