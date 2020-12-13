package com.espark.adarsh.web;

import com.espark.adarsh.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;


@Controller
public class UiController {

    @Autowired
    CommunicationService communicationService;


    @GetMapping(value = "/led-on/{name}")
    public String lightLed(@PathVariable("name") String ledName, Model model) throws IOException {
        String message = this.communicationService.lightLed(ledName);
        model.addAttribute("message", message);
        return "redirect:/";
    }

    @GetMapping(value = "/led-off/{name}")
    public String offLed(@PathVariable("name") String ledName, Model model) throws IOException {
        String message = this.communicationService.offLed(ledName);
        model.addAttribute("message", message);
        return "redirect:/";
    }

}
