package com.example.mmishak.home_accountant;

import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by mmishak on 8/9/17.
 */

public class FormAPI {

    static private String API_URL = "https://randomapi.com/api/9whi1ld8?key=204U-L3PQ-GZQ3-3PJN";

    private FormAPI() {
    }

    static public void updateForm() {
        new GetFormInfoTask().execute(API_URL);
    }
}
