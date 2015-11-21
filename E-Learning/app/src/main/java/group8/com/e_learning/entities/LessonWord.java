package group8.com.e_learning.entities;

/**
 * Created by tranngoclinh on 11/21/15.
 */
public class LessonWord {
    private int id;
    private int lessonId;
    private int wordId;
    private int wordAnswerId;
    private String createdAt;
    private String updatedAt;

    public LessonWord() {
        id = lessonId = wordId = wordAnswerId = 0;
        createdAt = "";
        updatedAt = "";
    }

    public LessonWord(String createdAt, int id, int lessonId, String updatedAt, int wordAnswerId, int wordId) {
        this.createdAt = createdAt;
        this.id = id;
        this.lessonId = lessonId;
        this.updatedAt = updatedAt;
        this.wordAnswerId = wordAnswerId;
        this.wordId = wordId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getWordAnswerId() {
        return wordAnswerId;
    }

    public void setWordAnswerId(int wordAnswerId) {
        this.wordAnswerId = wordAnswerId;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }
}
