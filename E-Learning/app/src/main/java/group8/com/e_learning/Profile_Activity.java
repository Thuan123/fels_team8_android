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
        listLesson.add(new Lesson(0, "10/10/2013", 1, 12, 1));
        listLesson.add(new Lesson(1, "10/10/2013", 2, 13, 1));
        listLesson.add(new Lesson(2, "10/10/2013", 3, 14, 1));
        listLesson.add(new Lesson(2, "10/10/2013", 4, 11, 1));
        listLesson.add(new Lesson(1, "10/10/2013", 5, 12, 1));
        listLesson.add(new Lesson(0, "10/10/2013", 6, 0, 1));
        listLesson.add(new Lesson(1, "10/10/2013", 4, 19, 1));
        listLesson.add(new Lesson(1, "10/10/2013", 2, 9, 1));
        listLesson.add(new Lesson(2, "10/10/2013", 3, 11, 1));
        listLesson.add(new Lesson(0, "10/10/2013", 5, 2, 1));
    }

    private void setRecycleView() {
        RecyclerView rvLesson = (RecyclerView) findViewById(R.id.rv_learned);
        ItemLearnedAdapter adapter = new ItemLearnedAdapter(ItemLearned.createItemLearned(listLesson));
        rvLesson.setAdapter(adapter);
        rvLesson.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit:
                Intent intentEdit = new Intent(Profile_Activity.this, UpdateProfile_Activity.class);
                startActivity(intentEdit);
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
