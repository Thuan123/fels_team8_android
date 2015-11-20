package group8.com.e_learning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tranngoclinh on 11/20/15.
 */
public class ItemWord {
    private String word, meaning;

    public ItemWord(String meaning, String word) {
        this.meaning = meaning;
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getWord() {
        return word;
    }

    private static int lastItem = 0;

    public static List<ItemWord> createItemWord(int numWord) {
        List<ItemWord> itemList = new ArrayList<ItemWord>();
        for (int i = 1; i <= numWord; i++) {
            itemList.add(new ItemWord("abc " + lastItem, "VietNamese"));
        }
        return itemList;
    }
}
