package com.assist.home.assisthome.api;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.assist.home.assisthome.api.devices.AC;
import com.assist.home.assisthome.api.devices.Blind;
import com.assist.home.assisthome.api.devices.Door;
import com.assist.home.assisthome.api.devices.Fridge;
import com.assist.home.assisthome.api.devices.Oven;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

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