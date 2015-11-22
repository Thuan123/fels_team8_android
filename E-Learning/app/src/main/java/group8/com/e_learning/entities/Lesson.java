package group8.com.e_learning.entities;

import android.widget.Toast;

import group8.com.e_learning.Lesson_Activity;

/**
 * Created by tranngoclinh on 11/21/15.
 */
public class Lesson {
    private int id;
    private int userId;
    private int categoryId;
    private int result;
    private String createdAt;
    private String updatedAt;

    public Lesson() {
        id = userId = categoryId = result = 0;
        createdAt = "";
        updatedAt = "";
    }

    public Lesson(int categoryId, String createdAt, int id, int result, String updatedAt, int userId) {
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.id = id;
        this.result = result;
        this.updatedAt = updatedAt;
        this.userId = userId;

    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
