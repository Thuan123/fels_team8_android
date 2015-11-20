package group8.com.e_learning.common;

import android.content.Context;

/**
 * Created by nomore on 18/11/2015.
 */
public class Constant {

    public static final String API_WORD = "{\"words\":[{\"id\":1,\"content\":\"test1\",\"category_id\":1,\"created_at\":\"2015-11-16T16:33:46.651Z\",\"updated_at\":\"2015-11-16T16:33:46.651Z\"},{\"id\":2,\"content\":\"test2\",\"category_id\":1,\"created_at\":\"2015-11-16T16:33:47.655Z\",\"updated_at\":\"2015-11-16T16:33:47.655Z\"},{\"id\":3,\"content\":\"test3\",\"category_id\":2,\"created_at\":\"2015-11-16T16:33:48.584Z\",\"updated_at\":\"2015-11-16T16:33:48.584Z\"},{\"id\":4,\"content\":\"test4\",\"category_id\":2,\"created_at\":\"2015-11-16T16:33:49.255Z\",\"updated_at\":\"2015-11-16T16:33:49.255Z\"}]}";


    public static final String API_LOGIN = "https://powerful-beach-9556.herokuapp.com/login.json";
    //public static final String API_SIGNUP = "https://protected-earth-1676.herokuapp.com/users.json";
    public static final String API_SIGNUP = "https://powerful-beach-9556.herokuapp.com/signup.json";
    public static final String LOGIN_SESSION = "session";
    public static final String SIGNUP_SESSION = "user";
    public static final String WORD_SESSION = "words";
    public static final String PARA_EMAIL = "";
        public static final String PARA_PASS = "";
    public static boolean registerDone = false;
    public static Context context = null;

}
