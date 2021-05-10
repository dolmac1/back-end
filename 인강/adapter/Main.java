package com.company.design;

import com.company.design.adapter.*;
import com.company.design.singleton.Aclazz;
import com.company.design.singleton.Bclazz;
import com.company.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        electronic110v adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        electronic110v adapter2 = new SocketAdapter(airConditioner);
        connect(adapter2);
    }

    public static void connect(electronic110v electronic110v){
        electronic110v.powerOn();
    }
}
