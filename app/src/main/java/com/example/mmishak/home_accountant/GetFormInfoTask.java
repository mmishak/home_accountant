package com.example.mmishak.home_accountant;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by mmishak on 8/9/17.
 */

class GetFormInfoTask extends AsyncTask<String, Integer, String> {

    private String response;

    @Override
    protected String doInBackground(String... params) {

        try {
            URL url = new URL(params[0]);
            URLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return parseFormURL(new JSONObject(sb.toString()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String parseFormURL(JSONObject json) throws JSONException {
        return json.getJSONObject("results").getString("form_url");
    }
}
