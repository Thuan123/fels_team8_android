package group8.com.e_learning.entities;

/**
 * Created by tranngoclinh on 11/21/15.
 */
public class WordAnswer {
    private int id;
    private String content;
    private int wordId;
    private int correct;
    private String creatAt;
    private String updateAt;

    public WordAnswer() {
        id = wordId = correct = 0;
        content = "";
        creatAt = "";
        updateAt = "";
    }

    public WordAnswer(String content, int correct, String creatAt, int id, String updateAt, int wordId) {
        this.content = content;
        this.correct = correct;
        this.creatAt = creatAt;
        this.id = id;
        this.updateAt = updateAt;
        this.wordId = wordId;
    }

    public String getContent() {
        return content;
    }

    public int getCorrect() {
        return correct;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public int getId() {
        return id;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public int getWordId() {
        return wordId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }
}
