package group8.com.e_learning;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Category;
import group8.com.e_learning.entities.Word;

public class Category_activity extends Activity implements View.OnClickListener{
    ArrayList<Category> listCategory = new ArrayList<Category>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_activity);
        initList();
        setRecycleView();
    }
    private void initList(){
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
    }

    private void setRecycleView() {
        RecyclerView rvCategory = (RecyclerView) findViewById(R.id.rv_category);
        ItemCategoryAdapter adapter = new ItemCategoryAdapter(ItemCategory.createItemCategory(listCategory));
        rvCategory.setAdapter(adapter);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_back:
                finish();
                break;
        }
    }
}
