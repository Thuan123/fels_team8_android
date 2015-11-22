package group8.com.e_learning;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Word;
import group8.com.e_learning.entities.WordAnswer;
import group8.com.e_learning.network.EConnect;


public class WordList_Activity extends Activity
        implements AdapterView.OnItemSelectedListener, EConnect.OnConnected {
    private JSONObject jsonObject;
    private Spinner spLevel, spStatus;
    private ArrayList<Word> listWord = new ArrayList<Word>();
    private String[] state = {"Cupcake", "Donut", "Eclair", "Froyo",
            "Gingerbread", "HoneyComb", "IceCream Sandwich", "Jellybean",
            "kitkat"};
    private RecyclerView rvWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list_);
        //   Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_actionBar);
        // setSupportActionBar(myToolbar);

        initWordExample();
        hanglerJsonObject();
        initSpiner();
        initRecycleWord();
    }

    private void initWordExample() {
        WordAnswer[] answer = new WordAnswer[4];
        answer[0] = new WordAnswer("di", 1, "20/11/2015", 12, "21/11/2032", 12);
        answer[1] = new WordAnswer("di choi", 1, "20/1/2015", 12, "21/11/2032", 12);
        answer[2] = new WordAnswer("di hoc", 1, "20/1/2005", 12, "21/11/2032", 12);
        answer[3] = new WordAnswer("di ngu", 1, "2/11/2015", 12, "21/11/2032", 12);
        listWord.add(new Word(Constant.CATEGORY_ADVANCE, "Go", "10/22/1023", 12, "13/31/2001", 0, answer));

        WordAnswer[] answer1 = new WordAnswer[4];
        answer1[0] = new WordAnswer("di", 1, "20/11/2015", 12, "21/11/2032", 12);
        answer1[1] = new WordAnswer("choi", 1, "20/1/2015", 12, "21/11/2032", 12);
        answer1[2] = new WordAnswer("cho meo", 1, "20/1/2005", 12, "21/11/2032", 12);
        answer1[3] = new WordAnswer("chim lon", 1, "2/11/2015", 12, "21/11/2032", 12);
        listWord.add(new Word(Constant.CATEGORY_BASIC, "Play", "10/22/1023", 12, "13/31/2001", Constant.LEARNED, answer1));

        WordAnswer[] answer2 = new WordAnswer[4];
        answer2[0] = new WordAnswer("dang yeu", 1, "20/11/2015", 12, "21/11/2032", 12);
        answer2[1] = new WordAnswer("tot bung", 1, "20/1/2015", 12, "21/11/2032", 12);
        answer2[2] = new WordAnswer("con cho", 1, "20/1/2005", 12, "21/11/2032", 12);
        answer2[3] = new WordAnswer("con meo", 1, "2/11/2015", 12, "21/11/2032", 12);
        listWord.add(new Word(Constant.CATEGORY_EXPERT, "Pic", "10/22/1023", 12, "13/31/2001", Constant.NOT_LEARNED, answer2));

        WordAnswer[] answer3 = new WordAnswer[4];
        answer3[0] = new WordAnswer("di", 1, "20/11/2015", 12, "21/11/2032", 12);
        answer3[1] = new WordAnswer("di choi", 1, "20/1/2015", 12, "21/11/2032", 12);
        answer3[2] = new WordAnswer("di hoc", 1, "20/1/2005", 12, "21/11/2032", 12);
        answer3[3] = new WordAnswer("di ngu", 1, "2/11/2015", 12, "21/11/2032", 12);
        listWord.add(new Word(Constant.CATEGORY_BASIC, "Go", "10/22/1023", 12, "13/31/2001", Constant.LEARNED, answer3));

        WordAnswer[] answer4 = new WordAnswer[4];
        answer4[0] = new WordAnswer("di", 1, "20/11/2015", 12, "21/11/2032", 12);
        answer4[1] = new WordAnswer("di choi", 1, "20/1/2015", 12, "21/11/2032", 12);
        answer4[2] = new WordAnswer("di hoc", 1, "20/1/2005", 12, "21/11/2032", 12);
        answer4[3] = new WordAnswer("di ngu", 1, "2/11/2015", 12, "21/11/2032", 12);
        listWord.add(new Word(Constant.CATEGORY_ADVANCE, "Go", "10/22/1023", 12, "13/31/2001", Constant.LEARNED, answer4));

        WordAnswer[] answer5 = new WordAnswer[4];
        answer5[0] = new WordAnswer("di", 1, "20/11/2015", 12, "21/11/2032", 12);
        answer5[1] = new WordAnswer("di choi", 1, "20/1/2015", 12, "21/11/2032", 12);
        answer5[2] = new WordAnswer("di hoc", 1, "20/1/2005", 12, "21/11/2032", 12);
        answer5[3] = new WordAnswer("di ngu", 1, "2/11/2015", 12, "21/11/2032", 12);
        listWord.add(new Word(Constant.CATEGORY_BASIC, "Go", "10/22/1023", 12, "13/31/2001", Constant.NOT_LEARNED, answer5));
    }

    private void initRecycleWord() {
        rvWord = (RecyclerView) findViewById(R.id.rv_words);
        // Create adapter passing in the sample user data
        ItemWordAdapter adapter = new ItemWordAdapter(ItemWord.createItemWord(listWord));
        // Attach the adapter to the recyclerview to populate items
        rvWord.setAdapter(adapter);
        // Set layout manager to position the items
        rvWord.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initSpiner() {
        spLevel = (Spinner) findViewById(R.id.sp_level);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.level_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.checked_text_view);
        spLevel.setAdapter(adapter);
        spLevel.setOnItemSelectedListener(this);

        spStatus = (Spinner) findViewById(R.id.sp_status);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, state);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStatus.setAdapter(adapter1);
        spStatus.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_list_, menu);
        return true;
    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.button_next) {
            ;
            Intent intent = new Intent(this, Category_activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    } */


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

    private void hanglerJsonObject() {
        /*try {
            jsonObject = new JSONObject(Constant.API_WORD_OFFLINE);
            //code vao day, cac thao tac nhu  getlist...
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }*/
        EConnect eConnect = new EConnect(this);
        eConnect.execute(Constant.API_WORD_ONLINE);

    }

    @Override
    public void getJson(JSONObject jsonObject) {
        this.jsonObject = jsonObject;

    }

    private ArrayList<Word> getList() throws JSONException {
        ArrayList<Word> result = new ArrayList<>();
        JSONArray jsonArray = jsonObject.getJSONArray("words");// thay list = tag name cua list trong api nhe
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);

            //tiep theo lay cac du lieu trong object chuyen vao result nhe
        }
        return result;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        int indexLevel = 0;
        int indexStatus = 0;
        switch (spinner.getId()) {
            case R.id.sp_level:
                indexLevel = spLevel.getSelectedItemPosition();
            case R.id.sp_status:
                indexStatus = spStatus.getSelectedItemPosition();
                Toast.makeText(this, indexLevel + "-" + indexStatus, Toast.LENGTH_SHORT).show();
                fillter(indexLevel, indexStatus);
                break;
        }

    }

    private void fillter(int indexLevel, int indexStatus) {
        ArrayList<Word> list = new ArrayList<Word>();
        if (indexLevel == 0 && indexStatus == 0) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                list.add(word);
            }
        }
        if (indexLevel == 0 && indexStatus == 1) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getStatus() == Constant.LEARNED) {
                    list.add(word);
                }
            }
        }
        if (indexLevel == 0 && indexStatus == 2) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getStatus() == Constant.NOT_LEARNED) {
                    list.add(word);
                }
            }
        }

        if (indexLevel == 1 && indexStatus == 0) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_BASIC) {
                    list.add(word);
                }
            }
        }
        if (indexLevel == 1 && indexStatus == 1) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_BASIC && word.getStatus() == Constant.LEARNED) {
                    list.add(word);
                }
            }
        }
        if (indexLevel == 1 && indexStatus == 2) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_BASIC && word.getStatus() == Constant.NOT_LEARNED) {
                    list.add(word);
                }
            }
        }

        if (indexLevel == 2 && indexStatus == 0) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_ADVANCE) {
                    list.add(word);
                }
            }
        }
        if (indexLevel == 2 && indexStatus == 1) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_ADVANCE && word.getStatus() == Constant.LEARNED) {
                    list.add(word);
                }
            }
        }
        if (indexLevel == 2 && indexStatus == 2) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_ADVANCE && word.getStatus() == Constant.NOT_LEARNED) {
                    list.add(word);
                }
            }
        }

        if (indexLevel == 3 && indexStatus == 0) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_EXPERT) {
                    list.add(word);
                }
            }
        }
        if (indexLevel == 3 && indexStatus == 1) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_EXPERT && word.getStatus() == Constant.LEARNED) {
                    list.add(word);
                }
            }
        }
        if (indexLevel == 3 && indexStatus == 2) {
            for (int i = 0; i < listWord.size(); i++) {
                Word word = listWord.get(i);
                if (word.getCategoryId() == Constant.CATEGORY_EXPERT && word.getStatus() == Constant.NOT_LEARNED) {
                    list.add(word);
                }
            }
        }

        ItemWordAdapter adapter = new ItemWordAdapter(ItemWord.createItemWord(list));
        // Attach the adapter to the recyclerview to populate items
        rvWord.setAdapter(adapter);
        // Set layout manager to position the items
        rvWord.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
