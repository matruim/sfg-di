package com.jaredgood.sfgdi.config;

import com.jaredgood.pets.PetService;
import com.jaredgood.pets.PetServiceFactory;
import com.jaredgood.sfgdi.datasource.FakeDataSource;
import com.jaredgood.sfgdi.repositories.EnglishGreetingRepository;
import com.jaredgood.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.jaredgood.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:sfgdi-config.xml")
@EnableConfigurationProperties(ConstuctorConfig.class)
public class GreetingServiceConfig {

//    @Bean
//    ConstructorGreetingService constructorGreetingService(){
//        return new ConstructorGreetingService(); // moved to xml
//    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterBasedGreetingService setterBasedGreetingService(){
        return new SetterBasedGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }
    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat"})
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }


    @Bean
    FakeDataSource fakeDataSource(ConstuctorConfig constuctorConfig){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(constuctorConfig.getUsername());
        fakeDataSource.setPassword(constuctorConfig.getPassword());
        fakeDataSource.setJdbcurl(constuctorConfig.getJdbcurl());
        return fakeDataSource;
    }
}
