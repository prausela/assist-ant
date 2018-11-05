package com.assist.home.assisthome;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.support.v7.widget.ViewStubCompat;
import android.view.View;
import android.widget.Toast;

public abstract class CardListActivity extends AppActivity {

    //GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewStubCompat stub = (ViewStubCompat) findViewById(R.id.content);
        stub.setLayoutResource(R.layout.activity_card_list);
        stub.inflate();
        android.support.v7.widget.GridLayout mainGrid = (android.support.v7.widget.GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);

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
            //Toast.makeText(CardListActivity.this, "Cant:" + i, Toast.LENGTH_SHORT).show();

            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(CardListActivity.this, "Cliked at" + finalI, Toast.LENGTH_SHORT).show();
                    if(finalI==0){
                        Intent intent = new Intent(CardListActivity.this,DeviceAC.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }


                }
            });
        }
    }

}
