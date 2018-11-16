package com.assist.home.assisthome;

import android.bluetooth.BluetoothClass;

import java.util.List;

public class Routine {


    String RoutineName;
    List<DeviceCard> devices;



    public Routine(String rName,List<DeviceCard> devices){
        this.RoutineName = rName;
        this.devices=devices;

    }

}

