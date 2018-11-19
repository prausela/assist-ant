package com.assist.home.assisthome.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class API {
    static String url = "http://192.168.1.208:8080/api";
    public static Map<String, DeviceType> deviceTypes = new HashMap<>();
    public static Map<String, Device> devices = new HashMap<>();
    public static String getUrl() {
        return url;
    }
    private static API api;
    private Context context;
    private RequestQueue requestQueue;

    private API(Context context){
        this.context = context;
    }

    static API getInstance(){
        return api;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public static API getInstance(Context context){
        if (api == null){
            api = new API(context);
        }
        return api;
    }

    public static void loadTypes(List<DeviceType> types) {
        for (DeviceType t : types) {
            Log.d("Shipu", "Added devicetype: " + t.name);
            deviceTypes.put(t.id,t);
        }
    }
}
