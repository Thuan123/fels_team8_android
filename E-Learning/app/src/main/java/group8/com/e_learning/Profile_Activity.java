package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by tranngoclinh on 11/15/15.
 */
public class Profile_Activity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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
                Intent intentLesson = new Intent(Profile_Activity.this, Lesson_Basic_Activity.class);
                startActivity(intentLesson);
                break;
        }
    }
}
