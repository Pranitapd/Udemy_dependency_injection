package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx =  SpringApplication.run(SfgDiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController"); 	//Here Spring framework is creating obj for u an
		//providing those instantiated object here
		//if name is not given to the bean By default, Spring takes class name

		//String greeting = myController.sayHello();
		System.out.println("------Primary Bean");
		System.out.println(myController.sayHello());

		//--------Applyinh Spring here
		System.out.println("------Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-------Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------Constructor");
		ConstructorInjectionController constructorInjectionController = (ConstructorInjectionController) ctx.getBean("constructorInjectionController");
		System.out.println(constructorInjectionController.getGreeting());

		System.out.println("-------i18");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());	//since we have added EN as active profile in application.properties the EN bean will get picked up

		System.out.println("------Bean Scopes-------------");
		System.out.println("------Singleton-------------");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println("s1 " + singletonBean1.getMyScope() +" "+ singletonBean1);
		System.out.println("s2 " + singletonBean2.getMyScope() + " " + singletonBean2);

		System.out.println("------Prototype-------------");
		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println("p1 " + prototypeBean1.getMyScope() + " " + prototypeBean1);
		System.out.println("p2 " + prototypeBean2.getMyScope() + " " + prototypeBean2);
	}

}
