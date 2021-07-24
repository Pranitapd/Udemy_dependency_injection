package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectionControllerTest {

    //This is without autowiring.. to check how Spring does this internally

    ConstructorInjectionController controller;

    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectionController(new ConstructorGreetingServiceImpl());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}