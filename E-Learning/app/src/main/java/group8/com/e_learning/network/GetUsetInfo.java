package group8.com.e_learning.network;

import org.json.JSONObject;

import group8.com.e_learning.common.SharedPreferencesHelper;
import group8.com.e_learning.entities.User;

/**
 * Created by nomore on 19/11/2015.
 */
public class GetUsetInfo {

    public User getUserInfo(JSONObject object)
    {
        if (object == null)
        {
            SharedPreferencesHelper preferencesHelper = SharedPreferencesHelper.getInstance();
            return new User(preferencesHelper.getUser1Email(), preferencesHelper.getUser1Pass(), preferencesHelper.getUser1Name());
        }
        return null;
    }

}
