package com.assist.home.assisthome;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class DeviceCardAdapter extends BaseAdapter {
    public ArrayList<DeviceCard> devicesCard;
    private Context context;

    public DeviceCardAdapter(Context context, ArrayList<DeviceCard> listProducts) {
        this.context = context;
        this.devicesCard = listProducts;
    }

    @Override
    public int getCount() {
        return devicesCard.size();
    }

    @Override
    public DeviceCard getItem(int position) {
        return devicesCard.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final DeviceCardViewHolder deviceCardViewHolder;
        View row;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_device_card_view, parent, false);
            deviceCardViewHolder = new DeviceCardViewHolder();
            deviceCardViewHolder.d_name = row.findViewById(R.id.device_name);
            deviceCardViewHolder.d_img = row.findViewById(R.id.device_img);


            row.setTag(deviceCardViewHolder);
        } else {
            row = convertView;
            deviceCardViewHolder = (DeviceCardViewHolder) row.getTag();
        }
        final DeviceCard deviceCard = getItem(position);

        deviceCardViewHolder.d_name.setText(deviceCard.DeviceName);
        deviceCardViewHolder.d_img.setImageResource(deviceCard.Deviceimage);



        return row;
    }
}
