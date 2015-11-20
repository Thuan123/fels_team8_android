package group8.com.e_learning;

/**
 * Created by nomore on 17/11/2015.
 */
public class User {
    private String userName;
    private String passWord;
    private String fullName;

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
