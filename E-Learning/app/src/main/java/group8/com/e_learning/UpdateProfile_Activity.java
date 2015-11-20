package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.network.PostInfo;

/**
 * Created by tranngoclinh on 11/15/15.
 */
public class UpdateProfile_Activity extends Activity {
    private EditText email,pass,fullName,passConfirmation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        /*email = (EditText)findViewById(R.id.et_email_login);
        pass = (EditText)findViewById(R.id.et_password_login);
        fullName=(EditText)findViewById(R.id.et_name_login);
        passConfirmation = (EditText)findViewById(R.id.et_password_confirmation_login);*/

    }

    private void tapUpdate() {

        Toast.makeText(this, "Update Register", Toast.LENGTH_LONG).show();
       // PostInfo postInfo = new PostInfo(this);
        //postInfo.execute(Constant.API_SIGNUP, email.getText().toString(), pass.getText().toString(),Constant.SIGNUP_SESSION,
          //      fullName.getText().toString()
            //    , passConfirmation.getText().toString());
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

}
