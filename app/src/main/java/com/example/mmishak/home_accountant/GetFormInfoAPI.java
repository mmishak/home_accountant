package com.example.mmishak.home_accountant;

import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

/**
 * Created by mmishak on 8/9/17.
 */

public class GetFormInfoAPI {

    static private String API_URL = "https://randomapi.com/api/9whi1ld8?key=204U-L3PQ-GZQ3-3PJN";

    private GetFormInfoAPI() {
    }

    static public String getFormLink() {
        GetFormInfoTask task = new GetFormInfoTask();
        try {
            return task.execute(API_URL).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
