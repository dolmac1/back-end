package com.company.design.adapter;

public class Cleaner implements electronic220v{

    @Override
    public void connect() {
        System.out.println("청소기 220v on");
    }
}
