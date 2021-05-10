package com.company.design.adapter;

public class HairDryer implements electronic110v{
    @Override
    public void powerOn(){
        System.out.println("헤어드리아기 110v on");
    }
}
