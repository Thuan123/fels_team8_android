package group8.com.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

public class Category_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);
        Toolbar myToolbar = (Toolbar)findViewById(R.id.toolbar_actionBar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.button_next) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view)
    {

        switch (view.getId()) {
            case R.id.layout_basic:
                Intent intent1 = new Intent(this,Lesson_Basic_Activity.class);
                startActivity(intent1);
                break;
            case R.id.layout_advance:
                Intent intent2 = new Intent(this,lesson_advance_activity.class);
                startActivity(intent2);
                break;
            case R.id.layout_expert:
                Intent intent3 = new Intent(this,Lesson_expert_activity.class);
                startActivity(intent3);
                break;
        }
    }
}
