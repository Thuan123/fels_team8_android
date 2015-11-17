package group8.com.e_learning.common;

import android.content.Context;

/**
 * Created by nomore on 12/11/2015.
 */
public class Application extends android.app.Application {

    private static Application instance;

    public Application() {
        instance = this;
    }

    public static Context getInstance() {
        return instance;
    }

    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
