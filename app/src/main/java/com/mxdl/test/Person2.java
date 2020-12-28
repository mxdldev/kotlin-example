package com.mxdl.test;

import android.util.JsonReader;

import org.json.JSONException;
import org.json.JSONObject;

public class Person2 {
    public static void main(String[] args) {
       String val = "{a:123}";
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(val);
            int a = jsonObject.getInt("a");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //System.out.println("ok");

    }
}
