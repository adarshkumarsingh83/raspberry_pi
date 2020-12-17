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
                Integer data = LedState.ON.getState() +  LedType.RED.getType();
                this.i2CDevice.write(0x8, data.byteValue());
            } else if (led.equalsIgnoreCase("green")) {
                Integer data = LedState.ON.getState() + LedType.GREEN.getType();
                this.i2CDevice.write(0x8, data.byteValue());
            } else if (led.equalsIgnoreCase("yellow")) {
                Integer date = LedState.ON.getState() +  LedType.YELLOW.getType();
                this.i2CDevice.write(0x8, date.byteValue());
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
                Integer data = LedState.OFF.getState() +  LedType.RED.getType();
                this.i2CDevice.write(0x8,data.byteValue());
            } else if (led.equalsIgnoreCase("green")) {
                Integer date = LedState.OFF.getState()  + LedType.GREEN.getType();
                this.i2CDevice.write(0x8,date.byteValue());
            } else if (led.equalsIgnoreCase("yellow")) {
                Integer data = LedState.OFF.getState()+ LedType.YELLOW.getType();
                this.i2CDevice.write(0x8,data.byteValue());
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
