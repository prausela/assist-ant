package com.assist.home.assisthome.api.devices;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.assist.home.assisthome.api.Device;

import org.json.JSONObject;

public class Door extends Device {
    public void switchState(boolean state){

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.PUT, this.getUrl() + "/" + (state ? "open" : "close"),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response57", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Response57", "Wrong");
                    }
                }
        );
        getAPI().getRequestQueue().add(postRequest);
    }

    public void switchLock(boolean state){
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.PUT, this.getUrl() + "/" + (state ? "lock" : "unlock"),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response57", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Response57", "Wrong");
                    }
                }
        );
        getAPI().getRequestQueue().add(postRequest);
    }
}
