package com.company.design.adapter;

public class SocketAdapter implements electronic110v{
    private electronic220v electronic220v;
    public SocketAdapter(electronic220v electronic220v){
        this.electronic220v = electronic220v;
    }
    @Override
    public void powerOn() {
        electronic220v.connect();
    }
}
