package com.assist.home.assisthome.api.devices;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.assist.home.assisthome.AppActivity;
import com.assist.home.assisthome.DeviceBlind;
import com.assist.home.assisthome.R;
import com.assist.home.assisthome.SingleDevice;
import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;
import com.assist.home.assisthome.api.DeviceEvent;
import com.assist.home.assisthome.notifications.NotificationBroadcastReceiver;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Fridge extends Device {
    public static Resources resources;


    public void setTemperature(int temperature) {
        String URL = getUrl() + "/" + "setTemperature";
        final String requestBody = "[" + temperature + "]";

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String responseString = "";
                if (response != null) {
                    responseString = String.valueOf(response.statusCode);
                    // can get more details such as response.headers
                }
                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        getAPI().getRequestQueue().add(stringRequest);
    }

    public void setFreezerTemperature(int temperature) {
        String URL = getUrl() + "/" + "setFreezerTemperature";
        final String requestBody = "[" + temperature + "]";

        StringRequest stringRequest = new StringRequest(Request.Method.PUT, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("VOLLEY", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String responseString = "";
                if (response != null) {
                    responseString = String.valueOf(response.statusCode);
                    // can get more details such as response.headers
                }
                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        getAPI().getRequestQueue().add(stringRequest);
    }

    public void setMode(String mode, final SingleDevice context) {
        String URL = getUrl() + "/" + "setMode";
        final String requestBody = "[\"" + mode + "\"]";
        final Fridge that = this;
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                that.refreshState(context);
                Log.i("VOLLEY", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                try {
                    return requestBody == null ? null : requestBody.getBytes("utf-8");
                } catch (UnsupportedEncodingException uee) {
                    VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                    return null;
                }
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                String responseString = "";
                if (response != null) {
                    responseString = String.valueOf(response.statusCode);
                    // can get more details such as response.headers
                }
                return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
            }
        };

        getAPI().getRequestQueue().add(stringRequest);
    }

    @Override
    public void notifyEvent(DeviceEvent e) {
        Log.v("Shipu", "sending notification...");
        Context c = API.getInstance().context;
        Intent intent2 = new Intent(c, DeviceBlind.class);
        intent2.putExtra("device",e.device.id);
        String title = e.device.name;

        if (e.event.equals("modeChanged")) {
            if (e.args.get("newMode").equals("party")) {
                Log.v("Notif", AppActivity.getContext().getString(R.string.fridge_party));
                title+=" "+AppActivity.getContext().getString(R.string.fridge_party);
            } else if(e.args.get("newMode").equals("vacation")){
                Log.v("Notif", AppActivity.getContext().getString(R.string.fridge_trip));
                title+=" "+ AppActivity.getContext().getString(R.string.fridge_trip);
            }else{
                Log.v("Notif", AppActivity.getContext().getString(R.string.fridge_def));
                title+=" "+ AppActivity.getContext().getString(R.string.fridge_def);
            }

        }
        new NotificationBroadcastReceiver().sendNotification(c, intent2, title);
    }



}
