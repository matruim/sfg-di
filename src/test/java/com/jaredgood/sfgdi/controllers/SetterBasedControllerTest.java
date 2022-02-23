package com.jaredgood.sfgdi.controllers;

import com.jaredgood.sfgdi.services.GreetingServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetterBasedControllerTest {

    SetterBasedController controller;

    @BeforeEach
    void setUp(){
        controller = new SetterBasedController();
        controller.setGreetingService(new GreetingServiceImplementation());
    }

    @Test
    void setGreetingService() {
        System.out.println(controller.getGreeting());
    }
}
