package com.jaredgood.sfgdi.controllers;

import com.jaredgood.sfgdi.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public PropertyInjectedController() {
    }

    public PropertyInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
