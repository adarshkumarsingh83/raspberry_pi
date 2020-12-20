package com.espark.adarsh.service;

import com.espark.adarsh.config.LedState;
import com.espark.adarsh.config.LedType;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.i2c.I2CDevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;


@Slf4j
@Service
public class CommunicationService {

    @Autowired
    private I2CDevice i2CDevice;
    static long waitTimeSent = 5000;

    public String lightLed(String led) throws IOException, InterruptedException {
        if (!StringUtils.isEmpty(led)) {
            if (led.equalsIgnoreCase("red")) {
                String data = LedState.ON.getState() +"_"+ LedType.RED.getType();
                this.i2CDevice.write(0x8, data.getBytes());
            } else if (led.equalsIgnoreCase("green")) {
                String data = LedState.ON.getState() +"_"+ LedType.GREEN.getType();
                this.i2CDevice.write(0x8, data.getBytes());
            } else if (led.equalsIgnoreCase("yellow")) {
                String date = LedState.ON.getState() +"_"+  LedType.YELLOW.getType();
                this.i2CDevice.write(0x8, date.getBytes());
            }
            Thread.sleep(waitTimeSent);
            String data = this.readResponse();
            log.info("Response from Arduino " + data);
            return data;
        }
        return "LED NAME IS REQUIRED";
    }

    public String offLed(String led) throws IOException, InterruptedException {
        if (!StringUtils.isEmpty(led)) {
            if (led.equalsIgnoreCase("red")) {
                String data = LedState.OFF.getState() +"_"+  LedType.RED.getType();
                this.i2CDevice.write(0x8,data.getBytes());
            } else if (led.equalsIgnoreCase("green")) {
                String date = LedState.OFF.getState()  +"_"+ LedType.GREEN.getType();
                this.i2CDevice.write(0x8,date.getBytes());
            } else if (led.equalsIgnoreCase("yellow")) {
                String data = LedState.OFF.getState()+"_"+LedType.YELLOW.getType();
                this.i2CDevice.write(0x8,data.getBytes());
            }
            Thread.sleep(waitTimeSent);
            String data = this.readResponse();
            log.info("Response from Arduino " + data);
            return data;
        }
        return "LED NAME IS REQUIRED";
    }

    public String readResponse() throws IOException {
        int ch = 0;
        StringBuilder sb = new StringBuilder();
        while (this.i2CDevice.read() > -1) {
            ch = this.i2CDevice.read();
            sb.append((char) ch);
        }
        return sb.toString();
    }
}
