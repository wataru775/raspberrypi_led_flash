package org.mmpp.raspberrypi.ledflash.controller;

import com.pi4j.io.gpio.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class GPIOController {
    private GpioController gpio;
    private java.util.Map<String,GpioPinDigitalOutput> hmpPins = new java.util.HashMap<String,GpioPinDigitalOutput>();
    private void initialize() {
        if (gpio == null) {
            gpio = GpioFactory.getInstance();
        }
    }

    public GpioPinDigitalOutput getLED(String channel){
        initialize();
        if(hmpPins.containsKey(channel)){
            return hmpPins.get(channel);
        }
        Pin pin = null;
        switch(channel){
            case "GPIO_13":
                pin = RaspiPin.GPIO_23;
                break;
            case "GPIO_19":
                pin = RaspiPin.GPIO_24;
                break;
            case "GPIO_26":
                pin = RaspiPin.GPIO_25;
                break;
            case "GPIO_21":
                pin = RaspiPin.GPIO_29;
                break;
            case "GPIO_20":
                pin = RaspiPin.GPIO_28;
                break;
            default: return null;
        }
        GpioPinDigitalOutput pinLED = gpio.provisionDigitalOutputPin(pin, "LED", PinState.LOW);
        hmpPins.put(channel,pinLED);

        return pinLED;
    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/turnon", method = RequestMethod.GET)
    public void turnOn(@RequestParam String channel){
        initialize();
        GpioPinDigitalOutput pinLED = getLED(channel);
        if(pinLED == null)return;
        pinLED.high();

    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/turnoff", method = RequestMethod.GET)
    public void turnOff(@RequestParam String channel){
        initialize();
        GpioPinDigitalOutput pinLED = getLED(channel);
        if(pinLED == null)return;
        pinLED.low();

    }
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public void test(){
        initialize();
        List<String> channels = Arrays.asList(new String[]{"GPIO_13","GPIO_19","GPIO_26","GPIO_21","GPIO_20"});
        for(String _channel :channels) {
            GpioPinDigitalOutput pinLED = getLED(_channel);
            pinLED.high();
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pinLED.low();
        }
        for(int i= 0 ; i < 4 ; i ++) {
            for (String _channel : channels) {
                GpioPinDigitalOutput pinLED = getLED(_channel);
                pinLED.high();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(String _channel :channels) {
                GpioPinDigitalOutput pinLED = getLED(_channel);
                pinLED.low();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
