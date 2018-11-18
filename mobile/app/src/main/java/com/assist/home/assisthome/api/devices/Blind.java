package com.assist.home.assisthome.api.devices;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.assist.home.assisthome.DeviceAC;
import com.assist.home.assisthome.DeviceBlind;
import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Blind extends Device {

//    public void init(final DeviceBlind blind){
//        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.PUT, this.getUrl() + "/" + "getState",
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("Response57", response.toString());
//                        try {
//                            Log.d("Response54", response.getJSONObject("result").getInt("level") + "");
//                            String status = response.getJSONObject("result").getString("status");
//                            Log.d("response54", status);
//                            if (status.equals("opened") || status.equals("opening")){
//                                blind.open();
//                            } else {
//                                blind.close();
//                            }
//                        } catch (JSONException e){
//                            Log.d("Response54", "No status");
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("Response57", "Wrong");
//                    }
//                }
//        );
//        getAPI().getRequestQueue().add(postRequest);
//    }
    private class BlindStatus{
        String status;
        int level;
    }

    public Boolean isOpen() {
        String state = this.state.get("status");
        if (state == null) {
            return false;
        }
        if (state.equals("opened") || state.equals("opening")) {
            return true;
        }
        return false;
    }

    public void switchState(boolean state){

        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.PUT, this.getUrl() + "/" + (state ? "up" : "down"),
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
