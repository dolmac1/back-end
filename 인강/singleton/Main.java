package com.company.design;

import com.company.design.singleton.Aclazz;
import com.company.design.singleton.Bclazz;
import com.company.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Aclazz aclass = new Aclazz();
        Bclazz bclass = new Bclazz();

        SocketClient aClient = aclass.getSocketClient();
        SocketClient bClient = bclass.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
    }
}
