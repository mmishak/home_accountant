package com.example.mmishak.home_accountant;

import android.os.AsyncTask;
import android.view.View;
import android.webkit.WebView;

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

    @Override
    protected String doInBackground(String... params) {

        try {
            URL url = new URL(params[0]);
            URLConnection conn = url.openConnection();
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

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        webView.setVisibility(View.GONE);
        loadingTitle.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        new GetFormTask().execute(s);
    }

    private String parseFormURL(JSONObject json) throws JSONException {
        return json.getJSONArray("results").getJSONObject(0).getString("form_url");
    }
}
