package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    //This is without autowiring.. to check how Spring does this internally

    PropertyInjectedController controller ;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectedController();
        controller.greetingService = new ConstructorGreetingServiceImpl();     //here we are accessing the property directly
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}