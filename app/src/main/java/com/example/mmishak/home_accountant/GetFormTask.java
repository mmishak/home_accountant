package com.example.mmishak.home_accountant;

import android.os.AsyncTask;
import android.view.View;

/**
 * Created by mmishak on 8/9/17.
 */

public class GetFormTask extends AsyncTask<String, Integer, String> {
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        webView.setVisibility(View.VISIBLE);
        loadingTitle.setVisibility(View.GONE);
        refreshLayout.setRefreshing(false);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        loadingTitle.setText(R.string.loading_link_title);
    }

    @Override
    protected String doInBackground(String... params) {
        webView.loadUrl(params[0]);
        return null;
    }
}
