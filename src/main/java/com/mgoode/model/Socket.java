package com.mgoode.model;

import static com.pi4j.wiringpi.Gpio.*;

/**
 * Created by michaelgoode on 12/12/2017.
 */
public class Socket {
    private int pin;
    private boolean state;
    private final static int _DEFAULT_DELAY = 50;

    public Socket(int id) {
        this.pin = id;
        this.state = false;
        wiringPiSetup();
        pinMode(pin, OUTPUT);
        digitalWrite(pin, HIGH);
    }

    public void toggle() {
        if (state) {
            state = false;
            off();
        } else {
            state = true;
            on();
        }
    }

    public void strobe(int delay) {

        if ( delay < _DEFAULT_DELAY ) delay = _DEFAULT_DELAY;

        if (state) {
            state = false;
            off();
        } else {
            state = true;
            on();
        }
        delay(delay);
        if (state) {
            state = false;
            off();
        } else {
            state = true;
            on();
        }
    }

    public void off() {
        wiringPiSetup();
        pinMode(pin, OUTPUT);
        digitalWrite(pin, HIGH);
        state = false;
    }

    public void on() {
        wiringPiSetup();
        pinMode(pin, OUTPUT);
        digitalWrite(pin, LOW);
        state = true;
    }

}
