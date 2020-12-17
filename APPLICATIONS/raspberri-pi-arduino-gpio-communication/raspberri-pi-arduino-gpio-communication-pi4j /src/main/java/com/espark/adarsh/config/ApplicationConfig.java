package com.espark.adarsh.config;


import com.pi4j.io.gpio.*;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@Slf4j
@Configuration
public class ApplicationConfig {


    @Bean
    public I2CBus i2CBus() throws IOException, I2CFactory.UnsupportedBusNumberException {
        return I2CFactory.getInstance(I2CBus.BUS_1);
    }


    @Bean
    public I2CDevice i2CDevice() throws IOException, I2CFactory.UnsupportedBusNumberException {
        return i2CBus().getDevice(0x8);
    }
}
