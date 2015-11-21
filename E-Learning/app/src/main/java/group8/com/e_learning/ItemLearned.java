package group8.com.e_learning;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

import group8.com.e_learning.common.Constant;
import group8.com.e_learning.entities.Lesson;
import android.util.Log;

import static group8.com.e_learning.common.Constant.*;

/**
 * Created by tranngoclinh on 11/20/15.
 */
public class ItemLearned {
    private String categoriesLearned, dateLearned;
    private Image mImage;

    public ItemLearned(String categoriesLearned, String dateLearned) {
        this.categoriesLearned = categoriesLearned;
        this.dateLearned = dateLearned;
        mImage = null;
    }

    public String getCategoriesLearned() {
        return categoriesLearned;
    }

    public String getDateLearned() {
        return dateLearned;
    }

    public Image getmImage() {
        return mImage;
    }

    private static int lastItem = 0;

    public static List<ItemLearned> createItemLearned(ArrayList<Lesson> lessons) {
        List<ItemLearned> itemList = new ArrayList<ItemLearned>();
        for (int i = 0; i < lessons.size(); i++) {
            Lesson les = lessons.get(i);
            String date = les.getCreatedAt();
            Log.i("ItemLearned", "onCreate() Restoring previous state");
            String cate = "";
            switch (lessons.get(i).getCategoryId()) {
                case Constant.CATEGORY_BASIC:
                    cate = "Leaned " + les.getResult() + " words in Lesson \"Basic\"";
                    break;
                case Constant.CATEGORY_ADVANCE:
                    cate = "Leaned " + les.getResult() + " words in Lesson \"Advance\"";
                    break;
                case Constant.CATEGORY_EXPERT:
                    cate = "Leaned " + les.getResult() + " words in Lesson \"Expert\"";
                    break;
                default:
                    cate = "Not found";
                    break;
            }

            itemList.add(new ItemLearned(cate, date));
        }
        return itemList;
    }
}
