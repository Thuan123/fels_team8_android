package group8.com.e_learning;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tranngoclinh on 11/20/15.
 */
public class ItemLearned {
    private String categoriesLearned, dateLearned;
    private Image mImage;

    public ItemLearned(String categoriesLearned, String dateLearned, Image mImage) {
        this.categoriesLearned = categoriesLearned;
        this.dateLearned = dateLearned;
        this.mImage = mImage;
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

    public static List<ItemLearned> createItemLearned(int numLearned) {
        List<ItemLearned> itemList = new ArrayList<ItemLearned>();
        for (int i = 1; i <= numLearned; i++) {
            itemList.add(new ItemLearned("Personjkahsdfhlahsdfklhaksjdhfkjahskdfjhaskjdhfkjashdfkhasdkfhkashfdk " + ++lastItem, lastItem +
                    "/" + lastItem + "/" + lastItem, null));
        }
        return itemList;
    }
}
