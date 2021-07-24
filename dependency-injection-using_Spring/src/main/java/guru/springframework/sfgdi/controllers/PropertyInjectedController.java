package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;

public class PropertyInjectedController {
    public GreetingService greetingService;     //we have used interface here

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
