package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller        //added while autowiring
public class PropertyInjectedController {

    @Qualifier("propertyInjectorGreetingService")       //same as class name but first letter lowercase
    @Autowired      //this tell spring that it needs to inject an instance of greeting service here
    public GreetingService greetingService;     //we have used interface here
    //before adding @service, it gives error that required bean could not be found

    public String getGreeting(){
        return greetingService.sayGreeting();
        //when we didnt add @Autowired the greetingService here gets nullpointer exception
        //Sprng doesnt know that it needs to add injection here
    }
}
