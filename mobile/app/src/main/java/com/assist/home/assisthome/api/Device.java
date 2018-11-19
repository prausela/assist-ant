package com.assist.home.assisthome.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.assist.home.assisthome.SingleDevice;
import com.assist.home.assisthome.api.devices.AC;
import com.assist.home.assisthome.api.devices.Blind;
import com.assist.home.assisthome.api.devices.Door;
import com.assist.home.assisthome.api.devices.Fridge;
import com.assist.home.assisthome.api.devices.Oven;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Map;

public class Device implements Serializable {
    private final static String DEVICES_API = "devices";
    public String id;
    public String name;
    public String typeId;
    public DeviceType type;
    public String meta;
    public Map<String,String> decodedMeta;
    public Map<String,String> state;

    public String toString() {
        return id + ": " + name;
    }

    public String getUrl(){
        return API.getUrl() + "/" + DEVICES_API + "/" + this.id;
    }

    protected API getAPI(){
        return API.getInstance();
    }

    public void refreshState(final SingleDevice c) {
        String stateUrl = API.getUrl() + "/devices/" + this.id + "/getState";
        final Gson gson = new Gson();
        final Device that = this;
        final Type type = new TypeToken<Map<String, String>>(){}.getType();
        Log.d("Shipu", "Refreshing state...");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.PUT, stateUrl,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Shipu7", response.toString());
                        try {
                            Map<String, String> state = gson.fromJson(response.getJSONObject("result").toString(), type);
                            that.state = state;
                            c.updateState();
                            Log.v("State refreshsed", response.toString());
                         } catch (JSONException e){
                            Log.d("Shipu4", "No status");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Shipu7", "Wrong");
                    }
                });
        API.getInstance().getRequestQueue().add(postRequest);
    }
    /*public Device deserialize(JsonElement json, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        Log.d("Whatever", "Hello");
        String typeName = API.deviceTypes.get(type).name;
        switch (typeName){
            case "ac":
                return context.deserialize(json, AC.class);
            case "oven":
                return context.deserialize(json, Oven.class);
            case "door":
                return context.deserialize(json, Door.class);
            case "blind":
                return context.deserialize(json, Blind.class);
            case "fridge":
                return context.deserialize(json, Fridge.class);
        }
        return null;
    }*/
}