package com.jaredgood.sfgdi;

import com.jaredgood.sfgdi.config.ConstuctorConfig;
import com.jaredgood.sfgdi.config.SfgConfiguration;
import com.jaredgood.sfgdi.controllers.*;
import com.jaredgood.sfgdi.datasource.FakeDataSource;
import com.jaredgood.sfgdi.services.PrototypeBean;
import com.jaredgood.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController");
		System.out.println("--------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("--------- Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");
		SetterBasedController setterBasedController = (SetterBasedController) ctx.getBean("setterBasedController");
		System.out.println(setterBasedController.getGreeting());

		System.out.println("--------- Constructor");
		ConstructorBasedController constructorBasedController = ctx.getBean("constructorBasedController", ConstructorBasedController.class);
		System.out.println(constructorBasedController.getGreeting());

		System.out.println("--------- i18n");
		I18nController i18nController = ctx.getBean("i18nController", I18nController.class);
		System.out.println(i18nController.sayHello());

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		System.out.println("---- Bean Scopes ---------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("---- Datasource Info ---------");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

		System.out.println("---- Config Props Bean ---------");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcurl());

		System.out.println("---- Constructor Binding ---------");
		ConstuctorConfig constuctorConfig = ctx.getBean(ConstuctorConfig.class);
		System.out.println(constuctorConfig.getUsername());
		System.out.println(constuctorConfig.getPassword());
		System.out.println(constuctorConfig.getJdbcurl());
	}

}
