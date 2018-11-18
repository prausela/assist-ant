package com.assist.home.assisthome.api;

import java.io.Serializable;
import java.util.Map;

public class Device implements Serializable {
    public String id;
    public String name;
    public String typeId;
    public DeviceType type;
    public String meta;
    public Map<String,String> decodedMeta;

    public String toString() {
        return id + ": " + name;
    }
}
