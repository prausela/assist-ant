package com.assist.home.assisthome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;
import com.assist.home.assisthome.api.DeviceElementAdapter;
import com.assist.home.assisthome.api.JSONResponses;
import com.assist.home.assisthome.notifications.NotificationChecker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceActivity extends AppActivity {
    private GridView dView;
    private DeviceCardAdapter dAdapter;
    ArrayList<DeviceCard> devices;
    LinearLayout all;
    RelativeLayout loading;
    Context context;
    Snackbar no_conection;
    Snackbar connecting;
    Snackbar connected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        all=(LinearLayout) findViewById(R.id.activity_all);
        loading=(RelativeLayout) findViewById(R.id.loadingPanel);
        //setContentView(R.layout.activity_devices_cards);
        super.setContent(R.layout.activity_devices_cards, getString(R.string.devices_title));
        context = this;
//        super.setContent(R.layout.activity_devices_cards,getString(R.string.devices_title));
//        getDevices();
        NotificationChecker.init(this);
        no_conection = Snackbar.make(drawer, getString(R.string.no_conectivity), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.retry), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        no_conection.dismiss();
                        getDevices();
                    }
                });
        connecting = Snackbar.make(drawer, getString(R.string.connecting), Snackbar.LENGTH_SHORT);
        connected = Snackbar.make(drawer, getString(R.string.connected), Snackbar.LENGTH_SHORT);
