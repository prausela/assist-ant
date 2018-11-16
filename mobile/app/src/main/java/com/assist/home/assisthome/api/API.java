package com.assist.home.assisthome.api;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.*;
import com.android.volley.toolbox.*;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brian on 13/11/18.
 */

public class API {

    static String url = "http://192.168.0.9:8080/api";
    public static String baseUrl() {
        return url;
    }


}
