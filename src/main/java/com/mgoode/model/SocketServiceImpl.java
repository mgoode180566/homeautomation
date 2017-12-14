package com.mgoode.model;

import jdk.net.Sockets;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by michaelgoode on 12/12/2017.
 */
@Component
public class SocketServiceImpl implements SocketService {

    HashMap<Integer, Socket> sockets = new HashMap<>();

    public SocketServiceImpl() {
        // map socket numbers to WiringPi pins
        sockets.put(0, new Socket(7));
        sockets.put(1, new Socket(0));
        sockets.put(2, new Socket(2));
        sockets.put(3, new Socket(3));
        sockets.put(4, new Socket(28));
        sockets.put(5, new Socket(29));
    }

    public Socket getSocket( int id ) {
        return sockets.get(id);
    }

    public void toggleSocket( int id ) {
        sockets.get(id).toggle();
    }

    public void toggleAll() {
        for (Socket socket : sockets.values() ) {
             socket.toggle();
        }
    }

    public void strobeAll(int delay, boolean reverse) {

        ArrayList<Socket> values = new ArrayList<>(sockets.values());

        if (reverse) {
            Collections.reverse(values);
        }

        for (Socket socket : values ) {
            socket.strobe(delay);
        }
    }

    public void allOff() {
        for (Socket socket : sockets.values() ) {
            socket.off();
        }
    }

    public void allOn() {
        for (Socket socket : sockets.values() ) {
            socket.on();
        }
    }
}
