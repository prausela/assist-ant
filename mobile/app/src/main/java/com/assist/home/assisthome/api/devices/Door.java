package com.assist.home.assisthome.api.devices;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.assist.home.assisthome.AppActivity;
import com.assist.home.assisthome.DeviceActivity;
import com.assist.home.assisthome.DeviceDoor;
import com.assist.home.assisthome.R;
import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;
import com.assist.home.assisthome.api.DeviceEvent;
import com.assist.home.assisthome.notifications.NotificationBroadcastReceiver;
import com.assist.home.assisthome.notifications.NotificationChecker;

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

    @Override
    public void notifyEvent(DeviceEvent e) {
        Log.v("Shipu", "sending notification...");
        Context c = API.getInstance().context;
        Intent intent2 = new Intent(c, DeviceDoor.class);
        intent2.putExtra("device",e.device.id);
        String title = e.device.name;
        if (e.event.equals("statusChanged")) {
            if (e.args.get("newStatus") == "closed") {
                title += " "+AppActivity.getContext().getString(R.string.device_closed);
            }  else {
                title += " "+AppActivity.getContext().getString(R.string.device_opened);

            }
        } else if ( e.event.equals("lockChanged")) {
            if (e.args.get("newLock") == "locked") {
                title +=" "+ AppActivity.getContext().getString(R.string.door_locked);
                }  else {
                title +=" "+ AppActivity.getContext().getString(R.string.door_unlocked);
                }
        }
        new NotificationBroadcastReceiver().sendNotification(c, intent2, title);
    }
}
