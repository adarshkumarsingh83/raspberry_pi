package com.espark.adarsh.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import com.fazecast.jSerialComm.SerialPort;
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
        if (this.serialPort.openPort()) {
            log.info("Serial Port is open for communication");
            serialPort.getOutputStream().write(("ON_" + ledName.toUpperCase()).getBytes());
            serialPort.getOutputStream().flush();
            return ledName + " led is on";
        } else {
            log.error("Serial Port is not open for communication");
            return "device is not reachable to provide cmd";
        }

    }

    public String offLed(String ledName) throws IOException {
        if (this.serialPort.openPort()) {
            log.info("Serial Port is open for communication");
            serialPort.getOutputStream().write(("OFF_" + ledName.toUpperCase()).getBytes());
            serialPort.getOutputStream().flush();
            return ledName + " led is off";
        } else {
            log.error("Serial Port is not open for communication");
            return "device is not reachable to provide cmd";
        }
    }
}
