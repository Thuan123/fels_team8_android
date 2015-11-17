package group8.com.e_learning.network;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nomore on 14/11/2015.
 */
public class EConnect extends AsyncTask<String, String, JSONObject>{
    private OnConnected mOnConnected;

    public EConnect(OnConnected mOnConnected) {
        this.mOnConnected = mOnConnected;
    }

    protected JSONObject doInBackground(String... api) {
        String response = "";
        JSONObject object = null;

        try {
            URL url = new URL(api[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line = "";

            while ((line = reader.readLine()) != null)
                response = response.concat(line + "\n");
            conn.disconnect();

            object = new JSONObject(response);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return object;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);

        if (mOnConnected != null) {
            mOnConnected.getJson(result);
        }

    }


//    public JSONObject  getJson(String api)
//    {
//
//    }

    public interface OnConnected {
        public void getJson(JSONObject jsonObject);
    }
}
