package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import group8.com.e_learning.R;

/**
 * Created by tranngoclinh on 11/19/15.
 */
public class Lesson_Activity extends Activity implements View.OnClickListener {
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        initTitle();
    }

    private void initTitle() {
        tvTitle = (TextView) findViewById(R.id.tv_title_lesson);
        Intent intent = getIntent();
        String str = intent.getStringExtra(Category_activity.KEY_TITLE);
        tvTitle.setText(str);
    }

    private void doneLesson() {
        Toast.makeText(this, "Lesson done", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_done:
                doneLesson();
                break;
            case R.id.btn_sound:
                playSound();
                break;
            case R.id.btn_ans1:
            case R.id.btn_ans2:
            case R.id.btn_ans3:
            case R.id.btn_ans4:
                checkAns(v);
                callResult();
                break;
        }
    }

    private void callResult() {
        Intent intent = new Intent(Lesson_Activity.this, Result_Activity.class);
        startActivity(intent);
        finish();
    }

    private void checkAns(View v) {
        Button btnAns = (Button) v;
        Toast.makeText(this, btnAns.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    private void playSound() {
        Toast.makeText(this, "Play sound", Toast.LENGTH_SHORT).show();
    }
}
