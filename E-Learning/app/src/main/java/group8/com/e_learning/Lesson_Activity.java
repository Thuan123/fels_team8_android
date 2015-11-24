package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import group8.com.e_learning.R;
import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Word;
import group8.com.e_learning.entities.WordAnswer;
import group8.com.e_learning.network.EConnect;

/**
 * Created by tranngoclinh on 11/19/15.
 */
public class Lesson_Activity extends Activity implements View.OnClickListener, EConnect.OnConnected {
    private TextView tvTitle;
    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        connectNetwork();
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
                callResult();
                break;
            case R.id.btn_sound:
                playSound();
                break;
            case R.id.btn_ans1:
            case R.id.btn_ans2:
            case R.id.btn_ans3:
            case R.id.btn_ans4:
                checkAns(v);
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

    @Override
    public void getJson(JSONObject JsonObject) {

        this.jsonObject = JsonObject;
        handlerJsonObject();
    }

    private void handlerJsonObject() {
        try {
            JSONArray array = this.jsonObject.getJSONArray(Constant.PARA_WORDS);
            handlerListWord(getListWord(array));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private ArrayList<Word> getListWord(JSONArray array) {

        ArrayList<Word> result = new ArrayList<>();
        try {
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                Word word = new Word();
                word.setContent(object.getString(Constant.PARA_CONTENT));
                word.setWordAnswer(getAnswer(object.getJSONArray(Constant.PARA_ANSWER)));
                result.add(word);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private WordAnswer[] getAnswer(JSONArray arrayAnswer) throws JSONException {
        WordAnswer[] result = new WordAnswer[4];
        for (int i = 0; i < 4; i++) {
            JSONObject object = arrayAnswer.getJSONObject(i);
            WordAnswer answer = new WordAnswer();
            answer.setContent(object.getString(Constant.PARA_CONTENT));
            answer.setCorrect(object.getInt(Constant.PARA_CORRECT));
            result[i] = answer;
        }
        return result;
    }

    private String makeAPI() {

        int category_id = getIntent().getIntExtra(Constant.PARA_CATEGORY_ID, 0);

        return String.format(Constant.API_LESSON, category_id);
    }

    private void connectNetwork() {
        EConnect eConnect = new EConnect(this);
        eConnect.execute(makeAPI());
    }

    private void handlerListWord(ArrayList<Word> listWord) {
        //do something wih list word
    }
}
