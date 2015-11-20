package group8.com.e_learning.common;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nomore on 12/11/2015.
 */
public class SharedPreferencesHelper {

    private static SharedPreferencesHelper instance = null;
    public static final int LENGTH_OF_PREFERENCES = 35;

    private SharedPreferencesHelper() {

    }

    public static SharedPreferencesHelper getInstance() {
        if (instance == null) {
            instance = new SharedPreferencesHelper();
        }
        return instance;
    }

    public void setUser1Email(String email)
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo",0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("user1_email", email);
        edit.apply();
    }

    public String getUser1Email()
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sharedPreferences.getString("user1_email",null);
    }

    public void setUser2Email(String email)
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo",0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("user2_email", email);
        edit.apply();
    }

    public String getUser2Email()
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sharedPreferences.getString("user2_email",null);
    }



    public void setUser1Password(String email)
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo",0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("user1_pass", email);
        edit.apply();
    }

    public String getUser1Pass()
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sharedPreferences.getString("user1_pass",null);
    }


    public void setUser2Password(String email)
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo",0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("user2_pass", email);
        edit.apply();
    }

    public String getUser2Pass()
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sharedPreferences.getString("user2_pass",null);
    }

    public void setUser1Name(String email)
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo",0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("user1_name", email);
        edit.apply();
    }

    public String getUser1Name()
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sharedPreferences.getString("user1_name",null);
    }




    public void setUser2Name(String email)
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo",0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("user2_name", email);
        edit.apply();
    }

    public String getUser2Name()
    {
        SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sharedPreferences.getString("user2_name",null);
    }

       /* public boolean getCheckLogin() {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getBoolean("CHECK_LOGIN", false);
        }

        public void setCheckLogin(boolean checkLogin) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putBoolean("CHECK_LOGIN", checkLogin);
            user.apply();
        }

        public boolean getCheckIntrusion() {
            SharedPreferences preferences = Application.getInstance().getSharedPreferences("CheckInstrusion", Context.MODE_PRIVATE);
            return preferences.getBoolean("CHECK_INSTRUSION", false);
        }

        public void setCheckIntrusion(boolean checkInstrusion)
        {
            SharedPreferences preferences = Application.getInstance().getSharedPreferences("CheckInstrusion", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = preferences.edit();
            user.putBoolean("CHECK_INSTRUSION",checkInstrusion);
            user.apply();
        }

        public void setInstrusionTime(String time)
        {
            SharedPreferences preferences = Application.getInstance().getSharedPreferences("CheckInstrusion", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = preferences.edit();
            user.putString("TIME_INSTRUSION", time);
            user.apply();
        }
        public String getInstrusionTime() {
            SharedPreferences preferences = Application.getInstance().getSharedPreferences("CheckInstrusion", Context.MODE_PRIVATE);
            return preferences.getString("TIME_INSTRUSION", "");
        }

        public String getUserRealPW() {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getString("PIN_REAL", "");
        }

        public void setUserRealPW(String realPIN) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putString("PIN_REAL", realPIN);
            user.apply();
        }

        public String getUserFakePW() {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getString("PIN_FAKE", "");
        }

        public void setUserFakePW(String fakePIN) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putString("PIN_FAKE", fakePIN);
            user.apply();
        }

        public void setDestNumber(String destNumber) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putString("DEST_NUMBER", destNumber);
            user.apply();
        }

        public String getDestNumber() {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getString("DEST_NUMBER", "");
        }

        public void setDestName(String destName) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putString("DEST_NAME", destName);
            user.apply();
        }

        public String getDestName() {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getString("DEST_NAME", "");
        }

        public void setUserName(String name) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putString("USER_NAME", name);
            user.apply();
        }

        public String getUserName() {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getString("USER_NAME", "Bro");
        }

        public void setWifiList(String key, ArrayList<String> wifiList) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("WifiInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            Set<String> wifiSet = new HashSet<>(wifiList);
            user.putStringSet(key, wifiSet);
            user.apply();
        }

        public ArrayList<String> getWifiList(String key) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("WifiInfo", Context.MODE_PRIVATE);
            Set<String> wifiSet = sharedPreferences.getStringSet(key, null);
            ArrayList<String> wifiList = new ArrayList<>();
            if (wifiSet != null)
                wifiList.addAll(wifiSet);
            Collections.sort(wifiList);
            return wifiList;
        }

        public void setWifiCheck(String key, boolean state) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("WifiInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putBoolean(key, state);
            user.apply();
        }

        public boolean getWifiCheck(String key) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("WifiInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getBoolean(key, false);
        }

        public void setGpsCheck(String key, boolean state) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("GpsInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putBoolean(key, state);
            user.apply();
        }

        public boolean getGpsCheck(String key) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("GpsInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getBoolean(key, false);
        }

        public void setLongitude(String key, float longitude)
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("GpsInfo", 0);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putFloat(key, longitude);
            user.apply();
        }

        public float getLongitude(String key)
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("GpsInfo", 0);
            return sharedPreferences.getFloat(key,0);
        }

        public void setLatitude(String key, float latitude)
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("GpsInfo", 0);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putFloat(key, latitude);//key == ..._lat
            user.apply();
        }

        public float getLatitude(String key)
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("GpsInfo", 0);
            return sharedPreferences.getFloat(key,0);//...lat
        }


        public void setDaysPreferences(String value) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putString("DAYS", value);
            user.apply();
        }

        public String getDaysPreferences() {
            char[] charArray = new char[LENGTH_OF_PREFERENCES];
            Arrays.fill(charArray, '0');
            String str = new String(charArray);
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
            return sharedPreferences.getString("DAYS", str);
        }

        public void setGirlWifiState(boolean state)
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("StopSend", 0);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putBoolean("WIFI", state);//key == ..._lat
            user.apply();
        }

        public boolean getGirlWifiState()
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("StopSend",0);
            return sharedPreferences.getBoolean("WIFI",false);
        }

        public void setGirlGpsState(boolean state)
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("StopSend", 0);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putBoolean("GPS", state);//key == ..._lat
            user.apply();
        }

        public boolean getGirlGpsState()
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("StopSend",0);
            return sharedPreferences.getBoolean("GPS",false);
        }

        public void setDatabaseVersion(int version) {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("AppInfo", 0);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putInt("VERSION", version);
            user.apply();
        }

        public int getDatabaseVersion() {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("AppInfo", 0);
            return sharedPreferences.getInt("VERSION", 1);
        }

        public void setAutoReply(boolean auto)
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("reply", 0);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putBoolean("auto", auto);
            user.apply();
        }

        public boolean getAutoReply()
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("reply", 0);
            return sharedPreferences.getBoolean("auto",false);
        }

        public void setReplyWaitTime(int time)
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("reply", 0);
            SharedPreferences.Editor user = sharedPreferences.edit();
            user.putInt("time", time);
            user.apply();
        }

        public int getReplyWaitTime()
        {
            SharedPreferences sharedPreferences = Application.getInstance().getSharedPreferences("reply", 0);
            return sharedPreferences.getInt("time",0);
        }

    }*/

}
