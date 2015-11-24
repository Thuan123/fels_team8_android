package group8.com.e_learning;

import java.util.ArrayList;
import java.util.List;

import group8.com.e_learning.entities.Word;
import group8.com.e_learning.entities.WordAnswer;

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

    public static List<ItemWord> createItemWord(ArrayList<Word> list) {
        List<ItemWord> itemList = new ArrayList<ItemWord>();
        String mean = "";
        for (int i = 0; i < list.size(); i++) {
            Word item = list.get(i);
            itemList.add(new ItemWord(item.getRightAnswer(), item.getContent()));
        }
        return itemList;
    }
}
