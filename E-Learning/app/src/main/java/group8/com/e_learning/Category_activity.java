package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Category;
import group8.com.e_learning.network.EConnect;

public class Category_activity extends Activity implements EConnect.OnConnected, View.OnClickListener {

    private JSONObject jsonObject;
    private ArrayList<Category> listCategory = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);
        connectNetwork();
        listCategory.add(new Category("1/1/1",1,"1/1/","1"));
        initRecycleCategory();
    }

    private void initRecycleCategory() {
        RecyclerView rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        ItemCategoryAdapter adapter = new ItemCategoryAdapter(ItemCategory.createItemCategory(listCategory));
        adapter.setOnItemClickListener(new ItemCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(Category_activity.this, " was clicked!" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Category_activity.this, Lesson_Activity.class);
                startActivity(intent);
            }
        });
        rvCategory.setAdapter(adapter);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
    }

    private void connectNetwork() {
        EConnect eConnect = new EConnect(this);
        eConnect.execute(Constant.API_CATEGORY);
    }

    private void doAfterfetchData() {
        try {
            JSONArray array = this.jsonObject.getJSONArray(Constant.PARA_WORDS);
            ArrayList<Category> listcategoryList = getCategoryList(array);
            doSomeThingWithList(listcategoryList);
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

    @Override
    public void getJson(JSONObject JsonObject) {
        this.jsonObject = JsonObject;
        Log.d("abcde", JsonObject.toString());
        doAfterfetchData();
    }


    private void doSomeThingWithList(ArrayList<Category> listcategoryList) {
        //code vao day de lam viec voi llist category nhe.
        for (int i = 0; i < listcategoryList.size(); i++) {
            //  Log.i("Category_activity", listcategoryList.get(i).getName());
            // Toast.makeText(this, listcategoryList.get(i).getName(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                finish();
                break;
        }
    }
}
