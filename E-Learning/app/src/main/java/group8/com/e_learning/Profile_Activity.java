package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Lesson;

/**
 * Created by tranngoclinh on 11/15/15.
 */
public class Profile_Activity extends Activity implements View.OnClickListener {
    private TextView name, email;
    private ArrayList<Lesson> listLesson = new ArrayList<Lesson>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.text_name);
        name.setText(getIntent().getStringExtra("name"));

        email = (TextView) findViewById(R.id.text_email);
        email.setText(getIntent().getStringExtra("email"));
        createExampleListLession();
        setRecycleView();
    }

    private void createExampleListLession() {

        listLesson.add(new Lesson(0, "10/10/2013", 1, 12, "11/10/2013", 1));
        listLesson.add(new Lesson(1, "10/10/2013", 2, 13, "11/10/2013", 1));
        listLesson.add(new Lesson(2, "10/10/2013", 3, 14, "11/10/2013", 1));
        listLesson.add(new Lesson(2, "10/10/2013", 4, 11, "11/10/2013", 1));
        listLesson.add(new Lesson(1, "10/10/2013", 5, 12, "11/10/2013", 1));
        listLesson.add(new Lesson(0, "10/10/2013", 6, 0, "11/10/2013", 1));
        listLesson.add(new Lesson(1, "10/10/2013", 4, 19, "11/10/2013", 1));
        listLesson.add(new Lesson(1, "10/10/2013", 2, 9, "11/10/2013", 1));
        listLesson.add(new Lesson(2, "10/10/2013", 3, 11, "11/10/2013", 1));
        listLesson.add(new Lesson(0, "10/10/2013", 5, 2, "11/10/2013", 1));
    }

    private void setRecycleView() {
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rv_learned);
        // Create adapter passing in the sample user data
        ItemLearnedAdapter adapter = new ItemLearnedAdapter(ItemLearned.createItemLearned(listLesson));
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit:
                Intent intentEdit = new Intent(Profile_Activity.this, UpdateProfile_Activity.class);
                intentEdit.putExtra("email", email.getText().toString());
                startActivity(intentEdit);
                if (Constant.updateDone)
                {
                    Constant.updateDone = false;
                    this.finish();
                }
                break;
            case R.id.btn_words:
                Intent intentWords = new Intent(Profile_Activity.this, WordList_Activity.class);
                startActivity(intentWords);
                break;
            case R.id.btn_lesson:
                Intent intentLesson = new Intent(Profile_Activity.this, Category_activity.class);
                startActivity(intentLesson);
                break;
        }
    }
}
