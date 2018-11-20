package com.assist.home.assisthome.api;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class DeviceEvent {
    public String deviceId;
    public Device device;
    public String event;
    public Map<String,String> args;
    public Calendar cal;

    public void sendNotification() {
        Log.v("Shipu", this.toString());
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("Event: \n");
        str.append(device.name + "\n");
        str.append(event + "\n");
        str.append(cal.getTime().toString() + "\n");
        Iterator<Map.Entry<String,String>> it = args.entrySet().iterator();
        str.append("Args: \n");
        while(((Iterator) it).hasNext()) {
            Map.Entry<String,String> entry = it.next();
            str.append("\t " + entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return str.toString();
    }
}
