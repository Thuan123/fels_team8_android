package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Word;

public class Category_activity extends Activity {
    private ArrayList<Word> categoryBasic = new ArrayList<Word>();
    private ArrayList<Word> categoryAdvance = new ArrayList<Word>();
    private ArrayList<Word> categoryExpert = new ArrayList<Word>();
    private ArrayList<Word> allWord = new ArrayList<Word>();
    public static final String KEY_TITLE = "key_title";
    private TextView tvBasic, tvAdvance, tvExpert, tvWordBasic, tvWordAdvance, tvWordExpert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);
        //    Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_actionBar);
        //  setSupportActionBar(myToolbar);
        initView();
        initCategory();
        initProgress();
    }

    private void initView() {
        tvBasic = (TextView) findViewById(R.id.tv_basic);
        tvAdvance = (TextView) findViewById(R.id.tv_advance);
        tvExpert = (TextView) findViewById(R.id.tv_expert);
        tvWordBasic = (TextView) findViewById(R.id.tv_word_basic);
        tvWordAdvance = (TextView) findViewById(R.id.tv_word_advance);
        tvWordExpert = (TextView) findViewById(R.id.tv_word_expert);
    }


    private void initProgress() {
        int coutBasic = 0;
        int coutAdvance = 0;
        int coutExpert = 0;
        String strBasic = "";
        String strAdvance = "";
        String strExpert = "";
        for (int i = 0; i < categoryBasic.size(); i++) {
            Word word = categoryBasic.get(i);
            if (word.getStatus() == Constant.LEARNED) {
                coutBasic++;
                strBasic += word.getContent() + ",";
            }
        }
        for (int i = 0; i < categoryAdvance.size(); i++) {
            Word word = categoryAdvance.get(i);
            if (word.getStatus() == Constant.LEARNED) {
                coutAdvance++;
                strAdvance += word.getContent() + ",";
            }
        }
        for (int i = 0; i < categoryExpert.size(); i++) {
            Word word = categoryExpert.get(i);
            if (word.getStatus() == Constant.LEARNED) {
                coutExpert++;
                strExpert += word.getContent() + ",";
            }
        }
        tvBasic.setText("You're learned " + coutBasic + "/" + categoryBasic.size());
        tvAdvance.setText("You're learned " + coutAdvance + "/" + categoryAdvance.size());
        tvExpert.setText("You're learned " + coutExpert + "/" + categoryExpert.size());
        tvWordBasic.setText(strBasic);
        tvWordAdvance.setText(strAdvance);
        tvWordExpert.setText(strExpert);
    }

    private void initCategory() {
        initAllWord();
        for (int i = 0; i < allWord.size(); i++) {
            Word word = allWord.get(i);
            switch (word.getCategoryId()) {
                case Constant.CATEGORY_BASIC:
                    categoryBasic.add(word);
                    break;
                case Constant.CATEGORY_ADVANCE:
                    categoryAdvance.add(word);
                    break;
                case Constant.CATEGORY_EXPERT:
                    categoryExpert.add(word);
                    break;
            }
        }

    }

    private void initAllWord() {

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

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.layout_basic:
                Intent intentBasic = new Intent(this, Lesson_Activity.class);
                intentBasic.putExtra(KEY_TITLE, "Basic Lesson");
                startActivity(intentBasic);
                break;
            case R.id.layout_advance:
                Intent intentAdvance = new Intent(this, Lesson_Activity.class);
                intentAdvance.putExtra(KEY_TITLE, "Advance Lesson");
                startActivity(intentAdvance);
                break;
            case R.id.layout_expert:
                Intent intentExpert = new Intent(this, Lesson_Activity.class);
                intentExpert.putExtra(KEY_TITLE, "Expert Lesson");
                startActivity(intentExpert);
                break;
            case R.id.button_back:
                finish();
                break;
        }
    }
}
