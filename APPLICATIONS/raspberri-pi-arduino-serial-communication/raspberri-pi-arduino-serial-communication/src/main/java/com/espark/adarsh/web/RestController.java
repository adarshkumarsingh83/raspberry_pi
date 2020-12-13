package com.espark.adarsh.web;

import com.espark.adarsh.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @Autowired
    CommunicationService communicationService;

    @GetMapping(value = "/led-on/{name}")
    public String lightLed(@PathVariable("name") String ledName) throws IOException {
        String message = this.communicationService.lightLed(ledName);
        return message;
    }

    @GetMapping(value = "/led-off/{name}")
    public String offLed(@PathVariable("name") String ledName) throws IOException {
        String message = this.communicationService.offLed(ledName);
        return message;
    }

}
