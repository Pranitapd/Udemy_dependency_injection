package guru.springframework.sfgdi.services;

public class I18nMarathiGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello Marathi people!";
    }
}
