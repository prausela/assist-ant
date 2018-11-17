package com.assist.home.assisthome.api;

import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class API {
    static String url = "http://186.136.83.173:9090/api";

    public static Map<String, DeviceType> deviceTypes = new HashMap<>();
    public static String getUrl() {
        return url;
    }

    public static void loadTypes(List<DeviceType> types) {
        for (DeviceType t : types) {
            Log.d("Shipu", "Added devicetype: " + t.name);
            deviceTypes.put(t.id,t);
        }
    }
}
