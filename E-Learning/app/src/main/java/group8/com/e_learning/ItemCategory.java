package group8.com.e_learning;

import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Category;
import group8.com.e_learning.entities.Lesson;

/**
 * Created by tranngoclinh on 11/22/15.
 */
public class ItemCategory {
    ImageView ivCategory;
    String nameCatergory, progress, listWord;

    public ItemCategory() {
        nameCatergory = "";
        progress = "";
        listWord = "";
        ivCategory = null;
    }

    public ItemCategory(ImageView ivCategory, String listWord, String nameCatergory, String progress) {
        this.ivCategory = ivCategory;
        this.listWord = listWord;
        this.nameCatergory = nameCatergory;
        this.progress = progress;
    }

    public ImageView getIvCategory() {
        return ivCategory;
    }

    public void setIvCategory(ImageView ivCategory) {
        this.ivCategory = ivCategory;
    }

    public String getListWord() {
        return listWord;
    }

    public void setListWord(String listWord) {
        this.listWord = listWord;
    }

    public String getNameCatergory() {
        return nameCatergory;
    }

    public void setNameCatergory(String nameCatergory) {
        this.nameCatergory = nameCatergory;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    private static int lastItem = 0;

    public static List<ItemCategory> createItemCategory(ArrayList<Category> categories) {
        List<ItemCategory> itemList = new ArrayList<ItemCategory>();
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            itemList.add(new ItemCategory(null, "word...." + i, category.getName(), "prcess" + i));
        }
        return itemList;
    }
}
