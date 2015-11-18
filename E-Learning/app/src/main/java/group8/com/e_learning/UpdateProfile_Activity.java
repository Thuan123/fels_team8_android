package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by tranngoclinh on 11/15/15.
 */
public class UpdateProfile_Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
    }

    private void tapUpdate() {
        Toast.makeText(this, "Update Register", Toast.LENGTH_LONG).show();
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
