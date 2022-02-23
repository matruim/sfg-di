package com.jaredgood.sfgdi.controllers;

import com.jaredgood.sfgdi.services.GreetingService;

public class SetterBasedController {

    private GreetingService greetingService;

    public SetterBasedController() {}

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
