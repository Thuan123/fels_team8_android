package group8.com.e_learning.entities;

/**
 * Created by nomore on 17/11/2015.
 */
public class Word {
    private int id;
    private String content;
    private int categoryId;
    private String creatAt;
    private String updateAt;
    private int status;
    private WordAnswer[] wordAnswer;
    private String rightAnswer;

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public WordAnswer[] getWordAnswer() {
        return wordAnswer;
    }

    public void setWordAnswer(WordAnswer[] wordAnswer) {
        this.wordAnswer = wordAnswer;
    }

    public Word() {
        id = categoryId = status = 0;
        content = "";
        creatAt = "";
        updateAt = "";
        wordAnswer = new WordAnswer[4];
    }

    public Word(int categoryId, String content, String creatAt, int id, String updateAt, int status, WordAnswer[] wordAnswer, String rightAnswer) {
        this.categoryId = categoryId;
        this.content = content;
        this.creatAt = creatAt;
        this.id = id;
        this.updateAt = updateAt;
        this.status = status;
        this.wordAnswer = wordAnswer;
        this.rightAnswer = rightAnswer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
