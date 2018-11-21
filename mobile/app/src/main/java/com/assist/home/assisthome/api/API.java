package com.assist.home.assisthome.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.assist.home.assisthome.AppActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class API {


    static String url = "http://192.168.0.5:8080/api";
    public static Map<String, DeviceType> deviceTypes = new HashMap<>();
    public static Map<String, Device> devices = new HashMap<>();
    public static String getUrl() {
        return url;
    }
    private static API api;
    public Context context;
    private RequestQueue requestQueue;
    long lastCheck = System.currentTimeMillis();
    Map<String, DeviceEvent> toNotifyEvents = new HashMap<>();

    private API(Context context){
        this.context = context;
    }

    public static API getInstance(){
        return api;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }

    public static API getInstance(Context context){
        if (api == null){
            api = new API(context);
        }
        return api;
    }

    public static void loadTypes(List<DeviceType> types) {
        for (DeviceType t : types) {
            Log.d("Shipu", "Added devicetype: " + t.name);
            deviceTypes.put(t.id,t);
        }
    }

    public void checkEvents() {
        if (System.currentTimeMillis() - lastCheck < 2000) {
            return;
        }

        if (!notificationsEnabled()) {
            return;
        }
        lastCheck = System.currentTimeMillis();
        Log.d("Shipu", "Checking events...");

        StringRequest request = new StringRequest(Request.Method.GET, API.getUrl() + "/devices/events", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Log.d("Shipu", response);
                Gson gson = new Gson();
                if (response.length() > 0) {
                    String[] events = response.split("id: ");
                    List<DeviceEvent> parsedEvents = new LinkedList<>();
                    for (String e : events) {

                        if (e.length() > 20) {
                            DeviceEvent de = new DeviceEvent();
//                            Log.d("Shipu", "event: " + e);
                            Pattern p = Pattern.compile("\"deviceId\": (.*)");
                            Matcher m = p.matcher(response);
                            if (m.find()) {
                                String quotedId = m.group(1);
                                String unquotedId = quotedId.replaceAll("^\"|\",$", "");
                                de.deviceId = unquotedId;
                                Device d = devices.get(unquotedId);
                                de.device = d;
                            }

                            p = Pattern.compile("\"event\": (.*)");
                            m = p.matcher(response);
                            if (m.find()) {
                                String quotedEvent = m.group(1);
                                String unquotedEvent = quotedEvent.replaceAll("^\"|\",$", "");
                                de.event= unquotedEvent;
                            }

                            p = Pattern.compile("\"args\": (.*)");
                            m = p.matcher(response);
                            if (m.find()) {
                                String quotedArgs = m.group(1);
                                String unquotedArgs = quotedArgs.replaceAll("^\"|\"$", "");
                                Gson g = new Gson();
//                                Log.v("Shipu", "args:" + unquotedArgs);
                                try {

                                    Type type = new TypeToken<Map<String, String>>(){}.getType();
                                    Map<String, String> myMap = gson.fromJson(unquotedArgs, type);
                                    de.args = myMap;
                                } catch ( Exception exc) {
                                    Log.v("Shipu", exc.toString());
                                }
                            }

                            p = Pattern.compile("\"timestamp\": (.*)");
                            m = p.matcher(response);
                            if (m.find()) {
                                String unparsedTs = m.group(1);
                                String parsedTs = unparsedTs.replaceAll("^\"|\",$", "");
//                                Log.v("Shipu", "ts: " + parsedTs);
                                Calendar cal = Calendar.getInstance(Locale.getDefault());

                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
                                sdf.setTimeZone(cal.getTimeZone());
                                try {
                                    cal.setTime(sdf.parse(parsedTs));
                                    de.cal = cal;
                                } catch (Exception ex) {
                                    Log.v("Shipu", "unable to parse, " + e.toString());
                                }
                            }
                            Log.v("Shipu",e.toString());
                            Log.v("Shipu", "Checking if favorite...");
                            if (de.device.decodedMeta.containsKey("favorite") && de.device.decodedMeta.get("favorite").equals("true")) {
                                DeviceEvent previousEvent = toNotifyEvents.get(de.deviceId);
                                if (previousEvent == null || de.cal.getTime().compareTo(previousEvent.cal.getTime()) > 0) {
                                    toNotifyEvents.put(de.deviceId,de);
                                }
                            }

                        }
                    }
                }
                notifyPendingEvents();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Shipu", "Failure");
                Log.d("Shipu", volleyError.toString());
                volleyError.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }

            ;
        };

        requestQueue.add(request);
    }

    public void notifyPendingEvents() {
        Iterator<Map.Entry<String,DeviceEvent>> it = toNotifyEvents.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String,DeviceEvent> entry = it.next();
//            Log.v("Shipu", "Notifying of event: " + entry.getValue().device.name);
//            Log.v("Shipu", "Notifying of event: " + entry.getValue().device.getClass());
            entry.getValue().device.notifyEvent(entry.getValue());
            entry.getValue().sendNotification();
            toNotifyEvents.remove(entry.getKey());
        }
    }

    public void saveNotificationsSettings(Boolean value) {
        SharedPreferences preferences = AppActivity.getContext().getSharedPreferences("NotificationsInfo", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("enabled", value);
        editor.commit();
    }

    public Boolean notificationsEnabled() {
        SharedPreferences preferences = AppActivity.getContext().getSharedPreferences("NotificationsInfo", 0);
        return preferences.getBoolean("enabled", true);
    }
}
