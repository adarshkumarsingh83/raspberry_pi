package com.espark.adarsh.service;

import com.espark.adarsh.config.ApplicationConfig;
import com.pi4j.io.serial.Serial;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;


import com.fazecast.jSerialComm.SerialPort;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class CommunicationService {




    @Autowired
    Serial serial;

    public String lightLed(String ledName) throws IOException {
        if (!StringUtils.isEmpty(ledName)) {
            if (this.serial.isOpen()) {
                log.info("Serial Port is open for communication");
                serial.write(("ON_" + ledName.toUpperCase()).getBytes());
                serial.flush();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("CommunicationService.lightLed()" + e.getLocalizedMessage());
                }
                String responseString = ApplicationConfig.getSerialData();
                return responseString;
            } else {
                log.error("Serial Port is not open for communication");
                return "device is not reachable to provide cmd";
            }
        } else {
            log.error("ledName is empty or null");
            return "ledName is empty or null";
        }

    }

    public String offLed(String ledName) throws IOException {
        if (!StringUtils.isEmpty(ledName)) {
            if (this.serial.isOpen()) {
                log.info("Serial Port is open for communication");
                serial.write(("OFF_" + ledName.toUpperCase()).getBytes());
                serial.flush();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("CommunicationService.lightLed()" + e.getLocalizedMessage());
                }
                String responseString = ApplicationConfig.getSerialData();
                return responseString;
            } else {
                log.error("Serial Port is not open for communication");
                return "device is not reachable to provide cmd";
            }
        } else {
            log.error("ledName is empty or null");
            return "ledName is empty or null";
        }
    }


    public String getString(InputStream inputStream) throws IOException {
        int ch = 0;
        StringBuilder sb = new StringBuilder();
        while (inputStream.available() != 0) {
            ch = inputStream.read();
            sb.append((char) ch);
        }
        return sb.toString();
    }
}
