package group8.com.e_learning;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Word;
import group8.com.e_learning.entities.WordAnswer;
import group8.com.e_learning.network.EConnect;


public class WordList_Activity extends Activity
        implements AdapterView.OnItemSelectedListener, EConnect.OnConnected {
    private JSONObject jsonObject;
    private Spinner spCategory, spStatus;
    private String[] arrStatus = {"All", "Learned", "Not learned"};
    private List<String> arrCategory = new ArrayList<String>();
    private RecyclerView rvWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Wordlist", "onCreate1");
        setContentView(R.layout.activity_word_list_);
        connectNetWork(0, null);
    }

    private void initRecycleWord(ArrayList<Word> listWord) {
        Log.d("Wordlist", "initRecycleWord2");
        rvWord = (RecyclerView) findViewById(R.id.rv_words);
        ItemWordAdapter adapter = new ItemWordAdapter(ItemWord.createItemWord(listWord));
        rvWord.setAdapter(adapter);
        rvWord.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initSpiner() {
        Log.d("Wordlist", "initSpinner3");
        spCategory = (Spinner) findViewById(R.id.sp_category);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, arrCategory);
        adapter.setDropDownViewResource(R.layout.checked_text_view);
        spCategory.setAdapter(adapter);
        spCategory.setOnItemSelectedListener(this);

        spStatus = (Spinner) findViewById(R.id.sp_status);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.spinner_item, arrStatus);
        adapter1.setDropDownViewResource(R.layout.checked_text_view);
        spStatus.setAdapter(adapter1);
        spStatus.setOnItemSelectedListener(this);
    }


    private void tapPDF() {
        Toast.makeText(this, "Print PDF", Toast.LENGTH_LONG).show();
    }

    public void onClick(View view) {
        Log.d("Wordlist", "onClick4");
        switch (view.getId()) {
            case R.id.button_back:
                finish();
                break;
            case R.id.button_PDF:
                tapPDF();
                break;
        }
    }

    private void connectNetWork(int category_id, String type) {
        Log.d("Wordlist", "connectNetWork5");
        /*try {
            jsonObject = new JSONObject(Constant.API_WORD_OFFLINE);
            //code vao day, cac thao tac nhu  getlist...
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }*/
        EConnect eConnect = new EConnect(this);
        eConnect.execute(makeAPI(category_id, type));
    }

    private String makeAPI(Integer categoty_id, String type) {
        Log.d("Wordlist", "makeAPI6");
        if (categoty_id == 0 && type == null) return Constant.API_WORD_ONLINE;
        if (categoty_id == 0)
            return Constant.API_WORD_ONLINE + '?' + Constant.PARA_TYPE + '=' + type;
        if (type == null)
            return Constant.API_WORD_ONLINE + '?' + Constant.PARA_CATEGORY_ID + '=' + categoty_id.toString();

        return Constant.API_WORD_ONLINE + '?' + Constant.PARA_CATEGORY_ID + '=' + categoty_id.toString() + '&'
                + Constant.PARA_TYPE + '=' + type;
    }

    @Override
    public void getJson(JSONObject jsonObject) {
        Log.d("Wordlist", "getJson7");
        this.jsonObject = jsonObject;
        doSomeThingWithListWord(getList());
    }

    private Word getWord(JSONObject object) throws JSONException {
        Log.d("Wordlist", "getWord8");
        Word word = new Word();
        word.setContent(object.getString(Constant.PARA_CONTENT));
        //word.setCategoryId(object.getInt("category_id"));
        word.setRightAnswer(object.getString(Constant.PARA_RIGHT_ANSWER));
        return word;

    }

    private ArrayList<Word> getList() {
        Log.d("Wordlist", "getList9");
        ArrayList<Word> result = new ArrayList<>();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray(Constant.PARA_WORDS);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                Log.d("json", object.toString());
                Word word = getWord(object);
                result.add(word);
                //word.setCategoryId(object.getString(""));
                //tiep theo lay cac du lieu trong object chuyen vao result nhe
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void doSomeThingWithListWord(ArrayList<Word> listWord) {
        Log.d("Wordlist", "doSomeThing10");
        initSpiner();
        initRecycleWord(listWord);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d("Wordlist", "OnItemSelectied11");
        Spinner spinner = (Spinner) parent;
        int indexLevel = 0;
        int indexStatus = 0;
        switch (spinner.getId()) {
            case R.id.sp_category:
                indexLevel = spCategory.getSelectedItemPosition();
            case R.id.sp_status:
                indexStatus = spStatus.getSelectedItemPosition();
                Toast.makeText(this, indexLevel + "-" + indexStatus, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d("Wordlist", "onNothingSelected13");
    }
}
