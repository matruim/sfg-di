package com.jaredgood.sfgdi.controllers;

import com.jaredgood.sfgdi.services.GreetingService;

public class ConstructorBasedController {
    private final GreetingService greetingService;

    public ConstructorBasedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
