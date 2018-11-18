package com.assist.home.assisthome;

import android.widget.ImageView;

import com.assist.home.assisthome.api.Device;

public class DeviceCard {
    String DeviceName;
    int Deviceimage;
    Device d;


    public DeviceCard(String dName,int img,Device d){
        this.DeviceName = dName;
        this.Deviceimage=img;
        this.d=d;
    }

}
