package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectionController {
    private final GreetingService greetingService;

    @Autowired //optional
    //Qualifire name same as class name but first letter lowercase
    public ConstructorInjectionController(@Qualifier("constructorGreetingServiceImpl") GreetingService greetingService){
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }

}
