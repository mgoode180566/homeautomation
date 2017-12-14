package com.mgoode.controller;

import com.mgoode.model.SocketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by michaelgoode on 04/12/2017.
 */
@RestController
public class HomeController {

    @Autowired
    SocketServiceImpl socketManager;

    @RequestMapping(value = "/toggle/{pin}")
    public String toggleSocket(@PathVariable int pin) {
        socketManager.getSocket(pin).toggle();
        return String.format("Toggle %d", pin);
    }

    @RequestMapping(value = "/toggleall")
    public String toggleSocket() {
        socketManager.toggleAll();
        return "Toggle all";
    }

    @RequestMapping(value = "/strobeall/{delay}")
    public String strobeAll(@PathVariable int delay) {
        socketManager.strobeAll(delay, false);
        System.out.println("delay = [" + delay + "]");
        return String.format("Strobe %dms", delay);
    }

    @RequestMapping(value = "/cycleall/{delay}")
    public String cycleAll(@PathVariable int delay) {
        socketManager.strobeAll(delay, false);
        socketManager.strobeAll(delay, true);
        System.out.println("delay = [" + delay + "]");
        return String.format("Strobe %dms", delay);
    }

    @RequestMapping(value = "/alloff")
    public String allOff() {
        socketManager.allOff();
        return "All off";
    }

    @RequestMapping(value = "/allon")
    public String allOn() {
        socketManager.allOn();
        return "All on";
    }
}







