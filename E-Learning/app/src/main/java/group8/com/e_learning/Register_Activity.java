package group8.com.e_learning;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tranngoclinh on 11/15/15.
 */
public class Register_Activity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_done:
                Toast.makeText(this, "Register done", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
