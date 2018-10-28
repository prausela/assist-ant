package com.assist.home.assisthome;

import android.os.Bundle;
import android.support.v7.widget.ViewStubCompat;

public abstract class CardListActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewStubCompat stub = (ViewStubCompat) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.activity_card_list);
        stub.inflate();
    }
}
