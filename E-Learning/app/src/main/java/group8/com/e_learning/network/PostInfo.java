package group8.com.e_learning.network;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.Buffer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import group8.com.e_learning.common.Application;
import group8.com.e_learning.common.Constant;

/**
 * Created by nomore on 18/11/2015.
 */
public class PostInfo extends AsyncTask<String,String,JSONObject>  {

    private OnConnected mOnConnected;

    public PostInfo(OnConnected mOnConnected) {
        this.mOnConnected = mOnConnected;
    }

    private JSONObject getJson(HttpURLConnection conn) throws Exception
    {
        BufferedReader rd = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String line;
        StringBuilder stringBuilder = new StringBuilder();


        while ((line = rd.readLine()) != null) {
            stringBuilder.append(line);

        }
        return new JSONObject(stringBuilder.toString());
    }

    @Override
    protected JSONObject doInBackground(String... api) {
        String response = "";
        JSONObject object = null;

        try {
            URL url = new URL(api[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);

            //set timeout
            conn.setConnectTimeout(10000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            JSONObject bodyObject = new JSONObject();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", api[1]);
            jsonObject.put("password", api[2]);
            if (api.length > 4) {

                jsonObject.put("name", api[4]);
                jsonObject.put("password_confirmation", api[5]);
            }

            bodyObject.put(api[3], jsonObject);


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(bodyObject.toString());
            writer.flush();
            writer.close();

            int responseCode = conn.getResponseCode();
            //checkRsponseHeader(conn);
            if (responseCode == 200) object = getJson(conn);
            else object = null;
           // Log.d("Header", "token = " + getHeaderSession(conn));

            if (api.length < 5)getHeaderSession(conn);
            Log.d("Post info",object.toString());
            //Log.d("Headesr","nothing");
            //Log.d("Header","token = " + Constant.token);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return object;
    }

    private void checkRsponseHeader(HttpURLConnection conn) {
        Map<String,List<String>> map = conn.getHeaderFields();
        for(Map.Entry<String,List<String>> entry:map.entrySet())
        {
            Log.d(entry.getKey(), entry.getValue().toString());
        }
    }

    private void getHeaderSession(HttpURLConnection conn) throws Exception
    {

        String cookies =  conn.getHeaderField(Constant.LOGIN_TOKEN);
        //Constant.token = cookies;
        Constant.cookiesManager.getCookieStore().add(null, HttpCookie.parse(cookies).get(0));

       /* int startIndex = cookies.indexOf('=') + 1,
            endIndex = cookies.indexOf(';');
        return cookies.substring(startIndex,endIndex);*/





    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);

        if (mOnConnected != null) {
            mOnConnected.getJson(result);
        }
        //Log.d("PostInfo", "result.toString() " + result.toString());
        //Toast.makeText(Application.getInstance(), result.toString(), Toast.LENGTH_LONG).show();

    }

    public interface OnConnected {
        public void getJson(JSONObject jsonObject);


    }
}
