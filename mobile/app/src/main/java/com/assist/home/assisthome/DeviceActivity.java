package com.assist.home.assisthome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.Device;
import com.assist.home.assisthome.api.DeviceType;
import com.assist.home.assisthome.api.JSONResponses;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DeviceActivity extends AppActivity {
    private GridView dView;
    private DeviceCardAdapter dAdapter;
    ArrayList<DeviceCard> devices = new ArrayList<>();
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_devices_cards);
        super.setContent(R.layout.activity_devices_cards, getString(R.string.devices_title));
        requestQueue = Volley.newRequestQueue(this);
//        super.setContent(R.layout.activity_devices_cards,getString(R.string.devices_title));
        getDevices();

    }

    public void loadGridView() {
        dView = (GridView) findViewById(R.id.mainGrid);
        dAdapter = new DeviceCardAdapter(this, devices);
        dView.setAdapter(dAdapter);

        dView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                Toast.makeText(DeviceActivity.this, "Cliked at " + dAdapter.getItem(position).d.type.name, Toast.LENGTH_SHORT).show();
                String name = dAdapter.getItem(position).d.type.name;

                switch (name) {
                    case "ac":
                        Intent intent = new Intent(DeviceActivity.this, DeviceAC.class);
                        intent.putExtra("device",dAdapter.getItem(position).d.id);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                        break;
                    case "refrigerator":
                        Intent intent1 = new Intent(DeviceActivity.this, DeviceFridge.class);
                        intent1.putExtra("device",dAdapter.getItem(position).d.id);

//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent1);
                        break;
                    case "door":
                        Intent intent2 = new Intent(DeviceActivity.this, DeviceFridge.class);
                        intent2.putExtra("device",dAdapter.getItem(position).d.id);

//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent2);
                        break;
                    case "blind":
                        Intent intent3 = new Intent(DeviceActivity.this, DeviceBlind.class);
                        intent3.putExtra("device",dAdapter.getItem(position).d.id);

//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent3);
                        break;
                    case "oven":
                        Intent intent4 = new Intent(DeviceActivity.this, DeviceOven.class);
                        intent4.putExtra("device",dAdapter.getItem(position).d.id);

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
                Log.d("Shipu", "Failere");
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

    public void getDevices() {
        if (API.deviceTypes.isEmpty()) {
            loadDeviceTypes();
            return;
        }

        JsonObjectRequest request = new JsonObjectRequest(JsonRequest.Method.GET, API.getUrl() + "/devices", (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Shipu", "Success!");
                Log.d("Shipu", response.toString());
                Gson gson = new Gson();
                API.devices = new HashMap<>();
                JSONResponses.DevicesResponse rp = gson.fromJson(response.toString(), JSONResponses.DevicesResponse.class);

                List<Device> objDevices = rp.devices;

                for (Device d : objDevices) {
                    d.type = API.deviceTypes.get(d.typeId);

                    Type type = new TypeToken<Map<String, String>>(){}.getType();
                    Map<String, String> myMap = gson.fromJson(d.meta, type);
                    d.decodedMeta = myMap;

                    Log.d("Shipu", d.toString());
//                    Log.d("Shipu", d.typeId.toString());
//                    Log.d("Shipu", "Device type:" + API.deviceTypes.get(d.typeId).name.toString());
                    API.devices.put(d.id, d);

                    if (d.type != null) {

                        switch (d.type.name) {
                            case "ac":
                                devices.add(new DeviceCard(d.name, R.drawable.ac, d));
                                break;
                            case "refrigerator":
                                devices.add(new DeviceCard(d.name, R.drawable.fridge, d));
                                break;
                            case "door":
                                devices.add(new DeviceCard(d.name, R.drawable.door_close, d));
                                break;
                            case "blind":
                                devices.add(new DeviceCard(d.name, R.drawable.blind_close, d));
                                break;
                            case "oven":
                                devices.add(new DeviceCard(d.name, R.drawable.oven, d));
                                break;
                        }
                    }

                }
                loadGridView();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Shipu", "Failere");
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
}
