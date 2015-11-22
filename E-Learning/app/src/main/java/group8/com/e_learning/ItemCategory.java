package group8.com.e_learning;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import group8.com.e_learning.entities.Category;

/**
 * Created by tranngoclinh on 11/23/15.
 */
public class ItemCategory {
    private ImageView ivCategory;
    private String nameCategory, progressCategory, wordCategory;

    public ItemCategory() {
        ivCategory = null;
        nameCategory = "";
        progressCategory = "";
        wordCategory = "";
    }

    public ItemCategory(ImageView ivCategory, String nameCategory, String progressCategory, String wordCategory) {
        this.ivCategory = ivCategory;
        this.nameCategory = nameCategory;
        this.progressCategory = progressCategory;
        this.wordCategory = wordCategory;
    }

    public ImageView getIvCategory() {
        return ivCategory;
    }

    public void setIvCategory(ImageView ivCategory) {
        this.ivCategory = ivCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getProgressCategory() {
        return progressCategory;
    }

    public void setProgressCategory(String progressCategory) {
        this.progressCategory = progressCategory;
    }

    public String getWordCategory() {
        return wordCategory;
    }

    public void setWordCategory(String wordCategory) {
        this.wordCategory = wordCategory;
    }

    private static int lastItem = 0;

    public static List<ItemCategory> createItemCategory(ArrayList<Category> list) {
        List<ItemCategory> itemList = new ArrayList<ItemCategory>();
        for (int i = 0; i < list.size(); i++) {
            Category category = list.get(i);
            itemList.add(new ItemCategory(null, category.getName(), "a", "b"));
        }
        return itemList;
    }
}
