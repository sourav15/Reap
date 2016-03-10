package com.letsreap.reap.helpers;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.letsreap.reap.beans.ResponseBean;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.androidannotations.annotations.EBean;

import java.lang.reflect.Type;

/**
 * Created by sourav on 5/3/16.
 */

@EBean
public class AjaxHelper {

    private static final String TAG = "AjaxHelper";

    public static ResponseBean ajax() {

        String response = null;
        String url = "http://mobile-dev.letsreap.com/mobile-api/v1/3eba480b13642409957cdde42e315afbde4b312ba259717aa0bdc09944deee3c0799061800b7854a6252b41895a26a0128e24c0b8efd56c571cc6f8bf7c0f5d1/schemes?store-pincode=411045";

        try {
            OkHttpClient okHttpClient = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            Response responsehttp = okHttpClient.newCall(request).execute();
            response = responsehttp.body().string();
            Log.d(TAG,"response== "+response);
        } catch (Exception e) {
            if(e.getMessage() != null) {
                Log.e(TAG, e.getMessage());
            }
        }

        ResponseBean finalObject = null;
        Gson gson = new Gson();
        Type finalType = new TypeToken<ResponseBean>() {}.getType();
        try {
            finalObject = gson.fromJson(response, finalType);
        } catch (Exception e) {
            Log.e(TAG, "exception " + e.getMessage());
        }
        if (response != null && !response.equals("")) {
            return finalObject;
        } else {
            return null;
        }
    }
}
