package com.espark.adarsh.service;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Slf4j
@Service
public class CommunicationService {


    @Qualifier("redGpioPinDigitalOutput")
    @Autowired
    GpioPinDigitalOutput redGpioPinDigitalOutput;

    @Qualifier("greenGpioPinDigitalOutput")
    @Autowired
    GpioPinDigitalOutput greenGpioPinDigitalOutput;

    @Qualifier("yellowGpioPinDigitalOutput")
    @Autowired
    GpioPinDigitalOutput yellowGpioPinDigitalOutput;

    public String lightLed(String led) {
        if (!StringUtils.isEmpty(led)) {
            if (led.equalsIgnoreCase("red")) {
                if (this.redGpioPinDigitalOutput.getState().isLow()) {
                    this.redGpioPinDigitalOutput.setState(PinState.HIGH);
                    return "RED LED LIGHT IS ON ";
                } else {
                    return "RED LED LIGHT IS ALREADY ON ";
                }
            } else if (led.equalsIgnoreCase("green")) {
                if (this.greenGpioPinDigitalOutput.getState().isLow()) {
                    this.greenGpioPinDigitalOutput.setState(PinState.HIGH);
                    return "GREEN LED LIGHT IS ON ";
                } else {
                    return "GREEN LED LIGHT IS ALREADY ON ";
                }
            } else if (led.equalsIgnoreCase("yellow")) {
                if (this.yellowGpioPinDigitalOutput.getState().isLow()) {
                    this.yellowGpioPinDigitalOutput.setState(PinState.HIGH);
                    return "YELLOW LED LIGHT IS ON ";
                } else {
                    return "YELLOW LED LIGHT IS ALREADY ON ";
                }
            }
        }
        return "LED NAME IS REQUIRED";
    }

    public String offLed(String led) {
        if (!StringUtils.isEmpty(led)) {
            if (led.equalsIgnoreCase("red")) {
                if (this.redGpioPinDigitalOutput.getState().isHigh()) {
                    this.redGpioPinDigitalOutput.setState(PinState.LOW);
                    return "RED LED LIGHT IS OFF ";
                } else {
                    return "RED LED LIGHT IS ALREADY OFF ";
                }
            } else if (led.equalsIgnoreCase("green")) {
                if (this.greenGpioPinDigitalOutput.getState().isHigh()) {
                    this.greenGpioPinDigitalOutput.setState(PinState.LOW);
                    return "GREEN LED LIGHT IS OFF ";
                } else {
                    return "GREEN LED LIGHT IS ALREADY OFF ";
                }
            } else if (led.equalsIgnoreCase("yellow")) {
                if (this.yellowGpioPinDigitalOutput.getState().isHigh()) {
                    this.yellowGpioPinDigitalOutput.setState(PinState.LOW);
                    return "YELLOW LED LIGHT IS OFF ";
                } else {
                    return "YELLOW LED LIGHT IS ALREADY OFF ";
                }
            }
        }
        return "LED NAME IS REQUIRED";
    }

}
