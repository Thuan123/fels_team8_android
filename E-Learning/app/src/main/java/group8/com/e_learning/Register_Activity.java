package group8.com.e_learning;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by tranngoclinh on 11/15/15.
 */
public class Register_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        TextView tvEmail, tvPassword, tvRePassword, tvFullName, tvRequied;
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvPassword = (TextView) findViewById(R.id.tv_pass);
        tvRePassword = (TextView) findViewById(R.id.tv_retype_pass);
        tvFullName = (TextView) findViewById(R.id.tv_full_name);
        tvRequied = (TextView) findViewById(R.id.tv_required);
        tvEmail.setText(Html.fromHtml("\tEmail <sup>*</sup>"));
        tvPassword.setText(Html.fromHtml("\tPassword <sup>*</sup>"));
        tvRePassword.setText(Html.fromHtml("\tRetype password <sup>*</sup>"));
        tvFullName.setText(Html.fromHtml("\tFull name <sup>*</sup>"));
        tvRequied.setText(Html.fromHtml("<sup>*</sup>Required information"));

    }
}
