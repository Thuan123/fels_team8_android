package group8.com.e_learning.common;

import android.content.Context;

import java.net.CookieManager;

/**
 * Created by nomore on 18/11/2015.
 */
public class Constant {



    public static final String API_WORD_ONLINE = "https://frteam8.herokuapp.com/words.json";
    public static final String API_LOGIN = "https://frteam8.herokuapp.com/login.json";
    public static final String API_SIGNUP = "https://frteam8.herokuapp.com/signup.json";
    public static final String API_CATEGORY = "https://frteam8.herokuapp.com/categories.json";
    public static final String API_EDIT_PROFILE = "https://frteam8.herokuapp.com/user/:id.json";


    public static final String LOGIN_SESSION = "session";
    public static final String SIGNUP_SESSION = "user";
    public static final String WORD_SESSION = "words";
    public static final String PARA_EMAIL = "email";
    public static final String PARA_PASS = "password";
    public static final String PARA_NAME = "name";
    public static final String PARA_PASS_CONFIRM = "password_confimation";

    public static final int CATEGORY_BASIC = 0;
    public static final int CATEGORY_ADVANCE = 1;
    public static final int CATEGORY_EXPERT = 2;
    public static final int LEARNED = 0;
    public static final int NOT_LEARNED = 1;

    public static final String LOGIN_TOKEN = "Set-Cookie";
    public static final String PARA_WORDS = "words";
    public static final String  PARA_ID = "id";
    public static final String PARA_CONTENT = "content";
    public static final String PARA_RIGHT_ANSWER = "content_right_word_answer";
    public static final String PARA_CATEGORY_ID = "category_id";
    public static final String PARA_TYPE="type";
    public static final String PARA_ANSWER ="answer" ;
    public static final String PARA_CORRECT = "PARA_CORRECT";
    public static final String API_LESSON = "https://frteam8.herokuapp.com/categories/%d/lessons.json";
    public static final String PARA_USER = "user";


    public static boolean registerDone = false;
    public static Context context = null;
    public static String token = "abc";

    public static CookieManager cookiesManager = new CookieManager();





    //public static final String API_LOGIN = "https://protected-earth-1676.herokuapp.com/login.json";
    //public static final String API_SIGNUP = "https://protected-earth-1676.herokuapp.com/users.json";
    //public static final String API_WORD_ONLINE = "http://giapponese.herokuapp.com/words.json";

    public static final String API_WORD_OFFLINE = "{\"words\":[{\"id\":1,\"content\":\"test1\",\"category_id\":1,\"created_at\":\"2015-11-16T16:33:46.651Z\",\"updated_at\":\"2015-11-16T16:33:46.651Z\"},{\"id\":2,\"content\":\"test2\",\"category_id\":1,\"created_at\":\"2015-11-16T16:33:47.655Z\",\"updated_at\":\"2015-11-16T16:33:47.655Z\"},{\"id\":3,\"content\":\"test3\",\"category_id\":2,\"created_at\":\"2015-11-16T16:33:48.584Z\",\"updated_at\":\"2015-11-16T16:33:48.584Z\"},{\"id\":4,\"content\":\"test4\",\"category_id\":2,\"created_at\":\"2015-11-16T16:33:49.255Z\",\"updated_at\":\"2015-11-16T16:33:49.255Z\"}]}";


}
