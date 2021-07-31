package guru.springframework.sfgdi.services;

import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Profile("En")
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepositoryImpl englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }


    @Override
    public String sayGreeting() {
        return "Hello World- EN";
    }
}
