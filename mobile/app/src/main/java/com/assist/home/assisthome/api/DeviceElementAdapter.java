package com.assist.home.assisthome.api;

import android.util.Log;

import com.assist.home.assisthome.api.devices.AC;
import com.assist.home.assisthome.api.devices.Blind;
import com.assist.home.assisthome.api.devices.Door;
import com.assist.home.assisthome.api.devices.Fridge;
import com.assist.home.assisthome.api.devices.Oven;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class DeviceElementAdapter implements JsonDeserializer<Device> {
    @Override
    public Device deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("typeId").getAsString();
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
            case "refrigerator":
                return context.deserialize(json, Fridge.class);
        }
        return null;
    }
}
