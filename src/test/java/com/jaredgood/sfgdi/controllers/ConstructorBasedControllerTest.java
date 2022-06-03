package com.jaredgood.sfgdi.controllers;

import com.jaredgood.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorBasedControllerTest {
    ConstructorBasedController controller;

    @BeforeEach
    void setUp(){
        controller = new ConstructorBasedController(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}
