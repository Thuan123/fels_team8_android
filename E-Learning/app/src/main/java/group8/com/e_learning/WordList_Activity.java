package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.network.EConnect;


public class WordList_Activity extends Activity
        implements AdapterView.OnItemSelectedListener, EConnect.OnConnected {
    private JSONObject jsonObject;
    private Spinner spLevel, spStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list_);
        //   Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_actionBar);
        // setSupportActionBar(myToolbar);
        hanglerJsonObject();
        initSpiner();
    }

    private void initSpiner() {
        spLevel = (Spinner) findViewById(R.id.sp_level);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.level_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.checked_text_view);
        spLevel.setAdapter(adapter);
        spLevel.setOnItemSelectedListener(this);

        spStatus = (Spinner) findViewById(R.id.sp_status);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.status_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.checked_text_view);
        spStatus.setAdapter(adapter1);
        spStatus.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_list_, menu);
        return true;
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

    private void hanglerJsonObject()
    {
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
        Log.d("String",jsonObject.toString());
       //neu co api online thi code tiep vao day
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

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
