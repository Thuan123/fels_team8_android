package group8.com.e_learning.entities;

/**
 * Created by tranngoclinh on 11/21/15.
 */
public class Category {
    private int id;
    private String name;
    private String createdAt;
    private String updateAt;

    public Category() {
        id = 0;
        name = "";
        createdAt = "";
        updateAt = "";
    }

    public Category(String createdAt, int id, String name, String updateAt) {
        this.createdAt = createdAt;
        this.id = id;
        this.name = name;
        this.updateAt = updateAt;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }
}
