package group8.com.e_learning;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tranngoclinh on 11/20/15.
 */
public class ItemResult {
    private String word, meanning;
    private ImageView imageView;

    public ItemResult(String word, String meanning, ImageView imageView) {
        this.imageView = imageView;
        this.meanning = meanning;
        this.word = word;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getMeanning() {
        return meanning;
    }

    public String getWord() {
        return word;
    }

    private static int lastItem = 0;

    public static List<ItemResult> createItemResult(int numWord) {
        List<ItemResult> itemList = new ArrayList<ItemResult>();
        for (int i = 1; i <= numWord; i++) {
            itemList.add(new ItemResult("abc " + lastItem, "VietNamese", null));
        }
        return itemList;
    }
}