//        new NotificationBroadcastReceiver().sendNotification(this, new Intent(DeviceActivity.this, DeviceActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        connecting.show();
        getDevices();
    }

    public void Loading(){
        all.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);

    }
    public void Loaded(){
        all.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);
    }

    public void loadGridView() {
        dView = (GridView) findViewById(R.id.mainGrid);
        dAdapter = new DeviceCardAdapter(this, devices);
        dView.setAdapter(dAdapter);

        dView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                //Toast.makeText(DeviceActivity.this, "Cliked at " + dAdapter.getItem(position).d.type.name, Toast.LENGTH_SHORT).show();
                String name = dAdapter.getItem(position).d.type.name;

                switch (name) {
                    case "ac":
                        Intent intent = new Intent(DeviceActivity.this, DeviceAC.class);
                        intent.putExtra("device",dAdapter.getItem(position).d.id);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                        break;
                    case "refrigerator":
                        Intent intent1 = new Intent(DeviceActivity.this, DeviceFridge.class);
                        intent1.putExtra("device",dAdapter.getItem(position).d.id);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent1);
                        break;
                    case "door":
                        Intent intent2 = new Intent(DeviceActivity.this, DeviceDoor.class);
                        intent2.putExtra("device",dAdapter.getItem(position).d.id);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent2);
                        break;
                    case "blind":
                        Intent intent3 = new Intent(DeviceActivity.this, DeviceBlind.class);
                        intent3.putExtra("device",dAdapter.getItem(position).d.id);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent3);
                        break;
                    case "oven":
                        Intent intent4 = new Intent(DeviceActivity.this, DeviceOven.class);
                        intent4.putExtra("device",dAdapter.getItem(position).d.id);
                        intent4.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent4);
                        break;
                }


            }
        });
    }


    public void loadDeviceTypes() {
        JsonObjectRequest request = new JsonObjectRequest(JsonRequest.Method.GET, API.getUrl() + "/devicetypes", (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Shipu", response.toString());
                Gson gson = new Gson();
                JSONResponses.DeviceTypesResponse rp = gson.fromJson(response.toString(), JSONResponses.DeviceTypesResponse.class);
                API.loadTypes(rp.devices);
                getDevices();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Shipu", "Failere1");
                Log.d("Shipu", volleyError.toString());
                volleyError.printStackTrace();
                if(connecting.isShown())
                    connecting.dismiss();
                if (!no_conection.isShown()){
                    no_conection.show();
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }

            ;
        };

        API.getInstance(this).getRequestQueue().add(request);
    }

    public void getDevices() {
        if (API.deviceTypes.isEmpty()) {
            loadDeviceTypes();
            return;
        }
        Log.d("Shipu", "Getting devices");
        devices = new ArrayList<>();
        JsonObjectRequest request = new JsonObjectRequest(JsonRequest.Method.GET, API.getUrl() + "/devices", (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (connecting.isShown())
                    connecting.dismiss();
                connected.show();
                Log.d("Shipu", "Success!");
                Log.d("Shipu", response.toString());

                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(Device.class, new DeviceElementAdapter());
                final Gson gson = gsonBuilder.create();


                API.devices = new HashMap<>();
                JSONResponses.DevicesResponse rp = gson.fromJson(response.toString(), JSONResponses.DevicesResponse.class);

                List<Device> objDevices = rp.devices;
                /*objDevices.sort(new Comparator<Device>() {
                    @Override
                    public int compare(Device o1, Device o2) {
                        return o1.name.compareTo(o2.name);
                    }
                });*/
                for (Device d : objDevices) {
                    d.type = API.deviceTypes.get(d.typeId);

                    final Type type = new TypeToken<Map<String, String>>(){}.getType();
                    Map<String, String> myMap = gson.fromJson(d.meta, type);
                    d.decodedMeta = myMap;
                    String stateUrl = API.getUrl() + "/devices/" + d.id + "/getState";
                    Log.d("Shipu", stateUrl);
                    final Device dev = d;
                    JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.PUT, stateUrl,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.d("Shipu7", response.toString());
                                    if (no_conection.isShown()){
                                        no_conection.dismiss();
                                    }
                                    try {
                                        Map<String,String> state = gson.fromJson(response.getJSONObject("result").toString(), type);
                                        dev.state = state;
                                        Log.d("Shipu", "switching devtype" + dev.type.name);
                                        API.devices.put(dev.id, dev);
                                        if (dev.type != null) {
                                            switch (dev.type.name) {
                                                case "ac":
                                                    devices.add(new DeviceCard(dev.name, R.drawable.ac, dev));
                                                    break;
                                                case "refrigerator":
                                                    devices.add(new DeviceCard(dev.name, R.drawable.fridge, dev));
                                                    break;
                                                case "door":
                                                    if (dev.state.get("status") != null && dev.state.get("status").equals("opened")) {
                                                        devices.add(new DeviceCard(dev.name, R.drawable.door_open, dev));
                                                    } else {
                                                        devices.add(new DeviceCard(dev.name, R.drawable.door_close, dev));
                                                    }
                                                    break;
                                                case "blind":
                                                    String s = dev.state.get("status");
                                                    Log.d("Shipu", "Deciding which blind: " + s);
                                                    if (s != null && (s.equals("opened") || s.equals("opening")) ) {
                                                        devices.add(new DeviceCard(dev.name, R.drawable.blind_open, dev));
                                                    } else {
                                                        devices.add(new DeviceCard(dev.name, R.drawable.blind_close, dev));
                                                    }
                                                    break;
                                                case "oven":
                                                    devices.add(new DeviceCard(dev.name, R.drawable.oven, dev));
                                                    break;
                                            }
                                        }
                                        loadGridView();
                                    } catch (JSONException e){
                                        Log.d("Shipu4", "No status");
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.d("Shipu7", "Wrong");
                                    if(connecting.isShown())
                                        connecting.dismiss();
                                    if (!no_conection.isShown()){
                                        no_conection.show();
                                    }
                                }
                            }
                    );
                    API.getInstance(context).getRequestQueue().add(postRequest);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Shipu", "Failere2");
                Log.d("Shipu", volleyError.toString());
                volleyError.printStackTrace();
                if(connecting.isShown())
                    connecting.dismiss();
                if (!no_conection.isShown()){
                    no_conection.show();
                }
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }

            ;
        };
        API.getInstance(this).getRequestQueue().add(request);

    }
}
