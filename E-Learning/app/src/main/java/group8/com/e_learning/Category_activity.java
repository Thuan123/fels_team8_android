package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Category;
import group8.com.e_learning.network.EConnect;

public class Category_activity extends Activity implements EConnect.OnConnected{

    public static final String KEY_TITLE = "key_title";
    private JSONObject jsonObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);
        connectNetwork();

    }

    private void connectNetwork()
    {
        EConnect eConnect = new EConnect(this);
        eConnect.execute(Constant.API_CATEGORY);
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



    private void doAfterfetchData()
    {
        try{
            JSONArray array = this.jsonObject.getJSONArray(Constant.PARA_WORDS);
            ArrayList<Category> listcategoryList = getCategoryList(array);
            doSomeThingWithList(listcategoryList);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    private ArrayList<Category> getCategoryList(JSONArray array) throws JSONException{
        ArrayList<Category> result = new ArrayList<>();
        for (int i=0;i<array.length();i++)
        {
            JSONObject object = array.getJSONObject(i);
            Category category = new Category();
            category.setId(object.getInt(Constant.PARA_ID));
            category.setName(object.getString(Constant.PARA_NAME));
            result.add(category);
        }
        return result;
    }

    @Override
    public void getJson(JSONObject JsonObject) {
        this.jsonObject = JsonObject;
        doAfterfetchData();
    }


    private void doSomeThingWithList(ArrayList<Category> listcategoryList) {
        //code vao day de lam viec voi llist category nhe.
    }

}
