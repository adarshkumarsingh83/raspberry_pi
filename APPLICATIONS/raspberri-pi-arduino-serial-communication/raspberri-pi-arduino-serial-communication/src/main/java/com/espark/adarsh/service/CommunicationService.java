package com.espark.adarsh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.fazecast.jSerialComm.SerialPort;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class CommunicationService {

    @Value("${application.usb.port.name}")
    private String usbPortName;

    private SerialPort serialPort;

    @PostConstruct
    public void init() {
        serialPort = SerialPort.getCommPort(usbPortName);
        // default connection settings for Arduino
        serialPort.setComPortParameters(9600, 8, 1, 0);
        // block until bytes can be written
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
    }


    public String lightLed(String ledName) throws IOException {
        if (!StringUtils.isEmpty(ledName)) {
            if (this.serialPort.openPort()) {
                log.info("Serial Port is open for communication");
                serialPort.getOutputStream().write(("ON_" + ledName.toUpperCase()).getBytes());
                serialPort.getOutputStream().flush();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("CommunicationService.lightLed()" + e.getLocalizedMessage());
                }
                InputStream inputStream = serialPort.getInputStream();
                String responseString = getString(inputStream);
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
            if (this.serialPort.openPort()) {
                log.info("Serial Port is open for communication");
                serialPort.getOutputStream().write(("OFF_" + ledName.toUpperCase()).getBytes());
                serialPort.getOutputStream().flush();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("CommunicationService.lightLed()" + e.getLocalizedMessage());
                }
                InputStream inputStream = serialPort.getInputStream();
                String responseString = getString(inputStream);
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
