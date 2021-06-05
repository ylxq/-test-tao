package com.example.design.structure.adapter;

import com.example.design.structure.adapter.classadapter.Voltage5VAdapter;
import com.example.design.structure.adapter.interfaceadapter.HandlerAdapter;
import com.example.design.structure.adapter.interfaceadapter.Voltage220VTo5VAdapter;
import com.example.design.structure.adapter.interfaceadapter.Voltage440To5VAdapter;
import com.example.design.structure.adapter.objadapter.Voltage5VObjAdapter;

import java.util.ArrayList;
import java.util.List;

public class Phone {

    public void charge(Voltage5V v) {
        //充电5v
        v.show();
    }

    public static void main(String[] args) {
        new Phone().charge(new Voltage5VAdapter());
        new Phone().charge(new Voltage5VObjAdapter(new Voltage220()));

        Object voltage220 = new Voltage220();
        Object voltag440V = new Voltag440V();
        getHandlerAdapter(voltage220).handler(voltage220);
        getHandlerAdapter(voltag440V).handler(voltag440V);

    }

    public static HandlerAdapter getHandlerAdapter(Object handler){
       return adapterList.stream().filter(adapter->adapter.support(handler)).findFirst().get();
    }



    public static List<HandlerAdapter> adapterList = new ArrayList<>();

    static {
        adapterList.add(new Voltage440To5VAdapter());
        adapterList.add(new Voltage220VTo5VAdapter());
    }


}
