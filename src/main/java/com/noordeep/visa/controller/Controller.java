package com.noordeep.visa.controller;

import com.noordeep.visa.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final VisaService visaService;

    public Controller(VisaService visaService) {
        this.visaService = visaService;
    }

    @GetMapping("/visa")
    public String fetchVisaWaitTimes() {
        return visaService.getVisaWaitTimes();
    }

}
