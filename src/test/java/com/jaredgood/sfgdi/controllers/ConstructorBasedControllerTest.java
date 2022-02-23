package com.jaredgood.sfgdi.controllers;

import com.jaredgood.sfgdi.services.GreetingServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructorBasedControllerTest {
    ConstructorBasedController controller;

    @BeforeEach
    void setUp(){
        controller = new ConstructorBasedController(new GreetingServiceImplementation());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}
