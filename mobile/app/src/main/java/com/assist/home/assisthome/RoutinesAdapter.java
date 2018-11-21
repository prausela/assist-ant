package com.assist.home.assisthome;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.assist.home.assisthome.api.API;

import java.util.ArrayList;

public class RoutinesAdapter extends BaseAdapter {
    public ArrayList<Routine> listRoutines;
    private Context context;

    public RoutinesAdapter(Context context, ArrayList<Routine> listProducts) {
        this.context = context;
        this.listRoutines = listProducts;
    }

    @Override
    public int getCount() {
        return listRoutines.size();
    }

    @Override
    public Routine getItem(int position) {
        return listRoutines.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final RoutineViewHolder routineViewHolder;
        View row;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_routine_view, parent, false);
            routineViewHolder = new RoutineViewHolder();
            routineViewHolder.r_name = row.findViewById(R.id.r_name);
            routineViewHolder.r_on = row.findViewById(R.id.r_on);

            row.setTag(routineViewHolder);
        } else {
            row = convertView;
            routineViewHolder = (RoutineViewHolder) row.getTag();
        }
        final Routine routines = getItem(position);

        routineViewHolder.r_name.setText(routines.name);


        routineViewHolder.r_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                routines.activate();
                Toast.makeText(AppActivity.getContext(), AppActivity.getContext().getText(R.string.routine) + routines.name +AppActivity.getContext().getText(R.string.routine_isactive), Toast.LENGTH_SHORT).show();
                routineViewHolder.r_on.setBackgroundResource(R.drawable.circle);
                routineViewHolder.r_on.setText(R.string.routine_active);
                routineViewHolder.r_on.setTextColor(Color.parseColor("#1b87c9"));
            }
        });
       

        return row;
    }

}