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
import group8.com.e_learning.entities.Category;
import group8.com.e_learning.entities.Word;
import group8.com.e_learning.entities.WordAnswer;
import group8.com.e_learning.network.EConnect;
import group8.com.e_learning.network.GetCategory;


public class WordList_Activity extends Activity
        implements AdapterView.OnItemSelectedListener, EConnect.OnConnected,GetCategory.OnConnected {
    private JSONObject jsonObject,categoryObject;
    private Spinner spCategory, spStatus;
    private ArrayList<Word> listWord = new ArrayList<Word>();
    private String[] arrStatus = {"All", "Learned", "Not learned"};
    private List<String> arrCategory = new ArrayList<String>();
    private RecyclerView rvWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list_);
        connectNetWork(0, null);
        Log.d("API", makeAPI(0, "not learner"));
        initSpiner();
        initRecycleWord();

    }

    private void initRecycleWord() {
        rvWord = (RecyclerView) findViewById(R.id.rv_words);
        ItemWordAdapter adapter = new ItemWordAdapter(ItemWord.createItemWord(listWord));
        rvWord.setAdapter(adapter);
        rvWord.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initSpiner() {
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
        /*try {
            jsonObject = new JSONObject(Constant.API_WORD_OFFLINE);
            //code vao day, cac thao tac nhu  getlist...
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }*/
        GetCategory getCategory = new GetCategory(this);
        getCategory.execute(Constant.API_CATEGORY);

        EConnect eConnect = new EConnect(this);

        eConnect.execute(makeAPI(category_id, type));

    }

    private String makeAPI(Integer categoty_id, String type) {

        if (categoty_id == 0 && type == null) return Constant.API_WORD_ONLINE;
        if (categoty_id == 0)
            return Constant.API_WORD_ONLINE + '?' + Constant.PARA_TYPE + '=' + type;
        if (type == null)
            return Constant.API_WORD_ONLINE + '?' + Constant.PARA_CATEGORY_ID + '=' + categoty_id.toString();

        return Constant.API_WORD_ONLINE + '?' + Constant.PARA_CATEGORY_ID + '=' + categoty_id.toString() + '&'
                + Constant.PARA_TYPE + '=' + type;
    }

    @Override
    public void  getJson(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        doSomeThingWithListWord(getList());
    }

    private Word getWord(JSONObject object) throws JSONException {
        Word word = new Word();
        word.setContent(object.getString(Constant.PARA_CONTENT));
        //word.setCategoryId(object.getInt("category_id"));
        word.setRightAnswer(object.getString(Constant.PARA_RIGHT_ANSWER));
        return word;

    }

    private ArrayList<Word> getList() {
        ArrayList<Word> result = new ArrayList<>();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray(Constant.PARA_WORDS);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
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
        for (Word word:listWord)
        {
            Log.d("word content",word.getContent());
            Log.d("word right",word.getRightAnswer());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        int indexLevel = 0;
        int indexStatus = 0;
        switch (spinner.getId()) {
            case R.id.sp_category:
                indexLevel = spCategory.getSelectedItemPosition();
            case R.id.sp_status:
                indexStatus = spStatus.getSelectedItemPosition();
                Toast.makeText(this, indexLevel + "-" + indexStatus, Toast.LENGTH_SHORT).show();
                fillter(indexLevel, indexStatus);
                break;
        }

    }

    private void fillter(int indexLevel, int indexStatus) {
        ItemWordAdapter adapter = new ItemWordAdapter(ItemWord.createItemWord(listWord));
        // Attach the adapter to the recyclerview to populate items
        rvWord.setAdapter(adapter);
        // Set layout manager to position the items
        rvWord.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void getCategoryObject(JSONObject jsonObject) {
        categoryObject = jsonObject;
        doAfterfetchData();
    }

    private void doAfterfetchData() {
        try {
            JSONArray array = this.categoryObject.getJSONArray(Constant.PARA_WORDS);
            ArrayList<Category> listcategoryList = getCategoryList(array);
            doSomeThingWithCategoryList(listcategoryList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Category> getCategoryList(JSONArray array) throws JSONException {
        ArrayList<Category> result = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            Category category = new Category();
            category.setId(object.getInt(Constant.PARA_ID));
            category.setName(object.getString(Constant.PARA_NAME));
            result.add(category);
        }
        return result;
    }

    private void doSomeThingWithCategoryList(ArrayList<Category> listcategoryList) {
        //code vao day de lam viec voi llist category nhe.
        for (int i = 0; i < listcategoryList.size(); i++) {
             Log.d("Category_activity", listcategoryList.get(i).getName());
            //Toast.makeText(this, listcategoryList.get(i).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
