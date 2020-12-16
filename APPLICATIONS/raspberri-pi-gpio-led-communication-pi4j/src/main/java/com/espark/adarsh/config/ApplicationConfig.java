package com.espark.adarsh.config;


import com.pi4j.io.gpio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class ApplicationConfig {

    @Bean("redGpioPinDigitalOutput")
    public GpioPinDigitalOutput redGpioPinDigitalOutput() {
        return gpioController().provisionDigitalOutputPin(RaspiPin.GPIO_02, "MY_LED", PinState.LOW);
    }
    @Bean("greenGpioPinDigitalOutput")
    public GpioPinDigitalOutput greenGpioPinDigitalOutput() {
        return gpioController().provisionDigitalOutputPin(RaspiPin.GPIO_03, "MY_LED", PinState.LOW);
    }

    @Bean("yellowGpioPinDigitalOutput")
    public GpioPinDigitalOutput yellowGpioPinDigitalOutput() {
        return gpioController().provisionDigitalOutputPin(RaspiPin.GPIO_04, "MY_LED", PinState.LOW);
    }

    @Bean
    public GpioController gpioController() {
        return GpioFactory.getInstance();
    }

}
