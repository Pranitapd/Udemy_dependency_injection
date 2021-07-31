package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.config.GreetingServiceConfig;

//@Service
public class GreetingServiceFactory {

    public GreetingService getGreetingService(String greetingType){
        switch (greetingType){
            case("Mr"):
                return new I18nMarathiGreetingService();
            case("ES"):
                return new I18nSpanishGreetingService();
            default:
                return new I18nMarathiGreetingService();
        }
    }
}
