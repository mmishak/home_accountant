package com.example.mmishak.home_accountant;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private TextView loadingTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.main_web_view);
        loadingTitle = (TextView) findViewById(R.id.loading_title);

        webView.setVisibility(View.GONE);
        loadingTitle.setVisibility(View.VISIBLE);

        System.out.println("LOG Activity Create!");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        updateForm();
    }

    private void updateForm() {
        loadingTitle.setText(R.string.loading_link_title);

        webView.setVisibility(View.GONE);
        loadingTitle.setVisibility(View.VISIBLE);

        System.out.println("LOG Start get link");
        String formURL = GetFormInfoAPI.getFormLink();
        System.out.println("LOG Finish get link");

        loadingTitle.setText(R.string.loading_form_tirle);

        System.out.println("LOG Start load form");
        webView.loadUrl(formURL);
        System.out.println("LOG Finish load form");

        webView.setVisibility(View.VISIBLE);
        loadingTitle.setVisibility(View.GONE);
    }
}
