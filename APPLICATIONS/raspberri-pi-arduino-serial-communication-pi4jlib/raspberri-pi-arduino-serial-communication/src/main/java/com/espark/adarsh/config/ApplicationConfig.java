package com.espark.adarsh.config;

import com.pi4j.io.serial.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@Configuration
public class ApplicationConfig {

    @Value("${application.usb.port.name}")
    private String usbPortName;

    private static List<String> serialData = new LinkedList<String>();

    @Bean
    public Serial serial() throws IOException, InterruptedException {
        Serial serial = SerialFactory.createInstance();
        serial.addListener(this.serialDataEventListener());
        serial.open(this.serialConfig());
        return serial;
    }

    @Bean
    public SerialDataEventListener serialDataEventListener() {
        return new SerialDataEventListener() {
            @Override
            public void dataReceived(SerialDataEvent event) {

                // NOTE! - It is extremely important to read the data received from the
                // serial port.  If it does not get read from the receive buffer, the
                // buffer will continue to grow and consume memory.

                // print out the data received to the console
                try {
                    log.info("[HEX DATA]   " + event.getHexByteString());
                    log.info("[ASCII DATA] " + event.getAsciiString());
                    serialData.add(event.getAsciiString());
                } catch (IOException e) {
                    log.error(e.getLocalizedMessage());
                }
            }
        };
    }

    @Bean
    public SerialConfig serialConfig() throws IOException, InterruptedException {
        SerialConfig config = new SerialConfig();
        config.device(SerialPort.getDefaultPort())
                .baud(Baud._38400)
                .dataBits(DataBits._8)
                .parity(Parity.NONE)
                .stopBits(StopBits._1)
                .flowControl(FlowControl.NONE);
        return config;
    }

    public static String getSerialData(){
        return serialData.remove(0);
    }
}
