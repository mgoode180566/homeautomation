package com.mgoode.model;

/**
 * Created by michaelgoode on 14/12/2017.
 */
public interface SocketService {
    public void toggleAll();
    public void strobeAll(int delay, boolean reverse);
    public void allOff();
    public void allOn();
}
