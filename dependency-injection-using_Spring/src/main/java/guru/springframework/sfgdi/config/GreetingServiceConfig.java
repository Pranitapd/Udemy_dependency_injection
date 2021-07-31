package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(){
        return new GreetingServiceFactory();
    }

    @Profile("Mr")
    @Bean
    GreetingService mrGreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.getGreetingService("Mr");
    }

    @Profile("ES")
    @Bean  ("i18nService")
    GreetingService esgreetingService(GreetingServiceFactory greetingServiceFactory){
        return greetingServiceFactory.getGreetingService("ES");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    //Spring will create the bean of repository first then add the dependency injection in below service

    @Profile("En")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService((EnglishGreetingRepositoryImpl) englishGreetingRepository);
    }

    /* calling this by GreetingServicefactory
    @Profile({"ES","default"})
    //@Profile("ES")
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Profile("Mr")
    @Bean
    I18nMarathiGreetingService i18nMarathiGreetingService(){
        return new I18nMarathiGreetingService();
    }*/

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return  new PrimaryGreetingService();
    }

    @Bean
    ConstructorGreetingServiceImpl constructorGreetingService(){
        return new ConstructorGreetingServiceImpl();
    }

    @Bean
    PropertyInjectorGreetingService propertyInjectorGreetingService(){
        return new PropertyInjectorGreetingService();
    }

    @Bean
    SetterInjectorGreetingService setterInjectorGreetingService(){
        return new SetterInjectorGreetingService();
    }
}
