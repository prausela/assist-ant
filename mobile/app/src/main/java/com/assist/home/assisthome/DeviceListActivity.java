package com.assist.home.assisthome;

import android.os.Bundle;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;

public abstract class DeviceListActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewStubCompat stub = (ViewStubCompat) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.list_devices);
        stub.inflate();
    }
}
