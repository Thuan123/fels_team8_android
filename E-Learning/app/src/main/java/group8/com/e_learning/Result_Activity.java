package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Result_Activity extends Activity {


    private String updateTextLesson() {
        Intent intent = getIntent();
        return intent.getStringExtra("lessonName");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_);
        Toast.makeText(this, updateTextLesson(), Toast.LENGTH_LONG).show();
        initResultRecycle();
    }

    private void initResultRecycle() {
        RecyclerView rvResult = (RecyclerView) findViewById(R.id.rv_result);
        ItemResultAdapter adapter = new ItemResultAdapter(ItemResult.createItemResult(20));
        // Attach the adapter to the recyclerview to populate items
        rvResult.setAdapter(adapter);
        // Set layout manager to position the items
        rvResult.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
