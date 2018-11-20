package com.assist.home.assisthome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.assist.home.assisthome.api.API;
import com.assist.home.assisthome.api.JSONResponses;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoutinesActivity extends AppActivity {
    private ListView RView;
    private RoutinesAdapter RAdapter;
    ArrayList<Routine> routines = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContent(R.layout.activity_routines,"Rutinas");

        getRoutine();

        renderView();



    }

    public void renderView() {
        RView = (ListView) findViewById(R.id.customListView);
        RAdapter = new RoutinesAdapter(this,routines);
        RView.setAdapter(RAdapter);
        RView.setClickable(true);
        RView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = (int) parent.getItemAtPosition(position);
                Toast.makeText(RoutinesActivity.this, "Cliked at " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getRoutine(){
        List<DeviceCard> list=new ArrayList<>();
        routines = new ArrayList<>();
        JsonObjectRequest request = new JsonObjectRequest(JsonRequest.Method.GET, API.getUrl() + "/routines", (String) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                try {

                    Routine[] jsonRoutines = gson.fromJson(response.getJSONArray("routines").toString(), Routine[].class);
                    Log.v("Shipu", "got routines...");
                    Log.v("Shipu", jsonRoutines.length + "");
                    if (jsonRoutines.length > 0) {
                        Log.v("Shipu", jsonRoutines[0].name);
                        Log.v("Shipu", jsonRoutines[0].id);
                    }
                    for (Routine r : jsonRoutines) {
                        routines.add(r);
                    }
                    renderView();

                } catch (Exception exc) {
                    Log.e("Shipu", "Unable to parse routines");
                    Log.e("Shipu", response.toString());
                    Log.e("Shipu", exc.toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Shipu", "Failere2");
                Log.d("Shipu", volleyError.toString());
                volleyError.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                return new HashMap<>();
            }
        };
        API.getInstance().getRequestQueue().add(request);
    }
}
