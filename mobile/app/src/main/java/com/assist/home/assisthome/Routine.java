package com.assist.home.assisthome;

import android.bluetooth.BluetoothClass;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.assist.home.assisthome.api.API;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Routine {


    String name;
    String id;


    public Routine(String rName,String id){
        this.name = rName;
        this.id= id;
    }

    public void activate() {
        String URL = API.getUrl() + "/" + "routines/" + id + "/execute";
        Log.v("Shipu", "Activating routine " + id);
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v("Shipu", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }
        };
        API.getInstance().getRequestQueue().add(stringRequest);
    }

}

