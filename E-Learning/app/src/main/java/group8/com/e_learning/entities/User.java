package group8.com.e_learning.entities;

/**
 * Created by nomore on 17/11/2015.
 */
public class User {
    private int id;
    private String userName;
    private String passWord;
    private String fullName;
    private String creatAt;
    private String updateAt;

    public User(String creatAt, String fullName, int id, String passWord, String updateAt, String userName) {
        this.creatAt = creatAt;
        this.fullName = fullName;
        this.id = id;
        this.passWord = passWord;
        this.updateAt = updateAt;
        this.userName = userName;
    }

    public String getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(String creatAt) {
        this.creatAt = creatAt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public User(String userName, String passWord, String fullName) {
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
