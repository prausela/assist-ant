package com.assist.home.assisthome;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.ViewStubCompat;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.assist.home.assisthome.api.API;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public abstract class CardListActivity extends AppActivity {

    //GridLayout mainGrid;

    private RequestQueue requestQueue;

    public void getDevices() {

        System.out.println("getting devices");
        Log.d("Shipu", "asdf");
        JsonObjectRequest request = new JsonObjectRequest(JsonRequest.Method.GET, API.baseUrl() + "/devices", (String)null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response){
                Log.d("Shipu", "Success!");
                Log.d("Shipu", response.toString());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Shipu", "Failere");
                Log.d("Shipu", volleyError.toString());
                volleyError.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                return new HashMap<>();
            };
        };

        requestQueue.add(request);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Shipu", "testing this runs");
        requestQueue = Volley.newRequestQueue(this);
        getDevices();
        ViewStubCompat stub = (ViewStubCompat) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.activity_card_list);
        stub.inflate();
        android.support.v7.widget.GridLayout mainGrid = (android.support.v7.widget.GridLayout) findViewById(R.id.mainGrid2);

        setSingleEvent(mainGrid);

    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(CardListActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(CardListActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(final GridLayout mainGrid) {
        //Toast.makeText(CardListActivity.this, "Single:" + mainGrid.getRowCount(), Toast.LENGTH_SHORT).show();

        //Loop all child item of Main Grid

        for (int i = 0; i < mainGrid.getChildCount(); i++) {

            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(CardListActivity.this, "Cliked at " + finalI, Toast.LENGTH_SHORT).show();
                    if(finalI==0){
                        Intent intent = new Intent(CardListActivity.this,DeviceAC.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                    if(finalI==1){
                        Intent intent = new Intent(CardListActivity.this,DeviceBlind.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                    if(finalI==2){
                        Intent intent = new Intent(CardListActivity.this,DeviceFridge.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                    if(finalI==3){
                        Intent intent = new Intent(CardListActivity.this,DeviceDoor.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                    if(finalI==4){
                        Intent intent = new Intent(CardListActivity.this,DeviceOven.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                    if(finalI==5){
                        Intent intent = new Intent(CardListActivity.this,DeviceActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }


                }
            });
        }
    }

}
