package com.espark.adarsh.web;

import com.espark.adarsh.service.CommunicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;


@Slf4j
@Controller
public class UiController {

    @Autowired
    private CommunicationService communicationService;

    @GetMapping(value = "/")
    public String index(Model model) {
        log.info("UiController.index() ");
        model.addAttribute("message", "");
        return "index";
    }

    @GetMapping(value = "/led-on/{name}")
    public String lightLed(@PathVariable("name") String ledName, Model model) throws IOException {
        String message = this.communicationService.lightLed(ledName);
        log.info("UiController.lightLed() "+message);
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(value = "/led-off/{name}")
    public String offLed(@PathVariable("name") String ledName, Model model) throws IOException {
        String message = this.communicationService.offLed(ledName);
        log.info("UiController.offLed() "+message);
        model.addAttribute("message", message);
        return "index";
    }

}
